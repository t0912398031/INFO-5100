/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.CarList;
import Business.Car;
import Business.DateUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Chung-Yang Li
 */
public class CreateCarJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewVitlJPanel
     */
    int i = 1;
    private CarList cl;
    private Car car;
    private Car firstCar;
    CreateCarJPanel(CarList cl, Car car) {
        initComponents();
        this.cl = cl;
        this.car = car;
        this.firstCar = firstCar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFname = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtSeats = new javax.swing.JTextField();
        txtMadeYear = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblFname1 = new javax.swing.JLabel();
        lblFname2 = new javax.swing.JLabel();
        lblFname3 = new javax.swing.JLabel();
        lblFname4 = new javax.swing.JLabel();
        txtModelNum = new javax.swing.JTextField();
        lblFname6 = new javax.swing.JLabel();
        lblFname7 = new javax.swing.JLabel();
        lblFname8 = new javax.swing.JLabel();
        lblFname9 = new javax.swing.JLabel();
        txtSerialnum = new javax.swing.JTextField();
        checkboxAvail = new javax.swing.JCheckBox();
        checkboxUBER = new javax.swing.JCheckBox();
        checkboxEMC = new javax.swing.JCheckBox();
        txtBrand = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();

        lblFname.setText("Brand");

        jLabel1.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel1.setText("Create Car");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblFname1.setText("Seats");

        lblFname2.setText("Serial Number");

        lblFname3.setText("Model Number");

        lblFname4.setText("Manufactured Year");

        lblFname6.setText("City");

        lblFname7.setText("Availbility");

        lblFname8.setText("Manufacturers used by UBER");

        lblFname9.setText("Expired Maintenance Certificate");

        checkboxAvail.setText("Yes");

        checkboxUBER.setText("Yes");
        checkboxUBER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxUBERActionPerformed(evt);
            }
        });

        checkboxEMC.setText("Yes");

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblFname, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(lblFname1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(lblFname2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(102, 102, 102))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFname3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(63, 63, 63)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSerialnum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelNum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFname4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(txtMadeYear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblFname8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFname9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                    .addComponent(lblFname7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFname6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxEMC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxAvail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkboxUBER, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpload))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblFname4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMadeYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkboxAvail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpload))
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
   
        String Brand = txtBrand.getText();
        int Seats = Integer.parseInt(txtSeats.getText());
        int SerialNum = Integer.parseInt(txtSerialnum.getText());
        int ModelNum = Integer.parseInt(txtModelNum.getText());
        int MadeYear = Integer.parseInt(txtMadeYear.getText());        
        String UpdatedTime = DateUtils.now();
        String City = txtCity.getText();
        Boolean Avail = checkboxAvail.isSelected();
        Boolean MbyUBER = checkboxUBER.isSelected();  
        Boolean EMC = checkboxEMC.isSelected(); 
              
        Car c = cl.addCars();
        c.setBrand(Brand);
        c.setSeats(Seats);
        c.setSerialNum(SerialNum);
        c.setModelNum(ModelNum);
        c.setMadeYear(MadeYear);            
        c.setCity(City);
        c.setAvail(Avail);
        c.setManufacturersByUBER(MbyUBER);
        c.setExpiredMC(EMC);
        c.setUpdatedTime(UpdatedTime);
        car.setUpdatedTime(UpdatedTime);
//        Date date =new Date();
//        c.setUpdatedTime(date.toString());
//        car.setUpdatedTime(date.toString()); 
        c.setIndex(i);
        i++;
        if(checkboxAvail.isSelected()){firstCar = c;}
        
        JOptionPane.showMessageDialog(null, "Employee added successfully");
        txtBrand.setText("");
        txtCity.setText("");
        txtMadeYear.setText("");
        txtModelNum.setText("");
        txtSeats.setText("");
        txtSerialnum.setText(""); 
        checkboxAvail.setSelected(false);
        checkboxEMC.setSelected(false);
        checkboxUBER.setSelected(false);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void checkboxUBERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxUBERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxUBERActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        boolean fail = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CarList input.csv"));
            String line = null;
            while((line=reader.readLine())!=null){//read the .csv by each line
                String item[] = line.split(",");//separate each line based on ','
//                boolean avail;
//                boolean mainten;
//                if("TRUE".equals(item[1].intern())) avail = true;
//                else avail = false;
//                if("TRUE".equals(item[8].intern())) mainten = true;
//                else mainten = false;     
                
                Car c = cl.addCars();
                c.setBrand(item[0]);
                c.setSeats(Integer.parseInt(item[1]));
                c.setSerialNum(Integer.parseInt(item[2]));
                c.setModelNum(Integer.parseInt(item[3]));
                c.setMadeYear(Integer.parseInt(item[4]));            
                c.setCity(item[5]);
                c.setAvail(Boolean.parseBoolean(item[6]));
                c.setManufacturersByUBER(Boolean.parseBoolean(item[7]));
                c.setExpiredMC(Boolean.parseBoolean(item[8]));
                c.setUpdatedTime(DateUtils.now());
                car.setUpdatedTime(DateUtils.now());
                             
                fail = true;
            }
        } catch (Exception a){
            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
        }
        if(fail == true)
        JOptionPane.showMessageDialog(null,"Upload Car Information Successfully.");
    
    }//GEN-LAST:event_btnUploadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpload;
    private javax.swing.JCheckBox checkboxAvail;
    private javax.swing.JCheckBox checkboxEMC;
    private javax.swing.JCheckBox checkboxUBER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblFname1;
    private javax.swing.JLabel lblFname2;
    private javax.swing.JLabel lblFname3;
    private javax.swing.JLabel lblFname4;
    private javax.swing.JLabel lblFname6;
    private javax.swing.JLabel lblFname7;
    private javax.swing.JLabel lblFname8;
    private javax.swing.JLabel lblFname9;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtMadeYear;
    private javax.swing.JTextField txtModelNum;
    private javax.swing.JTextField txtSeats;
    private javax.swing.JTextField txtSerialnum;
    // End of variables declaration//GEN-END:variables
}
