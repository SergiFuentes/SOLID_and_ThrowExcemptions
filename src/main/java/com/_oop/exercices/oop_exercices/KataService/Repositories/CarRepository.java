package com._oop.exercices.oop_exercices.KataService.Repositories;

import com._oop.exercices.oop_exercices.KataService.Models.Car;

import java.util.Optional;

public interface CarRepository {
   Optional<Car>findCarById(Long id);
}
