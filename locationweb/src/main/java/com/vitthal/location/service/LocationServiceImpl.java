package com.vitthal.location.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitthal.location.entities.Location;
import com.vitthal.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRespository;
	
	@Override
	public Location saveLocation(Location location) {
		return locationRespository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		Location updatenew = locationRespository.save(location);
		return updatenew;
	}

	@Override
	public void deleteLocation(Location location) {
		locationRespository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return locationRespository.findOne(id);
	}

	@Override
	public List<Location> getAllLocations() {
		return locationRespository.findAll();
	}

	public LocationRepository getLocationRespository() {
		return locationRespository;
	}

	public void setLocationRespository(LocationRepository locationRespository) {
		this.locationRespository = locationRespository;
	}

}
