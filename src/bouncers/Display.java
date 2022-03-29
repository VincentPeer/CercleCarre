package bouncers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Display implements Displayer {
    private static Display instance;
    private final JFrame frame;
    private Image image;
    JPanel panel;

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

    public static Display getInstance(int width, int height) {
        if (instance == null)
            instance = new Display();
        instance.panel.setPreferredSize(new Dimension(width, height));
        instance.frame.pack();
        return instance;
    }

    public void addKeyListener(KeyListener listener) {
        frame.addKeyListener(listener);
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    @Override
    public void repaint() {
        frame.repaint();
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
