package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.modelo.entidad.Car;
import com.usergio.retos.retoapp.modelo.entidad.Gama;
import com.usergio.retos.retoapp.service.CarService;
import com.usergio.retos.retoapp.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Car")
@CrossOrigin("*")
public class ApiCar {
    @Autowired
    private CarService service;

    @GetMapping("/all")
    public List<Car> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getCar(@PathVariable long id){
        Optional<Car> car = service.getFindById(id);
        if(car.isPresent()){
            return ResponseEntity.ok(car.get());
        }
        else{
            Mensaje mensaje = Mensaje.builder()
                    .httpCode(404)
                    .mensaje("No se encontro Registro id="+id)
                    .build();
            return ResponseEntity.status(404).body(mensaje);
        }
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Car car){
        service.save(car);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity edit(@RequestBody Car car){
        service.updateCar(car);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable long id) {
        service.deleteCar(id);
        return ResponseEntity.status(204).build();
    }
}
