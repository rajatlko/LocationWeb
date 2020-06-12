package com.rajat.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajat.location.Entities.Location;
import com.rajat.location.service.LocationService;
import com.rajat.location.util.EmailUtil;

@Controller
public class locationController {
	@Autowired
	LocationService service;
	
	@Autowired
	EmailUtil emailUtil;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		//this function will just return jsp page to end user
		return "createLocation";
	}
	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		//to handle the request we use model attribute and to handle the response we use model map
		Location locationSaved = service.saveLocation(location);
		String msg="Location saved with id:"+ locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		//this modeMap can be accessed by jsp using spring Expression language
		emailUtil.sendEmail("rajatchaturvedi1995@gmail.com", "FOUND YOU!!", "");
		return "createLocation"; 
	}
	@RequestMapping("/displayLocation")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocation(); 
		modelMap.addAttribute("locations",locations);
		return "displayLocation";
	}
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id")int id,ModelMap modelMap) {
		//request Param tells it should parameter from url paramater 
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations =service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocation"; 
	}
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id")int id,ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location",location);
		return "updateLocation";
	}
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocation";
		
	}
}
