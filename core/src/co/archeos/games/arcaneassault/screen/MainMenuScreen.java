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
public class MainMenuScreen implements Screen {
    private final static String LOG_TAG_MAINMENUSCREEN_SHOW = "MainMenuScreen: SHOW";
    private final static String LOG_TAG_MAINMENUSCREEN_RENDER = "MainMenuScreen: RENDER";
    private final static String LOG_TAG_MAINMENUSCREEN_RESIZE = "MainMenuScreen: RESIZE";
    private final static String LOG_TAG_MAINMENUSCREEN_PAUSE = "MainMenuScreen: PAUSE";
    private final static String LOG_TAG_MAINMENUSCREEN_RESUME = "MainMenuScreen: RESUME";
    private final static String LOG_TAG_MAINMENUSCREEN_HIDE = "MainMenuScreen: HIDE";
    private final static String LOG_TAG_MAINMENUSCREEN_DISPOSE = "MainMenuScreen: DISPOSE";

    private ArcaneAssaultGame mArcaneAssaultGame;

    private MainMenuStage mMainMenuStage;

    public MainMenuScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mMainMenuStage = new MainMenuStage(arcaneAssaultGame);
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_MAINMENUSCREEN_SHOW, "Show called.");

        mMainMenuStage.createStage();

        Gdx.input.setInputProcessor(mMainMenuStage);
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_MAINMENUSCREEN_RENDER, "Render called.");

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mMainMenuStage.act(delta);
        mMainMenuStage.getViewport().apply();
        mMainMenuStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG_MAINMENUSCREEN_RESIZE, "Resize called.");

        mMainMenuStage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {
        Gdx.app.log(LOG_TAG_MAINMENUSCREEN_PAUSE, "Pause called.");
    }

    @Override
    public void resume() {
        Gdx.app.log(LOG_TAG_MAINMENUSCREEN_RESUME, "Resume called.");
    }

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG_MAINMENUSCREEN_HIDE, "Hide called.");
    }

    @Override
    public void dispose() {
        Gdx.app.log(LOG_TAG_MAINMENUSCREEN_DISPOSE, "Dispose called.");
    }
}

