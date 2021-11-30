package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

 //   @Autowired
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }

    @Override
    public List<Car> getCarsByCount(Integer count) {
        if (count == null || count < 0 || count >= carDao.getCars().size()) return carDao.getCars();
        return carDao.getCars().subList(0, count);
    }
}
