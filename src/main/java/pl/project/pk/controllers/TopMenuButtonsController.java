package pl.project.pk.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String STORE_INVESTMENTS_FXML = "/fxml/store/Investments.fxml";
    public static final String STORE_CLIENTS_FXML = "/fxml/store/Clients.fxml";
    public static final String STORE_STATISTICS_FXML = "/fxml/store/Statistics.fxml";
    public static final String ADD_CLIENTS_FXML = "/fxml/AddClients.fxml";

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
    public void openStatistic() {
        mainController.setCenter(STORE_STATISTICS_FXML);
    }

    @FXML
    public void addClient(){
        if(toggleGroups.getSelectedToggle() != null){
            toggleGroups.getSelectedToggle().setSelected(false);
        }

        mainController.setCenter(ADD_CLIENTS_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
