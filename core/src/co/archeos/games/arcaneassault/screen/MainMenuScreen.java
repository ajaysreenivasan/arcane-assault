package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.stage.MainMenuStage;

/**
 * Created by Ajay on 2015-06-01.
 */
public class MainMenuScreen extends AbstractScreen {
    public MainMenuScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mScreenStage = new MainMenuStage(arcaneAssaultGame);
    }
}

