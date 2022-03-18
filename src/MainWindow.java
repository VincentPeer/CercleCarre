import javax.swing.*;
import java.awt.*;

public class MainWindow implements Displayer{
    private static MainWindow instance;
    private JFrame frame;
    private MainWindow() {

        frame = new JFrame();
        // Bouton Fermer
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static MainWindow getInstance() {
        if (instance == null)
            instance = new MainWindow();
        return instance;
    }

    public Component add(Component comp) {
        frame.add(comp);
        frame.pack(); // Redimensionnement par rapport au sous contenu
        return comp;
    }

    @Override
    public int getWidth() {
        return frame.getWidth();
    }

    @Override
    public int getHeight() {
        return frame.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D)frame.getGraphics();
    }

    @Override
    public void repaint() {
        frame.repaint();
    }

    @Override
    public void setTitle(String title) {

    }
}
