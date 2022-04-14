package com._oop.exercices.oop_exercices.KataService.Services;

import com._oop.exercices.oop_exercices.KataService.Exceptions.RentServiceException;
import com._oop.exercices.oop_exercices.KataService.Models.Rent;
import com._oop.exercices.oop_exercices.KataService.Repositories.CarRepository;
import com._oop.exercices.oop_exercices.KataService.Repositories.CarUserRepository;
import com._oop.exercices.oop_exercices.KataService.Repositories.RentRepository;

import java.util.Date;

public class CarService {

    private RentRepository rentRepository;
    private CarRepository carRepository;
    private CarUserRepository carUserRepository;

    public CarService(RentRepository rentRepository, CarRepository carRepository, CarUserRepository carUserRepository){
        this.rentRepository = rentRepository;
        this.carRepository= carRepository;
        this.carUserRepository= carUserRepository;
    }

    public Rent rentCar(Long carId, Long carUserId) {


            var userOptional=carUserRepository.findCarUserById(carUserId);
            if(userOptional.isEmpty()){throw new RentServiceException("User not found", "R-101");
            }


            var carOptional= carRepository.findCarById(carId);
            if(carOptional.isEmpty()){throw new RentServiceException("Car not found","R-102");}


            var rentOptional= rentRepository.findRentByCar(carOptional.get());
            if(rentOptional.isPresent()) {throw new RentServiceException("Car rented yet", "R-103");}

            Rent rent = new Rent();
            rent.setRentingUser(userOptional.get());
            rent.setRentedCar(carOptional.get());
            rent.setDate(new Date());

            return rentRepository.save(rent);
    }



}
