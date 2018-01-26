package pl.project.pk.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.models.ClientModel;

import java.util.HashMap;
import java.util.Map;

public class ClientCreateController {

    /* widok dodawania nowego clienta */
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
    public Button saveClientButton;

    private ClientModel clientModel;

    @FXML
    public void initialize() throws ApplicationException {
        this.clientModel = new ClientModel();
        this.clientModel.init();
        this.initBindings();
    }

    private void initBindings() {
        this.saveClientButton.disableProperty().bind(firstName.textProperty().isEmpty());
        this.saveClientButton.disableProperty().bind(lastName.textProperty().isEmpty());
        this.saveClientButton.disableProperty().bind(address.textProperty().isEmpty());
        this.saveClientButton.disableProperty().bind(salary.textProperty().isEmpty());
        this.saveClientButton.disableProperty().bind(email.textProperty().isEmpty());
        this.saveClientButton.disableProperty().bind(phone.textProperty().isEmpty());
    }

    private void clearAllTextField(){
        firstName.clear();
        lastName.clear();
        address.clear();
        salary.clear();
        email.clear();
        phone.clear();
    }

    public void saveClient(ActionEvent actionEvent) throws ApplicationException {
        Map<String, String> dataForm = new HashMap<String, String>();
        dataForm.put(ClientModel.FIELD_NAME_FIRST_NAME,firstName.getText());
        dataForm.put(ClientModel.FIELD_NAME_LAST_NAME,lastName.getText());
        dataForm.put(ClientModel.FIELD_NAME_ADDRESS,address.getText());
        dataForm.put(ClientModel.FIELD_NAME_SALARY,salary.getText());
        dataForm.put(ClientModel.FIELD_NAME_EMAIL,email.getText());
        dataForm.put(ClientModel.FIELD_NAME_PHONE,phone.getText());

        clientModel.saveCategoryInDataBase(dataForm);
        this.clearAllTextField();
    }
}
