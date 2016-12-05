package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import  com.mygdx.game.Objetos.Obstaculos;


public class MiBolitas extends ApplicationAdapter {


    public 	SpriteBatch batch;
    public 	Texture img;
   // public Body obs1,obs2,obs3,obs4,obs5,obs6;
    public Box2DDebugRenderer b2dr;
    public boolean DEBUG = false;
    public OrthographicCamera camera;
    public World world;
    public Body base, techo;
    public Body paredder, paredizq;
    public Body obs1,obs2,obs3,obs4,obs5,obs6;
   // private long lastDropTime;
   // public ArrayList bodyArrayList;


    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        String s = "1";
        int d = 0;
        d = Integer.valueOf(s).intValue();
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        System.out.println(d);
        camera = new OrthographicCamera();
        camera.setToOrtho (false, w / 2, h / 2);
        world = new World(new Vector2(0f, -100f), true);
        b2dr =new Box2DDebugRenderer();
        base = Base (world, 0, 230);
        techo = Base(world, 0, 10);
        paredizq = Pared(world, 0,0);
        paredder = Pared(world, 360,0);

        Obstaculos  obs1= new Obstaculos();
        obs1.obstaculo(world, 50, 100);
        Obstaculos  obs2= new Obstaculos();
        obs2.obstaculo(world, 100, 100);
        Obstaculos  obs3= new Obstaculos();
        obs3.obstaculo(world, 150, 100);
        Obstaculos  obs4= new Obstaculos();
        obs4.obstaculo(world, 200, 100);
        Obstaculos  obs5= new Obstaculos();
        obs5.obstaculo(world, 250, 100);
        Obstaculos  obs6= new Obstaculos();
        obs6.obstaculo(world, 75, 50);
        Obstaculos  obs7= new Obstaculos();
        obs7.obstaculo(world, 125, 50);
        Obstaculos  obs8= new Obstaculos();
        obs8.obstaculo(world, 175, 50);
        Obstaculos  obs9= new Obstaculos();
        obs9.obstaculo(world, 225, 50);
        Obstaculos  obs10= new Obstaculos();
        obs10.obstaculo(world, 275, 50);




        for(int i = 0; i < 5; i++)
        {
            float rand = MathUtils.random(10, 300);
            Pelota(rand);

        }


    }


    @Override
    public void render () {

        batch.begin();
        batch.end();
        update (Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        b2dr.render(world, camera.combined);


    }

    public void resize (int width, int height) {
        camera.setToOrtho(false, width / 2,height / 2);

    }

    @Override
    public void dispose () {
        world.dispose();
        b2dr.dispose();
        batch.dispose();
        img.dispose();

    }
    public void update (float delta) {
        world.step(1 / 60f, 6, 2);

        if(ScoreManager.contactNumber > ScoreManager.ballNumber)
        {
            ScoreManager.ScorePlayer -= 1;
        }
    }

    public static Body Base (World world, int x, int y) {
        Body bBase;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        def.position.set(x,y);
        def.fixedRotation = true;
        bBase = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox (1000 / 2 , 10 / 2);

        FixtureDef fDef= new FixtureDef();
        fDef.shape = shape;
        bBase.createFixture(fDef);

        shape.dispose();
        return bBase;
    }

    public static Body Pared (World world, int x, int y) {
        Body pPared;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        def.position.set(x,y);
        def.fixedRotation = true;

        pPared = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox (10 / 2 , 500 / 2);

        FixtureDef fDef= new FixtureDef();
        fDef.shape = shape;
        pPared.createFixture(fDef);

        shape.dispose();
        return pPared;
    }

   //   public Body Pelota (World world, int x,int y) {
   public  Body Pelota (float random) {

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







