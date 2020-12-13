package org.jarzarr.test.controls;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jarzarr.code.EngineLoop;
import org.jarzarr.code.EngineLoopInterface;
import org.jarzarr.code.controls.KeyboardControl;
import org.jarzarr.code.window.Window;

public class KeyboardControlsTest implements EngineLoopInterface{
	private int x = 20, y = 20;
	private int speed = 2;

	public static void main(String[] args) {
		Window.createDecoratedWindow("Test Keyboard Controls", null);
		EngineLoop loop = new EngineLoop(new KeyboardControlsTest());
		loop.start();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		if (KeyboardControl.wKey)
			y -= speed;
		if (KeyboardControl.sKey)
			y += speed;
		if (KeyboardControl.aKey)
			x -= speed;
		if (KeyboardControl.dKey)
			x += speed;
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
