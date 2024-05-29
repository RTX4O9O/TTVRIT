import javax.swing.*;

public class Notify {

    public static void error() {
        JOptionPane.showMessageDialog(null, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void error(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void warning() {
        JOptionPane.showMessageDialog(null, "Warning", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    public static void warning(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
