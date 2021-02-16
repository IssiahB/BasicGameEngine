package org.jarzarr.test.controls;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import org.jarzarr.code.EngineLoop;
import org.jarzarr.code.EngineLoopInterface;
import org.jarzarr.code.controls.MouseControl;
import org.jarzarr.code.controls.MouseInterface;
import org.jarzarr.code.window.Window;

public class MouseClickControls implements EngineLoopInterface, MouseInterface {
	
	private int mouseX = 0, mouseY = 0;
	private int x = 0, y = 0;
	private int speed = 2;

	public static void main(String[] args) {
		Window.createDecoratedWindow("Test Mouse Controls", null);
		EngineLoop loop = new EngineLoop(new MouseClickControls());
		loop.start();
	}

	@Override
	public void init() {
		MouseControl.addMouse(this);
	}

	@Override
	public void update() {
		if (x < mouseX)
			x += speed;
		if (x > mouseX)
			x -= speed;
		
		if (y < mouseY)
			y += speed;
		if (y > mouseY)
			y -= speed;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 50, 50);
	}

	@Override
	public void cleanup() {
		System.out.println("Clean");
	}

	@Override
	public void mousePressed(MouseEvent event) {
		mouseX = event.getX();
		mouseY = event.getY();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		int mouseRelX = event.getX();
		int mouseRelY = event.getY();
		
		if (mouseRelX == mouseX && mouseRelY == mouseY) {
			System.out.println("Mouse Released At Same Position Pressed");
		} else {
			System.out.println("Mouse Released At Different Position Pressed");
		}
	}
}
