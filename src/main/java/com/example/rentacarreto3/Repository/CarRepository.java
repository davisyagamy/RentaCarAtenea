package com.example.rentacarreto3.Repository;
import com.example.rentacarreto3.Repository.CRUD.CarCrudRepository;
import com.example.rentacarreto3.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class CarRepository {
    @Autowired
    private CarCrudRepository carCrudRepository;

    public List <Car> findAll(){
        return (List<Car>) carCrudRepository.findAll();
    }
    public Optional<Car> getCar(int id){
        return carCrudRepository.findById(id);
    }
    public Car save(Car car){
        return carCrudRepository.save(car);
    }
    public void deleted (Car car){
        carCrudRepository.delete(car);
    }
}