package com._oop.exercices.oop_exercices.KataServiceTests;

import com._oop.exercices.oop_exercices.KataService.Exceptions.RentServiceException;
import com._oop.exercices.oop_exercices.KataService.Models.Car;
import com._oop.exercices.oop_exercices.KataService.Models.CarUser;
import com._oop.exercices.oop_exercices.KataService.Models.Rent;
import com._oop.exercices.oop_exercices.KataService.Repositories.CarRepository;
import com._oop.exercices.oop_exercices.KataService.Repositories.CarUserRepository;
import com._oop.exercices.oop_exercices.KataService.Repositories.RentRepository;
import com._oop.exercices.oop_exercices.KataService.Services.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class KataServiceTest {
    @Mock
    RentRepository rentRepository;
    @Mock
    CarRepository carRepository;
    @Mock
    CarUserRepository carUserRepository;



    @BeforeEach
    void setUp(){}

    @Test
    void carServiceCanReturnARentalItem(){

        CarUser carUser = new CarUser(1L, "user1");
        Car car = new Car(1L, "8888-F", "Renault");
        Rent rent = new Rent(car, carUser);


        when(carRepository.findCarById(1L)).thenReturn(Optional.of(car));
        when(carUserRepository.findCarUserById(carUser.getId())).thenReturn(Optional.of(carUser));
        when(rentRepository.findRentByCar(car)).thenReturn(Optional.empty());
        when(rentRepository.save(any(Rent.class))).thenReturn(rent);

        CarService carService = new CarService(rentRepository,carRepository,carUserRepository);

        var sut= carService.rentCar(car.getId(), carUser.getId());

        assertThat(sut.getClass(), equalTo(rent.getClass()));
        assertThat(sut.getRentedCar(),equalTo(car));
        assertThat(sut.getRentingUser(), equalTo(carUser));
        assertEquals(carUser,carUserRepository.findCarUserById(carUser.getId()).get());
        assertEquals(car,carRepository.findCarById(car.getId()).get());
        assertEquals(rent,rentRepository.save(rent));
    }

    @Test
    void carServiceShouldReturnExceptionIfCarUserDoesntExists() {

        CarUser carUser = new CarUser(1L, "user1");
        Car car = new Car(2L, "8888-F", "Renault");
        Rent rent = new Rent(car, carUser);

        when(carRepository.findCarById(2L)).thenReturn(Optional.of(car));
        when(carUserRepository.findCarUserById(carUser.getId())).thenReturn(Optional.empty());
        when(rentRepository.findRentByCar(car)).thenReturn(Optional.empty());
        when(rentRepository.save(rent)).thenReturn(rent);

        CarService carService = new CarService(rentRepository, carRepository, carUserRepository);

        RentServiceException thrown = assertThrows(RentServiceException.class, () -> carService.rentCar(car.getId(), carUser.getId()));


        assertEquals("User not found", thrown.getMessage());
        assertEquals("R-101", thrown.getCode());
    }

    @Test
    void carServiceShouldReturnExceptionIfCarDoesntExists() {

        CarUser carUser = new CarUser(1L, "user1");
        Car car = new Car(2L, "8888-F", "Renault");
        Rent rent = new Rent(car, carUser);


        when(rentRepository.findRentByCar(car)).thenReturn(Optional.empty());
        when(carRepository.findCarById(2L)).thenReturn(Optional.empty());
        when(carUserRepository.findCarUserById(carUser.getId())).thenReturn(Optional.of(carUser));
        when(rentRepository.save(rent)).thenReturn(rent);

        CarService carService = new CarService(rentRepository, carRepository, carUserRepository);

        RentServiceException thrown = assertThrows(RentServiceException.class, () -> carService.rentCar(car.getId(), carUser.getId()));


        assertEquals("Car not found", thrown.getMessage());
        assertEquals("R-102", thrown.getCode());
    }

    @Test
    void carServiceShouldReturnExceptionIfCarExistsInRentRepository(){

        CarUser carUser = new CarUser(1L, "user1");
        Car car = new Car(2L, "8888-F", "Renault");
        Rent rent = new Rent(car, carUser);

        when(carRepository.findCarById(2L)).thenReturn(Optional.of(car));
        when(carUserRepository.findCarUserById(carUser.getId())).thenReturn(Optional.of(carUser));
        when(rentRepository.findRentByCar(car)).thenReturn(Optional.of(rent));
        when(rentRepository.save(rent)).thenReturn(rent);

        CarService carService = new CarService(rentRepository,carRepository,carUserRepository);

        RentServiceException thrown = assertThrows(RentServiceException.class,()->carService.rentCar(car.getId(), carUser.getId()));

        assertEquals("Car rented yet", thrown.getMessage());
        assertEquals("R-103", thrown.getCode());
    }
}
