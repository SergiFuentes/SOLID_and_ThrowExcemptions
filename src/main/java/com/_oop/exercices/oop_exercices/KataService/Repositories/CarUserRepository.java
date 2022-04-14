package com._oop.exercices.oop_exercices.KataService.Repositories;

import com._oop.exercices.oop_exercices.KataService.Models.CarUser;

import java.util.Optional;

public interface CarUserRepository {
    Optional<CarUser> findCarUserById(Long id);
}
