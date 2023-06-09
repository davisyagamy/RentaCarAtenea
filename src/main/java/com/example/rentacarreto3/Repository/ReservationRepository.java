package com.example.rentacarreto3.Repository;
import com.example.rentacarreto3.Repository.CRUD.ReservationCrudRepository;
import com.example.rentacarreto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> findAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationsDates(Date fecha1,Date fecha2){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fecha1,fecha2);
    }

    public List<Reservation> getReservationsStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Object[]> getTotalReservationsByClient(){
        return reservationCrudRepository.getTotalReservationsByClient();
    }

}
