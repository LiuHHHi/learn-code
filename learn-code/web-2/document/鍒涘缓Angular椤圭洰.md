# 创建Angular项目

## 安装软件环境

1. 需要Nodejs14版本 v14.x.x
2. 安装 nrm `npm install -g nrm --registry=https://registry.npm.taobao.org`
3. 切换镜像源 `nrm use taobao`
4. 查看镜像是否使用成功 `nrm ls`
5. 全局安装Angular CLI `npm install -g @angular/cli@8`

## 创建Angular项目

1. 进入到需要创建项目的目录 `ng new angular1`  第一个问题：是否添加路由模块，选择y，第二个问题：选择样式编写方式，选择Less
2. 启动项目，进入 `angualr1` 目录，`npm run start` 启动。
3. Angular创建组件：`ng generate component [组件名称]` 缩写 `ng g c [组件名称]`
4. Angular添加第三方库：`ng add [第三方库名称]` ,这个根据第三方库的要求使用`ng add`或`npm install`
5. Angular打包：`ng build --prod`

## NG-ZORRO

注意版本：angular 8 使用nodejs 8.x  angular 15 使用nodejs 16.x

[ZG-ZORRO](http://ng.ant.design/)
[NgSite](https://ngsite.yunzainfo.com/)
[Ng](https://ng.yunzainfo.com/)
[Ng](https://ng-yunzai-doc.surge.sh/)
