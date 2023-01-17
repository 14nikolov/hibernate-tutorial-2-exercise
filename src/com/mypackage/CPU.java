package com.mypackage;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cpu")
public class CPU {
	
	// Fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "brand")
	private String brand;
	@Column(name="model")
	private String model;
	@OneToOne(mappedBy = "cpu", cascade = CascadeType.ALL)
	private Computer computer;
	
	
	// Constructors
	
	public CPU() {}

	public CPU(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	// toString 
	
	@Override
	public String toString() {
		return "CPU [id=" + id + ", brand=" + brand + ", model=" + model + "]";
	}

	// Getters and Setters

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
	
}
