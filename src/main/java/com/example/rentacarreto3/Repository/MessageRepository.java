package com.example.rentacarreto3.Repository;
import com.example.rentacarreto3.Repository.CRUD.MessageCrudRepository;
import com.example.rentacarreto3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<Message> findAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    public void deleted (Message message){
        messageCrudRepository.delete(message);
    }
}
