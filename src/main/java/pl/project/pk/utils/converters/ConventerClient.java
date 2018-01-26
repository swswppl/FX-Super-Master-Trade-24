package pl.project.pk.utils.converters;


import pl.project.pk.database.models.Client;
import pl.project.pk.mapper.ClientMapper;

public class ConventerClient {
    public static ClientMapper convertToClientMapper(Client client){
        ClientMapper clientMapper = new ClientMapper();
        clientMapper.setId(client.getId());
        clientMapper.setFirstName(client.getFirstName());
        clientMapper.setLastname(client.getLastname());
        clientMapper.setAddress(client.getAddress());
        clientMapper.setSalary(client.getSalary());
        clientMapper.setEmail(client.getEmail());
        clientMapper.setPhone(client.getPhone());

        return clientMapper;
    }
}
