package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utilities.*;

public class GameScreen implements Screen {
    Game game;
    Stage s;
    Texture map;
    Texture mask;
    Texture img;
    public static boolean movable[][];
    int width,height;
    Pixmap maskpix;
    int firstX=0;
    int firstY=0;
    GameObject go;
    
    

    public GameScreen(Game g) {
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        width=Gdx.graphics.getDisplayMode().width;
        height=Gdx.graphics.getDisplayMode().height;
        movable=new boolean[width][height];
        game=g;
        s=new Stage(new ScreenViewport());
        map=new Texture("map.png");
        mask=new Texture("mask.png");
        img=new Texture("badlogic.jpg");
        go=new GameObject(img);
        TextureData td=mask.getTextureData();
        td.prepare();
        maskpix=td.consumePixmap();
        
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                Color c=new Color();
                Color.rgba8888ToColor(c, maskpix.getPixel(i, height-j));
                movable[i][j]=c.equals(Color.BLACK)?false:true;
         }
        }
        System.out.println(Color.CLEAR.toString()+"\n"+Color.BLACK.toString());
        
        for(int i=0;firstX==0 && i<width;i++){
            System.out.println(movable[i][firstY]);
            if(movable[i][firstY]){
                firstX=i;
            }
        }
        go.setPos(firstX, firstY);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputHandler());
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	s.getBatch().begin();
	s.getBatch().draw(map, 0, 0);
        //s.getBatch().draw(mask, 0, 0);
        go.draw((SpriteBatch) s.getBatch());
                
	s.getBatch().end();
    }

    @Override
    public void resize(int i, int i1) {
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
        s.dispose();
	map.dispose();
	mask.dispose();
        img.dispose();
        maskpix.dispose();
    }
    
}
