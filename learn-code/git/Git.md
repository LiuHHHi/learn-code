# Git

## Git下载安装

命令行形式的版本管理工具，管理一个目录下文件变化工具

- [Git-scm官网](https://git-scm.com/)

## SourceTree下载安装

一个简单强大好看的Git可视化工具

- [Sourcetree](https://www.sourcetreeapp.com/)

## Git学习内容

### 创建公私钥

```text
# 右键鼠标，选择菜单中的 GitBashHere
# 在控制台中输入 例如：ssh-keygen -t rsa -C "xx@qq.com"
ssh-keygen -t rsa -C "填写你的邮箱"

# 一路回车，不要添加密钥密码
# 公私钥生成目录在 `~/.ssh/`  就是当前用户目录下的 .ssh 目录下
# 在控制台查看公钥
cat ~/.ssh/id_rsa.pub

# id_rsa 是私钥
```

### 掌握Git概念

- 本地提交 commit
- 文件状态
- 分支 branch
- 推送 push
- 获取 fetch  pull
- 合并
- 冲突的产生和处理
- 提交日志 log
- 忽略文件 .gitignore

[Git教程](https://www.runoob.com/git/git-tutorial.html)

- Git创建仓库
- Git基本操作
- Git分支管理
- Git查看提交历史
- Git标签

### Git提交日志格式

feat：添加新功能，fix：修复某些bug，build：编译某些功能

```text
feat(模块): 一行文字描述提交内容
```

```text
fix(模块): 一行简短描述

1.xxx
2.xx
3.xx
```
