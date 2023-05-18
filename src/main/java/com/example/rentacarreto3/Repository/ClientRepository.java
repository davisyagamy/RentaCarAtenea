package com.example.rentacarreto3.Repository;
import com.example.rentacarreto3.Repository.CRUD.ClientCrudRepository;
import com.example.rentacarreto3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;
    public List<Client> findAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public void deleted(Client client){
        clientCrudRepository.delete(client);
    }
}
