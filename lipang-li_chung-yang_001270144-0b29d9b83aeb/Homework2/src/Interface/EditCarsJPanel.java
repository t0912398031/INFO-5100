/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.CarList;
import Business.Car;
import Business.DateUtils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chung-Yang Li
 */
public class EditCarsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewCarsJPanel
     */
    private CarList cl;
    private Car car;
    String UpdatedTime = DateUtils.now();
    public EditCarsJPanel(CarList cl, Car car) {
        initComponents();
        this.cl = cl;
        this.car = car;
        populateTable();
    }
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblCarList.getModel();
        dtm.setRowCount(0);
        /*
        int rowCount = tblCar.getRowCount();
        for(int i=rowCount-1;i>=0;i--){
            dtm.removeRow(i);
        }
        */
        for(Car c : cl.getCarList()){
            Object row[] = new Object[2];
            row[0] = c;
            row[1] = c.getSerialNum();
            dtm.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarList = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnViewDetials = new javax.swing.JButton();
        lblFname = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        lblFname1 = new javax.swing.JLabel();
        txtSeats = new javax.swing.JTextField();
        lblFname2 = new javax.swing.JLabel();
        txtSerialnum = new javax.swing.JTextField();
        lblFname3 = new javax.swing.JLabel();
        txtModelNum = new javax.swing.JTextField();
        lblFname4 = new javax.swing.JLabel();
        txtMadeYear = new javax.swing.JTextField();
        lblFname5 = new javax.swing.JLabel();
        txtUpdateTime = new javax.swing.JTextField();
        lblFname6 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblFname7 = new javax.swing.JLabel();
        checkboxAvail = new javax.swing.JCheckBox();
        lblFname8 = new javax.swing.JLabel();
        checkboxUBER = new javax.swing.JCheckBox();
        lblFname9 = new javax.swing.JLabel();
        checkboxEMC = new javax.swing.JCheckBox();

        jLabel1.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel1.setText("Edit Cars");

        tblCarList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand", "Serial Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCarList);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnViewDetials.setText("View Details");
        btnViewDetials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetialsActionPerformed(evt);
            }
        });

        lblFname.setText("Brand");

        lblFname1.setText("Seats");

        lblFname2.setText("Serial Number");

        lblFname3.setText("Model Number");

        lblFname4.setText("Manufactured Year");

        lblFname5.setText("Latest Update Time");

        txtUpdateTime.setEnabled(false);

        lblFname6.setText("City");

        lblFname7.setText("Availbility");

        checkboxAvail.setText("Yes");

        lblFname8.setText("Manufacturers used by UBER");

        checkboxUBER.setText("Yes");

        lblFname9.setText("Expired Maintenance Certificate");

        checkboxEMC.setText("Yes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnViewDetials)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSave))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(77, 77, 77)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblFname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFname1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFname2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblFname3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSerialnum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelNum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblFname4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFname8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFname9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFname7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFname6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFname5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUpdateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxEMC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxAvail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxUBER, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMadeYear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnViewDetials))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFname1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFname2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFname3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerialnum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFname4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFname5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFname6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFname7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFname8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxUBER, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFname9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxEMC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUpdateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkboxAvail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtMadeYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetialsActionPerformed
        int selectedrow = tblCarList.getSelectedRow();      
        
        if(selectedrow >=0){
            Car c = (Car)tblCarList.getValueAt(selectedrow, 0);
            txtBrand.setText(String.valueOf(c.getBrand()));
            txtCity.setText(String.valueOf(c.getCity()));
            txtMadeYear.setText(String.valueOf(c.getMadeYear()));
            txtModelNum.setText(String.valueOf(c.getModelNum()));
            txtSeats.setText(String.valueOf(c.getSeats()));
            txtSerialnum.setText(String.valueOf(c.getSerialNum()));
            txtUpdateTime.setText(c.getUpdatedTime());
            checkboxAvail.setSelected(c.isAvail());
            checkboxUBER.setSelected(c.getManufacturersByUBER());
            checkboxEMC.setSelected(c.isExpiredMC()); 
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select any row");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewDetialsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int selectedrow = tblCarList.getSelectedRow();

        if(selectedrow >=0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Save selected row?");
            if(dialogResult == JOptionPane.YES_OPTION){
                Car c = (Car)tblCarList.getValueAt(selectedrow, 0);
                
                c.setBrand(txtBrand.getText());
                c.setSeats(Integer.parseInt(txtSeats.getText()));
                c.setSerialNum(Integer.parseInt(txtSerialnum.getText()));
                c.setModelNum(Integer.parseInt(txtModelNum.getText()));
                c.setMadeYear(Integer.parseInt(txtMadeYear.getText()));
                c.setUpdatedTime(UpdatedTime);
                c.setCity(txtCity.getText());
                c.setAvail(checkboxAvail.isSelected());
                c.setManufacturersByUBER(checkboxUBER.isSelected());  
                c.setExpiredMC(checkboxEMC.isSelected());
                car.setUpdatedTime(UpdatedTime); 
                JOptionPane.showMessageDialog(null, "Save successfully");
                populateTable();
            }            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select any row");
        }            // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnViewDetials;
    private javax.swing.JCheckBox checkboxAvail;
    private javax.swing.JCheckBox checkboxEMC;
    private javax.swing.JCheckBox checkboxUBER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblFname1;
    private javax.swing.JLabel lblFname2;
    private javax.swing.JLabel lblFname3;
    private javax.swing.JLabel lblFname4;
    private javax.swing.JLabel lblFname5;
    private javax.swing.JLabel lblFname6;
    private javax.swing.JLabel lblFname7;
    private javax.swing.JLabel lblFname8;
    private javax.swing.JLabel lblFname9;
    private javax.swing.JTable tblCarList;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtMadeYear;
    private javax.swing.JTextField txtModelNum;
    private javax.swing.JTextField txtSeats;
    private javax.swing.JTextField txtSerialnum;
    private javax.swing.JTextField txtUpdateTime;
    // End of variables declaration//GEN-END:variables
}
