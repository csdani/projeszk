package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.utilities.Position;

public abstract class GameObject {
    Texture img;
    Position pos;
    int width, height;


    public static boolean[] move = new boolean[4];

    GameObject(Texture i) {
        img = i;
        width = img.getWidth();
        height = img.getHeight();
    }

    public void setPos(int x, int y) {
        pos = new Position(x,y);
    }

    public abstract void draw(SpriteBatch batch);

    public void dispose() {
    }
}
