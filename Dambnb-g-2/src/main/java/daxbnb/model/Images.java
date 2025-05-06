package daxbnb.model;

/**
<<<<<<< HEAD
 * Clase que representa una imagen asociada a una vivienda.
 * 
 * @author Alfredo, Jonathan, Diana
 */
public class Images {

=======
 * Representa una imagen asociada a un alojamiento.
 * 
 * @author Alfredo,Jonathan,Diana
 */
public class Images {

	/** ID de la imagen. */
>>>>>>> 89d4511 (JavaDoc 5.02)
	private int idImage;

	/** Ruta de la imagen (identificador o código). */
	private int imgRoute;

	/**
<<<<<<< HEAD
	 * Constructor de Images
	 * 
	 * @param idImage  ID de la imagen
	 * @param imgRoute Ruta de la imagen
=======
	 * Constructor con todos los campos.
	 *
	 * @param idImage  ID de la imagen
	 * @param imgRoute Ruta (o código) de la imagen
>>>>>>> 89d4511 (JavaDoc 5.02)
	 */
	public Images(int idImage, int imgRoute) {
		this.idImage = idImage;
		this.imgRoute = imgRoute;
	}

<<<<<<< HEAD
	/**
	 * @return ID de la imagen
	 */
=======
	/** @return ID de la imagen */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getIdImage() {
		return idImage;
	}

<<<<<<< HEAD
	/**
	 * @param idImage ID de la imagen
	 */
=======
	/** @param idImage Nuevo ID */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

<<<<<<< HEAD
	/**
	 * @return Ruta de la imagen
	 */
=======
	/** @return Ruta o código de la imagen */
>>>>>>> 89d4511 (JavaDoc 5.02)
	public int getImgRoute() {
		return imgRoute;
	}

<<<<<<< HEAD
	/**
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
=======
	/** @param imgRoute Nueva ruta o código */
	public void setImgRoute(int imgRoute) {
		this.imgRoute = imgRoute;
	}
>>>>>>> 89d4511 (JavaDoc 5.02)
}
