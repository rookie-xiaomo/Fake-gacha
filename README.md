# 🎲 Fake Gacha Demo

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen)
![MyBatis](https://img.shields.io/badge/MyBatis-3.x-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1)
![Maven](https://img.shields.io/badge/Maven-3.8+-red)
![License](https://img.shields.io/badge/License-Learning-lightgrey)

一个基于 **Spring Boot + MyBatis + MySQL** 开发的抽卡模拟系统，用于模拟游戏中的角色抽取机制，实现角色管理、抽卡逻辑演示及数据持久化存储。

适合作为：

* Java Web 课程设计
* Spring Boot 学习项目
* MyBatis 入门实践
* GitHub 个人作品展示

---

## ✨ 项目预览

> 建议运行项目后截图上传到 GitHub 仓库，然后替换下面图片链接。

### 首页

```text
docs/images/index.png
```

### 抽卡界面

```text
docs/images/gacha.png
```

### 角色管理

```text
docs/images/character.png
```

---

## 🚀 功能特性

### 🎯 抽卡系统

* 单抽
* 十连抽
* 随机角色生成
* 概率模拟

### 👤 角色管理

* 角色查询
* 角色列表展示
* 数据库存储

### 💾 数据持久化

* MySQL 数据库
* MyBatis 映射管理
* CRUD 操作

### 🔧 系统架构

* Spring Boot
* MVC 分层设计
* RESTful 接口风格

---

## 🛠 技术栈

| 技术            | 说明      |
| ------------- | ------- |
| Java          | JDK 17  |
| Spring Boot   | Web开发框架 |
| MyBatis       | ORM框架   |
| MySQL         | 数据存储    |
| Maven         | 项目管理    |
| IntelliJ IDEA | 开发工具    |

---

## 📁 项目结构

```text
Fake-gacha
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.dream.demo
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── mapper
│   │   │       ├── entity
│   │   │       └── DemoApplication
│   │   │
│   │   ├── resources
│   │   │   ├── mapper
│   │   │   ├── static
│   │   │   ├── templates
│   │   │   └── application.properties
│   │
│   └── test
│
├── pom.xml
├── schema.sql
└── README.md
```

---

## ⚙️ 环境要求

| 软件    | 版本    |
| ----- | ----- |
| JDK   | 17+   |
| Maven | 3.8+  |
| MySQL | 8.0+  |
| IDEA  | 2023+ |

---

## 📦 快速开始

### 1. 克隆项目

SSH：

```bash
git clone git@github.com:rookie-xiaomo/Fake-gacha.git
```

HTTPS：

```bash
git clone https://github.com/rookie-xiaomo/Fake-gacha.git
```

---

### 2. 创建数据库

```sql
CREATE DATABASE game_db DEFAULT CHARACTER SET utf8mb4;
```

---

### 3. 导入数据库脚本

执行项目中的：

```text
schema.sql
```

完成表结构初始化。

---

### 4. 修改数据库配置

编辑：

```text
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/game_db
spring.datasource.username=root
spring.datasource.password=123456
```

根据实际情况修改用户名和密码。

---

### 5. 启动项目

运行：

```java
DemoApplication
```

或者：

```bash
mvn spring-boot:run
```

启动成功后访问：

```text
http://localhost:8080
```

---

## 🧪 常见问题

### 数据库连接失败

检查：

```properties
spring.datasource.url
spring.datasource.username
spring.datasource.password
```

是否正确。

---

### Unknown database 'game_db'

执行：

```sql
CREATE DATABASE game_db;
```

---

### Maven 下载失败

执行：

```bash
mvn clean install
```

或者配置阿里云 Maven 镜像。

---

### JDK版本不兼容

推荐：

```text
JDK 17
```

不要使用 JDK 8。

---

## 📈 后续优化方向

* [ ] 抽卡概率公示
* [ ] 保底机制
* [ ] 用户系统
* [ ] 登录注册
* [ ] Redis缓存
* [ ] Docker部署
* [ ] 前后端分离

---

## 👨‍💻 作者

张磊

GitHub：

https://github.com/rookie-xiaomo

---

## 📄 License

本项目仅供学习交流使用，请勿用于商业用途。
