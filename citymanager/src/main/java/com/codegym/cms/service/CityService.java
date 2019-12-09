package com.codegym.cms.service;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> findAll(Pageable pageable);
    City findById(Long id);

    void save(City city);

    void remove(Long id);

    Iterable<City> findAllByCustomer(City city);

//    Page<City> findAllByNameContaining(String name, Pageable pageable);
}
