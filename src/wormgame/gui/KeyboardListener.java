/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.domain.Worm;

/**
 *
 * @author jovana
 */
public class KeyboardListener implements KeyListener{
    private Worm worm;
    private static final int UP = KeyEvent.VK_UP;
    private static final int DOWN = KeyEvent.VK_DOWN;
    private static final int LEFT = KeyEvent.VK_LEFT;
    private static final int RIGHT = KeyEvent.VK_RIGHT;
    
    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        
        if(code == KeyboardListener.UP) {
            this.worm.setDirection(Direction.UP);
        } else if(code == KeyboardListener.DOWN) {
            this.worm.setDirection(Direction.DOWN);
        } else if(code == KeyboardListener.LEFT) {
            this.worm.setDirection(Direction.LEFT);
        } else if(code == KeyboardListener.RIGHT) {
            this.worm.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}
