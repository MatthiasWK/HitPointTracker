package com.matthias.hitpointtracker;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerCharacterTest {
    @Test
    public void CharacterNameTest(){
        PlayerCharacter pc = new PlayerCharacter();
        assertEquals("Default", pc.getName());

        pc.setName("Hans");
        assertEquals("Hans", pc.getName());
    }

    @Test
    public void HitPointsTest(){
        PlayerCharacter pc = new PlayerCharacter();
        pc.setMaxHP(10);
        assertEquals(10, pc.getMaxHP());

        pc.regainAllHP();
        assertEquals(10, pc.getCurrentHP());

        pc.loseHP(5);
        assertEquals(5, pc.getCurrentHP());

        pc.loseHP(5);
        assertEquals(0, pc.getCurrentHP());

        pc.loseHP(5);
        assertEquals(0, pc.getCurrentHP());

        pc.gainHP(5);
        assertEquals(5, pc.getCurrentHP());
    }

    @Test
    public void CalculateHPAverageTest(){
        PlayerCharacter pc = new PlayerCharacter();
        pc.setConModifier(2);
        pc.setCharacterRace(new Human());

        ArrayList<CharacterClass> classList = new ArrayList<>();
        classList.add(new Fighter()); //12
        classList.add(new Fighter()); //8
        classList.add(new Fighter()); //8
        classList.add(new Wizard());  //6
        int avgHP = 34;

        pc.setCharacterClasses(classList);

        assertEquals(avgHP, pc.getAverageMaxHP());
    }

    @RepeatedTest(10)
    public void CalculateHPRandomTest(){
        PlayerCharacter pc = new PlayerCharacter();
        pc.setConModifier(2);
        pc.setCharacterRace(new Human());

        ArrayList<CharacterClass> classList = new ArrayList<>();
        classList.add(new Fighter()); //12
        classList.add(new Fighter()); //3-12
        classList.add(new Fighter()); //3-12
        classList.add(new Wizard());  //3-8
        //21-44
        int min = 21;
        int max = 44;

        pc.setCharacterClasses(classList);
        int hp = pc.getRandomMaxHP();
        System.out.println(hp);
        assertTrue(hp >= min && hp <= max);
    }
}