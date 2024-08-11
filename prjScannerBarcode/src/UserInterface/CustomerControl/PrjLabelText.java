package UserInterface.CustomerControl;

import javax.swing.*;

import java.awt.BorderLayout;

import UserInterface.Styles;

public class PrjLabelText extends JPanel {
    private PrjLabel lblEtiqueta = new PrjLabel();
    private PrjTextBox txtContenido = new PrjTextBox();

    public PrjLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(etiqueta, Styles.FONT_SMALL, Styles.COLOR_FONT_LIGHT, Styles.ALIGNMENT_LEFT);

        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
