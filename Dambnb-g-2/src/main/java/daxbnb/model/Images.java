package daxbnb.model;

/**
 * Representa una imagen asociada en el sistema, con su identificador y ruta.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Images {

	private int idImage;
	private int imgRoute;

	/**
	 * Crea una nueva imagen con el ID y la ruta especificados.
	 * 
	 * @param idImage  Identificador único de la imagen.
	 * @param imgRoute Ruta o referencia numérica de la imagen.
	 */
	public Images(int idImage, int imgRoute) {
		this.idImage = idImage;
		this.imgRoute = imgRoute;
	}

	/**
	 * Obtiene el ID de la imagen.
	 * 
	 * @return ID único de la imagen.
	 */
	public int getIdImage() {
		return idImage;
	}

	/**
	 * Establece el ID de la imagen.
	 * 
	 * @param idImage Nuevo ID para la imagen.
	 */
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	/**
	 * Devuelve la ruta o referencia numérica de la imagen.
	 * 
	 * @return Ruta numérica de la imagen.
	 */
	public int getImgRoute() {
		return imgRoute;
	}

	/**
	 * Establece la ruta o referencia numérica de la imagen.
	 * 
	 * @param imgRoute Nueva ruta para la imagen.
	 */
	public void setImgRoute(int imgRoute) {
		this.imgRoute = imgRoute;
	}
}