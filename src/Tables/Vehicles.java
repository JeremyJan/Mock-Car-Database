package Tables;

public class Vehicles {
	
	/**
	 * Unique vehicle number
	 */
	private String vin;
	
	/**
	 * Make of the vehicle
	 */
	private String make;
	
	/**
	 * model of the vehicle
	 */
	private String model;
	
	/**
	 * color of the vehicle
	 */
	private String color;
	
	/**
	 * Body style of the vehicle
	 */
	private String body;
	
	/**
	 * Drivetrain of the vehicle
	 */
	private String drivetrain;
	
	/**
	 * Engine of the vehicle
	 */
	private String engine;
	
	/**
	 * Fueltype of the vehicle
	 */
	private String fueltype;
	
	/**
	 * Category of the vehicle
	 */
	private String category;
	
	/**
	 * Transmission of the vehicle
	 */
	private String transmission;
	
	/**
	 * Trim of the vehicle
	 */
	private String trim;
	
	/**
	 * The miles of the vehicle
	 */
	private int miles;
	
	/**
	 * The condition of the car
	 */
	private String condition;
	
	/**
	 * The dealership
	 */
	private String dealership;
	
	/**
	 * The price
	 */
	private double price;

	
	public Vehicles(String vin2, String make2, String model2, 
			String color2, String body2, String drive, String engine2,
			String fuel, String cat, String tran, String trim2, 
			int miles2, String cond, String dealer, double price2) {
		setVin(vin2);
		setMake(make2);
		setModel(model2);
		setColor(color2);
		setBody(body2);
		setDrivetrain(drive);
		setEngine(engine2);
		setFueltype(fuel);
		setCategory(cat);
		setTransmission(tran);
		setTrim(trim2);
		setMiles(miles2);
		setCondition(cond);
		setDealership(dealer);
		setPrice(price2);
	}

	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the drivetrain
	 */
	public String getDrivetrain() {
		return drivetrain;
	}

	/**
	 * @param drivetrain the drivetrain to set
	 */
	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}

	/**
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * @return the fueltype
	 */
	public String getFueltype() {
		return fueltype;
	}

	/**
	 * @param fueltype the fueltype to set
	 */
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the transmission
	 */
	public String getTransmission() {
		return transmission;
	}

	/**
	 * @param transmission the transmission to set
	 */
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	/**
	 * @return the trim
	 */
	public String getTrim() {
		return trim;
	}

	/**
	 * @param trim the trim to set
	 */
	public void setTrim(String trim) {
		this.trim = trim;
	}

	/**
	 * @return the miles
	 */
	public int getMiles() {
		return miles;
	}

	/**
	 * @param miles the miles to set
	 */
	public void setMiles(int miles) {
		this.miles = miles;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the dealership
	 */
	public String getDealership() {
		return dealership;
	}

	/**
	 * @param dealership the dealership to set
	 */
	public void setDealership(String dealership) {
		this.dealership = dealership;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
