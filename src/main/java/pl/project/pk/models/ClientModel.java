package pl.project.pk.models;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.database.dao.ClientDao;
import pl.project.pk.database.dbutils.DbManager;
import pl.project.pk.database.models.Client;
import pl.project.pk.mapper.ClientMapper;
import pl.project.pk.utils.converters.ConventerClient;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ClientModel {

    public static final String FIELD_NAME_FIRST_NAME = "firstName";
    public static final String FIELD_NAME_LAST_NAME = "lastName";
    public static final String FIELD_NAME_ADDRESS = "address";
    public static final String FIELD_NAME_SALARY = "salary";
    public static final String FIELD_NAME_EMAIL = "email";
    public static final String FIELD_NAME_PHONE = "phone";

    private ObjectProperty<ClientMapper> clientMapperObjectProperty = new SimpleObjectProperty<>(new ClientMapper());
    private ObjectProperty<ClientMapper> clientMapperObjectPropertyEdit = new SimpleObjectProperty<>(new ClientMapper());

    private ObservableList<ClientMapper> clientMapperObservableList = FXCollections.observableArrayList();


    public void init() throws ApplicationException {
        ClientDao clientDao = new ClientDao(DbManager.getConnectionSource());
        List<Client> clientList = clientDao.queryForAll(Client.class);

        this.clientMapperObservableList.clear();
        clientList.forEach(client -> {
            ClientMapper clientMapper = ConventerClient.convertToClientMapper(client);
            this.clientMapperObservableList.add(clientMapper);
        });
        DbManager.closeConnectionDB();
    }


    public void saveCategoryInDataBase(Map<String, String> data ) throws ApplicationException {
        ClientDao clientDao = new ClientDao(DbManager.getConnectionSource());
        Client client = new Client();

        client.setFirstName(data.get(FIELD_NAME_FIRST_NAME));
        client.setLastname(data.get(FIELD_NAME_LAST_NAME));
        client.setAddress(data.get(FIELD_NAME_ADDRESS));
        client.setSalary(data.get(FIELD_NAME_SALARY));
        client.setEmail(data.get(FIELD_NAME_EMAIL));
        client.setPhone(data.get(FIELD_NAME_PHONE));

        client.setCreatedAt(new Date());
        client.setUpdatedAt(new Date());

        //Save clients
        clientDao.createOrUpdate(client);
        DbManager.closeConnectionDB();
        init();
    }

    public ClientMapper getClientMapperObjectProperty() {
        return clientMapperObjectProperty.get();
    }

    public ObjectProperty<ClientMapper> clientMapperObjectPropertyProperty() {
        return clientMapperObjectProperty;
    }

    public void setClientMapperObjectProperty(ClientMapper clientMapperObjectProperty) {
        this.clientMapperObjectProperty.set(clientMapperObjectProperty);
    }

    public ClientMapper getClientMapperObjectPropertyEdit() {
        return clientMapperObjectPropertyEdit.get();
    }

    public ObjectProperty<ClientMapper> clientMapperObjectPropertyEditProperty() {
        return clientMapperObjectPropertyEdit;
    }

    public void setClientMapperObjectPropertyEdit(ClientMapper clientMapperObjectPropertyEdit) {
        this.clientMapperObjectPropertyEdit.set(clientMapperObjectPropertyEdit);
    }

    public ObservableList<ClientMapper> getClientMapperObservableList() {
        return clientMapperObservableList;
    }

    public void setClientMapperObservableList(ObservableList<ClientMapper> clientMapperObservableList) {
        this.clientMapperObservableList = clientMapperObservableList;
    }
}
