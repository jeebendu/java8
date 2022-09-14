package com.example.java.demo.app.java8;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
	private String name;
	private Long qty;
	private BigDecimal price;
	

	

}
