  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idbased;


import static Idbased.updation.Table_click1;
import static Idbased.upload.ext;
import static Idbased.upload.fileName;
import static Idbased.upload.fileSize;
import static Idbased.upload.inputFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import org.apache.poi.hwpf.HWPFDocument;

/**
 *
 * @author EGC
 */
public class update_files extends javax.swing.JFrame {

    /**
     * Creates new form update_files
     */
     int ss=1;
    
     SecretKey secKey1;
    public static String enc_content;
    String key1,key2;
     String s1="",s2="";
     public static String fid;
     /**
	     * gets the AES encryption key. In your actual programs, this should be safely
	     * stored.
	     * @return
	     * @throws Exception
	     */

	    public static SecretKey getSecretEncryptionKey() throws Exception{
	        KeyGenerator generator = KeyGenerator.getInstance("AES");
	        generator.init(128); // The AES key size in number of bits
	        SecretKey secKey = generator.generateKey();
	        return secKey;
	    }
            
            
            /**
	     * Encrypts plainText in AES using the secret key
	     * @param plainText
	     * @param secKey
	     * @return
	     * @throws Exception
	     */
	    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{
	        // AES defaults to AES/ECB/PKCS5Padding in Java 7
	        Cipher aesCipher = Cipher.getInstance("AES");
	        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
	        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
	        return byteCipherText;
	    }
            
            
            
             /**
	     * Decrypts encrypted byte array using the key used for encryption.
	     * @param byteCipherText
	     * @param secKey
	     * @return
	     * @throws Exception
	     */
	    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {
	        // AES defaults to AES/ECB/PKCS5Padding in Java 7
	        Cipher aesCipher = Cipher.getInstance("AES");
	        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
	        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
	        return new String(bytePlainText);
	    }
            
            
            
            
            /**
	     * Convert a binary byte array into readable hex form
	     * @param hash
	     * @return
	     */
	    private static String  bytesToHex(byte[] hash) {
	        return DatatypeConverter.printHexBinary(hash);

	    }
        
     
      public static String fn;
     
    public update_files() {
        initComponents();
        this.setResizable(false);
         this.setResizable(false);
         this.setLocationRelativeTo(null);
//        jLabel14.setText("Welcome! Data Owner");
        String file_name=Table_click1;
      
        
          try {
            // TODO add your handling code here:
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rollback","root","");
            java.sql.Statement stmt=con.createStatement();
            String sql = "SELECT * from enc WHERE file_name='"+file_name+"'";
            
            ResultSet rs1 = stmt.executeQuery(sql);
           
            while(rs1.next())
            {
                fn=rs1.getString("file_name");
                jTextField3.setText(rs1.getString("file_name"));
                jTextArea1.setText(rs1.getString("original_content"));
                jTextField4.setText(rs1.getString("search_keyword"));
                jTextField5.setText(rs1.getString("search_keyword1"));
                jTextField6.setText(rs1.getString("secret_key"));
                jTextField7.setText(rs1.getString("proof_index")+" "+rs1.getString("proof_index1"));
                jTextArea2.setText(rs1.getString("enc_content"));
                
               fid=rs1.getString("file_id");
                
          
                
            }
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cloud_approve_request.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cloud_approve_request.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
    
    
    public static int a=1;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("Update File and Search Keywords");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextField3.setToolTipText("File Name");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextField4.setToolTipText("Serach Keyword 1");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setLabel("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel9.setText("File Content");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextField5.setToolTipText("Search Keyword 2");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel12.setText("File Name");

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel13.setText("Search Keyword 1");

        jLabel15.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel15.setText("Search Keyword 2");

        jLabel16.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel16.setText("Secret Key");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextField6.setToolTipText("Secret Key");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel18.setText("Encrypted Index");

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jTextField7.setToolTipText("Encrypted Index");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel19.setText("Encrypted File");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTextField3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
          try {                                         
              // TODO add your handling code here:
              
              
              try {
                  JFileChooser jfc = new JFileChooser();
                  //jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                  if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                      inputFile = jfc.getSelectedFile().getName();
                      fileName = jfc.getSelectedFile().getName();
                      fileSize = jfc.getSelectedFile().length();
                      ext = getExtension(jfc.getSelectedFile());
                      jTextField3.setText(inputFile);
                      
                      
                      if((ext.equalsIgnoreCase("txt"))||(ext.equalsIgnoreCase("csv"))){
                          
                          try{
                              BufferedReader br=new BufferedReader(new FileReader(jfc.getSelectedFile().getPath()));
                             
                              while((s1=br.readLine())!=null){
                                  System.out.println(s1);
                                  s2+=s1+"\n";
                              }
                              
                              ss=0;
                              br.close();
                          }catch (Exception ex)
                          {ex.printStackTrace();  }
                      }
                      
                      
                      
                      if((ext.equalsIgnoreCase("doc"))||(ext.equalsIgnoreCase("docx"))){
                          
                          FileInputStream fistream = new FileInputStream(jfc.getSelectedFile().getPath());
                          HWPFDocument document = new HWPFDocument(fistream);
                          System.out.println("Length of docment is :"
                                  + document.characterLength());
                          System.out.println(document.getText());
                          System.out.println(document.getDocumentText());
                          
                          
                          
                          
                          
                          
                      }}
              } catch (Exception ex) {
              }
              
              if(ss==0){
                  
                  try
                  {
                      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rollback","root","");
                      java.sql.Statement stmt=con.createStatement();
                      ResultSet rs = stmt.executeQuery("select * from enc where file_name='"+jTextField3.getText()+"' and original_content='"+jTextArea1.getText()+"'");
                      while(rs.next())
                      {
                          
                          a = 0;
                          JOptionPane.showMessageDialog(this, "Duplication Occured! File Already exits in a cloud");
                          
                          
                      }
                  }
                  catch(SQLException ex)
                  {
                      ex.printStackTrace();
                  }
                  
                  
                  if(a!=0){
                      try
                      {
                          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rollback","root","");
                          java.sql.Statement stmt=con.createStatement();
                          ResultSet rs = stmt.executeQuery("select * from enc where file_name='"+jTextField3.getText()+"'");
                          while(rs.next())
                          {
                              
                              
                              JOptionPane.showMessageDialog(this, "File_name already exists. Change the File_name and Store.");
                              
                          }
                      }
                      catch(SQLException ex)
                      {
                          ex.printStackTrace();
                      }
                  }
              }
              
              
              
              secKey1 = getSecretEncryptionKey();
              byte[] cipherText = encryptText(s2, secKey1);
                enc_content=""+bytesToHex(cipherText);
                jTextField6.setText(secKey1.toString());
                jTextArea2.setText(""+bytesToHex(cipherText));
                
                
                 File encryptedFile = new File("Cloudme\\Server\\" + "\\" + fileName);
                FileWriter fw=new FileWriter(encryptedFile);
                BufferedWriter bw=new BufferedWriter(fw);
                jTextArea2.write(bw);
              
              
          } catch (Exception ex) {
             Logger.getLogger(update_files.class.getName()).log(Level.SEVERE, null, ex);
        }
        
jTextArea1.setText(s2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         try {
             // TODO add your handling code here:
             
             String s1= JOptionPane.showInputDialog("Enter the Search Keyword 1 ");
             jTextField4.setText(s1);
             
             File encryptedFile = new File("Cloudme\\Server\\" + "\\" + fileName+"search1.txt");
                FileWriter fw=new FileWriter(encryptedFile);
                BufferedWriter bw=new BufferedWriter(fw);
                jTextField4.write(bw);
             
             
             MessageDigest md = MessageDigest.getInstance("SHA-256");
             //  FileInputStream fis = new FileInputStream("./"+fn);
             FileInputStream fis = new FileInputStream("Cloudme\\Server\\" + "\\" +fileName+ "search1.txt");
             
             byte[] dataBytes = new byte[1024];
             
             int nread = 0;
             while ((nread = fis.read(dataBytes)) != -1) {
                 md.update(dataBytes, 0, nread);
             };
             byte[] mdbytes = md.digest();
             
             //convert the byte to hex format method 1
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < mdbytes.length; i++) {
                 sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             
             System.out.println("Hex format : " + sb.toString());
             
             //convert the byte to hex format method 2
             StringBuffer hexString = new StringBuffer();
             for (int i=0;i<mdbytes.length;i++) {
                 hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
             }
             key1=hexString.toString();
             //String kk=key;
             key1=hexString.toString();
             
             //System.out.println("Hex format : " + hexString.toString());
             jTextField7.setText(hexString.toString());
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(update_files.class.getName()).log(Level.SEVERE, null, ex);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(update_files.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(update_files.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
      
      
       try {
             // TODO add your handling code here:
             
            String s1= JOptionPane.showInputDialog("Enter the Search Keyword 2 ");
      jTextField5.setText(s1);
             
             File encryptedFile = new File("Cloudme\\Server\\" + "\\" + fileName+"search2.txt");
                FileWriter fw=new FileWriter(encryptedFile);
                BufferedWriter bw=new BufferedWriter(fw);
                jTextField5.write(bw);
             
             
             MessageDigest md = MessageDigest.getInstance("SHA-256");
             //  FileInputStream fis = new FileInputStream("./"+fn);
             FileInputStream fis = new FileInputStream("Cloudme\\Server\\" + "\\" +fileName+ "search2.txt");
             
             byte[] dataBytes = new byte[1024];
             
             int nread = 0;
             while ((nread = fis.read(dataBytes)) != -1) {
                 md.update(dataBytes, 0, nread);
             };
             byte[] mdbytes = md.digest();
             
             //convert the byte to hex format method 1
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < mdbytes.length; i++) {
                 sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             
             System.out.println("Hex format : " + sb.toString());
             
             //convert the byte to hex format method 2
             StringBuffer hexString = new StringBuffer();
             for (int i=0;i<mdbytes.length;i++) {
                 hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
             }
             key1=hexString.toString();
             //String kk=key;
             key1=hexString.toString();
             
             //System.out.println("Hex format : " + hexString.toString());
             jTextField7.setText(jTextField7.getText()+hexString.toString());
         } catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(update_files.class.getName()).log(Level.SEVERE, null, ex);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(update_files.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(update_files.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        try
            {
                Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rollback","root","");
                String sql = "UPDATE enc SET file_name = '"+jTextField3.getText()+"', original_content='"+jTextArea1.getText()+"', search_keyword='"+jTextField4.getText()+"', search_keyword1='"+jTextField5.getText()+"', secret_key='"+jTextField6.getText()+"', enc_content='"+jTextArea2.getText()+"', file_size='"+fileSize+"', file_format='"+ext+"' where file_id = '"+fid+"'";
                File file = new File("Cloudme\\Server\\\\"+fn);
       file.delete();
        File file1 = new File("Cloudme\\Server\\\\"+fn+"search1.txt");
       file1.delete(); 
       File file2 = new File("Cloudme\\Server\\\\"+fn+"search2.txt");
       file2.delete();
                
                Statement stmt=con.createStatement();
                stmt.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(this, "File Updated Successfully");
                
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(cloud_approve_request.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(update_files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update_files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update_files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update_files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update_files().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
