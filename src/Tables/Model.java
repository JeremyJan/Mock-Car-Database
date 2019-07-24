package Tables;

public class Model {
	
	/**
	 * The model id
	 */
	private int modelID;
	
	/**
	 * The model name
	 */
	private String modelName;
	
	/**
	 * the make name
	 */
	private int makeName;

	/**
	 * Constructor
	 * @param id
	 * @param model
	 * @param make
	 */
	public Model(int id, String model, int make) {
		this.setModelID(id);
		this.setModelName(model);
		this.setMakeID(make);
	}

	/**
	 * @return the modelID
	 */
	public int getModelID() {
		return modelID;
	}

	/**
	 * @param modelID the modelID to set
	 */
	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	/**
	 * @return the makeName
	 */
	public int getMakeID() {
		return makeName;
	}

	/**
	 * @param makeName the makeName to set
	 */
	public void setMakeID(int makeName) {
		this.makeName = makeName;
	}

	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	
}
