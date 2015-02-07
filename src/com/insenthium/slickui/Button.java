package com.insenthium.slickui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 * Creates a button with a label.
 * @author Tony Erazo.
 *
 */
public class Button extends Component {

	/**
	 * THe label of the button.
	 */
	private Label label;
	
	/**
	 * Creates a button with a label.
	 * @param label {@link String} the label of the button.
	 * @param idle the idle image of the button.
	 * @param container {@link GUIContext}
	 */
	public Button(String label, String idle,
			GUIContext container) {
		super(idle, container);
		this.label = new Label(label, this, container);
	}
	
	/**
	 * Creates a button with a label.
	 * @param label {@link String} the label of the button.
	 * @param idle the idle image of the button.
	 * @param clicked the clicked image of the button.
	 * @param container {@link GUIContext}
	 */
	public Button(String label, String idle, String clicked,
			GUIContext container) {
		super(idle, clicked, container);
		this.label = new Label(label, this, container);
	}
	
	/**
	 * Creates a button with a label.
	 * @param label {@link String} the label of the button.
	 * @param idle the idle image of the button.
	 * @param hovered the hovered image of the button.
	 * @param clicked the clicked image of the button.
	 * @param x the x-coordinate of the button.
	 * @param y the y-coordinate of the button.
	 * @param container {@link GUIContext}
	 */
	public Button(String label, String idle, String hovered, String clicked,
			GUIContext container) {
		super(idle, hovered, clicked, container);
		this.label = new Label(label, this, container);
	}
	
	/**
	 * Creates a button with a label.
	 * @param label {@link Label} the label of the button.
	 * @param idle the idle image of the button.
	 * @param container {@link GUIContext}
	 */
	public Button(Label label, String idle, GUIContext container) {
		super(idle, container);
		this.label = label;
	}
	
	/**
	 * Creates a button with a label.
	 * @param label {@link Label} the label of the button.
	 * @param idle the idle image of the button.
	 * @param clicked the clicked image of the button.
	 * @param x the x-coordinate of the button.
	 * @param y the y-coordinate of the button.
	 * @param container {@link GUIContext}
	 */
	public Button(Label label, String idle, String clicked,
			GUIContext container) {
		super(idle, clicked, container);
		this.label = label;
	}
	
	/**
	 * Creates a button with a label.
	 * @param label {@link Label} the label of the button.
	 * @param idle the idle image of the button.
	 * @param hovered the hovered image of the button.
	 * @param clicked the clicked image of the button.
	 * @param x the x-coordinate of the button.
	 * @param y the y-coordinate of the button.
	 * @param container {@link GUIContext}
	 */
	public Button(Label label, String idle, String hovered, String clicked,
			GUIContext container) {
		super(idle, hovered, clicked, container);
		this.label = label;
	}

	@Override
	public void render(GUIContext container, Graphics g) throws SlickException {
		if(label != null) {
			label.render(container, g);
		}
	}

}
