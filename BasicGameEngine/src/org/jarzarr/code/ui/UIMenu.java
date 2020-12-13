package org.jarzarr.code.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.jarzarr.code.ui.comp.UIComponent;
import org.jarzarr.code.window.Window;

public abstract class UIMenu {
	
	private Color backgroundColor = Color.white;
	private Image backgroundImage = null;
	
	private List<UIComponent> components = new ArrayList<UIComponent>();
	
	public UIMenu(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	/**
	 * Called once every frame renders the menu and
	 * every UIComponent on screen
	 * 
	 * @param g - the Graphics2D object to draw everything to
	 */
	public void render(Graphics2D g) {
		if (backgroundImage == null) {
			g.setColor(backgroundColor);
			g.fillRect(0, 0, Window.getCanvas().getWidth(), Window.getCanvas().getHeight());
		} else {
			g.drawImage(backgroundImage, 0, 0, Window.getCanvas().getWidth(), Window.getCanvas().getHeight(), null);
		}
		
		for (UIComponent comp : components) 
			comp.display(g);
	}
	
	/**
	 * Called once every frame Updates all the
	 * UIComponents on screen
	 */
	public void update() {
		for (UIComponent comp : components)
			comp.update();
	}
	
	/**
	 * Used to add all the components to your menu
	 */
	public abstract void addAllComp();
	
	public void setBackgroundImage(Image img) {
		this.backgroundImage = img;
	}
	
	public Image getBackgroundImage() {
		return this.backgroundImage;
	}
	
	public void addComponent(UIComponent comp) {
		if (comp == null) {
			System.err.println("Cannot have a null component!");
			return;
		}
		
		components.add(comp);
	}
	
	public List<UIComponent> getComponentList() {
		return this.components;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
