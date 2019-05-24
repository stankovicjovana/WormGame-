/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author jovana
 */
public class Worm {

    private Direction direction;
    private List<Piece> worm;
    private boolean growthTurnedOn;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.direction = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(originalX, originalY));
        this.growthTurnedOn = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public int getLength() {
        return this.worm.size();
    }
    
    public List<Piece> getPieces() {
        return this.worm;
    }
    
    public void move() {
        debug("moving forward " + this.direction);
        //add one piece at the end of the list to make new worm head
        int[] movingCoordinates = getNextCoordinates();
        this.worm.add(new Piece(movingCoordinates[0], movingCoordinates[1]));
        debug("add one peace");
        //if length is greater than 3 
        //if grow function is called before grow now
        if(!growthTurnedOn && getLength() > 3) {
            //delete first in the list to move
            this.worm.remove(0);
            debug("remove tail");
        }
        this.growthTurnedOn = false;
    }
    
    public void grow() {
        debug("grow turned on");
        this.growthTurnedOn = true;
    }
    
    public int[] getNextCoordinates() {
        int[] coordinates = new int[2];
        int wormHeadIndex = getLength() - 1;
        int nextXCoordinate = this.worm.get(wormHeadIndex).getX();
        int nextYCoordinate = this.worm.get(wormHeadIndex).getY();
        
        if(direction == Direction.UP) {
            nextYCoordinate = nextYCoordinate - Piece.size;
        }else if(direction == Direction.DOWN) {
            nextYCoordinate = nextYCoordinate + Piece.size;
        } else if(direction == Direction.LEFT){
            nextXCoordinate = nextXCoordinate - Piece.size;
        } else if(this.direction == Direction.RIGHT) {
            nextXCoordinate = nextXCoordinate + Piece.size;
        }
        
        coordinates[0] = nextXCoordinate;
        coordinates[1] = nextYCoordinate;
        
        return coordinates;
    }
    
    public boolean runsInto(Piece piece) {
        boolean result = false;
        
        for(int i = 0; i < getLength(); i++) {
            Piece pieceToCheck = worm.get(i);
            
            if(pieceToCheck.runsInto(piece)){
                result = true;
                debug("runs into something");
            }
        }
        
        return result;
    }
    
    public boolean runsIntoItself() {
        Piece wormHead = worm.get(getLength() - 1);
        boolean result = false;
        
        for(int i = 0; i < getLength() - 1; i++) {
            Piece pieceToCheck = worm.get(i);
            
            if(wormHead.runsInto(pieceToCheck)) {
                result = true;
                debug("runs into itself");
            }
        }
        
        return result;
    }
    
    public boolean runsIntoBorder(int boardX, int boardY) {
        Piece wormHead = worm.get(getLength() - 1);
        boolean result = false;
        
        if(wormHead.getX() <= 0 || wormHead.getX() >= boardX) {
            result = true;
            debug("Runs into horizontal border");
        }
        
        if(wormHead.getY() <= 0 || wormHead.getY() >= boardY) {
            result = true;
            debug("Runs into vertical border");
        }
        
        return result;
    }
    
    public void debug(String message) {
        boolean turnedOn = true;
        
        if(turnedOn){
            System.out.println(message);
        }
    }
}
