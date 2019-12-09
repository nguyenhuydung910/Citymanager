package com.codegym.cms.repository;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository <City, Long> {
    Page<City> findAllByNameContaining(String name, Pageable pageable);

        Iterable<City> findAllByCustomer(Customer customer);
}
