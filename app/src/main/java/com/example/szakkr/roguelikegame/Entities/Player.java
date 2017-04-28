package com.example.szakkr.roguelikegame.Entities;

/**
 * Created by Szakkör on 2017. 04. 28..
 */

public class Player extends LivingEntities {

    public float newX, newY;
    boolean isDead = false;

    int tick = 0;


    int hp = random.nextInt(HPmax);
}
