package co.archeos.games.arcaneassault.screen;

import com.badlogic.gdx.Screen;

import java.lang.reflect.InvocationTargetException;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.stage.LoadingStage;
import co.archeos.games.arcaneassault.utils.GameRunnable;

/**
 * Created by Ajay on 2015-06-22.
 */
public class LoadingScreen extends AbstractScreen {
    private final String METHOD_SETLOADINGRUNNABLE = "setLoadingRunnable";
    private final String METHOD_SETONLOADFINISHEDRUNNABLE = "setOnLoadFinishedRunnable";

    // TODO: Get Original Loading Pack
    // TODO: Randomized loading screen backgrounds
    public LoadingScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mArcaneAssaultGame.getAssetManager().loadLoadingScreenResources();
        mScreenStage = new LoadingStage(mArcaneAssaultGame);
    }

    public void loadScreen(Class<? extends Screen> screenType) {
        if (screenType.equals(GameScreen.class)) {

        }
    }

    public void setLoadingRunnable(GameRunnable loadingRunnable) {
        try {
            mScreenStage.getClass().getMethod(METHOD_SETLOADINGRUNNABLE, GameRunnable.class).invoke(mScreenStage, loadingRunnable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void setOnLoadFinishedRunnable(GameRunnable onLoadFinishedRunnable) {
        try {
            mScreenStage.getClass().getMethod(METHOD_SETONLOADFINISHEDRUNNABLE, GameRunnable.class).invoke(mScreenStage, onLoadFinishedRunnable);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
