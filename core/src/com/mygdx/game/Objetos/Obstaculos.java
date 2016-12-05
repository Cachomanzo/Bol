/**
 * Created by Ignacio on 05/12/2016.
 */

package com.mygdx.game.Objetos;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MiBolitas;




public final class Obstaculos {

    public static Body obstaculo (World world, int x, int y) {
        Body bBase;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x,y);
        def.fixedRotation = false;
        bBase = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox (17 / 2 , 17 / 2);


        FixtureDef fDef= new FixtureDef();



        bBase.createFixture(fDef);

        shape.dispose();
        return bBase;
    }

}
