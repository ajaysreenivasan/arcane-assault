package co.archeos.games.arcaneassault.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Arcane Assault";
        config.width = 960;
        config.height = 504;
        new LwjglApplication(new ArcaneAssaultGame(), config);
    }
}

