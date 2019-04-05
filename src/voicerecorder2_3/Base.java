package voicerecorder2_3;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

public class Base extends javax.swing.JFrame {
    static int c=0;
    static boolean saved=false;
    static Recorder rec;
    static Timer tim;
    JFileChooser fc;
    FileFilter ff;
    public Base() {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
        }
        rec=new Recorder();
        tim=new Timer();
        fc = new JFileChooser();
        ff=new FileFilter() {

            @Override
            public boolean accept(File file) {
                 if (file.isDirectory()) 
                    return true;
                else
                    if (file.getAbsolutePath().toLowerCase().endsWith(".wav")) 
                        return true;
                return false;
            }

            @Override
            public String getDescription() {
                return "wav";
            }
        };
        fc.addChoosableFileFilter(ff);
        initComponents();
        image.setVisible(false);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hit = new javax.swing.JButton();
        hh = new javax.swing.JLabel();
        mm = new javax.swing.JLabel();
        ss = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Save = new javax.swing.JMenu();
        nu = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voice Recorder 2.3");
        setBackground(new java.awt.Color(100, 100, 100));
        setLocationByPlatform(true);
        setResizable(false);

        hit.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        hit.setText("Record");
        hit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitActionPerformed(evt);
            }
        });

        hh.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        hh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hh.setText("0");

        mm.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        mm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mm.setText("0");

        ss.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        ss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ss.setText("0");

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/voicerecorder2_3/REC.gif"))); // NOI18N
        image.setEnabled(false);

        Save.setText("File");

        nu.setText("New");
        nu.setEnabled(false);
        nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuActionPerformed(evt);
            }
        });
        Save.add(nu);

        save.setText("Save");
        save.setEnabled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        Save.add(save);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        Save.add(exit);

        jMenuBar1.add(Save);

        help.setText("Help");

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(hit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hh, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitActionPerformed
        switch (c) {
            case 0:
                image.setVisible(true);
                image.setEnabled(true);
                rec.Capture(c);
                tim.start();
                hit.setText("Stop");
                ++c;
                break;
            case 1:
                image.setVisible(false);
                image.setEnabled(false);
                ++c;
                tim.stop();
                rec.abort();
                hit.setText("Play");
                save.setEnabled(true);
                nu.setEnabled(true);
                break;
            case 2:
                hit.setText("Stop");
                tim=new Timer();
                tim.start();
                rec.PlayBack(c);
                --c;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_hitActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        int ret=fc.showSaveDialog(this);
        if(ret==JFileChooser.APPROVE_OPTION)
            rec.save(fc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_saveActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
        new about().setVisible(true);
    }//GEN-LAST:event_aboutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        rec.abort();
        tim.stop();
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void nuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuActionPerformed
        // TODO add your handling code here:
        if(saved)
        {
            try {
                rec.reset();
            } catch (Exception ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
            Base.reset();
        }
        else
            new sure().setVisible(true);
    }//GEN-LAST:event_nuActionPerformed
    public static void reset()
    {
        hh.setText("0");
        mm.setText("0");
        ss.setText("0");
        c=0;
        rec=null;
        rec=new Recorder();
        tim=null;
        tim=new Timer();
        saved=false;
        hit.setText("Record");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Save;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu help;
    protected static javax.swing.JLabel hh;
    protected static javax.swing.JButton hit;
    private javax.swing.JLabel image;
    private javax.swing.JMenuBar jMenuBar1;
    protected static javax.swing.JLabel mm;
    private javax.swing.JMenuItem nu;
    private javax.swing.JMenuItem save;
    protected static javax.swing.JLabel ss;
    // End of variables declaration//GEN-END:variables

}