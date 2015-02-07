package com.insenthium.slickui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * Creates a password field which hides the input text
 * @author Tony Erazo.
 *
 */
public class PasswordField extends TextField {
	
	/**
	 * Creates a text field with a label.
	 * @param label {@code String} the label of the text field.
	 * @param idle the idle image of the text field.
	 * @param container {@link GUIContext}
	 */
	public PasswordField(String label, String idle,
			GUIContext container) {
		super(label, idle, container);
	}
	
	/**
	 * Creates a text field with a label.
	 * @param label {@code String} the label of the text field.
	 * @param idle the idle image of the text field.
	 * @param clicked the clicked image of the text field.
	 * @param container {@link GUIContext}
	 */
	public PasswordField(String label, String idle, String clicked,
			GUIContext container) {
		super(label, idle, clicked, container);
	}
	
	/**
	 * Creates a text field with a label.
	 * @param label {@code String} the label of the text field.
	 * @param idle the idle image of the text field.
	 * @param hovered the hovered image of the text field.
	 * @param clicked the clicked image of the text field.	
	 * @param container {@link GUIContext}
	 */
	public PasswordField(String label, String idle, String hovered, String clicked,
			GUIContext container) {
		super(label, idle, hovered, clicked, container);
	}
	
	/**
	 * Creates a text field with a label.
	 * @param label {@code Label} the label of the text field.
	 * @param idle the idle image of the text field.
	 * @param container {@link GUIContext}
	 */
	public PasswordField(Label label, String idle,
			GUIContext container) {
		super(label, idle, container);
	}
	
	/**
	 * Creates a text field with a label.
	 * @param label {@code Label} the label of the text field.
	 * @param idle the idle image of the text field.
	 * @param clicked the clicked image of the text field.
	 * @param container {@link GUIContext}
	 */
	public PasswordField(Label label, String idle, String clicked,
			GUIContext container) {
		super(label, idle, clicked, container);
	}
	
	/**
	 * Creates a text field with a label.
	 * @param label {@code Label} the label of the text field.
	 * @param idle the idle image of the text field.
	 * @param hovered the hovered image of the text field.
	 * @param clicked the clicked image of the text field.
	 * @param container {@link GUIContext}
	 */
	public PasswordField(Label label, String idle, String hovered, String clicked,
			GUIContext container) {
		super(label, idle, hovered, clicked, container);
	}
	
	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		
		if(isFocused()) {
			g.drawString(hideText(text) + (System.currentTimeMillis() /500 % 2 == 0 ? CARET : ""), x, y);
		} else {
			if(label != null && text.isEmpty()) {
				label.draw(container, g);
			} else {
				g.drawString(hideText(text), x, y);
			}
		}
	}
	
	/**
	 * Hides the text within the password field.
	 * @param text the target text to be hidden.
	 * @return the hidden text.
	 */
	private String hideText(String text) {
		StringBuilder builder = new StringBuilder();
		for(int i =0; i < text.toCharArray().length; i++) {
			builder.append("*");
		}
		return builder.toString();
	}
}
