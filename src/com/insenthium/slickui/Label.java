package com.insenthium.slickui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * Creates a label which renders text.
 * @author Tony Erazo.
 *
 */
public class Label extends Component {

	/**
	 * The text of the label.
	 */
	private String text;
	
	/**
	 * Color of the label text.
	 */
	private Color color;
	
	/**
	 * Parent of the label.
	 */
	private Component parent;
	
	/**
	 * Creates a label with the specified text.
	 * @param text the text of the label.
	 * @param container {@link GUIContext}
	 */
	public Label(String text,
			GUIContext container) {
		super(container);
		this.text = text;
		this.color = Color.black;
	}
	
	/**
	 * Creates a label with the specified text.
	 * @param text the text of the label.
	 * @param color the color of the label.
	 * @param x the x-coordinate of the label.
	 * @param y the y-coordinate of the label.
	 * @param container {@link GUIContext}
	 */
	public Label(String text, Color color,
			GUIContext container) {
		super(container);
		this.text = text;
		this.color = color;
	}
	
	/**
	 * Creates a label with the specified text and parent.
	 * @param text the text of the label.
	 * @param parent the parent of the label.
	 * @param container {@link GUIContext}
	 */
	public Label(String text, Component parent,
			GUIContext container) {
		super(container);
		this.x = parent.getX() + parent.getWidth()/4;
		this.y = parent.getY() + parent.getHeight()/4;
		this.text = text;
		this.parent = parent;
		this.color = Color.black;
	}
	
	/**
	 * Creates a label with the specified text and parent.
	 * @param text the text of the label.
	 * @param color the color of the label.
	 * @param parent the parent of the label.
	 * @param container {@link GUIContext}
	 */
	public Label(String text, Color color, Component parent,
			GUIContext container) {
		super(container);
		this.x = parent.getX() + parent.getWidth()/4;
		this.y = parent.getY() + parent.getHeight()/4;
		this.text = text;
		this.color = color;
		this.parent = parent;
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		if(text != null && color != null) {
			g.setColor(color);
			if(parent != null) {
				g.drawString(text, x, y);
			} else {
				g.drawString(text, x, y);	
			}
		}
	}

	/**
	 * Gets the text of the label.
	 * @return {@code String} text.
	 */
	public String getText() {
		return text;
	}
}
