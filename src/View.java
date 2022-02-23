// importing Java AWT class
import java.awt.*;

public class View extends Frame {
    // initializing using constructor
    View() {

        // frame size 300 width and 300 height
        setSize(300,300);

        // setting the title of Frame
        setTitle("Bouncers");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);
    }
}