package com.insenthium.slickui;



/**
 * The action listener class defines the type of event that triggers the componentActivated method
 * through the constructor.
 * @author Tony Erazo
 *
 */
public abstract class ActionListener {

	/**
	 * Type of action that triggers this listener.
	 */
	private Action action;
	
	public ActionListener(Action action) {
		this.action = action;
	}
	
	public abstract void componentActivated(Component component);
	
	/**
	 * Gets the action that triggers this listener.
	 * @return
	 */
	Action getAction() {
		return action;
	}
}
