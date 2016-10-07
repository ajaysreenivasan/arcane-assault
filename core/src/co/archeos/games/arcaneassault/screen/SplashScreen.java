package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.stage.SplashStage;


/**
 * Created by Ajay on 2015-06-02.
 */
public class SplashScreen extends AbstractScreen {
    public SplashScreen(ArcaneAssaultGame arcaneAssaultGame) {
        super(arcaneAssaultGame);

        mArcaneAssaultGame.getAssetManager().loadSplashScreenResources();
        mScreenStage = new SplashStage(mArcaneAssaultGame);
    }
}
