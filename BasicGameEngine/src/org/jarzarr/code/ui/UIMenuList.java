package org.jarzarr.code.ui;

import java.util.HashMap;

public class UIMenuList {
	private static HashMap<String, UIMenu> menus = new HashMap<String, UIMenu>();
	
	/**
	 * Add a UIMenu into a list of menus using a string as a key.
	 * If nameID and/or menu are null error message is printed and
	 * returns false. If nameID already exists in list error message
	 * is printed and returns false.
	 * 
	 * @param nameID - the string that is stored with the UIMenu
	 * as a key
	 * 
	 * @param menu - the UIMenu to store into the list
	 * 
	 * @return true if UIMenu has been successfully stored in list 
	 * and false otherwise
	 */
	public static boolean addMenu(String nameID, UIMenu menu) {
		if (nameID == null || menu == null) {
			System.err.println("Menu must not be null!");
			return false;
		}
		
		if (menus.containsKey(nameID.toLowerCase())) {
			System.err.println("nameID: " + nameID + " has already been used!");
			return false;
		}
		
		nameID = nameID.toLowerCase();
		menus.put(nameID, menu);
		return true;
	}
	
	/**
	 * Removes a UIMenu from the list of UIMenus using nameID
	 * as a key. If nameID is blank or null error
	 * message is printed and returns false.
	 * 
	 * @param nameID - the String used to remove a UIMenu
	 * from the list of UIMenus
	 * 
	 * @return true if UIMenu successfully removed and false
	 * otherwise
	 */
	public static boolean removeMenu(String nameID) {
		if (nameID == null || nameID.equals("")) {
			System.err.println("nameID must not be blank and/or null");
			return false;
		}
		
		nameID = nameID.toLowerCase();
		if (menus.containsKey(nameID))
			menus.remove(nameID);
		else
			return false;
		
		return true;
	}
	
	/**
	 * Retrieves a UIMenu from a list using a String
	 * as a key.
	 * 
	 * @param nameID - the string used to retrieve the
	 * UIMenu from the list
	 * 
	 * @return null if the key is not found inside the list
	 * otherwise returns the UIMenu attached to the key String
	 */
	public static UIMenu getMenu(String nameID) {
		UIMenu returnMenu = null;
		nameID = nameID.toLowerCase();
		if (menus.containsKey(nameID)) {
			returnMenu = menus.get(nameID);
		}
		
		return returnMenu;
	}
	
	/**
	 * Retrieves all the UIMenu values inside list as long
	 * as there are values inside of the list.
	 * 
	 * @return an array of UIMenu values or null if there are
	 * no values inside of list
	 */
	public static UIMenu[] getList() {
		if (menus.size() == 0) {
			System.err.println("There are no values in list!");
			return null;
		}
		
		UIMenu[] listMenus = new UIMenu[menus.size()];
		listMenus = menus.values().toArray(listMenus);
		
		return listMenus;
	}
}
