package br.com.beatrizguesser.car.service;

import br.com.beatrizguesser.car.dto.CarDtoRequest;
import br.com.beatrizguesser.car.dto.CarDtoResponse;
import br.com.beatrizguesser.car.entity.Car;
import br.com.beatrizguesser.car.exception.FoundException;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.beatrizguesser.car.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public void save(CarDtoRequest carDtoRequest) {
        if (carDtoRequest.getName() == null || carDtoRequest.getBrand() == null || carDtoRequest.getColor() == null || carDtoRequest.getFabricationYear() == null) {
            throw new FoundException("Null fields not allowed");
        } else if (!carDtoRequest.getBrand().equalsIgnoreCase("Ford") && !carDtoRequest.getBrand().equalsIgnoreCase("Chevrolet") && !carDtoRequest.getBrand().equalsIgnoreCase("BMW") && !carDtoRequest.getBrand().equalsIgnoreCase("Volvo")) {
            throw new FoundException("Invalid brand");
        } else {
            Car car = new Car(
                    null,
                    carDtoRequest.getName(),
                    carDtoRequest.getBrand(),
                    carDtoRequest.getColor(),
                    carDtoRequest.getFabricationYear());

            carRepository.save(car).toString();
        }
    }

    public CarDtoResponse getById(Long idChassi) {

        Car car = carRepository.findById(idChassi).orElse(null);

        if (car != null) {
            CarDtoResponse carDtoResponse = new CarDtoResponse(
                    car.getIdChassi(),
                    car.getName(),
                    car.getBrand(),
                    car.getColor(),
                    car.getFabricationYear());

            return carDtoResponse;
        } else {
            throw new FoundException("idChassi not found");
        }
    }
}
