package br.com.beatrizguesser.car.controller;

import br.com.beatrizguesser.car.dto.CarDtoRequest;
import br.com.beatrizguesser.car.dto.CarDtoResponse;
import br.com.beatrizguesser.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
;import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/post")
    public String postCar(@RequestBody CarDtoRequest carDtoRequest){
        carService.save(carDtoRequest);
        return "Car successfully saved!";
    }

    @GetMapping("/get/{idChassi}")
    public CarDtoResponse getCar(@PathVariable Long idChassi){
        return carService.getById(idChassi);
    }
}
