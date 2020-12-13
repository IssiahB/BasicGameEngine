package org.jarzarr.code.ui.comp;

import org.jarzarr.code.ui.UIMenu;
import org.jarzarr.code.ui.UIMenuList;

public class DisplayedMenu {
	private static UIMenu currentlyDisplayedMenu = null;
	
	/**
	 * Gets the UIMenu that is being updated and rendered
	 * 
	 * @return the currentlyDisplayedMenu
	 */
	public static UIMenu getCurrentlyDisplayedMenu() {
		return currentlyDisplayedMenu;
	}
	
	/**
	 * Sets the currentlyDisplayedMenu. If null then no menu
	 * will be updated or rendered.
	 * 
	 * @param menu - The menu to set as currentlyDisplayed
	 */
	public static void setCurrentlyDisplayedMenu(UIMenu menu) {
		currentlyDisplayedMenu = menu;
	}
	
	/**
	 * Retrieves a UIMenu from <code>UIMenuList</code> using a String
	 * as a key. If no key exists with the specified nameID an error
	 * message will display and currentlyDisplayedMenu will not be set.
	 * 
	 * @param nameID - The key that is used to find a UIMenu from a list
	 * of UIMenus in the class <code>UIMenuList</code>.
	 */
	public static void setCurrentlyDisplayedMenu(String nameID) {
		UIMenu listMenu = null;
		if ((listMenu = UIMenuList.getMenu(nameID)) != null)
			setCurrentlyDisplayedMenu(listMenu);
		else
			System.err.println("nameID: " + nameID + " does not exist in UIMenuList!");
	}
}
