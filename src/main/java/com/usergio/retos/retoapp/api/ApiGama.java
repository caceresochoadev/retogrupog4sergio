package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.modelo.entidad.Gama;
import com.usergio.retos.retoapp.service.GamaService;
import com.usergio.retos.retoapp.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Gama")
@CrossOrigin("*")
public class ApiGama {
    @Autowired
    private GamaService service;
    @GetMapping("/all")
    public List<Gama> getGamaAll(){
        return service.getAll();
    }
    @PostMapping("/save")
    public ResponseEntity saveGama(@RequestBody Gama gama){
        service.save(gama);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getGama(@PathVariable Long id) {
        Optional<Gama> gama = service.getFindById(id);
        if (gama.isPresent()) {
            return ResponseEntity.ok(gama.get());
        } else {
          // return ResponseEntity.notFound().build();
            Mensaje mensaje = Mensaje.builder().httpCode(404).mensaje("No se encontro Registro id"+id).build();
            return ResponseEntity.status(404).body(mensaje);
        }
    }

    @PutMapping("/update")
    public ResponseEntity editGama(@RequestBody Gama gama){
        service.updateGama(gama);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGama(@PathVariable Long id) {
         service.deleteGama(id);
        return ResponseEntity.status(204).build();
    }

}
