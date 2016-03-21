package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;

/**
 * Created by Ajay on 2015-06-24.
 */
public abstract  class AbstractScreen implements Screen {
    private final static String LOG_TAG_ABSTRACTSCREEN_SHOW = "AbstractScreen: SHOW";
    private final static String LOG_TAG_ABSTRACTSCREEN_RENDER = "AbstractScreen: RENDER";
    private final static String LOG_TAG_ABSTRACTSCREEN_RESIZE = "AbstractScreen: RESIZE";
    private final static String LOG_TAG_ABSTRACTSCREEN_PAUSE = "AbstractScreen: PAUSE";
    private final static String LOG_TAG_ABSTRACTSCREEN_RESUME = "AbstractScreen: RESUME";
    private final static String LOG_TAG_ABSTRACTSCREEN_HIDE = "AbstractScreen: HIDE";
    private final static String LOG_TAG_ABSTRACTSCREEN_DISPOSE = "AbstractScreen: DISPOSE";

    ArcaneAssaultGame mArcaneAssaultGame;

    public AbstractScreen(){

    }

    public AbstractScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_ABSTRACTSCREEN_SHOW, "Show called.");
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_ABSTRACTSCREEN_RENDER, "Render called.");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG_ABSTRACTSCREEN_RESIZE, "Resize called.");
    }

    @Override
    public void pause() {
        Gdx.app.log(LOG_TAG_ABSTRACTSCREEN_PAUSE, "Pause called.");
    }

    @Override
    public void resume() {
        Gdx.app.log(LOG_TAG_ABSTRACTSCREEN_RESUME, "Resume called.");
    }

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG_ABSTRACTSCREEN_HIDE, "Hide called.");
    }

    @Override
    public void dispose() {
        Gdx.app.log(LOG_TAG_ABSTRACTSCREEN_DISPOSE, "Dispose called.");
    }
}
