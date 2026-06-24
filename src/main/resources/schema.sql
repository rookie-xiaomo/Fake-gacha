CREATE TABLE IF NOT EXISTS game_character (
                                              id INT AUTO_INCREMENT PRIMARY KEY,
                                              name VARCHAR(255) NOT NULL,
                                              level INT NOT NULL
    );

-- 先预埋两个角色进去测试

-- 插入不同等级的角色
INSERT INTO game_character (name, level) VALUES ('Elysia', 5);      -- S级
INSERT INTO game_character (name, level) VALUES ('Vill-V', 3);      -- A级
INSERT INTO game_character (name, level) VALUES ('Pardofelis', 1);  -- B级
INSERT INTO game_character (name, level) VALUES ('Can', 1);         -- B级 (帕朵的猫也来凑数)