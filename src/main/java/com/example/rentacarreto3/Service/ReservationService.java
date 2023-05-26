package com.example.rentacarreto3.Service;
import com.example.rentacarreto3.Repository.ReservationRepository;
import com.example.rentacarreto3.model.Client;
import com.example.rentacarreto3.model.DTOs.CompleteAndCancelled;
import com.example.rentacarreto3.model.DTOs.TotalAndClient;
import com.example.rentacarreto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isPresent()) {
                if (reservation.getStartDate() != null) {
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservationEncontrado.get());
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean delete(int id) {
        Boolean respuesta = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }

    public List<Reservation>getReservationsDateReport(String fecha1,String fecha2){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(fecha1);
            b = parser.parse(fecha2);
        }catch (ParseException exception){
            exception.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getReservationsDates(a,b);
        }else {
            return new ArrayList<>();
        }
    }

    public CompleteAndCancelled getReservationsReport (){
        List<Reservation> completed = reservationRepository.getReservationsStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsStatus("cancelled");

        Long cantidadCompletada = (long) completed.size();
        Long cantidadCancelada = (long) cancelled.size();
        CompleteAndCancelled result = new CompleteAndCancelled(cantidadCompletada,cantidadCancelada);
        return result;
    }

    public List<TotalAndClient>getTopClientsReport(){
        List<TotalAndClient> result = new ArrayList<>();

        List<Object[]> report = reservationRepository.getTotalReservationsByClient();

        for (Object[] couple: report){
            result.add(new TotalAndClient( (Long) couple [1], (Client) couple[0] ));
        }
        return result;
    }


}
