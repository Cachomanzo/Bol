package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Created by Ignacio on 04/12/2016.
 */

public class MyContactListener implements ContactListener{


    public void beginContact(Contact c)
    {
        ScoreManager.DecreaseScore(1);
        System.out.println();

    }

    public void endContact(Contact c) {

    }
    public void preSolve(Contact c, Manifold m){

    }
    public void postSolve(Contact c, ContactImpulse ci) {



    }
}
