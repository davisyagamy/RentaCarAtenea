package com.example.rentacarreto3.Controller;
import com.example.rentacarreto3.Service.ReservationService;
import com.example.rentacarreto3.model.DTOs.CompleteAndCancelled;
import com.example.rentacarreto3.model.DTOs.TotalAndClient;
import com.example.rentacarreto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable int id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return  reservationService.delete(id);
    }

    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation>getResertavionsDatesReport(@PathVariable("fecha1")String fecha1,@PathVariable("fecha2")String fecha2){
        return reservationService.getReservationsDateReport(fecha1,fecha2);
    }

    @GetMapping("/report-status")
    public CompleteAndCancelled getReservationsStatus(){
        return reservationService.getReservationsReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient> getTopClientsReport(){
        return reservationService.getTopClientsReport();
    }

}