package co.archeos.games.arcaneassault.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.utils.GameConstants;
import co.archeos.games.arcaneassault.utils.GameRunnable;

/**
 * Created by Ajay on 2015-06-25.
 */
public class SplashStage extends AbstractStage {
    private TextureAtlas mSplashStageAtlas;
    private Image mSplashImage;

    public SplashStage(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mSplashStageAtlas = mArcaneAssaultGame.getAssetManager().get(GameConstants
                .SplashScreen.PACK_LOCATION, TextureAtlas.class);

        Runnable onSplashFinishedRunnable = new Runnable() {
            public void run() {
                mArcaneAssaultGame.getLoadingScreen().setLoadingRunnable(new GameRunnable() {
                    @Override
                    public void run() {
                        mArcaneAssaultGame.getAssetManager().loadMainMenuScreenResources();
                    }
                });
                mArcaneAssaultGame.getLoadingScreen().setOnLoadFinishedRunnable(new GameRunnable() {
                    @Override
                    public void run() {
                        mArcaneAssaultGame.setScreen(mArcaneAssaultGame.getMainMenuScreen());
                    }
                });

                mArcaneAssaultGame.setScreen(mArcaneAssaultGame.getLoadingScreen());
            }
        };

        mSplashImage = new Image(mSplashStageAtlas.findRegion(GameConstants.SplashScreen.SPLASH_IMAGE));
        mSplashImage.addAction(Actions.sequence(Actions.fadeIn(0.001f), Actions.fadeOut(0.01f),
                Actions.run(onSplashFinishedRunnable)));
        mSplashImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        addActor(mSplashImage);
    }
}
