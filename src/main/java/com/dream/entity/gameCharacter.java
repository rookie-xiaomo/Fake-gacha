package com.dream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class gameCharacter {
    private String name;
    private int level;
    private Integer id;
}
