package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.utilities.InputHandler;

public class Player extends GameObject {

    public Player(Texture i) {
        super(i);
    }

    public void draw(SpriteBatch batch) {
        int totalX = pos.getX() + width, totalY = pos.getY() + height;
        if (move[InputHandler.RIGHT]) {
            if (totalX < Gdx.graphics.getWidth() && GameScreen.movable[totalX + 1][pos.getY()])
                pos.setX(pos.getX()+1);
        }

        if (move[InputHandler.LEFT]) {
            pos.setX(pos.getX()-1);
        }
        if (move[InputHandler.UP]) {
            pos.setY(pos.getY()+1);
        }
        if (move[InputHandler.DOWN]) {
            pos.setY(pos.getY()-1);
        }
        if (pos.getX() < 0) pos.setX(0);
        if (pos.getY() < 0) pos.setY(0);
        batch.draw(img, pos.getX(), pos.getY());
    }

    public void dispose() {
    }
}
