package com.insenthium.slickui.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TestRun extends StateBasedGame {

	public TestRun(String name) {
		super(name);
		
		/* last, attempt to start the client GUI */
		try {

			AppGameContainer app = new AppGameContainer(this);

			/* always render our game, regardless of focus */
			app.setAlwaysRender(true);

			/* set the display mode */
			app.setDisplayMode(800, 600, false);

			/* show our current frame per second rate */
			app.setShowFPS(true);

			/* sets a "smoother" delta rate based on framerates */
			//app.setSmoothDeltas(true);

			/* start the game GUI */
			app.start();

		} catch (Exception ex) {
			/* report the details */
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestRun("SlickUI");
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new GuiState());
	}
}
