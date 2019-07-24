package Tables;

public class Make {
	
	/**
	 * The unique id of the make
	 */
	private int makeID;
	
	/**
	 * the make name
	 */
	private String makeName;
	
	/**
	 * the country of origin of the make
	 */
	private String makeCountry;

	public Make(int id, String name, String country) {
		this.setMakeID(id);
		this.setMakeName(name);
		this.setMakeCountry(country);
	}

	/**
	 * @return the makeID
	 */
	public int getMakeID() {
		return makeID;
	}
	
	@Override
	public String toString() {
		return "Make [id = " + makeID + " makename = " + makeName 
				+ " make country = " + makeCountry +"]";
	}

	/**
	 * @param makeID the makeID to set
	 */
	public void setMakeID(int makeID) {
		this.makeID = makeID;
	}

	/**
	 * @return the makeName
	 */
	public String getMakeName() {
		return makeName;
	}

	/**
	 * @param makeName the makeName to set
	 */
	public void setMakeName(String makeName) {
		if(makeName == null) 
			throw new IllegalArgumentException("Please supply a valid make name");
		this.makeName = makeName;
	}

	/**
	 * @return the makeCountry
	 */
	public String getMakeCountry() {
		return makeCountry;
	}

	/**
	 * @param makeCountry the makeCountry to set
	 */
	public void setMakeCountry(String makeCountry) {
		if (makeCountry == null)
			throw new IllegalArgumentException("Please supply a valid country");
		this.makeCountry = makeCountry;
	}

}
