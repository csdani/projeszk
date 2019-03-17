package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LeaderboardScreen implements Screen {
	Game game;
	Stage stage;
	
	private TextureAtlas atlas;
	protected Skin skin;
	private TextureAtlas atlas2;
	protected Skin skin2;
	    
	private long[] highScores;
	private String[] names;
	
	public LeaderboardScreen(Game g) {
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		game = g;
		atlas = new TextureAtlas("arcade/skin/arcade-ui.atlas");
        skin = new Skin(Gdx.files.internal("arcade/skin/arcade-ui.json"), atlas);
        atlas2 = new TextureAtlas("ui/uiskin.atlas");
        skin2 = new Skin(Gdx.files.internal("ui/uiskin.json"), atlas2);
		stage = new Stage(new ScreenViewport());
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		
		Table table = new Table();
		table.setFillParent(true);
        table.center();
        
        
		Label title = new Label("Leaderboard", skin);
		
		Label rank = new Label("Rank", skin);
		rank.setColor(Color.RED);
		Label player = new Label("Player", skin);
		player.setColor(Color.RED);
		Label score = new Label("Score", skin);
		score.setColor(Color.RED);
		
		TextButton backButton = new TextButton("Back", skin2);
		
		backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
            }
        });
		
		table.add(title).center().colspan(3).padBottom(30);
		table.row();
		table.add(rank).left();
		table.add(player).left().padLeft(30).padRight(30);
		table.add(score).left();
		table.row();
		for(int row = 1; row <= 10; row++) {
			table.add(new Label(String.valueOf(row), skin)).center();
			table.add(new Label("---", skin)).center().padLeft(30).padRight(30);
			table.add(new Label("0", skin)).center();
			table.row();
		}
		table.add(backButton).width(Gdx.graphics.getWidth() / 16).height(Gdx.graphics.getHeight() / 22).center().colspan(3).padTop(20);
		
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
