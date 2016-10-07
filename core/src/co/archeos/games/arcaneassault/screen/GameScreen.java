package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.model.GameWorld;
import co.archeos.games.arcaneassault.stage.GameStage;
import co.archeos.games.arcaneassault.stage.HUDStage;
import co.archeos.games.arcaneassault.utils.GameConstants;

/**
 * Created by Ajay on 2015-04-12.
 */
public class GameScreen extends AbstractScreen {
    private GameWorld mGameWorld;

    private GameStage mGameStage;
    private HUDStage mHUDStage;
    private float mGameWidth;
    private float mGameHeight;

    enum GameState {
        PLAY, PAUSE
    }

    private GameState mGameState;
    private float mRunTime;

    public GameScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;
        mRunTime = 0;
    }

    @Override
    public void show() {
        Gdx.app.log(LOG_TAG_SCREEN_SHOW, "Show called.");

        this.mGameState = GameState.PLAY;
        mArcaneAssaultGame.getAssetManager().get(GameConstants.GameScreen.BACKGROUND_MUSIC,
                Sound.class).loop();
    }

    @Override
    public void render(float delta) {
        Gdx.app.log(LOG_TAG_SCREEN_RENDER, "Render called.");

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
        Gdx.app.log(LOG_TAG_SCREEN_RESIZE, "Resize called.");

        mGameStage.getViewport().update(width, height, false);
        mHUDStage.getViewport().update(width, height, false);
    }

    @Override
    public void pause() {
        super.pause();

        mGameState = GameState.PAUSE;
    }

    @Override
    public void resume() {
        super.resume();

        mGameState = GameState.PLAY;
    }

    public void setGameWorld(GameWorld gameWorld) {
        mGameWorld = gameWorld;

        mScreenWidth = Gdx.graphics.getWidth();
        mScreenHeight = Gdx.graphics.getHeight();
        mGameWidth = gameWorld.getGameWidth();
        mGameHeight = gameWorld.getGameHeight();
    }

    public void createStages() {
        mGameStage = new GameStage(mGameWorld, mScreenWidth, mScreenHeight);
        mHUDStage = new HUDStage(mGameWorld, mScreenWidth, mScreenHeight);

        // TODO: Should be an input multiplexer here
        Gdx.input.setInputProcessor(mHUDStage);
    }

    public float getRuntime() {
        return mRunTime;
    }
}
