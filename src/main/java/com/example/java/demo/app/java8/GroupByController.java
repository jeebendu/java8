package com.example.java.demo.app.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("groupby")
public class GroupByController {
	
	@GetMapping("count")
	public Map<String, Long> groupByItems(){
		List<String> items = Arrays.asList("apple", "apple", "banana","apple", "orange", "banana", "papaya");
		Map<String,Long> result = items.stream().collect(
				Collectors.groupingBy(
						Function.identity(),Collectors.counting()
						)
				);
		
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/objects")
	public Map<Integer, Map<String, Long>> objectsCount() {
		
		Map< Integer , Map<String,Long> > output = new HashMap();
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
		
		Map<String,Long> counting = items.stream().collect(
				Collectors.groupingBy(
						Item::getName,Collectors.counting()
						)
				);
		output.put(1, counting);
		
		Map<String,Long> result = items.stream().collect(
				Collectors.groupingBy(
						Item::getName,Collectors.summingLong(Item::getQty)
						)
				);
		output.put(2, result);
		return output;
		
	}
	
	@GetMapping("/price")
	public Map<BigDecimal, Set<String>> byPrice() {
		
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
		
		Map<BigDecimal,List<Item>> result =  items.stream().collect(
				Collectors.groupingBy(Item::getPrice)
				);
		
		Map<BigDecimal,Set<String>> result2 =  items.stream().collect(
				Collectors.groupingBy(Item::getPrice,Collectors.mapping(Item::getName, Collectors.toSet()))
				);
		
		return result2;
		
	}

}
