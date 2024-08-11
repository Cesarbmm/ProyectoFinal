package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BusinessLogic.AdministradorBL;
import DataAccess.DTO.AdministradorDTO;
import UserInterface.Styles;
import UserInterface.CustomerControl.PrjButton;
import UserInterface.CustomerControl.PrjLabel;
import UserInterface.CustomerControl.PrjTextBox;

public class AddSupervisorPanel extends JPanel {
    private AdminTipoPanel adminTipoPanel;
    private PrjButton btnBack;
    private JLabel messageLabel;
    private JLabel info;

    private AdministradorBL administradorbl = new AdministradorBL();
    public PrjTextBox barcodeField;
    private PrjButton btnADD;
    private PrjButton btnDEL;
    private boolean mode = true;

    public AddSupervisorPanel(AdminTipoPanel adminTipoPanel) {
     
        this.adminTipoPanel= adminTipoPanel;
        btnBack = new PrjButton("Volver");
        btnADD = new PrjButton("Agregar");
        btnADD.setForeground(Styles.COLOR_FOREGROUND);
        btnDEL = new PrjButton("Eliminar");
        btnDEL.setForeground(Styles.COLOR_FOREGROUND);
        messageLabel = new PrjLabel();
        barcodeField = new PrjTextBox();
        barcodeField.setPreferredSize(new Dimension(200, 30));

        setLayout(new BorderLayout());

        btnBack.addActionListener(e -> showAdminTipoPanel());
        btnADD.addActionListener(e -> {
             btnADD.setForeground(Styles.COLOR_FOREGROUND);
            btnDEL.setForeground(Styles.COLOR_FOREGROUND_PRESSED);
            this.mode = true;
        });
        btnDEL.addActionListener(e -> {
            btnDEL.setForeground(Styles.COLOR_FOREGROUND);
            btnADD.setForeground(Styles.COLOR_FOREGROUND_PRESSED);
            this.mode = false;
        });

        JPanel northPanel = new JPanel();
        northPanel = paintPanel(northPanel);
        northPanel.setLayout(new FlowLayout());
        JPanel centerPanel = new JPanel();
        centerPanel = paintPanel(centerPanel);
        centerPanel.setLayout(new FlowLayout());
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Styles.COLOR_FONT_LIGHT);
        southPanel.setLayout(new FlowLayout());

        northPanel.add(btnADD);
        northPanel.add(btnDEL);
        add(northPanel, BorderLayout.NORTH);

        centerPanel.add(barcodeField);
        add(centerPanel, BorderLayout.CENTER);

        southPanel.add(btnBack);
        southPanel.add(messageLabel);
        add(southPanel, BorderLayout.SOUTH);

        barcodeField.addActionListener(e -> {
            String barcode = barcodeField.getText();
            if (!barcode.trim().isEmpty()) {
                try {
                    processBarcode(barcode);
                } catch (Exception e1) {
                    // messageLabel.setText("Ups... No se pudo agregar el administrador");
                    JOptionPane.showMessageDialog(this, "Error al procesar el código de barras: " + e1.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                barcodeField.setText(""); // Limpiar el campo de texto después de procesar
            }
        });

        // Solicita el foco en el campo de texto cuando el panel se muestra
        SwingUtilities.invokeLater(() -> barcodeField.requestFocusInWindow());

    }

    private JPanel paintPanel(JPanel panel) {
        panel.setBackground(Styles.COLOR_BACKGROUND);
        return panel;
    }


    private void processBarcode(String barcode) throws Exception {

        if (this.mode) {
            addAdmin(barcode);
        } else {
            delAdmin(barcode);
        }
    }

    private void delAdmin(String barcode) throws Exception {
        boolean tipoAdmin = administradorbl.tipoAdmin(barcode);
        if (tipoAdmin == true && this.mode == false) {
            messageLabel.setText("El codigo ingresado no pertenece a un supervisor");
        } else {
            try {
                boolean exito = administradorbl.delete(barcode);
                if (exito) {
                    messageLabel.setText("Administrador eliminado con éxito de la base de datos");
                }
            } catch (Exception e) {
                messageLabel.setText("Ups... No se pudo eliminar el administrador");
                e.printStackTrace();
            }
        }
    }

    private void addAdmin(String barcode) throws Exception {
        try {
            AdministradorDTO administradorDTO = new AdministradorDTO(barcode, 2);
            boolean exito = administradorbl.add(administradorDTO);
            if (exito) {
                messageLabel.setText("Administrador agregado con éxito en la base de datos");
            }
        } catch (Exception e) {
            messageLabel.setText("Ups... No se pudo agregar el administrador");
            e.printStackTrace();
        }
    }

    private void showAdminTipoPanel() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setContentPane(adminTipoPanel);
            frame.revalidate();
            frame.repaint();
        }
    }
}
