import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Tables.Address;
import Tables.Make;
import Tables.Model;
import Tables.Order;
import Tables.Vehicles;

public class DBGui extends JFrame implements ActionListener {

	
	/**
	 * the generated serial ID
	 */
	private static final long serialVersionUID = 406171104463901102L;
	
	/**
	 * The strings for make model and city
	 */
	private String makeString, modelString, cityString;
	
	/**
	 * The ints for the selected price range
	 */
	private int selectPriceStart, selectPriceEnd;
	
	
	/**
	 * the columns of the vehicle table
	 */
	private String[] vehicleTable = { "Vin",
			"Make", "Model", "Color", "Bodystyle",
			"Drivetrain", "Engine", "Fueltype", 
			"Vehicle Category", "Transmission", "Trim",
			"Miles", "Condition", "Dealership", "Price"
	};
	
	/**
	 * the columns of the orders
	 */
	private String[] oCol = {
			"Vin", "Customer First Name", "Customer Last Name",
			"SalesRep Firstname", "Salerep Lastname", "Date",
			"Out the door price"
	};
	
	/**
	 * the data of the vehicles and orders
	 */
	private Object[][]data, oData;
	
	/**
	 * the tables that display the two datasets
	 */
	private JTable vTable, oTable;
	
	/**
	 * the button to execute the query
	 */
	private JButton btnQuery;
	
	/**
	 * The two panels
	 */
	private JPanel pnlVehicle, pnlOrder;
	
	/**
	 * the db
	 */
	private DBUtil db;
	
	/**
	 * the comboboxes
	 */
	private JComboBox makeComboBox, modelComboBox, cityComboBox;
	
	/**
	 * the tabbed pane
	 */
	private JTabbedPane tabbedPane;
	
	/**
	 * the scrollpanes
	 */
	private JScrollPane sp, oSP;
	
	/**
	 * the price text fields
	 */
	private JTextField priceStart, priceEnd;
	
	/**
	 * the make list
	 */
	private List<Make> makeList;
	
	/**
	 * the vehicle list
	 */
	private List<Vehicles>vehiclesList;
	
	/**
	 * the model list
	 */
	private List<Model> modelList;
	
	/**
	 * the address list
	 */
	private List<Address> addressList;
	
	/**
	 * the order 
	 */
	private List<Order> orderList;

	/**
	 * The constructor of the gui which shows genrates
	 * the default table
	 */
	public DBGui() {
		super("Dealership Database");
		db = new DBUtil();
		try {
			makeList = db.getMakes();
			vehiclesList = db.getVehicles();
			modelList = db.getModels();
			addressList = db.getAddresses();
			orderList = db.getOrders();
			data = new Object[vehiclesList.size()][vehicleTable.length];
			for (int i = 0; i < vehiclesList.size(); i++) {
				data[i][0] = vehiclesList.get(i).getVin();
				data[i][1] = vehiclesList.get(i).getMake();
				data[i][2] = vehiclesList.get(i).getModel();
				data[i][3] = vehiclesList.get(i).getColor();
				data[i][4] = vehiclesList.get(i).getBody();
				data[i][5] = vehiclesList.get(i).getDrivetrain();
				data[i][6] = vehiclesList.get(i).getEngine();
				data[i][7] = vehiclesList.get(i).getFueltype();
				data[i][8] = vehiclesList.get(i).getCategory();
				data[i][9] = vehiclesList.get(i).getTransmission();
				data[i][10] = vehiclesList.get(i).getTrim();
				data[i][11] = vehiclesList.get(i).getMiles();
				data[i][12] = vehiclesList.get(i).getCondition();
				data[i][13] = vehiclesList.get(i).getDealership();
				data[i][14] = vehiclesList.get(i).getPrice();
			}
			oData = new Object[orderList.size()][oCol.length];
			for (int i = 0; i < orderList.size(); i++) {
				oData[i][0] = orderList.get(i).getVin();
				oData[i][1] = orderList.get(i).getFirstCusName();
				oData[i][2] = orderList.get(i).getLastCusName();
				oData[i][3] = orderList.get(i).getFirstRepName();
				oData[i][4] = orderList.get(i).getLastRepName();
				oData[i][5] = orderList.get(i).getDate();
				oData[i][6] = orderList.get(i).getPrice();
				System.out.println(data[i][0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		createComponents();
		this.setSize(1350, 750);
		this.setVisible(true);
	}
	
	
	/**
	 * Helper method which creates all of the components
	 */
	private void createComponents() {
		tabbedPane = new JTabbedPane();
		//Make Panel
		pnlVehicle = new JPanel();
		tabbedPane.setPreferredSize(new Dimension(1300, 600));
		
		//Make
		JPanel makeBox = new JPanel(new FlowLayout());
		makeComboBox = new JComboBox(retriveMakeNames());
		makeComboBox.setSelectedIndex(-1);
		JLabel makeLabel = new JLabel("Make :");
		makeBox.add(makeLabel);
		makeBox.add(makeComboBox);
		
		//model
		JLabel modelLabel = new JLabel("Model: ");
		modelComboBox = new JComboBox(retriveModelNames());
		modelComboBox.setSelectedIndex(-1);
		makeBox.add(modelLabel);
		makeBox.add(modelComboBox);
		
		//address
		JLabel cityLabel = new JLabel("City: ");
		cityComboBox = new JComboBox(retriveCity());
		cityComboBox.setSelectedIndex(-1);
		makeBox.add(cityLabel);
		makeBox.add(cityComboBox);
		
		//price
		JLabel priceStartLabel = new JLabel("Price from(please press enter on both text fields to complete) : ");
		priceStart = new JTextField(10);
		JLabel priceEndLabel = new JLabel("to");
		priceEnd = new JTextField(10);
		makeBox.add(priceStartLabel);
		makeBox.add(priceStart);
		makeBox.add(priceEndLabel);
		makeBox.add(priceEnd);
		
		//Query button
		btnQuery = new JButton("Query");
		makeBox.add(btnQuery);
		
		btnQuery.addActionListener(this);
		modelComboBox.addActionListener(this);
		makeComboBox.addActionListener(this);
		cityComboBox.addActionListener(this);
		priceStart.addActionListener(this);
		priceEnd.addActionListener(this);
		pnlVehicle.add(makeBox);
		
		
		
		vTable = new JTable(data, vehicleTable);
		vTable.setPreferredSize(new Dimension(1200, 600));
		
		sp = new JScrollPane(vTable);
		sp.setPreferredSize(new Dimension(1250, 600));
		
		pnlVehicle.add(sp);
		
		tabbedPane.add("Look for car", pnlVehicle);
		
		//Order pane
		
		pnlOrder = new JPanel();
		oTable = new JTable(oData, oCol);
		oTable.setPreferredSize(new Dimension(1200, 600));
		oSP = new JScrollPane(oTable);
		oSP.setPreferredSize(new Dimension(1250, 600));
		pnlOrder.add(oSP);
		tabbedPane.add("Orders",pnlOrder);
		
		
		add(tabbedPane);
		
	}
	
	/**
	 * Helper method which retrives the make names
	 * for the makeComboBox
	 * @return The string array of names
	 */
	private String[] retriveMakeNames() {
		String[] makeStrings = new String[makeList.size()];
		for (int i = 0; i < makeList.size(); i++) {
			makeStrings[i] = makeList.get(i).getMakeName();
		}
		Arrays.sort(makeStrings);
		return makeStrings;
	}
	
	/**
	 * Helper method which retrives the model names
	 * for the modelComboBox
	 * @return the string array of models
	 */
	private String[] retriveModelNames() {
		String[] modelStrings = new String[modelList.size()];
		for (int i = 0; i < modelList.size(); i++) {
			modelStrings[i] = modelList.get(i).getModelName();
		}
		Arrays.sort(modelStrings);
		return modelStrings;
	}
	
	/**
	 * Helper method which retrives the 
	 * cities for the cityComboBox
	 * @return
	 */
	private String[] retriveCity() {
		String[] addyStrings = new String[addressList.size()];
		for (int i = 0; i < addressList.size(); i++) {
			addyStrings[i] = addressList.get(i).getCity();
		}
		Arrays.sort(addyStrings);
		return addyStrings;
	}


	/**
	 * The action perfomed method which
	 * listens for if an action is created
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == makeComboBox) {
			JComboBox cb = (JComboBox)e.getSource();
			makeString = (String)cb.getSelectedItem();
			
		} else if (e.getSource() == modelComboBox) {
			JComboBox cb = (JComboBox)e.getSource();
			modelString = (String)cb.getSelectedItem();
		} else if (e.getSource() == cityComboBox) { 
			JComboBox cb = (JComboBox)e.getSource();
			cityString = (String)cb.getSelectedItem();
			
		} else if (e.getSource() == priceStart) {
			System.out.println("Getting priceStart");
			JTextField jt = (JTextField)e.getSource();
			selectPriceStart = Integer.parseInt(jt.getText());
		} else if (e.getSource() == priceEnd) {
			JTextField jt = (JTextField)e.getSource();
			selectPriceEnd = Integer.parseInt(jt.getText());
			System.out.println("In gui: price end = " + selectPriceEnd);
		} else  if (e.getSource() == btnQuery) {
			try {
				vehiclesList = db.getSpecificMakeVehicles(makeString, modelString, cityString, 
						selectPriceStart, selectPriceEnd);
			} catch (Exception exec) {
				JOptionPane.showMessageDialog(this, exec.getMessage());
			}
			
			if (vehiclesList.size() == 0) {
				JOptionPane.showMessageDialog(this, "There is none in stock or this car does not exist");
			}
			data = new Object[vehiclesList.size()][vehicleTable.length];
			for (int i = 0; i < vehiclesList.size(); i++) {
				data[i][0] = vehiclesList.get(i).getVin();
				data[i][1] = vehiclesList.get(i).getMake();
				data[i][2] = vehiclesList.get(i).getModel();
				data[i][3] = vehiclesList.get(i).getColor();
				data[i][4] = vehiclesList.get(i).getBody();
				data[i][5] = vehiclesList.get(i).getDrivetrain();
				data[i][6] = vehiclesList.get(i).getEngine();
				data[i][7] = vehiclesList.get(i).getFueltype();
				data[i][8] = vehiclesList.get(i).getCategory();
				data[i][9] = vehiclesList.get(i).getTransmission();
				data[i][10] = vehiclesList.get(i).getTrim();
				data[i][11] = vehiclesList.get(i).getMiles();
				data[i][12] = vehiclesList.get(i).getCondition();
				data[i][13] = vehiclesList.get(i).getDealership();
				data[i][14] = vehiclesList.get(i).getPrice();
			}
			pnlVehicle.removeAll();
			vTable = new JTable(data, vehicleTable);
			JPanel makeBox = new JPanel(new FlowLayout());
			//make
			makeComboBox = new JComboBox(retriveMakeNames());
			JLabel makeLabel = new JLabel("Make :");
			makeBox.add(makeLabel);
			makeBox.add(makeComboBox);
			makeComboBox.setSelectedIndex(-1);
			makeComboBox.addActionListener(this);
			pnlVehicle.add(makeBox);
			//model
			JLabel modelLabel = new JLabel("Model: ");
			modelComboBox = new JComboBox(retriveModelNames());
			modelComboBox.setSelectedIndex(-1);
			modelComboBox.addActionListener(this);
			makeBox.add(modelLabel);
			makeBox.add(modelComboBox);
			//address
			JLabel cityLabel = new JLabel("City: ");
			cityComboBox = new JComboBox(retriveCity());
			cityComboBox.setSelectedIndex(-1);
			cityComboBox.addActionListener(this);
			makeBox.add(cityLabel);
			makeBox.add(cityComboBox);
			//price
			JLabel priceStartLabel = new JLabel("Price from (please press enter on both text fields to complete) :: ");
			priceStart = new JTextField(10);
			JLabel priceEndLabel = new JLabel("to");
			priceEnd = new JTextField(10);
			makeBox.add(priceStartLabel);
			makeBox.add(priceStart);
			makeBox.add(priceEndLabel);
			makeBox.add(priceEnd);
			priceStart.addActionListener(this);
			priceEnd.addActionListener(this);
			
			//null or zero things out
			modelString = null;
			makeString = null;
			cityString = null;
			selectPriceStart = 0;
			selectPriceEnd = 0;
			
			//Query button
			btnQuery = new JButton("Query");
			btnQuery.addActionListener(this);
			makeBox.add(btnQuery);
			
			vTable.setPreferredSize(new Dimension(1200, 600));
			
			sp = new JScrollPane(vTable);
			sp.setPreferredSize(new Dimension(1250, 600));
			pnlVehicle.add(sp);
			pnlVehicle.revalidate();
			this.repaint();
		} 
		
	}
	
	public static void main(String[] args) {
		DBGui gui = new DBGui();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
