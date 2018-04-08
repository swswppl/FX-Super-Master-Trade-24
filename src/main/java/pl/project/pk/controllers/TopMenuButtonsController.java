package pl.project.pk.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    private static final String STORE_INVESTMENTS_FXML = "/fxml/store/Investments.fxml";
    private static final String STORE_CLIENTS_FXML = "/fxml/store/Clients.fxml";
    private static final String STORE_VENDORS_FXML = "/fxml/store/Vendors.fxml";
    private static final String STORE_STATISTICS_FXML = "/fxml/store/Statistics.fxml";
    private static final String ADD_CLIENTS_FXML = "/fxml/form/AddClients.fxml";
    private static final String ADD_VENDORS_FXML = "/fxml/form/AddVendors.fxml";

    private MainController mainController;

    @FXML
    private ToggleGroup toggleGroups;

    @FXML
    public void openInvestments() {
        mainController.setCenter(STORE_INVESTMENTS_FXML);
    }

    @FXML
    public void openClients() {
        mainController.setCenter(STORE_CLIENTS_FXML);
    }
    
    @FXML
    public void openVendors() {
        mainController.setCenter(STORE_VENDORS_FXML);
    }

    @FXML
    public void openStatistic() {
        mainController.setCenter(STORE_STATISTICS_FXML);
    }

    @FXML
    public void addClient(){
        this.resetToggleButtons();
        mainController.setCenter(ADD_CLIENTS_FXML);
    }
    
    @FXML
    public void addVendor(){
        this.resetToggleButtons();
        mainController.setCenter(ADD_VENDORS_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void resetToggleButtons(){
        if(toggleGroups.getSelectedToggle() != null){
            toggleGroups.getSelectedToggle().setSelected(false);
        }
    }

}
