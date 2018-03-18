package pl.project.pk.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.models.VendorModel;

import java.util.HashMap;
import java.util.Map;

public class VendorCreateController {

    /* widok dodawania nowego vendora */
    @FXML
    public TextField firstName;

    @FXML
    public TextField lastName;

    @FXML
    public TextField address;

    @FXML
    public TextField salary;

    @FXML
    public TextField email;

    @FXML
    public TextField phone;

    @FXML
    public Button saveVendorButton;

    private VendorModel vendorModel;

    @FXML
    public void initialize() throws ApplicationException {
        this.vendorModel = new VendorModel();
        this.vendorModel.init();
        this.initBindings();
    }

    private void initBindings() {
        this.saveVendorButton.disableProperty().bind(firstName.textProperty().isEmpty());
        this.saveVendorButton.disableProperty().bind(lastName.textProperty().isEmpty());
        this.saveVendorButton.disableProperty().bind(address.textProperty().isEmpty());
        this.saveVendorButton.disableProperty().bind(salary.textProperty().isEmpty());
        this.saveVendorButton.disableProperty().bind(email.textProperty().isEmpty());
        this.saveVendorButton.disableProperty().bind(phone.textProperty().isEmpty());
    }

    private void clearAllTextField(){
        firstName.clear();
        lastName.clear();
        address.clear();
        salary.clear();
        email.clear();
        phone.clear();
    }

    public void saveVendor(ActionEvent actionEvent) throws ApplicationException {
        Map<String, String> dataForm = new HashMap<String, String>();
        dataForm.put(VendorModel.FIELD_NAME_FIRST_NAME,firstName.getText());
        dataForm.put(VendorModel.FIELD_NAME_LAST_NAME,lastName.getText());
        dataForm.put(VendorModel.FIELD_NAME_ADDRESS,address.getText());
        dataForm.put(VendorModel.FIELD_NAME_SALARY,salary.getText());
        dataForm.put(VendorModel.FIELD_NAME_EMAIL,email.getText());
        dataForm.put(VendorModel.FIELD_NAME_PHONE,phone.getText());

        vendorModel.saveCategoryInDataBase(dataForm);
        this.clearAllTextField();
    }
}
