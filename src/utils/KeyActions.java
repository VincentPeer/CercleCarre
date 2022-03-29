package utils;

import bouncers.Bouncers;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyActions implements KeyListener {
    Bouncers bouncers;

    public KeyActions(Bouncers bouncers) {
        this.bouncers = bouncers;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'e' :
                bouncers.removeShapes();
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

    @Override
    public void keyPressed(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }
}
