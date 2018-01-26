package pl.project.pk.utils.converters;


import pl.project.pk.database.models.Client;
import pl.project.pk.mapper.ClientMapper;

public class ConventerClient {

    public static Client convertToClient(ClientMapper clientMapper){
        Client client = new Client();
        client.setId(client.getId());
        client.setFirstName(clientMapper.getFirstName());
        client.setLastname(clientMapper.getLastname());
        client.setAddress(clientMapper.getAddress());
        client.setSalary(clientMapper.getSalary());
        client.setEmail(clientMapper.getEmail());
        client.setPhone(clientMapper.getPhone());

        return client;
    }

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
