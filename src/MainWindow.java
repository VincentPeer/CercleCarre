import utils.FillRenderer;
import utils.OutlineRenderer;
import world.WorldView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow implements Displayer, KeyListener {
    private static MainWindow instance;
    private JFrame frame;
    private WorldView world;
    private MainWindow() {

        frame = new JFrame();
        // Bouton Fermer
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);
        world = new WorldView(600, 600);
        add(world);
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

    public JFrame getFrame() {
        return frame;
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

//    //todo testing
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'e' : //efacer affichage
            case 'b' :
                world.addShapes(10, 10, new OutlineRenderer());
                break;// todo renderer singleton generer 10 cercle et carre bordure
            case 'f' :
                world.addShapes(10, 10, new FillRenderer());
                break;//10 cercle 10 carre plein
            case 'q' : // quiter

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
