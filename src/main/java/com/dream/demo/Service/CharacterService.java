package com.dream.demo.Service;

import com.dream.common.Result;
import com.dream.demo.mapper.CharacterMapper;
import com.dream.entity.gameCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CharacterService {
    private int totalPity = 0; // 专门负责 90 抽大保底
    private int tenPity = 0;   // 专门负责 10 抽小保底

    Random random = new Random();
    @Autowired
    private CharacterMapper gamecharacter;

    @Transactional
    public boolean addCharacter(gameCharacter character) {
        if (gamecharacter.findByName(character.getName()) != null) {
            return false; // 表示没添加成功（已存在）
        }
        gamecharacter.addCharacter(character);
        return true; // 表示添加成功
    }

    public int getTotalPity() {
        return totalPity;
    }

    //单抽逻辑
    @Transactional
    public gameCharacter randomCharacter() {
        totalPity++;
        tenPity++;
        System.out.println("当前进度：大保底 " + totalPity + "/90, 小保底 " + tenPity + "/10");
        int level;
        // 1. 优先判定大保底
        if (totalPity >= 90) {
            level = 5;
            totalPity = 0;
            tenPity = 0; // 出金了通常小保底也重置
        }
        // 2. 判定原生 0.5% 出金
        else if (random.nextInt(1000) + 1 <= 5) {
            level = 5;
            totalPity = 0;
            tenPity = 0;
        }
        // 3. 判定小保底（10抽必出A）
        else if (tenPity >= 10) {
            level = 3;
            tenPity = 0; // 只有小保底重置，totalPity 继续累加！
        }
        // 4. 判定原生 5% 出 A
        else if (random.nextInt(100) + 1 <= 5) {
            level = 3;
            tenPity = 0;
        }
        else {
            level = 1;
        }

        List<gameCharacter> characters = gamecharacter.findByLevel(level);
        return characters.get(random.nextInt(characters.size()));
    }


    //十连逻辑
    @Transactional
    public List<gameCharacter> drawTen() {
        List<gameCharacter> tenResults = new ArrayList<>();

        // 循环 10 次，每次都去执行你写好的那个带保底的 randomCharacter()
        for (int j = 0; j < 10; j++) {
            // 复用你之前的单抽逻辑
            gameCharacter one = randomCharacter();
            // 依次存入结果集
            tenResults.add(one);
        }
        return tenResults;
    }

    public List<gameCharacter> findAll() {
        return gamecharacter.findAll();
    }

    @Transactional
    public boolean deletehero(gameCharacter hero) {
        if(gamecharacter.deleteCharacter(hero.getName()) != 0){
            return true;
        }else {
            return false;
        }
    }
}