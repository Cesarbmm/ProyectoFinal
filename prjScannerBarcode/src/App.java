import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import UserInterface.Form.MainForm;
import UserInterface.Form.SplashForm;

public class App {
    public static void main(String[] args) throws Exception {
        
        // FlatLightLaf.setup();
        // FlatLightLaf.supportsNativeWindowDecorations();
        // try {
        //     UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        // } catch (UnsupportedLookAndFeelException e) {
        //     e.printStackTrace();
        // 
        new SplashForm();
       new MainForm("Easy Access Alpha 0.0.1", true);

    }
}
