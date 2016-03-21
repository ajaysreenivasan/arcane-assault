package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.stage.LevelSelectStage;

/**
 * Created by Ajay on 2015-06-25.
 */
public class LevelSelectScreen implements Screen {
    private final static String LOG_TAG_LEVELSELECTSCREEN_SHOW = "LevelSelectScreen: SHOW";
    private final static String LOG_TAG_LEVELSELECTSCREEN_RENDER = "LevelSelectScreen: RENDER";
    private final static String LOG_TAG_LEVELSELECTSCREEN_RESIZE = "LevelSelectScreen: RESIZE";
    private final static String LOG_TAG_LEVELSELECTSCREEN_PAUSE = "LevelSelectScreen: PAUSE";
    private final static String LOG_TAG_LEVELSELECTSCREEN_RESUME = "LevelSelectScreen: RESUME";
    private final static String LOG_TAG_LEVELSELECTSCREEN_HIDE = "LevelSelectScreen: HIDE";
    private final static String LOG_TAG_LEVELSELECTSCREEN_DISPOSE = "LevelSelectScreen: DISPOSE";

    private ArcaneAssaultGame mArcaneAssaultGame;

    private LevelSelectStage mLevelSelectStage;

    public LevelSelectScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mLevelSelectStage = new LevelSelectStage(arcaneAssaultGame);
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_LEVELSELECTSCREEN_SHOW, "Show called.");

        mLevelSelectStage.createStage();

        Gdx.input.setInputProcessor(mLevelSelectStage);
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_LEVELSELECTSCREEN_RENDER, "Render called.");

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mLevelSelectStage.act(delta);
        mLevelSelectStage.getViewport().apply();
        mLevelSelectStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG_LEVELSELECTSCREEN_RESIZE, "Resize called.");

        mLevelSelectStage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {
        Gdx.app.log(LOG_TAG_LEVELSELECTSCREEN_PAUSE, "Pause called.");
    }

    @Override
    public void resume() {
        Gdx.app.log(LOG_TAG_LEVELSELECTSCREEN_RESUME, "Resume called.");
    }

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG_LEVELSELECTSCREEN_HIDE, "Hide called.");
    }

    @Override
    public void dispose() {
        Gdx.app.log(LOG_TAG_LEVELSELECTSCREEN_DISPOSE, "Dispose called.");
    }
}

