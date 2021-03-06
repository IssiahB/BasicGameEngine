package org.jarzarr.code;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import org.jarzarr.code.controls.KeyboardControl;
import org.jarzarr.code.window.Window;

public class EngineLoop implements Runnable {
	// game variables
	private volatile static boolean running = false;

	// back end variables
	private Thread thread;
	private BufferStrategy bs;
	private EngineLoopInterface loopInter;
	
	public EngineLoop(EngineLoopInterface inter) {
		this.loopInter = inter;
	}

	/**
	 * starts the GameLoop thread
	 */
	public synchronized void start() {
		if (running) // if game already running can't start
			return;
		
		if (Window.getFrame() == null) { // if window has not been created
			System.err.println("Must create a window before starting game loop");
			return;
		}

		// sets running to true
		running = true;
		// starts thread
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * stops the GameLoop thread
	 */
	public synchronized void stop() {
		if (!running) // if not running can't stop
			return;

		// sets running to false
		running = false;
		loopInter.cleanup();
		// safely ends the thread
		System.exit(0);
	}

	/**
	 * Runs the game loop (UPDATE, and RENDER methods)
	 */
	public void run() {
		loopInter.init();

		boolean widnowVisible = true;

		double maxFrameTime = 1000000000 / 60;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int update = 0;

		// the main loop
		while (widnowVisible && running) {
			now = System.nanoTime();
			delta += (now - lastTime) / maxFrameTime;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				// every second update and render 60 times
				update();
				render();
				update++;
				delta--;
			}

			if (timer >= 1000000000) {
				update = 0;
				timer = 0;
			}

			if (widnowVisible)
				widnowVisible = Window.getFrame().isVisible();
		}

		this.stop();
	}

	public void update() {
		KeyboardControl.updateKeys();
		loopInter.update();
	}

	private void render() {
		bs = Window.getCanvas().getBufferStrategy();
		if (bs == null) {
			Window.getCanvas().createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, Window.getCanvas().getWidth(), Window.getCanvas().getHeight());

		loopInter.render(g);
		// Render End

		bs.show();
		g.dispose();
	}

	public static boolean isRunning() {
		return running;
	}
	
	/**
	 * Ends the main game loop by destroying
	 * the window the game loop is running
	 * for
	 */
	public static void endLoop() {
		Window.cleanUp();
	}

}
