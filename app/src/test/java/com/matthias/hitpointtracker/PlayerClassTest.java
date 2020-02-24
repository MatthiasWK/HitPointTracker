package com.matthias.hitpointtracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerClassTest {

    @Test
    public void DefaultClassTest(){
        PlayerClass pc = new PlayerClass();
        assertEquals("Default", pc.getClassName());
    }

    @Test
    public void FighterClassTest(){
        PlayerClass pc = new Fighter();
        assertEquals("Fighter", pc.getClassName());
        assertEquals(10, pc.getHitDice());
    }

    @Test
    public void WizardClassTest(){
        PlayerClass pc = new Wizard();
        assertEquals("Wizard", pc.getClassName());
        assertEquals(6, pc.getHitDice());
    }
}