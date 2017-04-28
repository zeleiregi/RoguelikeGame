package com.example.szakkr.roguelikegame.Entities;

/**
 * Created by Szakkör on 2017. 04. 28..
 */

public class LivingEntities extends Entity {

    protected int HPmax;
    protected int hp ;
    protected int damage;
    protected boolean isDead;

    public void kill(){
        isDead = true;
        hp = 0;
    }



}
