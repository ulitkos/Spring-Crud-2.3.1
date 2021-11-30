package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car(1,"Lada","Kalina"));
        cars.add(new Car(2,"Nissan","Patrol"));
        cars.add(new Car(3,"Toyota","Sequoya"));
        cars.add(new Car(4,"Honda","Accord"));
        cars.add(new Car(5,"Subaru","Forester"));

        return cars;
    }
}
