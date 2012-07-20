/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fotossii;

import javax.swing.*;

public class FotoSii extends JApplet {

    JTabbedPane jtp = new JTabbedPane();

    public void init() {
        jtp.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent e) {
                if (java.awt.event.KeyEvent.getKeyText(e.getKeyChar()).equals("Escape")) {
                    JOptionPane.showMessageDialog(null, "\"Alumnos ITM\"\nPor: MiichaelD\nDiciembre/2011", "About", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("about.jpg")));

                }
            }
        });
        jtp.addTab("Alumnos", new Panel());
        jtp.addTab("Generacion", new Panel1());
        this.add(jtp);

    }
    // TODO overwrite start(), stop() and destroy() methods
}
