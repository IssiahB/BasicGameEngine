package org.jarzarr.test.menu;

import java.awt.Color;
import java.awt.Graphics2D;

import org.jarzarr.code.EngineLoop;
import org.jarzarr.code.EngineLoopInterface;
import org.jarzarr.code.ui.UIMenuList;
import org.jarzarr.code.ui.comp.DisplayedMenu;
import org.jarzarr.code.window.Window;

public class MenusTest implements EngineLoopInterface {
	
	public MenusTest() {
		Window.createDecoratedWindow("MenusTest", null);
		EngineLoop loop = new EngineLoop(this);
		loop.start();
	}
	
	public static void main(String[] args) {
		new MenusTest();
	}

	@Override
	public void init() {
		TestStartMenu start = new TestStartMenu(Color.orange);
		UIMenuList.addMenu("StartMenu", start);
		DisplayedMenu.setCurrentlyDisplayedMenu(start);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics2D g) {
		
	}

	@Override
	public void cleanup() {
		
	}

}
