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
```
# Type(<scope>): <subject>

# <body>

# <footer>

# type 字段包含:
# feature：新功能
# fix：修补bug
# docs：文档（documentation）
# style： 格式（不影响代码运行的变动）
# refactor：重构（即不是新增功能，也不是修改bug的代码变动）
# test：增加测试
# chore：构建过程或辅助工具的变动
# scope用于说明 commit 影响的范围，比如数据层、控制层、视图层等等。
# subject是 commit 目的的简短描述，不超过50个字符
# Body 部分是对本次 commit 的详细描述，可以分成多行
# Footer用来关闭 Issue或以BREAKING CHANGE开头，后面是对变动的描述、
#       以及变动理由和迁移方法

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