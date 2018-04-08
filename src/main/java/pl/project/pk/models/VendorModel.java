package pl.project.pk.models;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.database.dao.VendorDao;
import pl.project.pk.database.dbutils.DbManager;
import pl.project.pk.database.models.Vendor;
import pl.project.pk.mapper.VendorMapper;
import pl.project.pk.utils.converters.ConventerVendor;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class VendorModel {

    public static final String FIELD_NAME_FIRST_NAME = "firstName";
    public static final String FIELD_NAME_LAST_NAME = "lastName";
    public static final String FIELD_NAME_ADDRESS = "address";
    public static final String FIELD_NAME_SALARY = "salary";
    public static final String FIELD_NAME_EMAIL = "email";
    public static final String FIELD_NAME_PHONE = "phone";

    private ObjectProperty<VendorMapper> vendorMapperObjectProperty = new SimpleObjectProperty<>(new VendorMapper());
    private ObjectProperty<VendorMapper> vendorMapperObjectPropertyEdit = new SimpleObjectProperty<>(new VendorMapper());

    private ObservableList<VendorMapper> vendorMapperObservableList = FXCollections.observableArrayList();


    public void init() throws ApplicationException {
        VendorDao vendorDao = new VendorDao(DbManager.getConnectionSource());
        List<Vendor> vendorList = vendorDao.queryForAll(Vendor.class);

        this.vendorMapperObservableList.clear();
        vendorList.forEach(vendor -> {
            VendorMapper vendorMapper = ConventerVendor.convertToVendorMapper(vendor);
            this.vendorMapperObservableList.add(vendorMapper);
        });
        DbManager.closeConnectionDB();
    }


    public void saveCategoryInDataBase(Map<String, String> data ) throws ApplicationException {
        VendorDao vendorDao = new VendorDao(DbManager.getConnectionSource());
        Vendor vendor = new Vendor();

        vendor.setFirstName(data.get(FIELD_NAME_FIRST_NAME));
        vendor.setLastname(data.get(FIELD_NAME_LAST_NAME));
        vendor.setAddress(data.get(FIELD_NAME_ADDRESS));
        vendor.setSalary(data.get(FIELD_NAME_SALARY));
        vendor.setEmail(data.get(FIELD_NAME_EMAIL));
        vendor.setPhone(data.get(FIELD_NAME_PHONE));

        vendor.setCreatedAt(new Date());
        vendor.setUpdatedAt(new Date());

        //Save vendors
        vendorDao.createOrUpdate(vendor);
        DbManager.closeConnectionDB();
        init();
    }

    public VendorMapper getVendorMapperObjectProperty() {
        return vendorMapperObjectProperty.get();
    }

    public ObjectProperty<VendorMapper> vendorMapperObjectPropertyProperty() {
        return vendorMapperObjectProperty;
    }

    public void setVendorMapperObjectProperty(VendorMapper vendorMapperObjectProperty) {
        this.vendorMapperObjectProperty.set(vendorMapperObjectProperty);
    }

    public VendorMapper getVendorMapperObjectPropertyEdit() {
        return vendorMapperObjectPropertyEdit.get();
    }

    public ObjectProperty<VendorMapper> vendorMapperObjectPropertyEditProperty() {
        return vendorMapperObjectPropertyEdit;
    }

    public void setVendorMapperObjectPropertyEdit(VendorMapper vendorMapperObjectPropertyEdit) {
        this.vendorMapperObjectPropertyEdit.set(vendorMapperObjectPropertyEdit);
    }

    public ObservableList<VendorMapper> getVendorMapperObservableList() {
        return vendorMapperObservableList;
    }

    public void setVendorMapperObservableList(ObservableList<VendorMapper> vendorMapperObservableList) {
        this.vendorMapperObservableList = vendorMapperObservableList;
    }
}
