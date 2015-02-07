package com.insenthium.slickui;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class Spinner extends Component {

	/**
	 * Repeat timer of the input.
	 */
	protected long repeatTimer;
	
	/**
	 * Current index of the spinner.
	 */
	private int index;

	/**
	 * Minimum value of the spinner.
	 */
	private final int MINIMUM_VALUE;

	/**
	 * Maximum value of the spinner.
	 */
	private final int MAXIMUM_VALUE;

	/**
	 * Increment ratio.
	 */
	private int step;

	/**
	 * {@code Button} increments the index value of the spinner.
	 */
	private Button incrementButton;

	/**
	 * {@code Button} decrements the index value of the spinner.
	 */
	private Button decrementButton;
	
	/**
	 * Index text field of the spinner.
	 */
	private TextField indexField;

	/**
	 * 
	 * @param idle the idle image of the spinner
	 * @param incrementButton the increment button
	 * @param decrementButton the decrement button.
	 * @param initialValue the starting index value
	 * @param minimumValue the minimum index value
	 * @param maxValue the maximum index value
	 * @param step the increment value
	 * @param container {@link GUIContext}
	 */
	public Spinner(String idle, Button incrementButton, Button decrementButton, int initialValue, int minimumValue, int maxValue, int step, GUIContext container) {
		super(idle, container);
		this.indexField = new TextField("", idle, container);
		this.incrementButton = incrementButton;
		this.decrementButton = decrementButton;
		this.index = initialValue;
		this.MINIMUM_VALUE = minimumValue;
		this.MAXIMUM_VALUE = maxValue;
		this.step = step;
		
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		indexField.draw(container, g);
		if(incrementButton.isClicked(Input.MOUSE_LEFT_BUTTON, input.getMouseX(), input.getMouseY())) {
			if(MAXIMUM_VALUE >= (index + step)) {
				index += step;
				indexField.setText(Integer.toString(index));
			}
		} else if(decrementButton.isClicked(Input.MOUSE_LEFT_BUTTON, input.getMouseX(), input.getMouseY())) {
			if(MINIMUM_VALUE <= (index - step)) {
				index -= step;
				indexField.setText(Integer.toString(index));
			}
		}
	}
	
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println(indexField);
		indexField.setLocation(x, y);
		incrementButton.setLocation(x ,10);
		decrementButton.setLocation(x + getWidth(),y);
	}
	
	public void keyPressed(int key, char c) {
		if (isFocused()) {
			if (System.currentTimeMillis() >= repeatTimer) {

				if (Keyboard.isKeyDown(Input.KEY_BACK) && (indexField.getText().length()) > 0) {
					indexField.setText(indexField.getText().substring(0, indexField.getText().length() - 1));
				}

				if ((c >= '0' && c <= '9')) {
					if (indexField.getText().length() < 20) {
						indexField.setText(indexField.getText() + c);
					}
				}
			}
			repeatTimer = System.currentTimeMillis() + TextField.KEY_REPEAT_INTERVAL;
		}

	}
	
	@Override
	public void mouseClicked(int button, int mouseX, int mouseY) {
		indexField.mouseClicked(button, mouseX, mouseY);
	}
	
	/**
	 * Returns the current index of the spinner.
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

}
