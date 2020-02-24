package com.matthias.hitpointtracker;

import java.util.ArrayList;

public class PlayerCharacter {
    private String name = "Default";
    private int conModifier = 0;
    private int hitPoints = 0;
    private ArrayList<PlayerClass> playerClass = new ArrayList<PlayerClass>();
    private PlayerRace playerRace = new PlayerRace();

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public int getHP() {
        return hitPoints;
    }

    public void setHP(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getConModifier() {
        return conModifier;
    }

    public void setConModifier(int conModifier) {
        this.conModifier = conModifier;
    }

    public ArrayList<PlayerClass> getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(ArrayList<PlayerClass> playerClass) {
        this.playerClass = playerClass;
    }

    public PlayerRace getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(PlayerRace playerRace) {
        this.playerRace = playerRace;
    }

    public void loseHP(int lostHP) {
        hitPoints = Math.max(0, hitPoints - lostHP);
    }

    public void gainHP(int gainedHP) {
        hitPoints += gainedHP;
    }

    public int CalculateHPAverage() {
        int result = 0;
        if(playerClass.size() > 0){
            result = playerClass.get(0).getHitDice();
            playerClass.remove(0);
            for (PlayerClass pc: playerClass) {
                int hd = pc.getHitDice();
                int averageHitDice = (int)Math.ceil((1+hd)*0.5);
                result += averageHitDice;
            }
        }
        return result;
    }

    public int CalculateHPRandom() {
        int result = 0;
        if(playerClass.size() > 0){
            result = playerClass.get(0).getHitDice();
            playerClass.remove(0);
            for (PlayerClass pc: playerClass) {
                //To Do: Implement
            }
        }
        return result;
    }
}
