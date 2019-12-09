package com.codegym.cms.controller;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Customer;
import com.codegym.cms.service.CityService;
import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    CustomerService customerService;

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {return customerService.findAll();}

    @GetMapping("/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView SaveCitys(@ModelAttribute("material") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/material/create");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Thêm mới thành công !");
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/citys/edit");
            modelAndView.addObject("citys", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-city")
    public ModelAndView updateCitys(@ModelAttribute("citys") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/citys/edit");
        modelAndView.addObject("citys", city);
        modelAndView.addObject("message","bạn có chắc thêm thành phố");
        return modelAndView;
    }
    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-city")
    public String deleteCitys(@ModelAttribute("city") City city){
        cityService.remove(city.getId());
        return "redirect:cities";
    }

    @GetMapping("/cities")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<City> cities;
        if (s.isPresent()){
            cities = cityService.findAllByNameContaining(s.get(), pageable);
        } else {
            cities = cityService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("city",cities);
        return modelAndView;
    }
}
