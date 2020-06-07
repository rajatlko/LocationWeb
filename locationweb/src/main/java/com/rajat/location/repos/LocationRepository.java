package com.rajat.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.rajat.location.Entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
