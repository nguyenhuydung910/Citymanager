package com.codegym.cms.formatter;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Customer;
import com.codegym.cms.service.CityService;
import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CityFormatter implements Formatter<City> {
    private CityService cityService;

    @Autowired
    public CityFormatter(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public City parse(String text, Locale locale) throws ParseException {
        return cityService.findById(Long.parseLong(text));
    }

    @Override
    public String print(City object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}
