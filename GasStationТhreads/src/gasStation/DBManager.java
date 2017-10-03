package gasStation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;

import gasStation.Car.FuelType;

public class DBManager {

	private static DBManager instance;

	private static Connection con;

	public static synchronized DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	DBManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {

			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		try {

			String url = "jdbc:mysql://localhost:3306/DBname";
			String username = "theUser";
			String password = "thePassword"; // Change it to your Password
			Properties props = setLoginForDB(username, password);
			con = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The connection failed to be established!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
	}

	/*
	 * “station_loadings” и да съдържа следните колони: - kolonka_id - номера на
	 * колонката за зареждане - fuel_type - тип гориво - бензин, дизел или газ -
	 * fuel_quantity - заредено количество в литри - loading_time - време на
	 * зареждане.
	 */
	public void getAllLoadings() {

		String sql = "SELECT kolonka_id, fuel_type, fuel_quantity, loading_time FROM DBname.station_loadings";
		PreparedStatement statement;
		TreeMap<String, TreeMap<String, ArrayList<Loading>>> loadings = null;
		try {
			statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			loadings = new TreeMap<>();
			while (result.next()) {
				String kolonka = result.getString("kolonka_id");
				Loading l = new Loading(kolonka, result.getString("fuel_type"), result.getInt("fuel_quantity"),
						result.getTimestamp("loading_time").toLocalDateTime());
				if (!loadings.containsKey(kolonka)) {
					loadings.put(kolonka, new TreeMap<>());
					loadings.get(kolonka).put("PETROL", new ArrayList<>());
					loadings.get(kolonka).put("DIESEL", new ArrayList<>());
					loadings.get(kolonka).put("GAS", new ArrayList<>());
				}
				loadings.get(kolonka).get(result.getString("fuel_type")).add(l);
				// System.out.println(l);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		printResult(loadings);
	}

	private void printResult(TreeMap<String, TreeMap<String, ArrayList<Loading>>> loadings) {

		System.out.println("========================================================");
		System.out.println("Printing the table from database(accumulated result from all runs of the program):");
		System.out.println("========================================================");

		for (Entry<String, TreeMap<String, ArrayList<Loading>>> e : loadings.entrySet()) {
			System.out.println(e.getKey());

			for (Entry<String, ArrayList<Loading>> entry : loadings.get(e.getKey()).entrySet()) {
				System.out.print("Total amaount of fuel " + entry.getKey());
				int sum = 0;
				for (Loading l : entry.getValue()) {
					sum += l.getFuelQuantity();
				}

				System.out.println(":   " + sum + " liters.");
			}
			System.out.println("=======================================");
		}

	}

	public void insertIntoDB(FuelType fuel, int amount, int kolonka, LocalDateTime date) {

		try {
			String sql = "INSERT INTO station_loadings (fuel_type, fuel_quantity, kolonka_id, loading_time) VALUES (?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, fuel.toString());
			statement.setInt(2, amount);
			statement.setString(3, "Kolonka " + kolonka);
			statement.setTimestamp(4, Timestamp.valueOf(date));
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Properties setLoginForDB(final String uname, final String passwd) {
		Properties props = new Properties();
		props.setProperty("user", uname);
		props.setProperty("password", passwd);
		return props;
	}
}
