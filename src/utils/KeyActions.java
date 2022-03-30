package utils;

import bouncers.Bouncers;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Take key event press by the user
 * @authors De Bleser, Peer
 */
public class KeyActions implements KeyListener {
    private final Bouncers bouncers;

    /**
     * Constructor of a specific KeyListener for Bouncer class
     * @param bouncers a Bouncer class to act on
     */
    public KeyActions(Bouncers bouncers) {
        this.bouncers = bouncers;
    }

    /**
     * Handles the keyTyped event by invoking the keyTyped methods on listener-a and listener-b.
     * @param e the key event
     */
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'e' :
                bouncers.clearShapes();
                break;
            case 'b' :
                bouncers.addShapes(10, Color.GREEN, Color.RED, new OutlineRenderer());
                break;
            case 'f' :
                bouncers.addShapes(10, Color.BLUE, Color.ORANGE, new FillRenderer());
                break;
            case 'q' :
                bouncers.quit();
        }
    }

    /**
     * Key pressed listener (no action)
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // do nothing
    }

    /**
     * Key released listener (no action)
     * @param e KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }
}
