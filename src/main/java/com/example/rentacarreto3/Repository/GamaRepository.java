package com.example.rentacarreto3.Repository;
import com.example.rentacarreto3.Repository.CRUD.GamaCrudRepository;
import com.example.rentacarreto3.model.Gama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository {

    @Autowired
    private GamaCrudRepository gamaCrudRepository;

    public List<Gama> findAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }

    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);
    }

    public Gama save(Gama gama){
        return gamaCrudRepository.save(gama);
    }

    public void delete(Gama gama){
        gamaCrudRepository.delete(gama);
    }
}


