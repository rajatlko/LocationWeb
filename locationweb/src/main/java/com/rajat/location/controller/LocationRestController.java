package com.rajat.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.location.Entities.Location;
import com.rajat.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController {

	@Autowired
	LocationRepository locationRepository;
	
	@GetMapping
	public List<Location> getLocation(){
		return locationRepository.findAll();
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location) {//requestbody is used so that spring derialise the location
		return locationRepository.save(location);
	}
	@PutMapping
	public Location updateLoaction(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {//Path variable tells which value from link is attached to provided variable
		locationRepository.deleteById(id);
	}
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable int id) {
		return locationRepository.findById(id).get();
	}
}
