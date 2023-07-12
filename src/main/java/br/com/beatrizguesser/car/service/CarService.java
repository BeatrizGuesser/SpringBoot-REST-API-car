package br.com.beatrizguesser.car.service;

import br.com.beatrizguesser.car.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.beatrizguesser.car.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public Car save(Car car) {
        carRepository.save(car);
        return car;
    }

    public Car getById(Long idChassi) {
        return carRepository.findById(idChassi).orElseThrow();
    }

}
