package com._oop.exercices.oop_exercices.KataService.Repositories;


import com._oop.exercices.oop_exercices.KataService.Models.Car;
import com._oop.exercices.oop_exercices.KataService.Models.Rent;

import java.util.Optional;

public interface RentRepository {

    Optional<Rent> findRentByCar(Car car);

    Rent save(Rent rent);
}
