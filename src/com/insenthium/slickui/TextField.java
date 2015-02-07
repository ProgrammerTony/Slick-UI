package com.insenthium.slickui;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * Creates a text field which accepts user input to grab text from this
 * component.
 * 
 * @author Tony Erazo
 *
 */
public class TextField extends Component {

	/**
	 * Limit to how fast it receives input from the user.
	 */
	protected static final int INITIAL_KEY_REPEAT_INTERVAL = 400;

	/**
	 * Speed of the key repetition added to the textfield when a key is pressed
	 * consecutively
	 */
	protected static final int KEY_REPEAT_INTERVAL = 25;

	/**
	 * Repeat timer of the input.
	 */
	protected long repeatTimer;

	private int maxLength = 20;

	/**
	 * Caret of the text field.
	 */
	protected static final String CARET = "|";

	/**
	 * Current text the text field is containing.
	 */
	protected String text = "";

	/**
	 * The label of the text field this label is not rendered when the field is
	 * focused.
	 */
	protected Label label;

	/**
	 * Creates a text field with a label.
	 * 
	 * @param label
	 *            {@code String} the label of the text field.
	 * @param idle
	 *            the idle image of the text field.
	 * @param container
	 *            {@link GUIContext}
	 */
	public TextField(String label, String idle, GUIContext container) {
		super(idle, container);
		this.label = new Label(label, this, container);
	}

	/**
	 * Creates a text field with a label.
	 * 
	 * @param label
	 *            {@code String} the label of the text field.
	 * @param idle
	 *            the idle image of the text field.
	 * @param clicked
	 *            the clicked image of the text field.
	 * @param container
	 *            {@link GUIContext}
	 */
	public TextField(String label, String idle, String clicked, GUIContext container) {
		super(idle, clicked, container);
		this.label = new Label(label, this, container);
	}

	/**
	 * Creates a text field with a label.
	 * 
	 * @param label
	 *            {@code String} the label of the text field.
	 * @param idle
	 *            the idle image of the text field.
	 * @param hovered
	 *            the hovered image of the text field.
	 * @param clicked
	 *            the clicked image of the text field.
	 * @param container
	 *            {@link GUIContext}
	 */
	public TextField(String label, String idle, String hovered, String clicked, GUIContext container) {
		super(idle, hovered, clicked, container);
		this.label = new Label(label, this, container);
	}

	/**
	 * Creates a text field with a label.
	 * 
	 * @param label
	 *            {@code Label} the label of the text field.
	 * @param idle
	 *            the idle image of the text field.
	 * @param container
	 *            {@link GUIContext}
	 */
	public TextField(Label label, String idle, GUIContext container) {
		super(idle, container);
		this.label = label;
	}

	/**
	 * Creates a text field with a label.
	 * 
	 * @param label
	 *            {@code Label} the label of the text field.
	 * @param idle
	 *            the idle image of the text field.
	 * @param clicked
	 *            the clicked image of the text field.
	 * @param x
	 *            the x-coordinate of the text field.
	 * @param y
	 *            the y-coordinate of the text field.
	 * @param container
	 *            {@link GUIContext}
	 */
	public TextField(Label label, String idle, String clicked, GUIContext container) {
		super(idle, clicked, container);
		this.label = label;
	}

	/**
	 * Creates a text field with a label.
	 * 
	 * @param label
	 *            {@code Label} the label of the text field.
	 * @param idle
	 *            the idle image of the text field.
	 * @param hovered
	 *            the hovered image of the text field.
	 * @param clicked
	 *            the clicked image of the text field.
	 * @param container
	 *            {@link GUIContext}
	 */
	public TextField(Label label, String idle, String hovered, String clicked, GUIContext container) {
		super(idle, hovered, clicked, container);
		this.label = label;
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		g.setColor(Color.white);

		if (!isFocused() && label != null && text.isEmpty()) {
			g.drawString(label.getText(), x, y);
		} else if(isFocused()){
			g.drawString(text + (System.currentTimeMillis() / 500 % 2 == 0 ? "|" : ""), x, y);
		} else {
			g.drawString(text, x, y);
		}
	}

	/**
	 * Checks if a key was pressed on the {@link TextField}.
	 * 
	 * @param key
	 *            the key id.
	 * @param c
	 *            the character id.
	 */

	public void keyPressed(int key, char c) {
		System.out.println("pressed ");

		if (isFocused()) {
			if (System.currentTimeMillis() >= repeatTimer) {

				if (Keyboard.isKeyDown(Input.KEY_BACK) && (text.length()) > 0) {
					text = text.substring(0, text.length() - 1);
				}

				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == ' ')) {
					if (text.length() < maxLength) {
						text += c;
					}
				}
			}
			repeatTimer = System.currentTimeMillis() + KEY_REPEAT_INTERVAL;
		}

	}

	/**
	 * Gets the text the Text field is currently containing.
	 * 
	 * @return {@code String} the text the field contains.
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the text of the text field is currently containing.
	 * @param text the text the field is containing.
	 */
	public void setText(String text) {
		this.text = text;
	}

}
