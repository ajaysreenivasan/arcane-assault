package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.model.GameWorld;
import co.archeos.games.arcaneassault.stage.GameStage;
import co.archeos.games.arcaneassault.stage.HUDStage;
import co.archeos.games.arcaneassault.utils.GameConstants;

/**
 * Created by Ajay on 2015-04-12.
 */
public class GameScreen implements Screen {
    private final static String LOG_TAG_GAMESCREEN_SHOW = "GameScreen: SHOW";
    private final static String LOG_TAG_GAMESCREEN_RENDER = "GameScreen: RENDER";
    private final static String LOG_TAG_GAMESCREEN_RESIZE = "GameScreen: RESIZE";
    private final static String LOG_TAG_GAMESCREEN_PAUSE = "GameScreen: PAUSE";
    private final static String LOG_TAG_GAMESCREEN_RESUME = "GameScreen: RESUME";
    private final static String LOG_TAG_GAMESCREEN_HIDE = "GameScreen: HIDE";
    private final static String LOG_TAG_GAMESCREEN_DISPOSE = "GameScreen: DISPOSE";

    private ArcaneAssaultGame mArcaneAssaultGame;

    private GameWorld mGameWorld;

    private GameStage mGameStage;
    private HUDStage mHUDStage;

    private float mScreenWidth;
    private float mScreenHeight;
    private float mGameWidth;
    private float mGameHeight;

    enum GameState {
        PLAY, PAUSE
    }

    private GameState mGameState;
    private float mRunTime = 0;

    public GameScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_GAMESCREEN_SHOW, "Show called.");

        this.mGameState = GameState.PLAY;
        mArcaneAssaultGame.getAssetManager().get(GameConstants.GameScreen.BACKGROUND_MUSIC,
                Sound.class).loop();
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_GAMESCREEN_RENDER, "Render called.");

        mRunTime += delta;

        mHUDStage.act(delta);
        mGameStage.act(delta);

        mGameStage.getViewport().apply();
        mGameStage.draw();
        mHUDStage.getViewport().apply();
        mHUDStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG_GAMESCREEN_RESIZE, "Resize called.");

        mGameStage.getViewport().update(width, height, false);
        mHUDStage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {
        Gdx.app.log(LOG_TAG_GAMESCREEN_PAUSE, "Pause called.");

        mGameState = GameState.PAUSE;
    }

    @Override
    public void resume() {
        Gdx.app.log(LOG_TAG_GAMESCREEN_RESUME, "Resume called.");

        mGameState = GameState.PLAY;
    }

    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG_GAMESCREEN_HIDE, "Hide called.");
    }

    @Override
    public void dispose() {
        Gdx.app.log(LOG_TAG_GAMESCREEN_DISPOSE, "Dispose called.");
    }

    public void setGameWorld(GameWorld gameWorld){
        mGameWorld = gameWorld;

        mScreenWidth = Gdx.graphics.getWidth();
        mScreenHeight = Gdx.graphics.getHeight();
        mGameWidth = gameWorld.getGameWidth();
        mGameHeight = gameWorld.getGameHeight();
    }

    public void createStages(){
        mGameStage = new GameStage(mGameWorld, mScreenWidth, mScreenHeight);
        mHUDStage = new HUDStage(mGameWorld, mScreenWidth, mScreenHeight);


        // TODO: Should be an input multiplexer here
        Gdx.input.setInputProcessor(mHUDStage);
    }

    public float getRuntime() {
        return mRunTime;
    }
}
