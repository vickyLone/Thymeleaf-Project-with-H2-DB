package com.vicky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
@Entity
public class Products {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "Name cannot be empty")
	@Size(min=2,max = 20)
	private String name;
	
	@NotNull(message = "Price cannot be a null")
	@Positive(message = "Price must be more than zero")
	private Double price;
	
	@NotNull(message = "Quantity cannot be null, please enter more than 1 quntity")
	@Min(value = 1)
	private Long quantity;


}
