package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
//@RequestMapping(value = "/1")

public class CarsController {

    //    @Autowired
    private final CarService carService;

    //    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    //    public String printCars(HttpServletRequest request) {
    public String printCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars = carService.getCarsByCount(count);
        model.addAttribute("elements", cars);

        return "cars";
    }
}
