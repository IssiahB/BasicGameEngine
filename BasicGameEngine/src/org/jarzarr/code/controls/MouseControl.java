package org.jarzarr.code.controls;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseControl implements MouseListener {
	
	private static int mouseOldX = 0, mouseOldY = 0;
	private static Point mouseLeftClickPosition = new Point(0, 0);
	private static boolean mouseChangedPosition = false;
	
	public static void updateMouse() {
		mouseChangedPosition = false;
		
		if (mouseOldX != mouseLeftClickPosition.x) {
			mouseChangedPosition = true;
			mouseOldX = mouseLeftClickPosition.x;
		}
		if (mouseOldY != mouseLeftClickPosition.y) {
			mouseChangedPosition = true;
			mouseOldY = mouseLeftClickPosition.y;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			mouseLeftClickPosition.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
				
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	/**
	 * @return The last position on screen the left mouse button
	 * was clicked as a Point object
	 */
	public static Point getMouseLeftClickPosition() {
		return mouseLeftClickPosition;
	}
	
	/**
	 * @return true if mouse clicked position has changed from last clicked position
	 * false otherwise
	 */
	public static boolean hasMouseChangedPosition() {
		return mouseChangedPosition;
	}

}
