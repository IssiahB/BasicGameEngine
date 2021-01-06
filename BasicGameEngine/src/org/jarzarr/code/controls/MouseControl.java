package org.jarzarr.code.controls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MouseControl implements MouseListener {
	
	private static List <MouseInterface> interfaces = new ArrayList<MouseInterface>();
	private int mouseX = 0, mouseY = 0;
	private int mouseType = 1;
	
	private void updateInterfaces() {
		interfaces.parallelStream().forEach(inter -> {
			if (mouseType == 1)
				inter.lmPressed(mouseX, mouseY);
			if (mouseType == 2)
				inter.mmPressed(mouseX, mouseY);
			if (mouseType == 3)
				inter.rmPressed(mouseX, mouseY);
		});
	}
	
	public static void addMouse(MouseInterface mouse) {
		if (mouse == null)
			return;
		
		interfaces.add(mouse);
	}
	
	public static void removeMouse(MouseInterface mouse) {
		if (mouse == null)
			return;
		
		interfaces.remove(mouse);
	}
	
	public static boolean containsMouse(MouseInterface mouse) {
		if (mouse == null)
			return false;
		
		return (interfaces.contains(mouse));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (interfaces.size() < 1)
			return;
		
		mouseX = e.getX();
		mouseY = e.getY();
		mouseType = e.getButton();
		updateInterfaces();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
