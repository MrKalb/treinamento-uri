package br.com.uri.URIDemo.service;

import br.com.uri.URIDemo.dto.CarDTO;
import br.com.uri.URIDemo.entity.CarEntity;
import br.com.uri.URIDemo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UriService {

    @Autowired
    private CarRepository carRepository;

    public void createCar(CarDTO car) {
        CarEntity carEntity = new CarEntity();
        carEntity.setChassi(car.getChassi());
        carEntity.setMarca(car.getMarca());
        carEntity.setNome(car.getNome());
        carRepository.save(carEntity);
    }

    public List<CarDTO> listarTodos(){
        List<CarDTO> carDTOS = new ArrayList<>();
        List<CarEntity> carEntities = carRepository.findAll();
        carEntities.stream().forEach(object -> {
            CarDTO carDTO = new CarDTO();
            carDTO.setMarca(object.getMarca());
            carDTO.setChassi(object.getChassi());
            carDTO.setNome(object.getNome());
            carDTOS.add(carDTO);
        });
        return carDTOS;
    }
}
