package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import UserInterface.Styles;

public class PrjButton extends JButton implements MouseListener {

    public PrjButton(String text) {
        customizeComponent(text);
    }

    public PrjButton(String text, String iconPath) {
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath) {

        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20);

        setIcon(new ImageIcon(iconPath));
        setFont(Styles.FONT);
    }

    public void customizeComponent(String text) {
        setText(text);
        setOpaque(true);
        setFocusPainted(false);
        setBorderPainted(false);

        setContentAreaFilled(true);
        setForeground(Styles.COLOR_FONT);
        setHorizontalAlignment(Styles.ALIGNMENT_LEFT);
        setFont(Styles.FONT);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(Styles.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(Styles.CURSOR_DEFAULT);
    }

}
