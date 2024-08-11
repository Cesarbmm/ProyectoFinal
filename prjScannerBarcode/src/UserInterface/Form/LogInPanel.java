package UserInterface.Form;

import java.awt.*;
import javax.swing.*;

import UserInterface.Styles;
import UserInterface.CustomerControl.PrjButton;

public class LogInPanel extends JPanel {

    private MenuPanel menuPanel;
    private PrjButton btnHome;
    private PrjButton btnaddAdmin;
    private PrjButton btnProduct;

    public LogInPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        btnHome = new PrjButton("Regresar al menu");
        btnaddAdmin = new PrjButton("Configuracion de administrador");
        btnProduct = new PrjButton("Administrar Productos");
        btnaddAdmin.setForeground(Styles.COLOR_FONT_LIGHT);

        setLayout(new BorderLayout());
        
        btnHome.addActionListener(e -> showMenuPanel());
        btnProduct.addActionListener(e -> showProductTipo());

        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(btnHome);
        southPanel =paintPanel(southPanel);
        add(southPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 300));
        centerPanel.add(btnaddAdmin);
        southPanel = paintPanel(centerPanel);
        centerPanel.add(btnProduct);
        add(centerPanel, BorderLayout.CENTER);

    }

    
    private JPanel paintPanel(JPanel panel) {
        panel.setBackground(Styles.COLOR_BACKGROUND);
        return panel;
    }


    public LogInPanel(MenuPanel menuPanel, boolean tipo) {
        this.menuPanel = menuPanel;
        btnHome = new PrjButton("Regresar al menu");
        btnaddAdmin = new PrjButton("Configuracion de administrador");
        btnaddAdmin.setForeground(Styles.COLOR_FONT);
        btnProduct = new PrjButton("Administrar Productos");
        btnProduct.setForeground(Styles.COLOR_FONT);

        setLayout(new BorderLayout());

        btnHome.addActionListener(e -> showMenuPanel());
        btnaddAdmin.addActionListener(e -> showAdminTipo());
        btnProduct.addActionListener(e -> showProductTipo());

        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(btnHome);
        southPanel.setBackground(Styles.COLOR_FONT_LIGHT);
        add(southPanel, BorderLayout.SOUTH);
        
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 300));
        centerPanel.add(btnaddAdmin);
        centerPanel = paintPanel(centerPanel);
        centerPanel.add(btnProduct);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void showAdminTipo() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setContentPane(new AdminTipoPanel(this));
            frame.revalidate();
            frame.repaint();
        }
    }

    private void showMenuPanel() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setContentPane(menuPanel);
            frame.revalidate();
            frame.repaint();
        }
    }
    private void showProductTipo(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setContentPane(new ProductTipoPanel(this));
            frame.revalidate();
            frame.repaint();
        } 
    }
}
