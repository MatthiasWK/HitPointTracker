package com.matthias.hitpointtracker;

import java.util.ArrayList;

public class PlayerCharacter extends Character{
    private ArrayList<CharacterClass> characterClasses = new ArrayList<>(); //To Do: change to list of tuples "(class, level)"
    private CharacterRace characterRace = new CharacterRace();

    public ArrayList<CharacterClass> getCharacterClasses() {
        return characterClasses;
    }

    public void setCharacterClasses(ArrayList<CharacterClass> characterClasses) {
        this.characterClasses = characterClasses;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(CharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    @Override
    public int getAverageMaxHP() {
        int result = getFirstLevelHP();

        for (int i = 1; i < characterClasses.size(); i++) {
            int hitDice = characterClasses.get(i).getHitDice();
            result += getAverageHitDiceRoll(hitDice);
        }

        return result;
    }

    @Override
    public int getRandomMaxHP() {
        int result = getFirstLevelHP();

        for (int i = 1; i < characterClasses.size(); i++) {
            int hitDice = characterClasses.get(i).getHitDice();
            result += getRandomHitDiceRoll(hitDice) + characterRace.getHPModifier();
        }

        return result;
    }

    private int getFirstLevelHP(){
        if(characterClasses.size() < 1)
            throw new ArrayIndexOutOfBoundsException("no Character Class has been set");

        CharacterClass cc = characterClasses.get(0);
        return cc.getHitDice() + conModifier + characterRace.getHPModifier();
    }

}
