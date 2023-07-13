package br.com.beatrizguesser.car.service;

import br.com.beatrizguesser.car.dto.CarDtoRequest;
import br.com.beatrizguesser.car.dto.CarDtoResponse;
import br.com.beatrizguesser.car.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.beatrizguesser.car.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public void save(CarDtoRequest carDtoRequest) {

        Car car = new Car(
                null,
                carDtoRequest.getName(),
                carDtoRequest.getBrand(),
                carDtoRequest.getColor(),
                carDtoRequest.getFabricationYear());

        carRepository.save(car);
    }

    public CarDtoResponse getById(Long idChassi) {

        Car car = carRepository.findById(idChassi).orElseThrow();

        CarDtoResponse carDtoResponse = new CarDtoResponse(
                car.getIdChassi(),
                car.getName(),
                car.getBrand(),
                car.getColor(),
                car.getFabricationYear());

        return carDtoResponse;
    }

}
