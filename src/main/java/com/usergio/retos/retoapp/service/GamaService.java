package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Gama;
import com.usergio.retos.retoapp.modelo.repositorio.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository repository;

    /**
     * Metodo getAll lista los registros de la tabla gama
     * @return List Objeto Gama
     */
    public List<Gama> getAll(){
        return repository.findAll();
    }
    /**
     * metodo save guarda registro en la tabla gama
     * return objeto tipo Gama
     * */
    public Gama save(Gama gama){
        return repository.save(gama);
    }

    public Optional<Gama> getFindById(Long id){
        return repository.findById(id);
    }
    /*
    public ResponseEntity updateGama(Gama gamaUpdate){
        Optional<Gama> gama = getFindById(gamaUpdate.getIdGama());
        if(gama.isPresent()){
            gama.get().setDescription(gamaUpdate.getDescription());
            gama.get().setName(gamaUpdate.getName());
            repository.save(gama.get());
            return ResponseEntity.status(201).build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

     */
    public Gama updateGama(Gama gamaUpdate){
        Optional<Gama> gama = getFindById(gamaUpdate.getIdGama());
        if(gama.isPresent()){
            gama.get().setDescription(gamaUpdate.getDescription());
            gama.get().setName(gamaUpdate.getName());
            return repository.save(gama.get());
        }
        else{
            return gamaUpdate;
        }
    }

    public void deleteGama(long id){
        repository.deleteById(id);
    }




}
