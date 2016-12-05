package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.game.MiBolitas;

/**
 * Created by Ignacio on 05/12/2016.
 */
public class StartScreen {

    public class MainMenuScreen extends AbstractScreen {


        OrthographicCamera camera;
        Box2DDebugRenderer b2dr;

        SpriteBatch batch;
        BitmapFont font;



        public MainMenuScreen (final MiBolitas app){
            super (app);



        }

        @Override
        public void render(float delta) {

            //Muestra el color de la Patalla del MainMenu
            Gdx.gl.glClearColor(0, 0.25f, 0.2f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            //Dibuja las letras de la pantalla MainMenu
            app.batch.begin();
            font.draw(app.batch, "Bolitas", 250, 150);
            font.draw(app.batch, "Toca la pantalla para comenzar", 100, 300);
            app.batch.end();

            if (Gdx.input.isTouched()) {
                app.setScreen(new GameScreen(app));
                dispose();
            }
        }

        @Override
        public void update(float delta) {

            batch.setProjectionMatrix(camera.combined);


        }

        @Override
        public void show() {



            camera = new OrthographicCamera();
            camera.setToOrtho(false, MiBolitas.APP_DESKTOP_WIDTH, MiBolitas.APP_DESKTOP_HEIGHT);
            b2dr = new Box2DDebugRenderer();

            //Dice donde se encuentran los archivos de la Fuente del MainMenu
            font = new BitmapFont(Gdx.files.internal("artbrewery.fnt"), Gdx.files.internal("artbrewery.png"), false);
            batch = new SpriteBatch();




        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void hide() {

        }

        @Override
        public void dispose() {
            b2dr.dispose();
            batch.dispose();
            font.dispose();

        }
    }
}
