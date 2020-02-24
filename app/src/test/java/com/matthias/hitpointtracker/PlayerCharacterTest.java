package com.matthias.hitpointtracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
        pc.setHP(10);
        assertEquals(10, pc.getHP());

        pc.loseHP(5);
        assertEquals(5, pc.getHP());

        pc.loseHP(5);
        assertEquals(0, pc.getHP());

        pc.loseHP(5);
        assertEquals(0, pc.getHP());

        pc.gainHP(5);
        assertEquals(5, pc.getHP());
    }

    @Test
    public void CalculateHPAverageTest(){
        PlayerCharacter pc = new PlayerCharacter();
        ArrayList<PlayerClass> classList = new ArrayList<>();
        classList.add(new Fighter());
        classList.add(new Fighter());
        classList.add(new Fighter());

        pc.setPlayerClass(classList);

        assertEquals(22, pc.CalculateHPAverage());
    }

}