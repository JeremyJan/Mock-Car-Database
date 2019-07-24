package Tables;

public class Address {
	
	/**
	 * The addressID
	 */
	private int addressID;
	
	/**
	 * the street address
	 */
	private String street;
	
	/**
	 * The city 
	 */
	private String city;
	
	/**
	 * The state
	 */
	private String state;
	
	/**
	 * The country
	 */
	private String country;
	
	/**
	 * the zipcode
	 */
	private int zip;

	/**
	 * The constructor
	 * @param addressID
	 * @param street
	 * @param city
	 * @param state
	 * @param country
	 * @param zip
	 */
	public Address(int addressID, String street, String city, String state
			, String country, int zip) {
		this.setAddressID(addressID);
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setCountry(country);
		this.setZip(zip);
	}

	/**
	 * @return the addressID
	 */
	public int getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID the addressID to set
	 */
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

}
