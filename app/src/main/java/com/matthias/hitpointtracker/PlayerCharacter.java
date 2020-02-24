package com.matthias.hitpointtracker;

import java.util.ArrayList;
import java.util.Random;

public class PlayerCharacter {
    private String name = "Default";
    private int conModifier = 0;
    private int maxHP = 0;
    private int currentHP = 0;
    private ArrayList<CharacterClass> characterClasses = new ArrayList<>(); //To Do: change to list of tuples "(class, level)"
    private CharacterRace characterRace = new CharacterRace();

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int hitPoints) {
        this.maxHP = hitPoints;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int hitPoints) {
        this.currentHP = hitPoints;
    }

    public int getConModifier() {
        return conModifier;
    }

    public void setConModifier(int conModifier) {
        this.conModifier = conModifier;
    }

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

    public void regainAllHP(){
        currentHP = maxHP;
    }

    public void loseHP(int lostHP) {
        currentHP = Math.max(0, currentHP - lostHP);
    }

    public void gainHP(int gainedHP) {
        currentHP += gainedHP;
    }

    public int getAverageMaxHP() {
        int result = getFirstLevelHP();

        for (int i = 1; i < characterClasses.size(); i++) {
            int hitDice = characterClasses.get(i).getHitDice();
            result += getAverageHitDiceRoll(hitDice);
        }

        return result;
    }

    public int getRandomMaxHP() {
        int result = getFirstLevelHP();

        for (int i = 1; i < characterClasses.size(); i++) {
            int hitDice = characterClasses.get(i).getHitDice();
            result += getRandomHitDiceRoll(hitDice) + characterRace.getHPModifier();
        }

        return result;
    }

    public int getFirstLevelHP(){
        if(characterClasses.size() < 1)
            throw new ArrayIndexOutOfBoundsException("no Character Class has been set");

        CharacterClass cc = characterClasses.get(0);
        return cc.getHitDice() + conModifier + characterRace.getHPModifier();
    }

    public int getAverageHitDiceRoll(int hitDice){
        int averageHitDice = (int)Math.ceil((1+hitDice)*0.5);
        return averageHitDice + conModifier;
    }

    public int getRandomHitDiceRoll(int hitDice){
        int randomHitDice = getRandomNumberInRange(1, hitDice);
        return randomHitDice + conModifier;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
