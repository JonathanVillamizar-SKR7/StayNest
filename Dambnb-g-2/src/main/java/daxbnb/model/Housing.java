package daxbnb.model;

import java.util.List;

public class Housing {
	private int idHouse;
	private String name;
	private String description;
	private String location;
	private int numGuest;
	private int numBedroom;
	private int numBed;
	private int numBath;
	private int idType;
	private double price;
	private List<Images> images;
	private List<Facilities> facilities;
	
	
	

	public Housing(int idHouse, String name, String description, String location, int numGuest, int numBedroom,
			int numBed, int numBath, int idType, double price, List<Images> images, List<Facilities> facilities) {
		this.idHouse = idHouse;
		this.name = name;
		this.description = description;
		this.location = location;
		this.numGuest = numGuest;
		this.numBedroom = numBedroom;
		this.numBed = numBed;
		this.numBath = numBath;
		this.idType = idType;
		this.price = price;
		this.images = images;
		this.facilities = facilities;
	}


	public int getIdHouse() {
		return idHouse;
	}


	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getNumGuest() {
		return numGuest;
	}


	public void setNumGuest(int numGuest) {
		this.numGuest = numGuest;
	}


	public int getNumBedroom() {
		return numBedroom;
	}


	public void setNumBedroom(int numBedroom) {
		this.numBedroom = numBedroom;
	}


	public int getNumBed() {
		return numBed;
	}


	public void setNumBed(int numBed) {
		this.numBed = numBed;
	}


	public int getNumBath() {
		return numBath;
	}


	public void setNumBath(int numBath) {
		this.numBath = numBath;
	}


	public int getIdType() {
		return idType;
	}


	public void setIdType(int idType) {
		this.idType = idType;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public List<Images> getImages() {
		return images;
	}


	public void setImages(List<Images> images) {
		this.images = images;
	}


	public List<Facilities> getFacilities() {
		return facilities;
	}


	public void setFacilities(List<Facilities> facilities) {
		this.facilities = facilities;
	}


	@Override
	public String toString() {
		return "Housing [idHouse=" + idHouse + ", name=" + name + ", description=" + description + ", location="
				+ location + ", numGuest=" + numGuest + ", numBedroom=" + numBedroom + ", numBed=" + numBed
				+ ", numBath=" + numBath + ", idType=" + idType + ", price=" + price + ", images=" + images
				+ ", facilities=" + facilities + "]";
	}


	
}
