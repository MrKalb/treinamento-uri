package br.com.uri.URIDemo.controller;

import br.com.uri.URIDemo.dto.CarDTO;
import br.com.uri.URIDemo.service.UriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UriController {

    @Autowired
    private UriService uriService;

    @PostMapping("/v1/car")
    public ResponseEntity<Void> createCar(@RequestBody CarDTO car) {
        uriService.createCar(car);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/cars")
    public ResponseEntity<List<CarDTO>> listTodos(){
        return ResponseEntity.ok(uriService.listarTodos());
    }
}
