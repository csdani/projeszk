package com.mygdx.game.utilities;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.gameobjects.GameObject;
import static java.lang.System.exit;

public class InputHandler implements InputProcessor {

    public static final int LEFT =0;
    public static final int UP =1;
    public static final int RIGHT =2;
    public static final int DOWN =3;

    InputType inputType;

    public InputHandler(){}
    @Override
    public boolean keyDown(int i) {
        if(i==Input.Keys.ESCAPE) exit(0);
            switch(i){
                case Input.Keys.A:
                    GameObject.move[LEFT]=true;
                    break;
                case Input.Keys.D:
                     GameObject.move[RIGHT]=true;
                    break;
                case Input.Keys.W:
                     GameObject.move[UP]=true;
                    break;
                case Input.Keys.S:
                     GameObject.move[DOWN]=true;
                    break;
            }
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        switch(i){
            case Input.Keys.A:
                    GameObject.move[LEFT]=false;
                break;
            case Input.Keys.D:
                     GameObject.move[RIGHT]=false;
                break;
            case Input.Keys.W:
                 GameObject.move[UP]=false;
                break;
            case Input.Keys.S:
                 GameObject.move[DOWN]=false;
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {return false;}

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {return false;}

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {return false; }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {return false;}

    @Override
    public boolean mouseMoved(int i, int i1) {return false;}

    @Override
    public boolean scrolled(int i) {return false;}
}
