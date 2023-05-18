package com.example.rentacarreto3.Repository.CRUD;

import com.example.rentacarreto3.model.Car;
import com.example.rentacarreto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
