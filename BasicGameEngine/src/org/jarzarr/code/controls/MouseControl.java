package org.jarzarr.code.controls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MouseControl implements MouseListener {
	private static List <MouseInterface> interfaces = new ArrayList<MouseInterface>();
	
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
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		if (interfaces.size() < 1)
			return;
		
		interfaces.parallelStream().forEach(inter -> {
			inter.mousePressed(e);
		});
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (interfaces.size() < 1)
			return;
		
		interfaces.parallelStream().forEach(inter -> {
			inter.mouseReleased(e);
		});
	}
}
