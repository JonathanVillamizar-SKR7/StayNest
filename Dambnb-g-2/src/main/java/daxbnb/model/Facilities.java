package daxbnb.model;

public class Facilities {
	private int idHouse;
	private int idFacilities;
	private String typeFacilities;
	private boolean available;
	
	public Facilities(int idHouse, int idFacilities, String typeFacilities, boolean available) {
		this.idHouse = idHouse;
		this.idFacilities = idFacilities;
		this.typeFacilities = typeFacilities;
		this.available = available;
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

	@Override
	public String toString() {
		return "Facilities [idHouse=" + idHouse + ", idFacilities=" + idFacilities + ", typeFacilities="
				+ typeFacilities + ", available=" + available + "]";
	}
	

	
	
}
