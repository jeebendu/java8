package com.example.java.demo.app.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sort")
public class SortingController {
	
	@GetMapping("asc")
	public List<Integer> order() {
		List<Integer> items = Arrays.asList(18,24,13,5,50,60,8,15,20);
		Collections.sort(items);
		Collections.reverse(items);
		return items;
	}
	
	
	@GetMapping("ascObj")
	public List<Item> orderObj() {
		List<Item> items = Arrays.asList(
				
				new Item("apple", 10L, new BigDecimal("9.99")),
                new Item("banana", 20L, new BigDecimal("19.99")),
                new Item("orang", 10L, new BigDecimal("29.99")),
                new Item("watermelon", 10L, new BigDecimal("29.99")),
                new Item("papaya", 20L, new BigDecimal("9.99")),
                new Item("apple", 10L, new BigDecimal("9.99")),
                new Item("banana", 10L, new BigDecimal("19.99")),
                new Item("apple", 20L, new BigDecimal("9.99"))
                );
		
		Collections.sort(items,(o1,o2)-> (o1.getName().compareTo(o2.getName())));
		
		items.sort(Comparator.comparing(Item::getQty));
		
		items.sort(  Comparator.comparing(Item::getQty).thenComparing(Item::getPrice) );
		
		
		return items;
	}

}
