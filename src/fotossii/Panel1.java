package fotossii;
import javax.swing.*;
import java.net.*;
import java.io.*;
public class Panel1 extends javax.swing.JPanel {
    
    public Panel1() {
        initComponents();    
        jCheckBox1.setSelected(false);
    }
    
    URL url=null;
    int Byte,errores=0;
    File file;
    InputStream in;
    OutputStream out;
    boolean stop=true;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        tf = new javax.swing.JTextField();

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

        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Detener");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Descargar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(60, 60, 60)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void aviso(final String msj){
        if(jLabel3.getText().equals(""))
        new Thread(new Runnable() {
            @Override
		        public void run(){
                            try{ 
		        	jLabel3.setText(msj);
                                Thread.sleep(1500);
                                jLabel3.setText("");
                            }catch(Exception e){}
		        	} }).start();
        else jLabel3.setText(msj);
    }
    
    public void fetch(){
        if(stop){
        stop=false;
        errores=0;
        if(tf.getText().length()!=8) JOptionPane.showMessageDialog(this,"Numero de control Incorrecto");
        else{ 
            new Thread(new Runnable() {public void run(){                            
            for(int i=0;i<3000;i++){
                if(errores>20||stop){stop=true; break;}
                try{
                if(tf.getText().length()==7)
                    tf.setText("0"+tf.getText());
                url=new URL("http://sii.itmexicali.edu.mx/img/fotos/alumnos/"+tf.getText()+".jpg");
                try{
                url.getContent();
                 jLabel2.setIcon(new ImageIcon(url)); 
                }catch(Exception e){errores++;
                    jLabel2.setIcon(new ImageIcon(getClass().getResource("/fotossii/Sin titulo.png")));}
              
//DESCARGAR                
               if(jCheckBox1.isSelected())download();
                 errores=0;              
                 tf.setText(""+((Integer.parseInt(tf.getText()))+1));
                 if(tf.getText().length()==7)tf.setText("0"+tf.getText());
                 }catch(Exception e){aviso("Error en obtención de Imagen");
                    errores++;
                     jLabel2.setIcon(new ImageIcon(getClass().getResource("/fotossii/Sin titulo.png")));}
             } stop=true;           
           } }).start();
            
        }
        }
    }
    
    public void download(){
        try{
        if(tf.getText().length()==7)tf.setText("0"+tf.getText());
            in = url.openStream();
            file=new File(Panel.path+tf.getText()+".jpg");
            if(!file.getParentFile().exists()){//si no existe el path
                System.out.printf("No existe path: %s\n",file.getParentFile());
                file.getParentFile().mkdirs();}
        out = new BufferedOutputStream(new FileOutputStream(file));
        while((Byte=in.read())!=-1)out.write(Byte);
        out.close();
        in.close();
        aviso("Foto Descargada");
        }catch(Exception e){aviso("Error escribiendo archivo");}
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fetch();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        stop=true;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Thread(new Runnable() {
		        public void run(){
                            JOptionPane.showMessageDialog(null,jLabel2.getIcon());
		        	} }).start();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
    fetch();
    }//GEN-LAST:event_tfActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
