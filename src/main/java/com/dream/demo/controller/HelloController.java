package com.dream.demo.controller;

import com.dream.common.Result;
import com.dream.demo.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dream.entity.gameCharacter;

import java.util.List;

@CrossOrigin // 允许所有来源的跨域请求，这样你的网页才能连上后端
@RestController
public class HelloController {
    @Autowired
    private CharacterService characterService;
//    简单的访问，SpringBoot自动返回JASON数据
    @GetMapping("/hello")
    public String startAdventure() {
        return "Java 开发者，你的 Spring Boot 开始了！";
    }

    //简单的赋值
    @GetMapping("/hero")
    public gameCharacter getHero() {
        gameCharacter hero = new gameCharacter();
        hero.setName("Elysia");
        return hero;
    }

    @GetMapping("/add/{name}")
    public Result<gameCharacter> addCharacter(@PathVariable("name") String name) {
        gameCharacter character = new gameCharacter();
        character.setName(name);
        character.setLevel(1);
        boolean isAdded = characterService.addCharacter(character);

        if (isAdded) {
            return Result.success(character); // 返回 200 和数据
        } else {
            return Result.error("角色已存在，请勿重复添加"); // 返回错误提示
        }
    }

    // 单抽同理
    @GetMapping("/draw")
    public Result<gameCharacter> draw() {
        gameCharacter character = characterService.randomCharacter();
        Result<gameCharacter> result = Result.success(character);
        result.setMessage(String.valueOf(characterService.getTotalPity()));
        return result;
    }

    @GetMapping("/drawTen")
    public Result<List<gameCharacter>> drawTen() {
        List<gameCharacter> characters = characterService.drawTen();
        // 我们把当前最新的 totalPity 放在 message 里传给前端
        Result<List<gameCharacter>> result = Result.success(characters);
        result.setMessage(String.valueOf(characterService.getTotalPity()));
        return result;
    }

    //获取URL中的name，没指定查哪个会自动查
    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "无名氏") String name){
        return "Hello "+name+"!";
    }

    //URL为RESTful风格的写法
    @GetMapping("/heros/{name}")
    public gameCharacter getHeros(@PathVariable("name") String name){
        gameCharacter hero=new gameCharacter();
        hero.setName(name);
        hero.setLevel(100);
        return hero;
    }

    @GetMapping("allheros")
    public Result<List<gameCharacter>> getAllHeros(){
        try {
            List<gameCharacter> allheros=characterService.findAll();
            return  Result.success(allheros);
        }catch (Exception e){
            return Result.error("错误");
        }
    }

    @GetMapping("/deletehero/{name}")
    public Result<gameCharacter> deleteHero(@PathVariable("name") String name){
        gameCharacter hero=new gameCharacter();
        hero.setName(name);
        boolean isAdded = characterService.deletehero(hero);
        if (isAdded) {
            return Result.success(hero);
        }else {
            return Result.error("不存在该角色");
        }
    }

}