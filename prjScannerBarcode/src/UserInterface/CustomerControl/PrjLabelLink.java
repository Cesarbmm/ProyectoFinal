package UserInterface.CustomerControl;

import javax.swing.ImageIcon;

import UserInterface.Styles;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PrjLabelLink extends PrjLabel implements MouseListener {

    public PrjLabelLink(String text) {
        super(text);
        setPersonalizacion();
    }

    public PrjLabelLink(String text, String iconPath) {
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }

    void setPersonalizacion() {
        addMouseListener(this);
        setOpaque(false);
        setForeground(Styles.COLOR_FONT);
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
        this.setCursor(Styles.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(Styles.CURSOR_DEFAULT);
    }

}
