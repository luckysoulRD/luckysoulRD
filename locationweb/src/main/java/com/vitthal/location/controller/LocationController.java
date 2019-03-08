package com.vitthal.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitthal.location.entities.Location;
import com.vitthal.location.repos.LocationRepository;
import com.vitthal.location.service.LocationService;
import com.vitthal.location.util.EmailUtil;
import com.vitthal.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	private ServletContext sc;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private LocationService service;

	@RequestMapping(value = "/showCreated")
	public String showCreated() {
		return "createLocation";
	}

	@RequestMapping(value = "/saveLoc", method = RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "location saved with Id Is :" + locationSaved.getId();
		modelmap.addAttribute("msg", msg);
		emailUtil.sendEmail("jadhav.vitthal25@gmail.com", "location saved", "location saved Successfully and about return a response");
		return "createLocation";
	}

	@RequestMapping(value = "/displayLocation")
	public String displayLocation(ModelMap modelMap) {

		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}

	@RequestMapping(value = "/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = new Location();
		location.setId(id);
		// Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}

	@RequestMapping(value = "/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "editLocation";
	}

	@RequestMapping(value = "/updateloc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationsaved = service.saveLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";

	}
	
	@RequestMapping(value="/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		System.out.println("Path :-----------------------"+path);
		List<Object[]> data = locationRepository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
}
