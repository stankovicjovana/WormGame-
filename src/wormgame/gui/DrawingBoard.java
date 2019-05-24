/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

/**
 *
 * @author jovana
 */
public class DrawingBoard extends JPanel implements Updatable {
    private WormGame game; 
    private int pieceLength;
    
    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        clearBoard(g);
        paintWorm(g);
        paintApple(g);
    }
    
    public void clearBoard(Graphics g) {
        super.paintComponent(g);
    }
    
    public void paintWorm(Graphics g) {
        Worm worm = this.game.getWorm();
        
        for(Piece piece : worm.getPieces()) {
            paintPiece(g, piece);
        }
    }
    
    public void paintPiece(Graphics g, Piece piece) {
        g.setColor(Color.BLACK);
        g.fill3DRect(piece.getX(), piece.getY(), pieceLength, pieceLength, true);
        
    }
    
    public void paintApple(Graphics g) {
        Apple apple = this.game.getApple();
        g.setColor(Color.RED);
        g.fillOval(apple.getX(), apple.getY(), pieceLength, pieceLength);
        
    }

    @Override
    public void update() {
        super.repaint();
    }
}
