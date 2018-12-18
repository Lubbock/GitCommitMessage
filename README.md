# Git Commit Message

Create Git commit messages.
The structure is defined within a template, that is customized by the user himself.
All variables can have an optional RegEx expression, that is parsing the Git or HG Mercurial Branch name.


## Installation
download GitCommitMessagePlugin.jar and import plugin to IDEA

<!-- Install directly from the IDE plugin manager (File > Settings > Plugins > Browser repositories > Git Commit Template)-->
## Usage
Template example:
```
${type:"(?<=_)[a-zA-Z0-9]+"}:${subject:"(?<=_)[a-zA-Z0-9]+"}

${body:"(?<=_)[a-zA-Z0-9]+"}

${footer:"(?<=_)[a-zA-Z0-9]+"}
```
Template variable
 - type
 - subject
 - body
 - footer
 
varible must be use as **${variable:regex}**

## License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.