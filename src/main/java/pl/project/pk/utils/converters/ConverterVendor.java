package pl.project.pk.utils.converters;


import pl.project.pk.database.models.Vendor;
import pl.project.pk.mapper.VendorMapper;

public class ConverterVendor {

    public static Vendor convertToVendor(VendorMapper vendorMapper){
        Vendor vendor = new Vendor();
        vendor.setId(vendor.getId());
        vendor.setFirstName(vendorMapper.getFirstName());
        vendor.setLastname(vendorMapper.getLastname());
        vendor.setAddress(vendorMapper.getAddress());
        vendor.setSalary(vendorMapper.getSalary());
        vendor.setEmail(vendorMapper.getEmail());
        vendor.setPhone(vendorMapper.getPhone());

        return vendor;
    }

    public static VendorMapper convertToVendorMapper(Vendor vendor){
        VendorMapper vendorMapper = new VendorMapper();
        vendorMapper.setId(vendor.getId());
        vendorMapper.setFirstName(vendor.getFirstName());
        vendorMapper.setLastname(vendor.getLastname());
        vendorMapper.setAddress(vendor.getAddress());
        vendorMapper.setSalary(vendor.getSalary());
        vendorMapper.setEmail(vendor.getEmail());
        vendorMapper.setPhone(vendor.getPhone());

        return vendorMapper;
    }
}
