package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.stage.AbstractStage;

/**
 * Created by Ajay on 2015-06-24.
 */
public abstract  class AbstractScreen implements Screen {
    protected final String LOG_TAG_SCREEN_SHOW = this.getClass().getSimpleName() + ": SHOW";
    protected final String LOG_TAG_SCREEN_RENDER = this.getClass().getSimpleName() + ": RENDER";
    protected final String LOG_TAG_SCREEN_RESIZE = this.getClass().getSimpleName() + ": RESIZE";
    protected final String LOG_TAG_SCREEN_PAUSE = this.getClass().getSimpleName() + ": PAUSE";
    protected final String LOG_TAG_SCREEN_RESUME = this.getClass().getSimpleName() + ": RESUME";
    protected final String LOG_TAG_SCREEN_HIDE = this.getClass().getSimpleName() + ": HIDE";
    protected final String LOG_TAG_SCREEN_DISPOSE = this.getClass().getSimpleName() + ": DISPOSE";

    protected ArcaneAssaultGame mArcaneAssaultGame;
    protected AbstractStage mScreenStage;

    protected float mScreenWidth;
    protected float mScreenHeight;

    public AbstractScreen(){

    }

    public AbstractScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_SCREEN_SHOW, "Show called.");

        mScreenStage.createStage();

        Gdx.input.setInputProcessor(mScreenStage);
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_SCREEN_RENDER, "Render called.");

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mScreenStage.act(delta);
        mScreenStage.getViewport().apply();
        mScreenStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG_SCREEN_RESIZE, "Resize called.");

        mScreenStage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {
        Gdx.app.log(LOG_TAG_SCREEN_PAUSE, "Pause called.");
    }

    @Override
    public void resume() {
        Gdx.app.log(LOG_TAG_SCREEN_RESUME, "Resume called.");
    }

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG_SCREEN_HIDE, "Hide called.");
    }

    @Override
    public void dispose() {
        Gdx.app.log(LOG_TAG_SCREEN_DISPOSE, "Dispose called.");

        mScreenStage.dispose();
    }
}
