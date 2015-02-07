package com.insenthium.slickui.test;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.insenthium.slickui.Action;
import com.insenthium.slickui.ActionListener;
import com.insenthium.slickui.Button;
import com.insenthium.slickui.Component;
import com.insenthium.slickui.Group;
import com.insenthium.slickui.PasswordField;
import com.insenthium.slickui.Spinner;
import com.insenthium.slickui.TextField;

public class GuiState extends BasicGameState {

	private Button registerButton;
	private TextField usernameField;
	private PasswordField passwordField;
	private Spinner spinner;
	private Group group = new Group();
	@Override
	public void init(GameContainer container, StateBasedGame arg1) throws SlickException {
		registerButton = new Button("", "./res/register_norm.jpg", "./res/register_hover.jpg",
				"./res/register_click.jpg", container);
		registerButton.setLocation(200, 180);
		usernameField = new TextField("Username", "./res/textfield.png", container);
		usernameField.setLocation(300, 180);
		passwordField = new PasswordField("", "./res/textfield.png", container);
		passwordField.setLocation(300, 250);
		
		Button upButton = new Button("", "./res/register_norm.jpg", "./res/register_hover.jpg",
				"./res/register_click.jpg", container);;
		Button downButton = new Button("", "./res/register_norm.jpg", "./res/register_hover.jpg",
				"./res/register_click.jpg", container);;
		spinner = new Spinner("./res/textfield.png", upButton, downButton, 0, 0, 20, 1, container);
		spinner.setLocation(20,30);
		
		registerButton.addListener(new ActionListener(Action.HOVERED) {

			@Override
			public void componentActivated(Component component) {
				System.out.println("hello action listener hover!");
			}
			
		});
		
		usernameField.addListener(new ActionListener(Action.CLICKED) {

			@Override
			public void componentActivated(Component component) {
				
			}
			
		});
		group.add(registerButton);
		group.add(usernameField);
		group.add(passwordField);
		group.add(spinner);
	}

	@Override
	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setBackground(Color.pink);
		group.render(container, g);
		spinner.setLocation(300, 100);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		group.update();
	}
	
	
	@Override
	public void keyPressed(int key, char c) {
		usernameField.keyPressed(key, c);
		spinner.keyPressed(key, c);
		//passwordField.keyPressed(key, c);
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		group.mouseClicked(button, x, y);
	}

	@Override
	public int getID() {
		return 0;
	}

}
