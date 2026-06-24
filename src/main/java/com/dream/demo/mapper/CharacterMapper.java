package com.dream.demo.mapper;

import com.dream.entity.gameCharacter;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper // 告诉 Spring：这是一个 MyBatis 的映射器
public interface CharacterMapper {
    @Select("SELECT * FROM game_character")
    List<gameCharacter> findAll();

    @Select("SELECT * FROM game_character WHERE name = #{name} LIMIT 1")
    gameCharacter findByName(String name);

    @Select("SELECT * FROM game_character WHERE level = #{level}")
    List<gameCharacter> findByLevel(int level);

    @Insert("INSERT INTO game_character(name,level) VALUES(#{name},#{level})")
    int addCharacter(gameCharacter character);

    @Delete("DELETE FROM game_character WHERE name=#{name};")
    int deleteCharacter(String name);
}