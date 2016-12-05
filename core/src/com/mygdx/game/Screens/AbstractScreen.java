package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MiBolitas;

/**
 * Created by Ignacio on 05/12/2016.
 */
public class AbstractScreen {protected final MiBolitas app;



    Stage stage;

    public AbstractScreen(final MiBolitas app) {
        this.app = app;
        this.stage = new Stage();
    }

    public abstract void update(float delta);



    @Override
    public void render(float delta) {
        update(delta);

        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0.25f, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        this.stage.dispose();

    }
}
}
