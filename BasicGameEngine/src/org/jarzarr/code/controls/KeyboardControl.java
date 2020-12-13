package org.jarzarr.code.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControl implements KeyListener {
	
	private static boolean[] keys = new boolean[120];
	public static boolean wKey = false, aKey = false, sKey = false, dKey = false;
	public static boolean shiftKey = false, spaceKey = false;
	
	public static void updateKeys() {
		wKey = keys[KeyEvent.VK_W];
		aKey = keys[KeyEvent.VK_A];
		sKey = keys[KeyEvent.VK_S];
		dKey = keys[KeyEvent.VK_D];
		
		shiftKey = keys[KeyEvent.VK_SHIFT];
		spaceKey = keys[KeyEvent.VK_SHIFT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			keys[KeyEvent.VK_W] = true;
		if (e.getKeyCode() == KeyEvent.VK_A)
			keys[KeyEvent.VK_A] = true;
		if (e.getKeyCode() == KeyEvent.VK_S)
			keys[KeyEvent.VK_S] = true;
		if (e.getKeyCode() == KeyEvent.VK_D)
			keys[KeyEvent.VK_D] = true;
		
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			keys[KeyEvent.VK_SHIFT] = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			keys[KeyEvent.VK_SPACE] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			keys[KeyEvent.VK_W] = false;
		if (e.getKeyCode() == KeyEvent.VK_A)
			keys[KeyEvent.VK_A] = false;
		if (e.getKeyCode() == KeyEvent.VK_S)
			keys[KeyEvent.VK_S] = false;
		if (e.getKeyCode() == KeyEvent.VK_D)
			keys[KeyEvent.VK_D] = false;
		
		if (e.getKeyCode() == KeyEvent.VK_SHIFT)
			keys[KeyEvent.VK_SHIFT] = true;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			keys[KeyEvent.VK_SPACE] = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
