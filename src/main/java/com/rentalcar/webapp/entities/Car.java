package com.rentalcar.webapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rentalcar.webapp.data.CarData;

@Entity
@Table(name="car")
public class Car implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_car")
	private int idCar;
	
	@Column(name="registration_year")
	private int yearOfRegistration;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="car_model")
	private String carModel;
	
	@Column(name="car_license_plate")
	private String carLicensePlate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_category")
	private Category category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="car")
	private List<Booking> booking;

	public Car() {
		super();
	}

	public Car(CarData carData, Category cat) {
		this.category = cat;
		this.yearOfRegistration = carData.getYearOfRegistration(); 
		this.manufacturer = carData.getManufacturer();
		this.carLicensePlate = carData.getCarLicensePlate();
		this.carModel = carData.getCarModel();
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public int getYearOfRegistration() {
		return yearOfRegistration;
	}

	public void setYearOfRegistration(int yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
}
