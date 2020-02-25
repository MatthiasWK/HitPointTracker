package com.matthias.hitpointtracker;
// To Do: Implement max hp calculation
public class NonPlayerCharacter extends Character {
    private int hitDice = 0;
    private int numHitDice = 0;

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice, int numHitDice) {
        this.hitDice = hitDice;
        this.numHitDice = numHitDice;
    }

    @Override
    public int getAverageMaxHP() {
        return 0;
    }

    @Override
    public int getRandomMaxHP() {
        return 0;
    }

}
