package com.mygdx.game.Objetos;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MiBolitas;
import com.mygdx.game.MyContactListener;

/**
 * Created by Ignacio on 05/12/2016.
 */





public class Pelotas {

    public Body Pelota (World world, float random) {

        Body pPelota;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;

        def.fixedRotation = false;
        pPelota = world.createBody(def);
        CircleShape shape = new CircleShape();
        shape.setRadius (10);
        //shape.setPosition(new Vector2( 4 , MathUtils.random(-100f, 5f)));

        FixtureDef fDef= new FixtureDef();
        fDef.shape = shape;
        fDef.density = 0.5f;
        fDef.friction = 0.3f;
        fDef.restitution =1f;
        // fDef.isSensor = true;

        world.setContactListener(new MyContactListener());

        float rand = MathUtils.random(20f, 180f);

        for (int i = 0; i < 3; i++ ){
            shape.setPosition(new Vector2( random, 150));
            fDef.shape = shape;
            pPelota.createFixture(fDef);


        }

        shape.dispose();
        return pPelota;
    }

    }






