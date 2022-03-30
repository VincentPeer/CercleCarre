package bouncers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 *
 * @authors De Bleser, Peer
 */
public class Display implements Displayer {
    private static Display instance;
    private final JFrame frame;
    private Image image;
    private final JPanel panel;

    /**
     * Constructor of our Displayer. Creates a mainWindow and ads a panel to draw on it.
     */
    private Display() {
        frame = new JFrame();
        // Close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding Panel with custom paintComponent
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null)
                    g.drawImage(image, 0, 0, this);
                image = createImage(getWidth(), getHeight());
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Access to the single instance of this class. If no instance exists, one is created
     * @param width width of the drawing panel
     * @param height height of the drawing panel
     * @return singleton instance of the class
     */
    public static Display getInstance(int width, int height) {
        if (instance == null)
            instance = new Display();
        instance.panel.setPreferredSize(new Dimension(width, height));
        instance.frame.pack();
        return instance;
    }

    /**
     * Ads a KeyListener to the main Frame
     * @param listener the listener to add
     */
    public void addKeyListener(KeyListener listener) {
        frame.addKeyListener(listener);
    }

    /**
     * @return width of the drawing panel
     */
    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    /**
     * @return height of the drawing panel
     */
    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    /**
     * Creates a graphics context for drawing to an off-screen image.
     * This method can only be called for off-screen images.
     * @return A graphics context to draw to the off-screen image.
     */
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    /**
     * Updates the graphics of our frame, using
     */
    @Override
    public void repaint() {
        frame.repaint();
    }

    /**
     * Sets window title
     * @param title title of the window
     */
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
