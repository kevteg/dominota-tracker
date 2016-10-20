/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author keeeevin
 */
public class initial extends javax.swing.JFrame {

    /**
     * Creates new form initial
     */
    public initial() {
        initComponents();
        setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Ir al menú");
        JMenu consutas = new JMenu("Consultas(Fecha)");
        JMenu consutas1 = new JMenu("Consultas");
        JMenu emp = new JMenu("Emparejar");
        menu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                goBack();
            }
            @Override
            public void menuDeselected(MenuEvent e) {}
            @Override
            public void menuCanceled(MenuEvent e) {}
        });
  
        JMenuItem itemn = new JMenuItem("Victorias de equipo");
        itemn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                teamVictoriesName();
            }
        });
        consutas1.add(itemn);
         JMenuItem itemn1 = new JMenuItem("Victorias de usuario");
        itemn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                playerVictoriesName();
            }
        });
        consutas1.add(itemn1);
        
        
        JMenuItem item = new JMenuItem("Victorias de equipo");
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                teamVictories();
            }
        });
        consutas.add(item);
        JMenuItem item1 = new JMenuItem("Perdidas de equipo");
        item1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                teamLosts();
            }
        });
        consutas.add(item1);
         JMenuItem item2 = new JMenuItem("Victorias de usuario");
        item2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                playerVictories();
            }
        });
        consutas.add(item2);
        JMenuItem item3 = new JMenuItem("Perdidas de usuario");
        item3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                playerLoses();
            }
        });
        consutas.add(item3);
        JMenuItem item4 = new JMenuItem("Porcentaje de victorias de equipo");
        item4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                teamPorc();
            }
        });
        consutas.add(item4);
        JMenuItem item5 = new JMenuItem("Porcentaje de victorias de usuario");
        item5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                playerPorc();
            }
        });
        consutas.add(item5);
        JMenuItem item6 = new JMenuItem("Zapatos de equipo");
        item6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                teamShoe();
            }
        });
        consutas.add(item6);
        JMenuItem item7 = new JMenuItem("Zapatos de usuario");
        item7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                playerShoe();
            }
        });
        JMenuItem iteme1 = new JMenuItem("Buscar mejor oponente para equipo");
        iteme1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                best4team();
            }
        });
        emp.add(iteme1);
        JMenuItem iteme2 = new JMenuItem("Buscar mejor oponente para usuario");
        iteme2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                best4player();
            }
        });
        emp.add(iteme2);
        
        consutas.add(item7);
        menuBar.add(menu);
        menuBar.add(consutas);
        menuBar.add(consutas1);
        menuBar.add(emp);
        
        this.setJMenuBar(menuBar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        choice1 = new java.awt.Choice();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Droid Sans", 0, 36)); // NOI18N
        jLabel2.setText("DOMINOTA");

        jButton1.setText("Nuevo Juego");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Estadisticas generales");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Información sobre partidas de equipos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Información sobre partidas de usuarios");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Top 3 jugadores");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cargar última partida");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      j.dominoInterface();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Integer[] info = j.Estadisticas();
        statisticsPanel panelE = new statisticsPanel(info[0], info[1], info[2]);
        panelE.setBackground(Color.white);
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(panelE, BorderLayout.CENTER);        
        pack();
        /*getContentPane().validate();
        getContentPane().repaint();*/
        setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String info = j.ObtenerPartidaEquipo();
        //System.out.println(info);
        infoteamsPanel panelE = new infoteamsPanel(info);
        panelE.setBackground(Color.white);
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(panelE, BorderLayout.CENTER);        
        pack();
        /*getContentPane().validate();
        getContentPane().repaint();*/
        setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String info = j.ObtenerPartidaJugador();
        //System.out.println(info);
        infoteamsPanel panelE = new infoteamsPanel(info);
        panelE.setBackground(Color.white);
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(panelE, BorderLayout.CENTER);        
        pack();
        /*getContentPane().validate();
        getContentPane().repaint();*/
        setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String info = j.Top3Puntos();
        infoteamsPanel panelE = new infoteamsPanel(info);
        panelE.setBackground(Color.white);
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(panelE, BorderLayout.CENTER);        
        pack();
        /*getContentPane().validate();
        getContentPane().repaint();*/
        setVisible(true);
        //j.TopMejoresJugadores(); // < El método del díablox
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        j.cargar_partida();
    }//GEN-LAST:event_jButton6ActionPerformed
    public void addPanelEquipo(Dbgestor db) { 
        equipoPanel panelE = new equipoPanel(db, this.j);
        panelE.setBackground(Color.white);
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(panelE, BorderLayout.CENTER);        
        pack();
        /*getContentPane().validate();
        getContentPane().repaint();*/
        setVisible(true);
    }  
    public void teamPorc(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del equipo:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         float data = j.Porcentaje_victoria_equipo(name, fecha);
         String message = name + " ha ganado el " + data + "% de sus partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
     public void playerPorc(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del jugador:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del jugador", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         float data = j.Porcentaje_victoria_jugador(name, fecha);
         String message = name + " ha ganado el " + data + "% de sus partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void playerVictories(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del usuario:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del usuario", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         int data = j.ListarJugadorGanadas(name, fecha);
         String message = name + " ha ganado " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
     public void playerLoses(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del usuario:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del usuario", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         int data = j.ListarJugadorPerdidas(name, fecha);
         String message = name + " ha perdido " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void teamVictories(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del equipo:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         int data = j.ListarEquipoGanadas(name, fecha);
         String message = name + " ha ganado " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void teamLosts(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del equipo:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         int data = j.ListarEquipoPerdidas(name, fecha);
         String message = name + " ha perdido " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void best4team(){
      JTextField xField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Nombre del equipo:"));
      myPanel.add(xField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String name = xField.getText();
         String message = j.EmparejarEquipo(name);
         //String message = name + " ha ganado " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void best4player(){
      JTextField xField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Nombre del usuario:"));
      myPanel.add(xField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Nombre del usuario", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String name = xField.getText();
         String message = j.EmparejarJugador(name);
         //String message = name + " ha ganado " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
         
    public void teamVictoriesName(){
      JTextField xField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Nombre del equipo:"));
      myPanel.add(xField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String name = xField.getText();
         int data = j.ListarEquipo(name);
         String message = name + " ha ganado " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void playerVictoriesName(){
      JTextField xField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Nombre del usuario:"));
      myPanel.add(xField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Nombre del usuario", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String name = xField.getText();
         int data = j.ListarJugador(name);
         String message = name + " ha ganado " + data + " partidas";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void teamShoe(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del equipo:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         int data = j.ZapatoEquipo(name, fecha);
         String message = name + " ha perdido " + data + " partidas con cero";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    public void playerShoe(){
      JTextField xField = new JTextField(10);
      JTextField yField = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Fecha (dd/mm/yyyy):"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Nombre del usuari:"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(this, myPanel, 
               "Ingresa la fecha de la partida y el nombre del usuario", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         String fecha = xField.getText();
         String name = yField.getText();
         int data = j.ZapatoJugador(name, fecha);
         String message = name + " ha perdido " + data + " partidas con cero";
         JOptionPane.showMessageDialog(this,
                    message,
                    "Consulta",
                    JOptionPane.INFORMATION_MESSAGE);
      }
    }
    
     public void addPanelIndividual(Dbgestor db) { 
        panelIndividual panelI = new panelIndividual(db, j);
        panelI.setBackground(Color.white);
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(panelI, BorderLayout.CENTER);        
        pack();
        /*getContentPane().validate();
        getContentPane().repaint();*/
        setVisible(true);
    }  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new initial().setVisible(true);
            }
        });
    }
    public void goBack(){
        System.out.println("Menú");
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(panelPrincipal, BorderLayout.CENTER);        
        pack();
        setVisible(true);
        //j.Cerrar_Sesion();
        //j.db.iniciarBD();
        
    }
    private Juego j = new Juego(this);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
