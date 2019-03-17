package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.mygdx.game.gameobjects.Enemy;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.Loot;
import com.mygdx.game.gameobjects.Player;
import com.mygdx.game.gameobjects.Vendor;
import com.mygdx.game.utilities.InputHandler;
import com.mygdx.game.utilities.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameScreen implements Screen {
    Game game;
    Stage s;
    Texture map;
    Texture mask;
    Texture playerImage;
    Texture enemyImage;
    Texture lootImage;
    Texture vendorImage;

    public static boolean movable[][];
    int width, height;
    Pixmap maskpix;
    int firstX = 0;
    int firstY = 0;
    GameObject player;
    GameObject enemy;
    GameObject loot;
    private GameObject vendor;

    Random rand;



    public GameScreen(Game g) {
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        game = g;
        s = new Stage(new ScreenViewport());
        map = new Texture("core/assets/map.png");
        mask = new Texture("core/assets/mask.png");
        playerImage = new Texture("core/assets/goofy.jpg");
        enemyImage = new Texture("core/assets/enemy.png");
        lootImage = new Texture("core/assets/loot.png");
        vendorImage = new Texture("core/assets/vendor.png");
        player = new Player(playerImage);
        enemy = new Enemy(enemyImage);
        loot = new Loot(lootImage);
        vendor = new Vendor(vendorImage);

        rand = new Random();

        TextureData td = mask.getTextureData();
        td.prepare();
        maskpix = td.consumePixmap();
        width = mask.getWidth();
        height = mask.getHeight();
        movable = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color();
                Color.rgba8888ToColor(c, maskpix.getPixel(i, height - j));
                movable[i][j] = !c.equals(Color.BLACK);
            }
        }
        System.out.println(Color.CLEAR.toString() + "\n" + Color.BLACK.toString());

        for (int i = 0; firstX == 0 && i < width; i++) {
            System.out.println(movable[i][firstY]);
            if (movable[i][firstY]) {
                firstX = i;
            }
        }

        int n = rand.nextInt(50);

        List<Position> possiblePositions = new ArrayList<Position>();

        for (int i = 0; i < movable.length; i++) {
            for (int j = 0; j < movable[i].length; j++) {
                if (movable[i][j]) {
                    Position pos = new Position(i,j);
                    possiblePositions.add(pos);
                }

            }
        }

        player.setPos(firstX, firstY);
        loot.setPos(possiblePositions.get(rand.nextInt(possiblePositions.size()-1)).getX(),
                possiblePositions.get(rand.nextInt(possiblePositions.size()-1)).getY());
        enemy.setPos(firstX+100,firstY+100);
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
        s.getBatch().draw(mask, 0, 0);
        player.draw((SpriteBatch) s.getBatch());
        enemy.draw((SpriteBatch) s.getBatch());
        loot.draw((SpriteBatch) s.getBatch());
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
        playerImage.dispose();
        enemyImage.dispose();
        lootImage.dispose();
        vendorImage.dispose();
        maskpix.dispose();
    }

}
