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
public class SplashScreen implements Screen {
    private final static String LOG_TAG_SPLASHSCREEN_SHOW = "GameScreen: SHOW";
    private final static String LOG_TAG_SPLASHSCREEN_RENDER = "GameScreen: RENDER";
    private final static String LOG_TAG_SPLASHSCREEN_RESIZE = "GameScreen: RESIZE";
    private final static String LOG_TAG_SPLASHSCREEN_PAUSE = "GameScreen: PAUSE";
    private final static String LOG_TAG_SPLASHSCREEN_RESUME = "GameScreen: RESUME";
    private final static String LOG_TAG_SPLASHSCREEN_HIDE = "GameScreen: HIDE";
    private final static String LOG_TAG_SPLASHSCREEN_DISPOSE = "GameScreen: DISPOSE";

    private ArcaneAssaultGame mArcaneAssaultGame;

    private SplashStage mSplashStage;

    private TextureAtlas mSplashScreenAtlas;

    public SplashScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mArcaneAssaultGame.getAssetManager().loadSplashScreenResources();
        mSplashStage = new SplashStage(mArcaneAssaultGame);
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_SPLASHSCREEN_SHOW, "Show called.");
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_SPLASHSCREEN_RENDER, "Render called.");

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mSplashStage.act(delta);
        mSplashStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG_SPLASHSCREEN_RESIZE, "Resize called.");

         mSplashStage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {
        Gdx.app.log(LOG_TAG_SPLASHSCREEN_PAUSE, "Pause called.");
    }

    @Override
    public void resume() {
        Gdx.app.log(LOG_TAG_SPLASHSCREEN_RESUME, "Resume called.");

    }

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG_SPLASHSCREEN_HIDE, "Hide called.");
    }

    @Override
    public void dispose() {
        Gdx.app.log(LOG_TAG_SPLASHSCREEN_DISPOSE, "Dispose called.");

        mSplashStage.dispose();
    }
}
