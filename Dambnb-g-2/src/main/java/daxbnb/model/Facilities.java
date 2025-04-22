package daxbnb.model;

public class Facilities extends Housing{
	private int idHouse;
	private int idFacilities;
	private String typeFacilities;
	private boolean available;
	private String description;
	private int idImage;
	private String imgRoute;
	
	
	public Facilities(int idHouse, String name, String description, String location, int numGuest, int numBedroom,
			int numBed, int numBath, int idType, double price, int idHouse2, int idFacilities, String typeFacilities,
			boolean available, String description2, int idImage, String imgRoute) {
		super(idHouse, name, description, location, numGuest, numBedroom, numBed, numBath, idType, price);
		idHouse = idHouse2;
		this.idFacilities = idFacilities;
		this.typeFacilities = typeFacilities;
		this.available = available;
		description = description2;
		this.idImage = idImage;
		this.imgRoute = imgRoute;
	}

	public int getIdHouse() {
		return idHouse;
	}

	public void setIdHouse(int idHouse) {
		this.idHouse = idHouse;
	}

	public int getIdFacilities() {
		return idFacilities;
	}

	public void setIdFacilities(int idFacilities) {
		this.idFacilities = idFacilities;
	}

	public String getTypeFacilities() {
		return typeFacilities;
	}

	public void setTypeFacilities(String typeFacilities) {
		this.typeFacilities = typeFacilities;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getImgRoute() {
		return imgRoute;
	}

	public void setImgRoute(String imgRoute) {
		this.imgRoute = imgRoute;
	}

	@Override
	public String toString() {
		return "Facilities [idHouse=" + idHouse + ", idFacilities=" + idFacilities + ", typeFacilities="
				+ typeFacilities + ", available=" + available + ", description=" + description + ", idImage=" + idImage
				+ ", imgRoute=" + imgRoute + ", toString()=" + super.toString() + "]";
	}


	
	
	
}
