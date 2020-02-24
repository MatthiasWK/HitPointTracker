package com.matthias.hitpointtracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerRaceTest {
    @Test
    public void DefaultRaceTest(){
        PlayerRace pr = new PlayerRace();
        assertEquals("Default", pr.getRaceName());
        assertEquals(0, pr.getHPModifier());
    }

    @Test
    public void HumanTest(){
        PlayerRace pr = new Human();
        assertEquals("Human", pr.getRaceName());
        assertEquals(0, pr.getHPModifier());
    }

    @Test
    public void HillDwarfTest(){
        PlayerRace pr = new Dwarf_Hill();
        assertEquals("Hill Dwarf", pr.getRaceName());
        assertEquals(1, pr.getHPModifier());
    }
}