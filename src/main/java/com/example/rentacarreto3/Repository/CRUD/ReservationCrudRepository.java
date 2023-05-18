package com.example.rentacarreto3.Repository.CRUD;

import com.example.rentacarreto3.model.Car;
import com.example.rentacarreto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
