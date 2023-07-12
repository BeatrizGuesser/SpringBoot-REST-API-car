package br.com.beatrizguesser.car.controller;

import br.com.beatrizguesser.car.entity.Car;
import br.com.beatrizguesser.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/post")
    public Car post(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping("/get/{idChassi}")
    public Car post(@PathVariable Long idChassi){
        return carService.getById(idChassi);
    }
}
