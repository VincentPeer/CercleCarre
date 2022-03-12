import javax.swing.*;
import java.awt.*;

public class MainWindow extends  JFrame{

    MainWindow() {
        // Bouton Fermer
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public Component add(Component comp) {
        super.add(comp);
        pack(); // Redimensionnement par rapport au sous contenu
        return comp;
    }
}
