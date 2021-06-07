package RPS;

import java.awt.Component;
import javax.swing.JOptionPane;

/*
 * JOP class, responsible for communicating with the user.
 */
public class JOP
{
	/*
	 * Shows a message using JOption messages.
	 */
    public static void msg(final String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /*
     * Takes input from the user using JOption input.
     */
    public static String in(final String msg) {
        return JOptionPane.showInputDialog(msg);
    }
}
