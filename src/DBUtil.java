

import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Tables.Address;
import Tables.Make;
import Tables.Model;
import Tables.Order;
import Tables.Vehicles;

public class DBUtil {
	
	/**
	 * username field which stores the username
	 * you will need to change this this for yourself
	 */
	private static String username = "root";
	
	/**
	 * password field which stores the password
	 * you will need to change this for yourself
	 */
	private static String password = "King_Saber1";
	
	/**
	 * servername field which is the path in which
	 * the database is stored
	 * you might need
	 */
	private static String serverName = "jdbc:mysql://localhost:3306/manandic_jeremy_db";
	
	/**
	 * The connection to the server;
	 */
	private static Connection myConnection;
	
	/**
	 * List of makes
	 */
	private List<Make> makeList;
	
	/**
	 * List of vehicles
	 */
	private List<Vehicles> vehiclesList;
	
	/**
	 * List of vehicles
	 */
	private List<Model> modelList;
	
	/**
	 * list of addresses
	 */
	private List<Address> addressList;
	
	/**
	 * List of orders
	 */
	private List<Order> orderList;
	
	public static void main(String[] args) {
		try {
			DBUtil driver = new DBUtil();
			List<Order> test = driver.getOrders();
			for (int i = 0; i < driver.orderList.size(); i++) {
				System.out.println("Loop = " + i);
				System.out.println(test.get(i).getVin());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * This method creates the connection to the MYSQL
	 * database
	 * @throws SQLException
	 */
	private static void createConnection() throws SQLException {
		//get a connection
		myConnection = DriverManager
				.getConnection(serverName, username, password);
		System.out.println("Connection made...");
	}
	
	/**
	 * This method retrives the addresses from
	 * the database
	 * @return the list of addresses from the database
	 * @throws Exception
	 */
	public List<Address> getAddresses() throws Exception {
		if (myConnection == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select * from AddressOF";
		
		addressList = new ArrayList<Address>();
		try {
			stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt("addressID");
				String address = resultSet.getString("streetAddress");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String country = resultSet.getString("country");
				int zip = resultSet.getInt("zipcode");
				Address addy = new Address(id, address, city, state, country, zip);
				addressList.add(addy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to retrive the makes" + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		System.out.println("done getting address...");
		return addressList;
	}
	
	/**
	 * getOrders method which retrives the orders
	 * from the database
	 * @return returnes the list of orders
	 * @throws Exception
	 */
	public List<Order> getOrders() throws Exception {
		if (myConnection == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "Select OrderDetails.vin, Customer.firstName, Customer.lastName, \n" + 
				"	SalesRep.firstName, SalesRep.lastName, OrderDetails.orderDate,\n" + 
				"    OrderDetails.otdPrice from OrderDetails\n" + 
				"    join SalesRep on OrderDetails.salesRepID = SalesRep.salesRepID\n" + 
				"    join Customer on Customer.customerID = OrderDetails.customerID;";
		System.out.println(query);
		orderList = new ArrayList<Order>();
		try {
			stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				String vin = resultSet.getString(1);
				String firstCus = resultSet.getString(2);
				String lastCus = resultSet.getString(3);
				String firstRep = resultSet.getString(4);
				String lastRep = resultSet.getString(5);
				String date = resultSet.getString(6);
				double price = resultSet.getDouble(7);
				Order order = new Order(vin, firstCus, lastCus, 
						firstRep, lastRep, date, price);
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to retrive the makes" + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		System.out.println("done getting orders...");
		return orderList;
	}
	
	/**
	 * getMakes method which retrives the makes
	 * from the database
	 * @return
	 * @throws Exception
	 */
	public List<Make> getMakes() throws Exception {
		if (myConnection == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select * from Make";
		
		makeList = new ArrayList<Make>();
		try {
			stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				String makeString = resultSet.getString("name");
				String makeCountry = resultSet.getString("country");
				int makeID = resultSet.getInt("makeID");
				Make make = new Make(makeID, makeString, makeCountry);
				makeList.add(make);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to retrive the makes" + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		System.out.println("done getting makes...");
		return makeList;
	}
	
	/**
	 * getModels method which retrives the model
	 * from the database
	 * @return a list of the models
	 * @throws Exception
	 */
	public List<Model> getModels() throws Exception {
		if (myConnection == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select * from Model";
		
		modelList = new ArrayList<Model>();
		try {
			stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				String modelString = resultSet.getString("name");
				int makeID = resultSet.getInt("makeID");
				int modelID = resultSet.getInt("modelID");
				Model model = new Model(modelID, modelString, makeID);
				modelList.add(model);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to retrive the makes" + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		System.out.println("done getting model...");
		return modelList;
	}
	
	/**
	 * Method to get vehicles from the database
	 * @return returns the list 
	 * @throws Exception
	 */
	public List<Vehicles> getVehicles() throws Exception {
		if (myConnection == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select Vehicle.vin, Make.name, Model.name ,Color.name, \n" + 
				"	Bodystyle.name, Drivetrain.name, Engine.name,\n" + 
				"    FuelType.name, Category.name, Transmission.name,\n" + 
				"    Trims.name, Vehicle.miles, Vehicle.conditionCar,\n" + 
				"    Dealership.name, Vehicle.price\n" + 
				"	from Vehicle\n" + 
				"	join Make on Vehicle.makeID = Make.makeID\n" + 
				"    join Model on Vehicle.modelID = Model.modelID\n" + 
				"    join Color on Vehicle.colorID = Color.colorID\n" + 
				"    join Bodystyle on Bodystyle.bodystyleID = Vehicle.bodyStyleID\n" + 
				"    join Drivetrain on Drivetrain.drivetrainID = Vehicle.drivetrainID\n" + 
				"    join Engine on Engine.engineID = Vehicle.engineID\n" + 
				"    join Category on Category.categoryID = Vehicle.categoryID\n" + 
				"    join Trims on Trims.trimID = Vehicle.trimID\n" + 
				"    join Transmission on Transmission.transmissionID = Vehicle.transmissionID\n" + 
				"    join Dealership on Vehicle.dealershipID = Dealership.dealershipID\n" + 
				"    join FuelType on Vehicle.fueltypeID = FuelType.fueltypeID;";
		
		vehiclesList = new ArrayList<Vehicles>();
		
		try {
			stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				String vin = resultSet.getString(1);
				String make = resultSet.getString(2);
				String model = resultSet.getString(3);
				String color = resultSet.getString(4);
				String body = resultSet.getString(5);
				String drive = resultSet.getString(6);
				String engine = resultSet.getString(7);
				String fuel = resultSet.getString(8);
				String cat = resultSet.getString(9);
				String tran = resultSet.getString(10);
				String trim = resultSet.getString(11);
				int miles = resultSet.getInt(12);
				String cond = resultSet.getString(13);
				String dealer = resultSet.getString(14);
				double price = resultSet.getDouble(15);
				Vehicles v = new Vehicles(vin, make, model, 
						color, body, drive, engine, fuel, 
						cat, tran, trim, miles, cond, dealer, price);
				vehiclesList.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to retrive the makes" + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		System.out.println("done getting vehicles...");
		return vehiclesList;
	}
	
	/**
	 * method to get the vehicles according to the parameters.
	 * @param selectMake the selected make
	 * @param selectModel the selected model
	 * @param selectAddress the selected address
	 * @param selectPriceStart the selected price start
	 * @param selectPriceEnd the selected price end
	 * @return return the list of vehicles
	 * @throws Exception
	 */
	public List<Vehicles> getSpecificMakeVehicles(String selectMake, String selectModel, String selectAddress, 
			int selectPriceStart, int selectPriceEnd) throws Exception{
		String goMake;
		String goModel;
		String goAddress;
		String goPrice;
		
		if (myConnection == null) {
			createConnection();
		}
		if (selectMake == null) {
			goMake = "IS NOT NULL";
		} else {
			goMake = "= \"" + selectMake + "\"";
		}
		
		if (selectModel == null) {
			goModel = "IS NOT NULL";
		} else {
			goModel = "= \"" + selectModel + "\"";
		}
		
		if (selectAddress == null) {
			goAddress = "IS NOT NULL";
		} else {
			goAddress = "= \"" + selectAddress + "\"";
		}
		
		if (selectPriceStart == 0 && selectPriceEnd == 0) {
			goPrice = " AND Price Between " + 1 + " and " + 99999999;

		} else {
			if (selectPriceStart == 0 && selectPriceEnd > 0) {
				goPrice = " AND Price Between " + 1 + " and " + selectPriceEnd;
			} else if (selectPriceEnd == 0 && selectPriceStart > 0) {
				goPrice = " AND Price Between " + selectPriceStart + " and " + 999999999;

			} else {
				goPrice = " AND Price Between " + selectPriceStart + " and " + selectPriceEnd;

			}
		}
		Statement stmt = null;
		String query = "select Vehicle.vin, Make.name, Model.name ,Color.name, \n" + 
				"	Bodystyle.name, Drivetrain.name, Engine.name,\n" + 
				"    FuelType.name, Category.name, Transmission.name,\n" + 
				"    Trims.name, Vehicle.miles, Vehicle.conditionCar,\n" + 
				"    Dealership.name, Vehicle.price\n" + 
				"	from Vehicle\n" + 
				"	join Make on Vehicle.makeID = Make.makeID\n" + 
				"    join Model on Vehicle.modelID = Model.modelID\n" + 
				"    join Color on Vehicle.colorID = Color.colorID\n" + 
				"    join Bodystyle on Bodystyle.bodystyleID = Vehicle.bodyStyleID\n" + 
				"    join Drivetrain on Drivetrain.drivetrainID = Vehicle.drivetrainID\n" + 
				"    join Engine on Engine.engineID = Vehicle.engineID\n" + 
				"    join Category on Category.categoryID = Vehicle.categoryID\n" + 
				"    join Trims on Trims.trimID = Vehicle.trimID\n" + 
				"    join Transmission on Transmission.transmissionID = Vehicle.transmissionID\n" + 
				"    join Dealership on Vehicle.dealershipID = Dealership.dealershipID\n" + 
				"    join FuelType on Vehicle.fueltypeID = FuelType.fueltypeID " +
				"	 join AddressOF on Dealership.addressID = AddressOF.addressID " +
				"	 where Make.name " + goMake + " and Model.name " + goModel + " and AddressOF.city " + 
				goAddress + goPrice + ";";
		
		System.out.println(query);
		
		vehiclesList = new ArrayList<Vehicles>();
		
		try {
			stmt = myConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
				String vin = resultSet.getString(1);
				String make = resultSet.getString(2);
				String model = resultSet.getString(3);
				String color = resultSet.getString(4);
				String body = resultSet.getString(5);
				String drive = resultSet.getString(6);
				String engine = resultSet.getString(7);
				String fuel = resultSet.getString(8);
				String cat = resultSet.getString(9);
				String tran = resultSet.getString(10);
				String trim = resultSet.getString(11);
				int miles = resultSet.getInt(12);
				String cond = resultSet.getString(13);
				String dealer = resultSet.getString(14);
				double price = resultSet.getDouble(15);
				Vehicles v = new Vehicles(vin, make, model, 
						color, body, drive, engine, fuel, 
						cat, tran, trim, miles, cond, dealer, price);
				vehiclesList.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to retrive the makes" + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		System.out.println("done getting vehicles...");
		return vehiclesList;
	}

}
