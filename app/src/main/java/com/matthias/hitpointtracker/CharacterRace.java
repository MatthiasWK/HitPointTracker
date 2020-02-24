package com.matthias.hitpointtracker;

class CharacterRace {
    protected String RaceName = "Default";
    protected int HPModifier = 0;

    public String getRaceName() {
        return RaceName;
    }

    public int getHPModifier(){
        return HPModifier;
    }
}
