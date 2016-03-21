package co.archeos.games.arcaneassault.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.entity.ui.bar.LoadingBar;
import co.archeos.games.arcaneassault.utils.GameConstants;
import co.archeos.games.arcaneassault.utils.GameRunnable;

/**
 * Created by Ajay on 2015-06-25.
 */
public class LoadingStage extends Stage {
    private final static String LOG_TAG_LOADINGSTAGE_ACT = "LoadingStage: ACT";
    private final static String LOG_TAG_LOADINGSTAGE_DRAW = "LoadingStage: DRAW";
    private final static String LOG_TAG_LOADINGSTAGE_RESIZE = "LoadingStage: RESIZE";
    private final static String LOG_TAG_LOADINGSTAGE_PAUSE = "LoadingStage: PAUSE";
    private final static String LOG_TAG_LOADINGSTAGE_RESUME = "LoadingStage: RESUME";
    private final static String LOG_TAG_LOADINGSTAGE_HIDE = "LoadingStage: HIDE";
    private final static String LOG_TAG_LOADINGSTAGE_DISPOSE = "LoadingStage: DISPOSE";

    private ArcaneAssaultGame mArcaneAssaultGame;

    private GameRunnable mLoadingRunnable = null;
    private GameRunnable mOnLoadFinishedRunnable = null;

    private boolean mIsInitializeGameLoad = true;

    private TextureAtlas mLoadingScreenAtlas;
    //    private TextureRegion mLoadingScreenBackground;
    private Image mLoadingScreenBackground;

    private LoadingBar mLoadingBar;

    // TODO: Replace the Image loading bar and all that junk with the correct stuff
    public LoadingStage(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mLoadingScreenAtlas = mArcaneAssaultGame.getAssetManager().get(GameConstants.LoadingScreen.PACK_LOCATION, TextureAtlas.class);

        mLoadingBar = new LoadingBar(mLoadingScreenAtlas, mArcaneAssaultGame.getAssetManager());
//        mLoadingScreenBackground = new TextureRegion(mLoadingScreenAtlas.findRegion(GameConstants
//                .LoadingScreen.LOADING_SCREEN_BACKGROUND));

        mLoadingScreenBackground = new Image(mLoadingScreenAtlas.findRegion(GameConstants
                .LoadingScreen.LOADING_SCREEN_BACKGROUND));

        getBatch().setProjectionMatrix(getCamera().combined);

        addActor(mLoadingScreenBackground);
        addActor(mLoadingBar);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        mLoadingScreenBackground.setSize(width, height);
        mLoadingBar.setPosition(width / 4, height / 4);

        if(mLoadingRunnable != null && !mLoadingRunnable.isRunning()) {
            mLoadingRunnable.setIsRunning(true);
            mLoadingRunnable.run();
        }

        Gdx.app.log(LOG_TAG_LOADINGSTAGE_ACT, "" + mArcaneAssaultGame.getAssetManager().getProgress());

        // if loading is complete, touch the screen to move to the next screen
        // TODO: Once loading is finished, replace with "TOUCH TO BEGIN" message
        if (mArcaneAssaultGame.getAssetManager().update()) {
            if (Gdx.input.isTouched()) {
                mLoadingBar.reset();

                if (mOnLoadFinishedRunnable != null) {
                    mOnLoadFinishedRunnable.run();
                }
            }
        }
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void setLoadingRunnable(GameRunnable loadingRunnable) {
        mLoadingRunnable = loadingRunnable;
    }

    public void setOnLoadFinishedRunnable(GameRunnable onLoadFinishedRunnable) {
        mOnLoadFinishedRunnable = onLoadFinishedRunnable;
    }
}
