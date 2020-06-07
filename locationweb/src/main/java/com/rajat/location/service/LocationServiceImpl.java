package com.rajat.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajat.location.Entities.Location;
import com.rajat.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private	LocationRepository repository;
	
	@Override
	public Location saveLocation(Location location) {
		// it is new location
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location);//it is a updated location
		
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		return (List<Location>) repository.findAll();
	}

	public LocationRepository getRepository() {
		return repository;
	}

	public void setRepository(LocationRepository repository) {
		this.repository = repository;
	}

}
