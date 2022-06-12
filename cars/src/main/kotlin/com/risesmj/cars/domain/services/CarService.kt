package com.risesmj.cars.domain.services

import com.risesmj.cars.domain.dto.CarDTO
import com.risesmj.cars.domain.entities.Car
import com.risesmj.cars.domain.repositories.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CarService {
    @Autowired(required = true)
    lateinit var repository: CarRepository

    fun getCars(): MutableList<CarDTO> {
        return repository.findAll().stream().map { CarDTO.fromCar(it) }.toList()
    }

    fun getCarById(id: Long): Optional<CarDTO>{
        return repository.findById(id).map { CarDTO.fromCar(it) }
    }

    fun getCarByType(type: String): MutableList<CarDTO>{
        return repository.findByType(type).stream().map { CarDTO.fromCar(it) }.toList()
    }

    fun save(car: Car): Car{
        return repository.save(car)
    }

    fun update(id: Long, car: Car): CarDTO{
        var optional = repository.findById(id)

        if(optional.isPresent){
            var db = optional.get()
            db.name = car.name
            db.type = car.type

            repository.save(db)

            return CarDTO.fromCar(db)
        }else{
            throw java.lang.RuntimeException("Não foi possível atualizar o registro")
        }
    }

    fun delete(id: Long){
        if(getCarById(id).isPresent) {
            repository.deleteById(id)
        }else{
            throw java.lang.RuntimeException("Registro não localizado")
        }
    }

    fun getCarsFake(): List<Car>{
        val car = mutableListOf<Car>()
        car.add(Car(1L,"Fusca"))
        car.add(Car(2L,"Brasília"))
        car.add(Car(3L,"Chevette"))
        return car
    }
}