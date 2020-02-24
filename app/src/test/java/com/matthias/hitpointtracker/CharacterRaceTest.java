package com.matthias.hitpointtracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterRaceTest {
    @Test
    public void DefaultRaceTest(){
        CharacterRace cr = new CharacterRace();
        assertEquals("Default", cr.getRaceName());
        assertEquals(0, cr.getHPModifier());
    }

    @Test
    public void HumanTest(){
        CharacterRace cr = new Human();
        assertEquals("Human", cr.getRaceName());
        assertEquals(0, cr.getHPModifier());
    }

    @Test
    public void HillDwarfTest(){
        CharacterRace cr = new Dwarf_Hill();
        assertEquals("Hill Dwarf", cr.getRaceName());
        assertEquals(1, cr.getHPModifier());
    }
}