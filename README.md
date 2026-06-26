# 🎲 Fake Gacha

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen)
![MyBatis](https://img.shields.io/badge/MyBatis-3.x-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1)
![Maven](https://img.shields.io/badge/Maven-3.8+-red)
![License](https://img.shields.io/badge/License-Learning-lightgrey)

一个基于 **Spring Boot + MyBatis + MySQL** 开发的抽卡模拟系统，通过 RESTful 接口实现角色管理与抽卡逻辑，并提供静态页面进行功能演示。

适合作为：

- Java Web 学习项目
- Spring Boot 入门实践
- MyBatis 数据库开发练习
- GitHub 个人作品展示

---

# ✨ 功能展示

## 🎯 抽卡系统

- 单抽
- 十连抽
- 随机角色生成
- 抽卡次数统计
- 页面刷新后重置抽卡状态（伪抽卡演示）

## 👤 角色管理

- 查看角色列表
- 添加角色
- 删除角色
- 防止重复添加角色

## 🌐 前后端交互

- 静态页面调用 Spring Boot REST API
- JSON 数据交互
- 页面与后台数据实时同步

## 💾 数据持久化

- MySQL 数据库存储角色信息
- MyBatis Mapper 操作数据库
- 基本 CRUD 功能

---

# 🛠 技术栈

| 技术 | 说明 |
|------|------|
| Java 17 | 开发语言 |
| Spring Boot | Web 后端框架 |
| MyBatis | 持久层框架 |
| MySQL | 数据库 |
| Maven | 项目管理 |
| HTML | 页面开发 |
| CSS | 页面样式 |
| JavaScript | 页面交互 |
| Axios | 前后端 HTTP 通信 |

---

# 📂 项目结构

```text
src
├── main
│   ├── java
│   │   └── com.dream
│   │       ├── controller
│   │       ├── Service
│   │       ├── mapper
│   │       ├── entity
│   │       └── common
│   │
│   └── resources
│       ├── static
│       │   ├── gacha.html
│       │   └── admin.html
│       ├── mapper
│       └── application.properties
```

---

# 🚀 已实现功能

✅ Spring Boot 项目搭建

✅ RESTful API 开发

✅ MyBatis 数据库操作

✅ 角色增删查功能

✅ 单抽、十连抽接口

✅ 抽卡概率模拟

✅ 抽卡次数统计

✅ 页面刷新自动重置抽卡状态

✅ 静态页面访问（resources/static）

---

# ⚙️ 环境要求

| 软件 | 版本 |
|------|------|
| JDK | 17+ |
| Maven | 3.8+ |
| MySQL | 8.0+ |

---

# 📦 快速开始

## 1. 克隆项目

### HTTPS

```bash
git clone https://github.com/rookie-xiaomo/Fake-gacha.git
```

### SSH

```bash
git clone git@github.com:rookie-xiaomo/Fake-gacha.git
```

进入项目目录：

```bash
cd Fake-gacha
```

---

# 2. 环境准备

运行本项目需要以下环境：

| 软件 | 推荐版本 |
|------|-----------|
| JDK | 17 |
| Maven | 3.8+ |
| MySQL | 8.0+ |
| IntelliJ IDEA | 2023 或以上 |

确认安装成功：

```bash
java -version
```

```bash
mvn -version
```

```bash
mysql --version
```

---

# 3. 创建数据库

打开 MySQL。

例如：

```bash
mysql -uroot -p
```

输入密码进入数据库。

创建数据库：

```sql
CREATE DATABASE game_db
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;
```

查看数据库：

```sql
SHOW DATABASES;
```

出现

```
game_db
```

说明创建成功。

---

# 4. 创建数据表

切换数据库：

```sql
USE game_db;
```

执行下面 SQL：

```sql
CREATE TABLE gamecharacter (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    level INT NOT NULL
);
```

查看是否创建成功：

```sql
SHOW TABLES;
```

可以看到：

```
gamecharacter
```

---

# 5. 初始化数据（推荐）

由于抽卡系统需要不同等级角色，因此建议提前插入一些测试数据。

例如：

```sql
INSERT INTO gamecharacter(name,level) VALUES
('安柏',1),
('凯亚',1),
('丽莎',1),
('诺艾尔',3),
('凝光',3),
('香菱',3),
('刻晴',5),
('钟离',5),
('神里绫华',5);
```

查看数据：

```sql
SELECT * FROM gamecharacter;
```

---

# 6. 修改数据库配置

打开：

```
src/main/resources/application.properties
```

修改为自己的数据库信息。

例如：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/game_db?serverTimezone=Asia/Shanghai

spring.datasource.username=root

spring.datasource.password=123456

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

如果数据库用户名或密码不同，请自行修改。

---

# 7. 下载 Maven 依赖

第一次运行建议执行：

```bash
mvn clean install
```

或者：

```bash
mvn dependency:resolve
```

等待依赖下载完成。

---

# 8. 启动项目

在 IDEA 中运行：

```
DemoApplication
```

或者命令行：

```bash
mvn spring-boot:run
```

控制台看到类似信息：

```
Tomcat started on port(s): 8080
Started DemoApplication
```

表示启动成功。

---

# 9. 访问页面

抽卡页面：

```
http://localhost:8080/gacha.html
```

后台管理：

```
http://localhost:8080/admin.html
```

---

# 10. 功能体验

可以体验以下功能：

## 抽卡页面

- 单抽
- 十连抽
- 查看抽卡结果
- 查看当前持有角色
- 页面刷新后自动重置抽卡次数

## 后台页面

- 查看角色列表
- 添加角色
- 删除角色
- 实时同步数据库内容

---

# 11. 常见问题

## ① 数据库连接失败

检查：

```
application.properties
```

中的：

```
spring.datasource.url

spring.datasource.username

spring.datasource.password
```

是否填写正确。

---

## ② Unknown database 'game_db'

说明数据库不存在。

执行：

```sql
CREATE DATABASE game_db;
```

---

## ③ Communications link failure

说明 MySQL 服务未启动。

Windows：

打开：

```
服务(Service)
```

启动：

```
MySQL80
```

即可。

---

## ④ 端口被占用

默认端口：

```
8080
```

如果被占用，可以修改：

```
application.properties
```

添加：

```properties
server.port=8081
```

然后访问：

```
http://localhost:8081/gacha.html
```

---

## ⑤ 页面为空

确认：

```
src/main/resources/static
```

下面存在：

```
gacha.html

admin.html
```

访问时需要带文件名：

```
http://localhost:8080/gacha.html

http://localhost:8080/admin.html
```

不要直接访问：

```
http://localhost:8080
```

否则 Spring Boot 会寻找：

```
index.html
```

而项目中没有该文件。

---

# 📈 后续计划

- [ ] 登录功能
- [ ] 用户抽卡记录
- [ ] 图片资源替换
- [ ] 优化抽卡动画
- [ ] 用户背包持久化
- [ ] Docker 部署
- [ ] Redis 缓存

---

# 👨‍💻 作者

GitHub：

**rookie-xiaomo**

---

# 📄 License

本项目仅供学习与交流使用。
