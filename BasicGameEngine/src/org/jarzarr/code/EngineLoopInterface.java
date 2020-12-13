package org.jarzarr.code;

import java.awt.Graphics2D;

public interface EngineLoopInterface {
	
	public void init();
	
	public void update();
	
	public void render(Graphics2D g);
	
	public void cleanup();
}
