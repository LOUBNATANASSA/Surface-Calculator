/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Form;
import services.chambreservice;
import entities.Chambre;
import services.clientservice;
import entities.Client;
import services.reservationservice;
import entities.Reservation;
import javax.swing.JOptionPane;
import java.util.List;


/**
 *
 * @author hp
 */
public class ReservationForm extends javax.swing.JInternalFrame {
    
    //la liste des chambres
 private chambreservice chambre=new chambreservice();
 private List<Chambre> a=chambre.findAll();
 
    //la liste des clients
 private clientservice client=new clientservice();
 private List<Client> b=client.findAll();
 
 private clientservice rs;
    
 
    public ReservationForm() {
        initComponents();
        rs=new clientservice();
    }
    
    /////la liste des chambres
        private void remplirChambreBox() {
        try {
            // Utilisation de chambreservice pour récupérer les catégories
            chambreservice x=new chambreservice();
            List<Chambre> chambres = x.findAll(); // Implémentez cette méthode dans chambreservice
            
            // Vider le JComboBox avant de le remplir
            chambre_Box.removeAllItems();
            
            // Ajouter chaque catégorie au JComboBox
            for (Chambre c : chambres) {
                chambre_Box.addItem(c.getnumero());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur lors du remplissage des chambres : " + e.getMessage(), 
                                          "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
        
     /////////remplire la liste des clients
            private void remplirClientBox() {
        try {
            // Utilisation de chambreservice pour récupérer les catégories
            clientservice x=new clientservice();
            List<Client> clients = x.findAll(); // Implémentez cette méthode dans chambreservice
            
            // Vider le JComboBox avant de le remplir
            client_Box.removeAllItems();
            
            // Ajouter chaque catégorie au JComboBox
            for (Client cl : clients) {
                client_Box.addItem(cl.getCIN());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur lors du remplissage des clients : " + e.getMessage(), 
                                          "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
        

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nouvelle_Reservation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chambre_Box = new javax.swing.JComboBox<>();
        DDEBUT_BOX = new com.toedter.calendar.JDateChooser();
        DFIN_BOX = new com.toedter.calendar.JDateChooser();
        Ajouter = new javax.swing.JButton();
        Modifier = new javax.swing.JButton();
        Supprimer = new javax.swing.JButton();
        client_Box = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listereservation = new javax.swing.JTable();

        Nouvelle_Reservation.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Nouvelle Reservation");

        jLabel2.setText("Date de debut");

        jLabel3.setText("Date de fin");

        jLabel4.setText("Chambre");

        jLabel5.setText("Client");

        chambre_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Ajouter.setText("Ajouter");
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });

        Modifier.setText("Modifier");

        Supprimer.setText("Supprimer");
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });

        client_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout Nouvelle_ReservationLayout = new javax.swing.GroupLayout(Nouvelle_Reservation);
        Nouvelle_Reservation.setLayout(Nouvelle_ReservationLayout);
        Nouvelle_ReservationLayout.setHorizontalGroup(
            Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Nouvelle_ReservationLayout.createSequentialGroup()
                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Nouvelle_ReservationLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(Nouvelle_ReservationLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Nouvelle_ReservationLayout.createSequentialGroup()
                                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(chambre_Box, 0, 262, Short.MAX_VALUE)
                                    .addComponent(client_Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(Nouvelle_ReservationLayout.createSequentialGroup()
                                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25)
                                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DFIN_BOX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DDEBUT_BOX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(178, 178, 178))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Nouvelle_ReservationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Ajouter)
                .addGap(105, 105, 105)
                .addComponent(Modifier)
                .addGap(114, 114, 114)
                .addComponent(Supprimer)
                .addGap(124, 124, 124))
        );
        Nouvelle_ReservationLayout.setVerticalGroup(
            Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Nouvelle_ReservationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Nouvelle_ReservationLayout.createSequentialGroup()
                        .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(DDEBUT_BOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(DFIN_BOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(chambre_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(client_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(Nouvelle_ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ajouter)
                    .addComponent(Modifier)
                    .addComponent(Supprimer))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("Liste des Reservations");

        listereservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date debut", "Date fin", "Client - CIN", "Chambre - Numero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listereservation);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nouvelle_Reservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nouvelle_Reservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupprimerActionPerformed

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
              /* if (DDEBUT_BOX.getDate()==null || DFIN_BOX.getDate()==null) {
        JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);}
       else{
       Chambre o=new Chambre();
       for(int i=0;i<a.size();i++){
           Chambre c = a.get(i);
           if(c.getCode().equals(Chambre_Categorie_Box.getSelectedItem())){
           o=ce;
           break;
           }
       }
 
        if(Chs.create(new Chambre(Numero_Box.getText(),Telephone_Box.getText(),o))){
          JOptionPane.showMessageDialog(null, "Chambre ajoute ");
          load();
    }                                               
        else{JOptionPane.showMessageDialog(null, "Ereeur de creation du chambre");}
    }*/
    }//GEN-LAST:event_AjouterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajouter;
    private com.toedter.calendar.JDateChooser DDEBUT_BOX;
    private com.toedter.calendar.JDateChooser DFIN_BOX;
    private javax.swing.JButton Modifier;
    private javax.swing.JPanel Nouvelle_Reservation;
    private javax.swing.JButton Supprimer;
    private javax.swing.JComboBox<String> chambre_Box;
    private javax.swing.JComboBox<String> client_Box;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listereservation;
    // End of variables declaration//GEN-END:variables
}
