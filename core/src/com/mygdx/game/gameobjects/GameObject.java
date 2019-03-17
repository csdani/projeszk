package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.GameScreen;

public abstract class GameObject {
    Texture img;
    int x, y, width, height;

    public static final int LEFT = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;

    public static boolean[] move = new boolean[4];

    GameObject(Texture i) {
        img = i;
        width = img.getWidth();
        height = img.getHeight();
    }

    public void setPos(int X, int Y) {
        x = X;
        y = Y;
    }

    public abstract void draw(SpriteBatch batch);

    public void dispose() {
    }
}
