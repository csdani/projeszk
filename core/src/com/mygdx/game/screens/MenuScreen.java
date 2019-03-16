package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen {

    private Game game;
    protected Stage stage;

    private TextureAtlas atlas;
    protected Skin skin;
    
    public MenuScreen(Game g){
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        game = g;
        atlas = new TextureAtlas("ui/uiskin.atlas");
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"), atlas);
        stage = new Stage(new ScreenViewport());
    }
    
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.center();

        TextButton playButton = new TextButton("Play", skin);
        TextButton leaderboardButton = new TextButton("Leaderboard", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        /*
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen());
            }
        });
        leaderboardButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new LeaderboardScreen());
            }
        });
        */
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        table.add(playButton).width(Gdx.graphics.getWidth() / 12).height(Gdx.graphics.getHeight() / 18).pad(20);
        table.row();
        table.add(leaderboardButton).width(Gdx.graphics.getWidth() / 12).height(Gdx.graphics.getHeight() / 18).pad(20);
        table.row();
        table.add(exitButton).width(Gdx.graphics.getWidth() / 12).height(Gdx.graphics.getHeight() / 18).pad(20);

        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(168/255f, 168/255f, 168/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
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
        skin.dispose();
        atlas.dispose();
    }

    
}
