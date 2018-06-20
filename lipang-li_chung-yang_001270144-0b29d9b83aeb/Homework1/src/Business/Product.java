/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Chung-Yang Li
 */
public class Product {
    private String Name;
    private String GeographicData;
    private String DateOfBirth;
    private String TelephoneNumbers;
    private String FaxNumber;
    private String EmailAddresses;
    private String SocialSecurityNumber;
    private String MedicalRecordNumber;
    private String HealthPlanBeneficiaryNumber;
    private String BankAccountNumbers;
    private ImageIcon photo;

    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    
    private String Path;
    public int imgWidth;
    public int imgHeight;

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGeographicData() {
        return GeographicData;
    }

    public void setGeographicData(String GeographicData) {
        this.GeographicData = GeographicData;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getTelephoneNumbers() {
        return TelephoneNumbers;
    }

    public void setTelephoneNumbers(String TelephoneNumbers) {
        this.TelephoneNumbers = TelephoneNumbers;
    }

    public String getFaxNumber() {
        return FaxNumber;
    }

    public void setFaxNumber(String FaxNumber) {
        this.FaxNumber = FaxNumber;
    }

    public String getEmailAddresses() {
        return EmailAddresses;
    }

    public void setEmailAddresses(String EmailAddresses) {
        this.EmailAddresses = EmailAddresses;
    }

    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public void setSocialSecurityNumber(String SocialSecurityNumber) {
        this.SocialSecurityNumber = SocialSecurityNumber;
    }

    public String getMedicalRecordNumber() {
        return MedicalRecordNumber;
    }

    public void setMedicalRecordNumber(String MedicalRecordNumber) {
        this.MedicalRecordNumber = MedicalRecordNumber;
    }

    public String getHealthPlanBeneficiaryNumber() {
        return HealthPlanBeneficiaryNumber;
    }

    public void setHealthPlanBeneficiaryNumber(String HealthPlanBeneficiaryNumber) {
        this.HealthPlanBeneficiaryNumber = HealthPlanBeneficiaryNumber;
    }

    public String getBankAccountNumbers() {
        return BankAccountNumbers;
    }

    public void setBankAccountNumbers(String BankAccountNumbers) {
        this.BankAccountNumbers = BankAccountNumbers;
    }

    public ImageIcon ResizeImage(String path, JLabel lbl_image){           
        ImageIcon myImage = new ImageIcon(path);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
