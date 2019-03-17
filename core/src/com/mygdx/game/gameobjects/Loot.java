package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Loot extends GameObject {

    public Loot(Texture i) {
        super(i);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, pos.getX(), pos.getY());
    }
}
