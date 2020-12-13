package org.jarzarr.test.controls;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jarzarr.code.EngineLoop;
import org.jarzarr.code.EngineLoopInterface;
import org.jarzarr.code.controls.MouseControl;
import org.jarzarr.code.window.Window;

public class MouseClickControls implements EngineLoopInterface {
	
	private int x = 20, y = 20;
	private int mouseX = 20, mouseY = 20;

	public static void main(String[] args) {
		Window.createDecoratedWindow("Test Mouse Controls", null);
		EngineLoop loop = new EngineLoop(new MouseClickControls());
		loop.start();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		if (MouseControl.hasMouseChangedPosition()) {
			mouseX = MouseControl.getMouseLeftClickPosition().x;
			mouseY = MouseControl.getMouseLeftClickPosition().y;
		}
		
		if (x > mouseX)
			x -= 1;
		if (x < mouseX)
			x += 1;
		if (y > mouseY)
			y -= 1;
		if (y < mouseY)
			y += 1;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 50, 50);
	}

	@Override
	public void cleanup() {
		
	}
}
