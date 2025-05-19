package daxbnb.DAO;

public class HousingImagesDAO {
	private static final String SELECT_ALL = "Select Housing.idHouse, Images.idImage from Housing INNER JOIN HousingImages hi ON Housing.idHouse = hi.idHouseINNER JOIN Images ON Images.idImage = hi.idImage order by idHouse asc;";
}
