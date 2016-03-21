package co.archeos.games.arcaneassault;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import co.archeos.games.arcaneassault.model.GameWorld;
import co.archeos.games.arcaneassault.screen.GameScreen;
import co.archeos.games.arcaneassault.screen.LevelSelectScreen;
import co.archeos.games.arcaneassault.screen.LoadingScreen;
import co.archeos.games.arcaneassault.screen.MainMenuScreen;
import co.archeos.games.arcaneassault.screen.SplashScreen;
import co.archeos.games.arcaneassault.utils.AssetManager;

public class ArcaneAssaultGame extends Game {
    private final String LOG_TAG_ARCANEASSAULTGAME_CREATE = "ArcaneAssaultGame: CREATE";
    private final String LOG_TAG_ARCANEASSAULTGAME_DISPOSE = "ArcaneAssaultGame: DISPOSE";

    private static AssetManager mAssetManager;

    private SplashScreen mSplashScreen;
    private LoadingScreen mLoadingScreen;
    private MainMenuScreen mMainMenuScreen;
    private LevelSelectScreen mLevelSelectScreen;
    private GameScreen mGameScreen;

    @Override
    public void create() {
        Gdx.app.log(LOG_TAG_ARCANEASSAULTGAME_CREATE, "Game created.");

        // TODO: Fix AssetManager
        mAssetManager = new AssetManager(this);
        mAssetManager.load();

//        mAssetManager.loadEssentialGameAssets();

        // TODO: Fix the issue where SplashScreen can't be before LoadingScreen because
        // SplashStage needs to pass in the onLoadFinishedRunnable, but the LoadScreen doesn't
        // exist yet.
        mLoadingScreen = new LoadingScreen(this);
        mGameScreen = new GameScreen(this);
        mLevelSelectScreen = new LevelSelectScreen(this);
        mMainMenuScreen = new MainMenuScreen(this);
        mSplashScreen = new SplashScreen(this);
        setScreen(new SplashScreen(this));

/*
        GameWorld gameWorld = new GameWorld(400, 240);

        mGameScreen.setGameWorld(gameWorld);
        mGameScreen.createStages();
        setScreen(mGameScreen);*/
    }

    public void dispose() {
        Gdx.app.log(LOG_TAG_ARCANEASSAULTGAME_DISPOSE, "Game disposed.");

        super.dispose();
        mAssetManager.dispose();
    }

    public SplashScreen getSplashScreen(){
        return mSplashScreen;
    }

    public LoadingScreen getLoadingScreen(){
        return mLoadingScreen;
    }

    public MainMenuScreen getMainMenuScreen(){
        return mMainMenuScreen;
    }

    public LevelSelectScreen getLevelSelectScreen(){
        return mLevelSelectScreen;
    }

    public GameScreen getGameScreen(){
        return mGameScreen;
    }

    public AssetManager getAssetManager(){
        return mAssetManager;
    }
}
