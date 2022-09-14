package com.example.java.demo.app.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.demo.app.city.City;

@RestController
@RequestMapping("/funInt")
public class FunInterfaceController {
	
	
	@GetMapping("/")
	public String welcome() {
		return "Fuctional Interface";
	}
	
	@GetMapping("/lambda")
	public String lambda() {
		MyInterface ref;
	    
	    // lambda expression
	    ref = () -> 3.1415;
	    
	    System.out.println("Value of Pi = " + ref.getValue());
		
		return "Fuctional Interface";
	}
	

	@GetMapping("/city")
	public List<City> cityList() {
		
		List<City> cityList = new ArrayList<City>();
		
		cityList.add(new City(2,"Delhi",4));
		cityList.add(new City(3,"Hyderbad",2));
		cityList.add(new City(4,"Chennai",1));
		cityList.add(new City(5,"Kollkatta",4));
		cityList.add(new City(1,"Bangalore",5));
		
		return cityList;
	}
	
	@GetMapping("/maxRating")
	public City maxRating() {
		
		List<City> cityList = cityList();
		cityList.forEach(city->System.out.println(city.getName()));
		City maxRatingCity = cityList.stream().max(Comparator.comparing(City::getRating)).get();
		
		return maxRatingCity;
		
		
	}
	
	
	@GetMapping("/minRating")
	public City minRating() {
		
		List<City> cityList = cityList();
		cityList.forEach(city->System.out.println(city.getName()));
		City maxRatingCity = cityList.stream().min(Comparator.comparing(City::getRating)).get();
		
		return maxRatingCity;
		
		
	}

}
