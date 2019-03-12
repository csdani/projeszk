package com.mygdx.game.utilities;

import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;


public class ResourceManager {
    public static final int MAP=0;
    public static final int MASK=1;
    public static final int PLAYER_CHARACTER=2;
    ArrayList<Texture> textures;
    public ResourceManager(){
        textures=new ArrayList<Texture>();
        textures.add(new Texture("map.png"));
        textures.add(new Texture("mask.png"));
        textures.add(new Texture("badlogic.jpg"));
    }
    
    public void dispose(){
        for(Texture t : textures){
            t.dispose();
        }
    }
}
