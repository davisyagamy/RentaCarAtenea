package com.example.rentacarreto3.Controller;
import com.example.rentacarreto3.Service.CarService;
import com.example.rentacarreto3.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("api/Car")
public class CarController {

    @Autowired
    private CarService carService;
    @GetMapping("/all")
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable int id){
        return carService.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car update(@RequestBody Car car){
        return carService.update(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return  carService.delete(id);
    }

}
