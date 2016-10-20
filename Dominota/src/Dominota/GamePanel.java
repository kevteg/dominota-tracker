/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominota;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keeeevin
 */
public class GamePanel extends javax.swing.JPanel {

    /**
     * Creates new form teamGamePanel
     */
    private final Dbgestor db;
    private Equipo team_1 = null;
    private Equipo team_2 = null;
    private final Partida par;
    private final int TEAM1 = 0;
    private final int TEAM2 = 1;
    private final int EQUIPO = 0;
    private final int INDIVIDUAL = 1;
    private  List<Jugador> ju;
    private int turno = 0;
    private final int modo;
    public GamePanel(Dbgestor db, Equipo team_1, Equipo team_2, Partida par) {
        initComponents();
        this.db = db;
        this.team_1 = team_1;
        this.team_2 = team_2;
        this.par = par;
        modo = EQUIPO;
        this.lpuntos.setText(String.valueOf(par.GetPuntos()));
        DefaultTableModel model = (DefaultTableModel)this.teaminfo.getModel();
        model.addColumn(team_1.getNombre());
        model.addColumn(team_2.getNombre());
        //this.teaminfo.getColumnModel().getColumn(TEAM1).setHeaderValue(team_1.getNombre());
        //this.teaminfo.getColumnModel().getColumn(TEAM2).setHeaderValue(team_2.getNombre());
        this.addTeam3.setVisible(false);
        this.addTeam4.setVisible(false);
    }
     public GamePanel(Dbgestor db, List<Jugador> ju, Partida par) {
        initComponents();
        this.db = db;
        this.ju = ju;
        this.par = par;
        modo = INDIVIDUAL;
        this.lpuntos.setText(String.valueOf(par.GetPuntos()));
        DefaultTableModel model = (DefaultTableModel)this.teaminfo.getModel();
        for(Jugador jugador : ju)
            model.addColumn(jugador.getNombre());
        if(ju.size() == 2){
            this.addTeam3.setVisible(false);
            this.addTeam4.setVisible(false);
        }else if(ju.size() == 3){
            this.addTeam4.setVisible(false);
        }
        //this.teaminfo.getColumnModel().getColumn(TEAM1).setHeaderValue(team_1.getNombre());
        //this.teaminfo.getColumnModel().getColumn(TEAM2).setHeaderValue(team_2.getNombre());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lpuntos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teaminfo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        addTeam1 = new javax.swing.JButton();
        addTeam2 = new javax.swing.JButton();
        addTeam3 = new javax.swing.JButton();
        addTeam4 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Droid Sans", 0, 36)); // NOI18N
        jLabel2.setText("DOMINOTA");

        jLabel1.setText("Puntos máximos:");

        lpuntos.setText("0");

        teaminfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(teaminfo);

        addTeam1.setText("Agregar");
        addTeam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeam1ActionPerformed(evt);
            }
        });

        addTeam2.setText("Agregar");
        addTeam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeam2ActionPerformed(evt);
            }
        });

        addTeam3.setText("Agregar");
        addTeam3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeam3ActionPerformed(evt);
            }
        });

        addTeam4.setText("Agregar");
        addTeam4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeam4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTeam1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTeam2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTeam3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTeam4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTeam1)
                    .addComponent(addTeam2)
                    .addComponent(addTeam3)
                    .addComponent(addTeam4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lpuntos))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lpuntos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private int click(){
        int p = 0;
        String puntos = JOptionPane.showInputDialog((JFrame) SwingUtilities.getWindowAncestor(this), "¿Puntos?");
        try {
             p = (Integer.parseInt(puntos) < 0)?0:Integer.parseInt(puntos);
        } catch (Exception e) {
            p = 0;
        }
        if(p == 0){
            JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                    "Dato erróneo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }
    private void addTeam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeam1ActionPerformed
        DefaultTableModel model = (DefaultTableModel)this.teaminfo.getModel();
        int puntos = click();
        if(puntos > 0){
            if(modo == EQUIPO){
                team_1.SetManos(puntos);
                team_1.asignar_puntos(puntos);
                team_1.setTurno(turno);
                model.addRow(new Object[]{puntos + "-" + team_1.GetPuntos(), "-"});
            }else{
                ju.get(0).setManos(puntos);
                ju.get(0).asignar_puntos(puntos);
                ju.get(0).setTurno(turno);
                if(ju.size() == 2)
                    model.addRow(new Object[]{puntos + "-" + ju.get(0).GetPuntos(), "-"});
                else if(ju.size() == 3)
                    model.addRow(new Object[]{puntos + "-" + ju.get(0).GetPuntos(), "-", "-"});
                else
                    model.addRow(new Object[]{puntos + "-" + ju.get(0).GetPuntos(), "-", "-", "-"});
            }
            turno++;
        }
        check();
    }//GEN-LAST:event_addTeam1ActionPerformed

    private void addTeam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeam2ActionPerformed
        DefaultTableModel model = (DefaultTableModel)this.teaminfo.getModel();
        int puntos = click();
        if(puntos > 0){
            if(modo == EQUIPO){
                team_2.SetManos(puntos);
                team_2.asignar_puntos(puntos);
                team_2.setTurno(turno);
                model.addRow(new Object[]{"-", puntos + "-" + team_2.GetPuntos()});
            }else{
                ju.get(1).setManos(puntos);
                ju.get(1).asignar_puntos(puntos);
                ju.get(1).setTurno(turno);
                if(ju.size() == 2)
                    model.addRow(new Object[]{"-", puntos + "-" + ju.get(1).GetPuntos()});
                else if(ju.size() == 3)
                    model.addRow(new Object[]{"-", puntos + "-" + ju.get(1).GetPuntos(), "-"});
                else
                    model.addRow(new Object[]{"-", puntos + "-" + ju.get(1).GetPuntos(), "-", "-"});
            }
            turno++;
        }
        check();
    }//GEN-LAST:event_addTeam2ActionPerformed

    private void addTeam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeam3ActionPerformed
        DefaultTableModel model = (DefaultTableModel)this.teaminfo.getModel();
        int puntos = click();
        if(puntos > 0){
            ju.get(2).setManos(puntos);
            ju.get(2).asignar_puntos(puntos);
            ju.get(2).setTurno(turno);
            if(ju.size() == 3)
                model.addRow(new Object[]{"-", "-", puntos + "-" + ju.get(2).GetPuntos()});
            else
                model.addRow(new Object[]{"-", "-", puntos + "-" + ju.get(2).GetPuntos(), "-"});
            turno++;
        }
        check();
    }//GEN-LAST:event_addTeam3ActionPerformed

    private void addTeam4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeam4ActionPerformed
        DefaultTableModel model = (DefaultTableModel)this.teaminfo.getModel();
        int puntos = click();
        if(puntos > 0){
            ju.get(3).setManos(puntos);
            ju.get(3).asignar_puntos(puntos);
            ju.get(3).setTurno(turno);
            model.addRow(new Object[]{"-", "-", "-", puntos + "-" + ju.get(2).GetPuntos()});
            turno++;
        }
        check();
    }//GEN-LAST:event_addTeam4ActionPerformed
    boolean singleZero(){
        boolean zero = false;
        for (Jugador jugador : ju) 
            zero = zero || jugador.GetPuntos() == 0;
        return zero;
    }
    private void check(){
        
        String message = "";
        if(modo == EQUIPO){
            if(team_1.GetPuntos() >= par.GetPuntos())
                message = "Gano el " + ((modo == EQUIPO)?"equipo ":"usuario ") + team_1.getNombre();
            else if(team_2.GetPuntos() >= par.GetPuntos())
                message = "Gano el " + ((modo == EQUIPO)?"equipo ":"usuario ")+ team_2.getNombre();
        }else{
            boolean winner = false;
            for (Iterator<Jugador> it = ju.iterator(); it.hasNext() && !winner;) {
                Jugador jugador = it.next();
                if(jugador.GetPuntos() >= par.GetPuntos() && message.equals("")){
                    message = "Gano el " + ((modo == EQUIPO)?"equipo ":"usuario ") + jugador.getNombre();
                    winner = true;
                }
            }
                    
        }
        boolean shoe = (team_1 != null && team_2 != null)?(team_1.GetPuntos() == 0 || team_2.GetPuntos() == 0)
                       :(singleZero());
        String icon = shoe?"shoe.png":"ok.png";
        if(!message.equals("")){
            List<Equipo> eq = new ArrayList <Equipo>();
            initial ventana = (initial) SwingUtilities.getWindowAncestor(this);
            System.out.println(message);
            //ImageIcon icon = new ImageIcon("shoe.ico"));
            JOptionPane.showMessageDialog(ventana,
                    message + (shoe?"\n¡Hubo zapato!":""),
                    "Ganador",
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(icon));
            eq.add(team_1);
            eq.add(team_2);
            par.SetEquipo(eq);
            db.AgregarPartida(par);
            turno = 0;
            ventana.goBack();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTeam1;
    private javax.swing.JButton addTeam2;
    private javax.swing.JButton addTeam3;
    private javax.swing.JButton addTeam4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lpuntos;
    private javax.swing.JTable teaminfo;
    // End of variables declaration//GEN-END:variables
}

