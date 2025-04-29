package daxbnb.model;

/**
 * Clase que representa una imagen asociada a una vivienda.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Images {

	private int idImage;
	private int imgRoute;

	/**
	 * Constructor de Images
	 * 
	 * @param idImage  ID de la imagen
	 * @param imgRoute Ruta de la imagen
	 */
	public Images(int idImage, int imgRoute) {
		this.idImage = idImage;
		this.imgRoute = imgRoute;
	}

	/**
	 * 
	 * @return ID de la imagen
	 */
	public int getIdImage() {
		return idImage;
	}

	/**
	 * 
	 * @param idImage ID de la imagen
	 */
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	/**
	 * 
	 * @return Ruta de la imagen
	 */
	public int getImgRoute() {
		return imgRoute;
	}

	/**
	 * 
	 * @param imgRoute Ruta de la imagen
	 */
	public void setImgRoute(int imgRoute) {
		this.imgRoute = imgRoute;
	}

	/**
	 * @return Representación en texto del objeto Images.
	 */
	@Override
	public String toString() {
		return "Images [idImage=" + idImage + ", imgRoute=" + imgRoute + "]";

	}
}
