package de.gatting.scm;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogBuilder;
import com.intellij.openapi.ui.DialogWrapper;

import javax.swing.*;

public class Panel {
    private JComboBox type;
    private JTextField subject;
    private JTextField footer;
    private JTextArea body;
    private JPanel mainPanel;
    private JButton changeTemplateButton;

    Panel(Project project) {
//        String branch = CommitMessage.extractBranchName(project);
//        if (branch != null) {
//            // Branch name  matches Ticket Name
//            setTextFieldsBasedOnBranch(branch, project);
//        }
//
        changeTemplateButton.addActionListener(e -> {
            DialogWrapper dialog = createTemplateDialog(project);
            if (dialog.getExitCode() != DialogWrapper.OK_EXIT_CODE) {
                dialog.getExitCode();
            }

        });
    }

    private void setTextFieldsBasedOnBranch(String branchName, Project project) {

        String templateString = TemplateFileHandler.loadFile(project);
        // Ticket
        String parsedTicket = CommitMessage.parseBranchNameByRegex(branchName, Consts.type, templateString);
        if (CommitMessage.isRegExForVariableInTemplateDefined(templateString, Consts.type)) {
            type.setSelectedItem(parsedTicket);
        }

        String parsedSubj = CommitMessage.parseBranchNameByRegex(branchName, Consts.subject, templateString);
        if (CommitMessage.isRegExForVariableInTemplateDefined(templateString, Consts.subject)) {
            subject.setText(parsedSubj);
        }

        // ShortDescription
        String parsedShortDescription = CommitMessage.parseBranchNameByRegex(branchName, Consts.footer, templateString);
        if (CommitMessage.isRegExForVariableInTemplateDefined(templateString, Consts.footer)) {
            footer.setText(parsedShortDescription);
        }

        // LongDescription
        String parsedLongDescription = CommitMessage.parseBranchNameByRegex(branchName, Consts.body, templateString);
        if (CommitMessage.isRegExForVariableInTemplateDefined(templateString, Consts.body)) {
            body.setText(parsedLongDescription);
        }
    }

    JPanel getMainPanel() {
        return mainPanel;
    }

    public String getType() {
        return type.getSelectedItem().toString();
    }


    public String getSubject() {
        return subject.getText().trim();
    }


    public String getFooter() {
        return footer.getText().trim();
    }



    public String getBody() {
        return body.getText().trim();
    }


    public DialogWrapper createTemplateDialog(Project project) {
        Template template = new Template(project);

        DialogBuilder builder = new DialogBuilder(project);
        builder.setTitle("Git / Hg Mercurial Commit Message Template.");
        builder.setCenterPanel(template.getMainPanel());
        builder.removeAllActions();
        builder.addOkAction();
        builder.addCancelAction();
        boolean isOk = builder.show() == DialogWrapper.OK_EXIT_CODE;
        if (isOk) {
            TemplateFileHandler.storeFile(project, template.getTemplateContent());
        }
        return builder.getDialogWrapper();
    }
}
