package com.mypackage;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="computer")
public class Computer {
	
	// Fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	// MSI 
	@Column(name="brand")
	private String brand;
	// Aegis RS 11th Gen
	@Column(name="model")
	private String model;
	// gaming, office
	@Column(name="computer_type")
	private String computerType;
	@Column(name="price")
	private int price;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cpu_foreign_key")
	private CPU cpu;
	
	// Create a one-to-one mapping relationship
	// between this table and table CPU
	// also make that relationship bi-directional
	// meaning if you delete one entry from one of the tables
	// then the corresponding entry in the other table is deleted too

	
	// Constructors
	
	public Computer() {}
	
	public Computer(String brand, String model, String computerType, int price) {
		super();
		this.brand = brand;
		this.model = model;
		this.computerType = computerType;
		this.price = price;
	}

	// toString
	
	@Override
	public String toString() {
		return "Computer [id=" + id + ", brand=" + brand + ", model=" + model + ", computerType=" + computerType
				+ ", price=" + price + "]";
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

	public String getComputerType() {
		return computerType;
	}

	public void setComputerType(String computerType) {
		this.computerType = computerType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	
	
}
