/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jovana
 */
public class Piece {
    private int x;
    private int y;
    public static int size = 1;
    
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece) {
        boolean sameX = this.x == piece.getX();
        boolean sameY = this.y == piece.getY();
        
        return sameX && sameY;
    }
    
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    
}
