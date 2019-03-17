package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.GameScreen;

public class Player extends GameObject {

    public Player(Texture i) {
        super(i);
    }

    public void draw(SpriteBatch batch) {
        int totalX = x + width, totalY = y + height;
        if (move[RIGHT]) {
            if (totalX < Gdx.graphics.getWidth() && GameScreen.movable[totalX + 1][y])
                x++;
        }

        if (move[LEFT]) {
            x--;
        }
        if (move[UP]) {
            y++;
        }
        if (move[DOWN]) {
            y--;
        }
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        batch.draw(img, x, y);
    }

    public void dispose() {
    }
}
