package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.stage.LoadingStage;
import co.archeos.games.arcaneassault.utils.GameRunnable;

/**
 * Created by Ajay on 2015-06-22.
 */
public class LoadingScreen implements Screen {
    private final static String LOG_TAG_LOADINGSCREEN_SHOW = "LoadingScreen: SHOW";
    private final static String LOG_TAG_LOADINGSCREEN_RENDER = "LoadingScreen: RENDER";
    private final static String LOG_TAG_LOADINGSCREEN_RESIZE = "LoadingScreen: RESIZE";
    private final static String LOG_TAG_LOADINGSCREEN_PAUSE = "LoadingScreen: PAUSE";
    private final static String LOG_TAG_LOADINGSCREEN_RESUME = "LoadingScreen: RESUME";
    private final static String LOG_TAG_LOADINGSCREEN_HIDE = "LoadingScreen: HIDE";
    private final static String LOG_TAG_LOADINGSCREEN_DISPOSE = "LoadingScreen: DISPOSE";

    private ArcaneAssaultGame mArcaneAssaultGame;

    private LoadingStage mLoadingStage;

    // TODO: Get Original Loading Pack
    // TODO: Randomized loading screen backgrounds
    public LoadingScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mArcaneAssaultGame.getAssetManager().loadLoadingScreenResources();
        mLoadingStage = new LoadingStage(mArcaneAssaultGame);
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_LOADINGSCREEN_SHOW, "Show called.");
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_LOADINGSCREEN_RENDER, "Render called.");

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

         // show the loading screen
        mLoadingStage.act(delta);
        mLoadingStage.getViewport().apply();
        mLoadingStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG_LOADINGSCREEN_RESIZE, "Resize called.");

        mLoadingStage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {
        Gdx.app.log(LOG_TAG_LOADINGSCREEN_PAUSE, "Pause called.");

    }

    @Override
    public void resume() {
        Gdx.app.log(LOG_TAG_LOADINGSCREEN_RESUME, "Resume called.");

    }

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG_LOADINGSCREEN_HIDE, "Hide called.");
   }

    @Override
    public void dispose() {
        Gdx.app.log(LOG_TAG_LOADINGSCREEN_DISPOSE, "Dispose called.");
    }

    public void loadScreen(Class<? extends Screen> screenType) {
        if(screenType.equals(GameScreen.class)){

        }
   }

    public void setLoadingRunnable(GameRunnable loadingRunnable){
        mLoadingStage.setLoadingRunnable(loadingRunnable);
    }

    public void setOnLoadFinishedRunnable(GameRunnable onLoadFinishedRunnable) {
        mLoadingStage.setOnLoadFinishedRunnable(onLoadFinishedRunnable);
    }
}
