package com.matthias.hitpointtracker;

import java.util.Random;
// To Do: make ClassLevel Class, add Class and Race Factories
public abstract class Character {
    protected String name = "Default";
    protected int conModifier = 0;
    protected int maxHP = 0;
    protected int currentHP = 0;

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

    public void regainAllHP(){
        currentHP = maxHP;
    }

    public void loseHP(int lostHP) {
        currentHP = Math.max(0, currentHP - lostHP);
    }

    public void gainHP(int gainedHP) {
        currentHP += gainedHP;
    }

    public abstract int getAverageMaxHP();

    public abstract int getRandomMaxHP();

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
