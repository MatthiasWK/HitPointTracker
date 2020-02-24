package com.matthias.hitpointtracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterClassTest {

    @Test
    public void DefaultClassTest(){
        CharacterClass cc = new CharacterClass();
        assertEquals("Default", cc.getClassName());
    }

    @Test
    public void FighterClassTest(){
        CharacterClass cc = new Fighter();
        assertEquals("Fighter", cc.getClassName());
        assertEquals(10, cc.getHitDice());
    }

    @Test
    public void WizardClassTest(){
        CharacterClass cc = new Wizard();
        assertEquals("Wizard", cc.getClassName());
        assertEquals(6, cc.getHitDice());
    }
}