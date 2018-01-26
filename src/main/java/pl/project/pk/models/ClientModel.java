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

    private ObservableList<ClientMapper> clientList = FXCollections.observableArrayList();
    private ObjectProperty<ClientMapper> client = new SimpleObjectProperty<>();

    public void init() throws ApplicationException {
        ClientDao clientDao = new ClientDao(DbManager.getConnectionSource());
        List<Client> clients = clientDao.queryForAll(Client.class);

        initClientList(clients);
        DbManager.closeConnectionDB();
    }

    private void initClientList(List<Client> clients) {
        this.clientList.clear();
        clients.forEach(c->{
            ClientMapper clientMapper = ConventerClient.convertToClientMapper(c);
            this.clientList.add(clientMapper);
        });
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
}
