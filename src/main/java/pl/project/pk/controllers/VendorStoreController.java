package pl.project.pk.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.mapper.VendorMapper;
import pl.project.pk.models.VendorModel;

public class VendorStoreController {

    @FXML
    private TableView<VendorMapper> vendorTableView;

    @FXML
    private TableColumn<VendorMapper, String> firstNameColumn;

    @FXML
    private TableColumn<VendorMapper, String> lastNameColumn;

    @FXML
    private TableColumn<VendorMapper, String> addressColumn;

    @FXML
    private TableColumn<VendorMapper, String> salaryColumn;

    @FXML
    private TableColumn<VendorMapper, String> emailColumn;

    @FXML
    private TableColumn<VendorMapper, String> phoneColumn;

    private VendorModel vendorModel;


    public void initialize(){
        this.vendorModel = new VendorModel();

        try {
            this.vendorModel.init();
        } catch (ApplicationException e) {
            e.printStackTrace();
            //TODO klasa z wlasnymi wyjatkami
        }

        bindingsTableView();
    }

    private void bindingsTableView() {
        this.vendorTableView.setItems(this.vendorModel.getVendorMapperObservableList());

        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
        this.addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        this.salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty());
        this.emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        this.phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

    }

}
