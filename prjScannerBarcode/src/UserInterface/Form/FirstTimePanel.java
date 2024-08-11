package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import UserInterface.Styles;

public class FirstTimePanel extends JPanel {

    private Image fondo;

    BorderLayout borderLayout;

    public FirstTimePanel() {
        customizeComponent();
    }

    public void customizeComponent() {
        this.fondo = new ImageIcon(Styles.URL_FONDO).getImage();
        borderLayout = new BorderLayout();
        setLayout(borderLayout);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
}
