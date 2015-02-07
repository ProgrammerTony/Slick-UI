package com.insenthium.slickui;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.gui.GUIContext;

public class Group {

	private ArrayList<Component> components = new ArrayList<>();
	
	public boolean add(Component component) {
		return components.add(component);
	}
	
	public boolean remove(Component component) {
		return components.remove(component);
	}
	
	public void render(GUIContext container, Graphics g) {
		for(Component component : components) {
			component.draw(container, g);
		}
	}
	
	public void update() {
		for(Component component : components) {
			component.update();
		}
	}
	
	public void mouseClicked(int button, int mouseX, int mouseY) {
		for(Component component : components) {
			component.mouseClicked(button, mouseX, mouseY);
		}
	}
}
