package pristanishte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class DB_Insert {

	private static final String DB_IP = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "port_shipments";
	private static final String DB_USER = "Ivan";
	private static final String DB_PASS = "parola";
	
	private static DB_Insert instance;

	private static Connection con;

	public static synchronized DB_Insert getInstance() {
		if (instance == null) {
			instance = new DB_Insert();
		}
		return instance;
	}

	DB_Insert() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME, DB_USER,
					DB_PASS);

		} catch (SQLException e) {
			System.out.println("Error connecting to Database " + e.getMessage());
		}

	}

	public void importEntry(Entry entry) {
		try {
			if (con == null) {
				getInstance();
			}

			PreparedStatement st = con.prepareStatement("INSERT INTO " + "pristanishte"
					+ " (boat_name, dock_id, crane_id, unloading_time, package_id) values (?, ?, ?, ?, ?)");
			st.setString(1, entry.getKorab().getName());
			st.setInt(2, entry.getDok());
			st.setInt(3, entry.getKran());
			st.setString(4, entry.getTime());
			st.setLong(5, entry.getPratkaNomer());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL exception: " + e.getMessage());
		} finally {

		}
	}

	public static void getCranesInfo() {
		
		TreeMap<Integer, Integer> kranove = new TreeMap<>();
		Integer kran = null;
		try {
			if (con == null) {
				getInstance();
			}
			PreparedStatement st = con.prepareStatement("SELECT crane_id, COUNT(crane_id) FROM pristanishte ORDER BY crain_id;");
			ResultSet res = st.executeQuery();
			for (int i = 0; i < res.getFetchSize(); i++) {
				res.next();
				kran = res.getInt("crane_id");
				if (!kranove.containsKey(kran)) {
					kranove.put(kran, 0);
				}
				kranove.put(kran, kranove.get(kran) + 1);
			}
		} catch (SQLException e) {
			System.out.println("SQL exception: " + e.getMessage());
		} finally {
			/*
			 * try { if (con != null) { con.close(); } } catch (SQLException e)
			 * { // TODO Auto-generated catch block e.printStackTrace(); }
			 */
		}
		
		System.out.println("Boats by dock:");
		kranove.forEach((k, v) -> System.out.println("Kran number: " + k + ": was usesed " + v + " times."));

	}

	public static void getDocsInfo() {
		
		TreeMap<String, Integer> numberOfBoutsByDock = null;
		try {
			if (con == null) {
				getInstance();
			}
			PreparedStatement st = con
					.prepareStatement("SELECT dock_id, COUNT(boat_name) FROM pristanishte ORDER BY dock_id;");
			ResultSet res = st.executeQuery();
		   numberOfBoutsByDock = new TreeMap<>();

			String dock = null;

			for (int i = 0; i < res.getFetchSize(); i++) {
				res.next();
				dock = res.getString("dock_id");
				if (!numberOfBoutsByDock.containsKey(dock)) {
					numberOfBoutsByDock.put(dock, 0);
				}
				numberOfBoutsByDock.put(dock, numberOfBoutsByDock.get(dock) + 1);

			}
		} catch (SQLException e) {
			System.out.println("SQL exception: " + e.getMessage());
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}

		System.out.println("Boats by dock:");
		numberOfBoutsByDock.forEach((k, v) -> System.out.println(k + ": " + v));

	}

	public static void best() {
		TreeMap<String, Integer> numberKorabi = null;

		try {
			if (con == null) {
				getInstance();
			}
			PreparedStatement st = con.prepareStatement(
					"SELECT boat_name, COUNT(boat_name) FROM port_shipments.pristanishte GROUP BY boat_name ORDER BY ID DESC LIMIT 10;");
			ResultSet res = st.executeQuery();
			numberKorabi = new TreeMap<>();
			String boat = null;

			while (res.next()) {
				boat = res.getString("boat_name");
				// Korab korab = new Korab(boat);
				if (!numberKorabi.containsKey(boat)) {
					numberKorabi.put(boat, 1);
				}
				numberKorabi.put(boat, numberKorabi.get(boat) + 0);
			}
		} catch (SQLException e) {
			System.out.println("SQL exception: " + e.getMessage());
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
		System.out.println("Ten most used boats:");
		numberKorabi.forEach((k, v) -> System.out.println(k + ": " + v));

	}
}
