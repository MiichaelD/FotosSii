package fotossii;
import javax.swing.*;
import java.net.*;
import java.io.*;
public class Panel extends javax.swing.JPanel {
    
    public Panel() {
        initComponents();
        path=System.getProperty("user.home")+File.separator+"FotosAlumnos"+File.separator;
        if('/'==File.separatorChar)
            NOseparador="\\";
        else NOseparador="/";
    }
    
    URL url=null;
    static String path;
    String NOseparador;
    File file;
    int Byte;
    InputStream in;
    OutputStream out;        
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel1.setText("Numero de Control:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotossii/Sin titulo.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jButton1.setText("Descargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel3MouseWheelMoved(evt);
            }
        });

        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotossii/pencil.png"))); // NOI18N
        jLabel4.setToolTipText("Cambiar directorio de descarga");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel4)))
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void aviso(final String msj){
        if(jLabel3.getText().equals(""))
        new Thread(new Runnable() {
		        public void run(){
                            try{ 
		        	jLabel3.setText(msj);
                                Thread.sleep(1500);
                                jLabel3.setText("");
                            }catch(Exception e){}
		        	} }).start();
        else jLabel3.setText(msj);
    }
    
    public void verProps(){
    java.util.Scanner in=new java.util.Scanner(""+System.getProperties());
    in.useDelimiter(",");
    while(in.hasNext()){
    System.out.printf("%s\n",in.next());
    }
    }
    
    public void fetch(){
        if(tf.getText().length()!=8&&!tf.getText().equals("lidia")&&!tf.getText().equals("claudia")
           &&!tf.getText().equals("luis")&&!tf.getText().equals("isabel")&&!tf.getText().equals("olvera")
                &&!tf.getText().equals("socorro")&&!tf.getText().equals("manuel"))
            JOptionPane.showMessageDialog(this,"Numero de control Incorrecto");
        else{ 
        try{
            if(tf.getText().equals("director"))url=new URL("http://www.itmexicali.edu.mx/images2/director.jpg");
            else if(tf.getText().equals("benjamin")||tf.getText().equals("lidia")||tf.getText().equals("claudia")
                    ||tf.getText().equals("isabel")||tf.getText().equals("luis")||tf.getText().equals("olvera")||
                    tf.getText().equals("socorro")||tf.getText().equals("manuel"))
                  url=new URL("http://www.syc.itmexicali.edu.mx/fotos/"+tf.getText()+"2.jpg");
            else  url=new URL("http://sii.itmexicali.edu.mx/img/fotos/alumnos/"+tf.getText()+".jpg");
         url.getContent();
        jLabel2.setIcon(new ImageIcon(url)); 
        
        }catch(Exception e){jLabel2.setIcon(new ImageIcon(getClass().getResource("/fotossii/Sin titulo.png")));
                url=null; aviso("Error en obtencion de Imagen");}
        }
    }
    
    public void download(){
    if(url==null)JOptionPane.showMessageDialog(this,"Debes cargar la imagen Primero");
    else
        try{
        if(tf.getText().length()==7)tf.setText("0"+tf.getText());
        in = url.openStream();
        file=new File(path+tf.getText()+".jpg");
        if(!file.getParentFile().exists()){//si no existe el path
            System.out.printf("No existía path: %s\n",file.getParentFile());
            file.getParentFile().mkdirs();}
        out = new BufferedOutputStream(new FileOutputStream(file));
        
        while((Byte=in.read())!=-1)out.write(Byte);
        out.close();
        in.close();
       aviso("Foto Descargada");
        }catch(Exception e){aviso("Error escribiendo archivo");}}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       download();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fetch();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
         new Thread(new Runnable() {
		        public void run(){
                            JOptionPane.showMessageDialog(null,jLabel2.getIcon());
		        	} }).start();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
     fetch();
    }//GEN-LAST:event_tfActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      String path2=JOptionPane.showInputDialog("Cambiar directorio de descarga",path);
      if(path2!=null){
          path=path2.replace(NOseparador, File.separator);
          if(!path.endsWith(File.separator))
              path+=File.separator;
      }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel3MouseWheelMoved
    verProps();
    }//GEN-LAST:event_jLabel3MouseWheelMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
