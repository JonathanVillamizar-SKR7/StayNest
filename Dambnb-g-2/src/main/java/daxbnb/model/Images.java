package daxbnb.model;

public class Images {
	
	private int idImage;
	private int imgRoute;
	
	public Images(int idImage, int imgRoute) {
		this.idImage = idImage;
		this.imgRoute = imgRoute;
	}
	
	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public int getImgRoute() {
		return imgRoute;
	}

	public void setImgRoute(int imgRoute) {
		this.imgRoute = imgRoute;
	}
	
	
}
