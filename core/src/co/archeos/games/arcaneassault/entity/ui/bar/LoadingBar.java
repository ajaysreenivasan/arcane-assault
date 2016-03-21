package co.archeos.games.arcaneassault.entity.ui.bar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import co.archeos.games.arcaneassault.utils.AssetManager;
import co.archeos.games.arcaneassault.utils.GameConstants;

/**
 * Created by Ajay on 2015-06-24.
 */
public class LoadingBar extends AbstractBar {
    private final static String LOG_TAG_LOADINGBAR_ACT = "LoadingBar: ACT";
    private final static String LOG_TAG_LOADINGBAR_DRAW = "LoadingBar: DRAW";
    private final static String LOG_TAG_LOADINGBAR_RESIZE = "LoadingBar: RESIZE";
    private final static String LOG_TAG_LOADINGBAR_PAUSE = "LoadingBar: PAUSE";


    private float mPercentLoaded;
    private float mBarStartX = 0f;
    private float mBarEndX = 0f;

    private AssetManager mAssetManager;

    float mCurrentAnimationFrameX, mCurrentAnimationFrameY;
    float mBarFrameX, mBarFrameY;
    float mBarHiddenX, mBarHiddenY;
    float mBarFrameBackgroundX, mBarFrameBackgroundY, mBarFrameBackgroundWidth,
            mBarFrameBackgroundHeight;

    public LoadingBar(TextureAtlas textureAtlas, AssetManager assetManager) {
        super(textureAtlas);
        mAssetManager = assetManager;

        mPercentLoaded = 0f;

        mBarFrame = new TextureRegion(mBarTextureAtlas.findRegion(GameConstants.UI.LoadingBar.FRAME));
        mBarFrameBackground = new TextureRegion(mBarTextureAtlas.findRegion(GameConstants.UI.LoadingBar.FRAME_BACKGROUND));
        mBarHidden = new TextureRegion(mBarTextureAtlas.findRegion(GameConstants.UI.LoadingBar.HIDDEN));

        mAnimation = new Animation(0.05f, mBarTextureAtlas.findRegions(GameConstants.UI.LoadingBar
                .ANIMATION));
        mAnimation.setPlayMode(Animation.PlayMode.LOOP_REVERSED);
        mCurrentAnimationFrame = mAnimation.getKeyFrame(0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        mPercentLoaded = Interpolation.linear.apply(mPercentLoaded, mAssetManager.getProgress(), 0.1f);

        mBarStartX = getX();
        mBarEndX = mBarStartX + 440;

        mBarHiddenX = mBarStartX + 500 * mPercentLoaded;
        mBarHiddenY = getY() + 3;

        mBarFrameX = getX();
        mBarFrameY = getY();

        mBarFrameBackgroundX = mBarHiddenX + 30;
        mBarFrameBackgroundY = mBarHiddenY + 1;
        mBarFrameBackgroundWidth = 490 * (1 - mPercentLoaded);
        mBarFrameBackgroundHeight = 50;

        mCurrentAnimationFrameX = getX() + 15;
        mCurrentAnimationFrameY = getY() + 5;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        Gdx.app.log(LOG_TAG_LOADINGBAR_DRAW, "StateTime: " + mStateTime);

        batch.draw(mCurrentAnimationFrame, mCurrentAnimationFrameX, mCurrentAnimationFrameY);
        batch.draw(mBarFrameBackground, mBarFrameBackgroundX, mBarFrameBackgroundY,
                mBarFrameBackgroundWidth, mBarFrameBackgroundHeight);
        batch.draw(mBarHidden, mBarHiddenX, mBarHiddenY);
        batch.draw(mBarFrame, mBarFrameX, mBarFrameY);
    }

    public void reset() {
        mPercentLoaded = 0f;
        mStateTime = 0f;
    }
}
