package co.archeos.games.arcaneassault.entity.ui.bar;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Ajay on 2015-06-25.
 */
public abstract class AbstractBar extends Actor {
    private final static String LOG_TAG_ABSTRACTBAR_ACT = "AbstractBar: ACT";
    private final static String LOG_TAG_ABSTRACTBAR_DRAW = "AbstractBar: DRAW";
    private final static String LOG_TAG_ABSTRACTBAR_RESIZE = "AbstractBar: RESIZE";
    private final static String LOG_TAG_ABSTRACTBAR_PAUSE = "AbstractBar: PAUSE";

    protected TextureAtlas mBarTextureAtlas;

    protected TextureRegion mBarFrame;
    protected TextureRegion mBarFrameBackground;
    protected TextureRegion mBarHidden;

    protected Animation mAnimation;
    protected TextureRegion mCurrentAnimationFrame;

    protected float mStateTime;

    public AbstractBar(TextureAtlas textureAtlas){
        mBarTextureAtlas = textureAtlas;

        mStateTime = 0f;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        mStateTime += delta;
        mCurrentAnimationFrame = mAnimation.getKeyFrame(mStateTime);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
