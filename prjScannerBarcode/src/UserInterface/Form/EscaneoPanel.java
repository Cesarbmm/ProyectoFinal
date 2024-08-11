package UserInterface.Form;

import javax.swing.*;
import BusinessLogic.ProductoBL;
import UserInterface.Styles;
import UserInterface.CustomerControl.PrjButton;
import UserInterface.CustomerControl.PrjTextBox;

import java.awt.*;
import java.text.NumberFormat.Style;

public class EscaneoPanel extends JPanel {

    private JLabel messageLabel;
    public PrjTextBox barcodeField;
    private ProductoBL productosbl = new ProductoBL(); 
    private PrjButton btnHome;
    private MenuPanel menuPanel;
    private Image fondo;
    public EscaneoPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        btnHome = new PrjButton("Regresar al menu");
        setLayout(new BorderLayout());
        setBackground(Styles.COLOR_BACKGROUND);
        messageLabel = new JLabel("Esperando a que escanee el código del producto...", SwingConstants.CENTER);
        messageLabel.setForeground(Styles.COLOR_FOREGROUND);
        messageLabel.setFont(Styles.FONT_BOLD_24);
        add(messageLabel, BorderLayout.CENTER);

        barcodeField = new PrjTextBox();
        barcodeField.setPreferredSize(new Dimension(200, 30)); 
        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.setBackground(Styles.COLOR_FONT_LIGHT);
        southPanel.add(barcodeField);
        southPanel.add(btnHome);

        add(southPanel, BorderLayout.SOUTH);

        btnHome.addActionListener(e -> showMenuPanel());
        
        barcodeField.addActionListener(e -> {
            String barcode = barcodeField.getText();
            if (!barcode.trim().isEmpty()) {
                try {
                    processBarcode(barcode);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(this, "Error al procesar el código de barras: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                barcodeField.setText("");
            }
        });
        

        SwingUtilities.invokeLater(() -> barcodeField.requestFocusInWindow());
    }

    private void processBarcode(String barcode) throws Exception {
        String nombre = productosbl.getNombreBy(barcode);
        String precio = productosbl.getPrecioBy(barcode);
        messageLabel.setText(
                             "Producto: " + nombre + "\n" +
                             "\nPrecio: " + precio + "\n" );
                           
    }

    private void showMenuPanel() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.setContentPane(menuPanel);
            frame.revalidate();
            frame.repaint();
        }
    }
}

