package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Car;
import com.usergio.retos.retoapp.modelo.entidad.Gama;
import com.usergio.retos.retoapp.modelo.repositorio.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;
    public List<Car> getAll(){
        return repository.findAll();
    }
    public Car save(Car car){
        return repository.save(car);
    }

    public Optional<Car> getFindById(Long id){
        return repository.findById(id);
    }
    public Car updateCar(Car carUpdate){
        Optional<Car> car = getFindById(carUpdate.getIdCar());
        if(car.isPresent()){
            car.get().setName(carUpdate.getName());
            car.get().setBrand(carUpdate.getBrand());
            car.get().setYear(carUpdate.getYear());
            car.get().setDescription(carUpdate.getDescription());
            car.get().setGama(carUpdate.getGama());
            return repository.save(car.get());
        }
        else{
            return carUpdate;
        }
    }

}
