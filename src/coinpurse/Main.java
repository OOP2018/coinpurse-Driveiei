package coinpurse;

import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Kornphon Noiprasert
 */
public class Main {

	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		init();
		// 1. create a Purse
		Purse purse = new Purse(10);
		// 2. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog ui = new ConsoleDialog(purse);
		// 3. run the ConsoleDialog
		ui.run();
	}

	/**
	 * This method gets instance from a file(purse) class and keeps into factory.
	 */
	public static void init() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			// the object could not be cast to type MoneyFactory
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			// any other exception means we could not create an object
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		// if no factory then quit
		if (factory == null)
			System.exit(1);
		MoneyFactory.setFactory(factory);
	}
}
