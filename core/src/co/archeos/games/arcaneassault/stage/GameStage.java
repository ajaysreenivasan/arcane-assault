package co.archeos.games.arcaneassault.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import co.archeos.games.arcaneassault.entity.common.Projectile;
import co.archeos.games.arcaneassault.entity.common.Sorcerer;
import co.archeos.games.arcaneassault.entity.ui.bar.LoadingBar;
import co.archeos.games.arcaneassault.environment.Background;
import co.archeos.games.arcaneassault.environment.BackgroundObject;
import co.archeos.games.arcaneassault.model.GameWorld;
import co.archeos.games.arcaneassault.utils.AssetManager;
import co.archeos.games.arcaneassault.utils.GameConstants;
import com.uwsoft.editor.renderer.Overlap2DStage;

/**
 * Created by Ajay on 2015-06-03.
 */
public class GameStage extends Overlap2DStage {
    private final static String LOG_TAG_GAMESTAGE_ACT = "GameStage: ACT";
    private final static String LOG_TAG_GAMESTAGE_DRAW = "GameStage: DRAW";
    private final static String LOG_TAG_GAMESTAGE_RESIZE = "GameStage: RESIZE";
    private final static String LOG_TAG_GAMESTAGE_PAUSE = "GameStage: PAUSE";
    private final static String LOG_TAG_GAMESTAGE_RESUME = "GameStage: RESUME";
    private final static String LOG_TAG_GAMESTAGE_HIDE = "GameStage: HIDE";
    private final static String LOG_TAG_GAMESTAGE_DISPOSE = "GameStage: DISPOSE";

    private final static float GAMESTAGE_VIEWPORT_WIDTH = GameConstants.GameScreen.GameStage
            .GAMESTAGE_VIEWPORT_WIDTH;
    private final float GAMESTAGE_VIEWPORT_HEIGHT = GameConstants.GameScreen.GameStage
            .GAMESTAGE_VIEWPORT_HEIGHT;
    private final float HUDSTAGE_BUTTON_ARRAY_HEIGHT = GameConstants.GameScreen.HUDStage
            .HUDSTAGE_BUTTON_ARRAY_HEIGHT;

    private GameWorld mGameWorld;
    private Background mBackground;

    private Sorcerer mSorcerer;

    private OrthographicCamera mGameCamera;

    private SpriteBatch mSpriteBatch;

    private float mScreenHeight;
    private float mScreenWidth;

    LoadingBar mLoadingBar;

    public GameStage(GameWorld gameWorld, float screenWidth, float screenHeight) {
        mGameWorld = gameWorld;

        mScreenHeight = screenHeight;
        mScreenWidth = screenWidth;

        mGameCamera = new OrthographicCamera();
        mGameCamera.setToOrtho(false, GAMESTAGE_VIEWPORT_WIDTH, GAMESTAGE_VIEWPORT_HEIGHT);
        mGameCamera.translate(0, -HUDSTAGE_BUTTON_ARRAY_HEIGHT);

        mSpriteBatch = new SpriteBatch();
        mSpriteBatch = (SpriteBatch) getBatch();
        mSpriteBatch.setProjectionMatrix(mGameCamera.combined);

        initializeGameAssets();
        initializeGameObjects();

        addActor(mSorcerer);
    }

    private void initializeGameObjects() {
        mSorcerer = mGameWorld.getSorcerer();
    }

    private void initializeGameAssets() {
        mBackground = new Background(AssetManager.backgroundSky, AssetManager.backgroundGround);

        for (int i = 0; i < 50; i++) {
            mBackground.addBackgroundObject(new BackgroundObject(50 + 50 * i, 150, 0f, 0f, "hi"));
        }
    }

    @Override
    public void act(float delta) {
        Gdx.app.log(LOG_TAG_GAMESTAGE_ACT, "Act called.");

        mBackground.act(delta);

        for (Projectile p : mGameWorld.mProjectileList) {
            p.act(delta);
        }
        mSorcerer.act(delta);
        panCamera(mSorcerer.getXCoord());
        mGameWorld.update(delta);
    }

    @Override
    public void draw() {
        super.draw();

        Gdx.app.log(LOG_TAG_GAMESTAGE_DRAW, "Draw called.");

//        mSpriteBatch.setProjectionMatrix(mGameCamera.combined);
//
//        mBackground.draw(mSpriteBatch, 1);
//
//        for (Projectile p : mGameWorld.mProjectileList) {
//            p.draw(mSpriteBatch, 1);
//        }


        //    mGameWorld.getSorcerer().draw(getBatch(), 1);
    }

    // TODO: Move this somewhere appropriate and fix the calculations
    public void panCamera(float x) {

        mGameCamera.position.set(x + 150, mGameCamera.position.y, 0);
        mGameCamera.update();
    }
}
