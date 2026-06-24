# Fake Gacha Demo

一个基于 Spring Boot + MyBatis + MySQL 的抽卡模拟系统。

## 项目简介

Fake Gacha Demo 是一个模拟游戏抽卡机制的 Web 项目，支持角色数据管理、抽卡逻辑演示以及基础的数据查询功能，适合作为 Spring Boot 学习项目或课程设计参考。

## 技术栈

* Java 17+
* Spring Boot 3.4.0
* MyBatis
* MySQL 8.x
* Maven

## 环境要求

### 开发环境

| 软件            | 推荐版本   |
| ------------- | ------ |
| JDK           | 17 或以上 |
| Maven         | 3.8+   |
| MySQL         | 8.0+   |
| IntelliJ IDEA | 2023+  |

## 项目获取

```bash
git clone git@github.com:rookie-xiaomo/Fake-gacha.git
```

或

```bash
git clone https://github.com/rookie-xiaomo/Fake-gacha.git
```

## 数据库配置

### 1. 创建数据库

登录 MySQL 后执行：

```sql
CREATE DATABASE game_db DEFAULT CHARACTER SET utf8mb4;
```

### 2. 导入数据表

项目中提供了数据库初始化脚本：

```text
schema.sql
```

执行脚本完成表结构创建。

### 3. 修改数据库配置

打开：

```text
src/main/resources/application.properties
```

根据实际情况修改：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/game_db
spring.datasource.username=root
spring.datasource.password=123456
```

如果数据库密码不是 `123456`，请修改为自己的密码。

## IDEA 启动项目

### 1. 导入项目

打开 IDEA：

```text
File
 └ Open
```

选择项目根目录。

等待 Maven 自动加载依赖。

### 2. 下载依赖

若依赖未自动下载：

```bash
mvn clean install
```

### 3. 启动项目

找到启动类：

```text
src/main/java/.../DemoApplication.java
```

点击运行按钮或执行：

```bash
mvn spring-boot:run
```

启动成功后控制台会出现类似内容：

```text
Started DemoApplication
```

## 访问项目

项目默认运行地址：

```text
http://localhost:8080
```

根据实际 Controller 配置访问对应页面。

## 常见问题

### 1. Failed to configure a DataSource

原因：

* MySQL 未启动
* 数据库配置错误

解决：

* 启动 MySQL 服务
* 检查 application.properties 配置

---

### 2. Unknown database 'game_db'

原因：

数据库不存在。

解决：

```sql
CREATE DATABASE game_db;
```

---

### 3. Access denied for user 'root'

原因：

数据库账号或密码错误。

解决：

修改：

```properties
spring.datasource.username=
spring.datasource.password=
```

---

### 4. Maven 依赖下载失败

执行：

```bash
mvn clean install
```

或更换 Maven 国内镜像源。

## 项目结构

```text
src
├── main
│   ├── java
│   │   └── 项目源码
│   └── resources
│       ├── application.properties
│       ├── mapper
│       └── 静态资源
│
└── test
    └── 测试代码
```

## 作者

GitHub：

https://github.com/rookie-xiaomo

## License

仅供学习与交流使用。
