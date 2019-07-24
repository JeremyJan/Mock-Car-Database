package Tables;

public class Order {
	
	/**
	 * The unique vin number of the vehicle
	 */
	private String vin;
	
	/**
	 * Customers first name
	 */
	private String firstCusName;
	
	/**
	 * Customers last name
	 */
	private String lastCusName;
	
	/**
	 * Sales Reps first name
	 */
	private String firstRepName;
	
	/**
	 * Sales reps last name
	 */
	private String lastRepName;
	
	/**
	 * The date of the order
	 */
	private String date;
	
	/**
	 * The price of the vehicle
	 */
	private double price;

	/**
	 * The constructor
	 * @param vin
	 * @param firstCusName
	 * @param lastCusName
	 * @param firstRepName
	 * @param lastRepName
	 * @param date
	 * @param price
	 */
	public Order(String vin, String firstCusName, String lastCusName
			, String firstRepName, String lastRepName, String date, double price) {
		this.setVin(vin);
		this.setFirstCusName(firstCusName);
		this.setLastCusName(lastCusName);
		this.setFirstRepName(firstRepName);
		this.setLastRepName(lastRepName);
		this.setDate(date);
		this.setPrice(price);
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
	 * @return the firstCusName
	 */
	public String getFirstCusName() {
		return firstCusName;
	}

	/**
	 * @param firstCusName the firstCusName to set
	 */
	public void setFirstCusName(String firstCusName) {
		this.firstCusName = firstCusName;
	}

	/**
	 * @return the lastCusName
	 */
	public String getLastCusName() {
		return lastCusName;
	}

	/**
	 * @param lastCusName the lastCusName to set
	 */
	public void setLastCusName(String lastCusName) {
		this.lastCusName = lastCusName;
	}

	/**
	 * @return the firstRepName
	 */
	public String getFirstRepName() {
		return firstRepName;
	}

	/**
	 * @param firstRepName the firstRepName to set
	 */
	public void setFirstRepName(String firstRepName) {
		this.firstRepName = firstRepName;
	}

	/**
	 * @return the lastRepName
	 */
	public String getLastRepName() {
		return lastRepName;
	}

	/**
	 * @param lastRepName the lastRepName to set
	 */
	public void setLastRepName(String lastRepName) {
		this.lastRepName = lastRepName;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
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
