package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.gui.Updatable;
import wormgame.domain.*;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    
    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width * Piece.size;
        this.height = height * Piece.size;
        this.continues = true;
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        
        this.setApple();
        
        addActionListener(this);
        setInitialDelay(2000);

    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }
    
    public void setApple() {
        boolean appleNotSet = true;
        
        while(appleNotSet) {
            int appleXCoordinate = new Random().nextInt(width);
            int appleYCoordinate = new Random().nextInt(height);

            this.apple = new Apple(appleXCoordinate, appleYCoordinate);
            if(!this.worm.runsInto(apple)) {
                appleNotSet = false;
            }
        }
        
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        } else {
            this.worm.move();
            if(this.worm.runsInto(this.apple)) {
                this.worm.grow();
                this.setApple();
            }
            
            if(this.worm.runsIntoItself()) {
                this.continues = false;
            }
            
            if(this.worm.runsIntoBorder(this.width, this.height)) {
                this.continues = false;
            }
            
            this.updatable.update();
            setDelay(1000/ worm.getLength());
        }

    }

}
