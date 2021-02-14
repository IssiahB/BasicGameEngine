package org.jarzarr.code.window;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;

import org.jarzarr.code.controls.KeyboardControl;
import org.jarzarr.code.controls.MouseControl;

public class Window {

	private static Canvas canvas = null;
	private static JFrame frame = null;
	
	/**
	 * Creates a window using a JFrame with a title, minimum 
	 * size of 500w and 300h, full screen with a visible border,
	 * and a icon at the top of the window. 
	 * A canvas is also created and put inside the JFrame's
	 * ContentPane. If a window has already been created nothing will happen.
	 * 
	 * @param title - The title of the window
	 * @param icon - The image icon that is displayed at the top
	 * of the window.
	 */
	public static void createDecoratedWindow(String title, Image icon) {
		if (frame != null) {
			System.err.println("Window Has Already Been Created!");
			return;
		}

		canvas = new Canvas();
		frame = new JFrame(title);
		canvas.addKeyListener(new KeyboardControl());
		canvas.addMouseListener(new MouseControl());

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setIconImage(icon);

		canvas.setSize(new Dimension(frame.getWidth(), frame.getHeight()));
		frame.getContentPane().add(canvas);
		frame.setVisible(true);
	}
	
	/**
	 * Creates a window using a JFrame with a title, minimum 
	 * size of 500w and 300h, full screen with a invisible border,
	 * and a icon at the top of the window. 
	 * A canvas is also created and put inside the JFrame's
	 * ContentPane. If a window has already been created nothing will happen.
	 * 
	 * @param title - The title of the window
	 * @param icon - The image icon that is displayed at the top
	 * of the window.
	 */
	public static void createNondecoratedWindow(String title, Image icon) {
		if (frame != null) {
			System.err.println("Window Has Already Been Created!");
			return;
		}

		canvas = new Canvas();
		frame = new JFrame(title);
		canvas.addKeyListener(new KeyboardControl());
		canvas.addMouseListener(new MouseControl());

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setUndecorated(true);
		frame.setIconImage(icon);

		canvas.setSize(new Dimension(frame.getWidth(), frame.getHeight()));
		frame.getContentPane().add(canvas);
		frame.setVisible(true);
	}
	
	/**
	 * Creates a window using a JFrame with a title, an icon displayed 
	 * at the top of the window, visible borders, and a set nonresizable
	 * width and height. A canvas is also created and put inside the JFrame's
	 * ContentPane. If a window has already been created nothing will happen.
	 * 
	 * @param title - The title of the window 
	 * @param icon - The image icon that is displayed at the top
	 * of the window.
	 * @param width - The width the window will be displayed as
	 * @param height - The height the window will be displayed as
	 */
	public static void createSizedWindow(String title, Image icon, int width, int height) {
		if (frame != null) {
			System.err.println("Window Has Already Been Created!");
			return;
		}

		canvas = new Canvas();
		frame = new JFrame(title);
		canvas.addKeyListener(new KeyboardControl());
		canvas.addMouseListener(new MouseControl());

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		Dimension frameSize = new Dimension(width, height);
		frame.setMinimumSize(frameSize);
		frame.setMaximumSize(frameSize);
		frame.setPreferredSize(frameSize);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon);

		canvas.setSize(frameSize);
		frame.getContentPane().add(canvas);
		frame.setVisible(true);
	}

	public static Canvas getCanvas() {
		return canvas;
	}

	public static JFrame getFrame() {
		return frame;
	}
}
