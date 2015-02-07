package com.insenthium.slickui;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

/**
 * Abstract class to create graphical user interface components.
 * 
 * @author Tony Erazo
 */
public abstract class Component extends AbstractComponent {

	/**
	 * Flags if the component is focused.
	 */
	private boolean focused;

	/**
	 * x-coordinate where the component is rendered.
	 */
	protected int x;

	/**
	 * y-coordinate where the component is rendered.
	 */
	protected int y;

	/**
	 * Width of the component.
	 */
	protected int width;

	/**
	 * Height of the component.
	 */
	protected int height;

	/**
	 * The variable image of the component.
	 */
	private Image sprite;

	/**
	 * The idle image of the component.
	 */
	protected String idle;

	/**
	 * The hovered image of the component.
	 */
	protected String hovered;

	/**
	 * The clicked image of the component.
	 */
	protected String clicked;

	/**
	 * Contains all the action listeners binded to the component.
	 */
	private ArrayList<ActionListener> listeners = new ArrayList<>();

	public Component(GUIContext container) {
		super(container);
	}

	public Component(int x, int y, int width, int height, GUIContext container) {
		super(container);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Component(String idle, GUIContext container) {
		super(container);
		try {
			this.idle = idle;
			this.sprite = new Image(idle);
			this.width = this.sprite.getWidth();
			this.height = this.sprite.getHeight();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Component(String idle, String clicked, GUIContext container) {
		this(idle, container);
		this.clicked = clicked;
	}

	public Component(String idle, String hovered, String clicked, GUIContext container) {
		this(idle, clicked, container);
		this.hovered = hovered;
	}

	/**
	 * Flags if the mouse hovered within the boundaries of the component.
	 * 
	 * @param mouseX
	 *            the x-coordinate of the mouse.
	 * @param mouseY
	 *            the y-coordinate of the mouse.
	 * @return if the mouse is clicked.
	 */
	protected boolean isHovered(int mouseX, int mouseY) {
		return (mouseX >= x && mouseX <= (x + width) && mouseY >= y && mouseY <= (y + height));
	}

	/**
	 * Flags if the mouse clicked within the boundaries of the component.
	 * 
	 * @param button
	 *            the button id desired to trigger the event.
	 * @param mouseX
	 *            the x-coordinate of the mouse.
	 * @param mouseY
	 *            the y-coordinate of the mouse.
	 * @return if the mouse is clicked.
	 */
	protected boolean isClicked(int button, int mouseX, int mouseY) {
		return (input.isMouseButtonDown(button) && isHovered(mouseX, mouseY));
	}

	/**
	 * Adds a listener which is binded to the component.
	 * 
	 * @param listener
	 *            {@code ActionListener}
	 */
	public void addListener(ActionListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes a listener which is binded to the component.
	 * 
	 * @param listener
	 *            {@code ActionListener}
	 */
	public void removeListener(ActionListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Updates all the listeners binded to the component.
	 */
	void update() {
		for (ActionListener listener : listeners) {
			if (listener.getAction() == Action.HOVERED && isHovered(input.getMouseX(), input.getMouseY()) || listener.getAction() == Action.CLICKED && isClicked(Input.MOUSE_LEFT_BUTTON, input.getMouseX(), input.getMouseY())) {
				listener.componentActivated(this);
			}
		}
	}

	void draw(GUIContext container, Graphics g) {

		if (sprite != null) {
			sprite.draw(x, y);
		}

		try {

			if (isClicked(Input.MOUSE_LEFT_BUTTON, input.getMouseX(), input.getMouseY()) && clicked != null) {
				sprite = new Image(clicked);
			} else if (isHovered(input.getMouseX(), input.getMouseY()) && hovered != null) {
				sprite = new Image(hovered);
			} else {
				if (idle != null) {
					sprite = new Image(idle);
				}
			}

		} catch (SlickException e) {
			e.printStackTrace();
		}
		try {
			render(container, g);
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the dimensions of the component.
	 * 
	 * @param width
	 *            the width of the component.
	 * @param height
	 *            the height of the component.
	 */
	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Flags if the component is focused.
	 * 
	 * @return {@code Boolean}
	 */
	public boolean isFocused() {
		return focused;
	}

	/**
	 * Sets the focus of the component
	 * 
	 * @param focused
	 *            {@code Boolean}
	 * @return {@code Boolean}
	 */
	public boolean setFocused(boolean focused) {
		this.focused = focused;
		return focused;
	}

	public void mouseClicked(int button, int mouseX, int mouseY) {
		focused = (button == Input.MOUSE_LEFT_BUTTON) && isHovered(input.getMouseX(), input.getMouseY());
	}

	/**
	 * Gets the image associated with the component.
	 * 
	 * @return
	 */
	public Image getImage() {
		return sprite;
	}

}
