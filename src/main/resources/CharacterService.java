package com.dream.demo.Service;

import com.dream.entity.Character;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CharacterService {
    private int i;
    public Character randomCharacter(){
        int level = 0;
        String name = "";
        Random random = new Random();
        if (i >= 9){
            name = "Elysia";
            level = 100;
            i = 0;
        }else{
            String[] pool = {"Pardofelis","Vill-V"};
            name = pool[random.nextInt(pool.length)];
            level = random.nextInt(20)+1;
            i++;
        }
        return  new Character(name,level);
    }

}
