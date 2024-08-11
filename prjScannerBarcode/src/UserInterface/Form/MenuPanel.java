package UserInterface.Form;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.text.NumberFormat.Style;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import UserInterface.Styles;
import UserInterface.CustomerControl.PrjButton;

public class MenuPanel extends JPanel {

    private PrjButton btnCliente = new PrjButton("Escanear");
    private PrjButton btnAdministrador = new PrjButton("Log In");
    private Image fondo;

    public MenuPanel() {
        customizeComponent();
        btnCliente.addActionListener(e -> showEscaneoPanel());
        btnAdministrador.addActionListener(e -> showEscaneoLogin());
    }

    private void customizeComponent() {
        this.fondo = new ImageIcon(Styles.URL_FONDO).getImage();
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 300));

        btnCliente.setForeground(Styles.COLOR_FONT);
        add(btnCliente);
        add(btnAdministrador);
    }

    private void showEscaneoPanel() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setContentPane(new EscaneoPanel(this)); // Pasar 'this' para el botón 'Regresar al menu'
            frame.revalidate();
            frame.repaint();
        }
    }

    private void showEscaneoLogin() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setContentPane(new EscaneoLogin(this));
            frame.revalidate();
            frame.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
}
