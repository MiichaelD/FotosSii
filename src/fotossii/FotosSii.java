package fotossii;
import javax.swing.*;
import javax.imageio.*;
public class FotosSii {
    /*
    *************************************************************
    * Aplicación para visualizar fotos de los alumnos del ITM   * 
    * almacenadas en el sitio: http://sii.itmexicali.edu.mx     *
    *                                                           *
    * Solo ingresa tu numero de control, tambien tendras la     *
    * posibilidad de descargar la imagen.                       *
    *                                                           *
    * En el apartado de 'Generación' la diferencia es que las   *
    * imagenes se iran cambiando (velocidad varia de ancho de   *
    * banda del servidor)                                       *
    *                                                           * 
    * MiichaelD                                                 *
    * ***********************************************************
    */
    
    static JFrame f;
    JTabbedPane jtp;
    
    FotosSii(){
    //JFrame.setDefaultLookAndFeelDecorated(true);
    f=new JFrame();
    jtp=new JTabbedPane();
    jtp.addKeyListener(new java.awt.event.KeyAdapter() {            
    	public void keyPressed(java.awt.event.KeyEvent e) {
    		if(java.awt.event.KeyEvent.getKeyText(e.getKeyChar()).equals("Escape")){
                    JOptionPane.showMessageDialog(null,"\"Alumnos ITM\"\nPor: MiichaelD\nDiciembre/2011","About"
                    ,JOptionPane.PLAIN_MESSAGE,new ImageIcon(getClass().getResource("about.jpg")));	
		 
    		}
    	}
    });
    jtp.addTab("Alumnos",new Panel());
    jtp.addTab("Generacion",new Panel1());
    f.add(jtp);
    try{
      f.setIconImage(ImageIO.read(new java.net.URL("http://www.itmexicali.edu.mx/images2/bufalo.jpg")));
     }catch (Exception e){e.printStackTrace();}
     f.setVisible(true);
     f.setTitle("Alumnos Tec Mexicali: ");
     f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     f.pack();
     f.setLocationRelativeTo(null);
    }
    
   public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FotosSii();
            }
        });
    }
}
