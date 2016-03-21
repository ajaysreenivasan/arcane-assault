package co.archeos.games.arcaneassault.entity.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import co.archeos.games.arcaneassault.utils.AssetManager;

/**
 * Created by Ajay on 2015-04-12.
 */
public class Sorcerer extends Actor {
    private float mRotation;

    private Vector2 mPosition;
    private Vector2 mVelocity;
    private Vector2 mAcceleration;

    private Animation mStarCraftAnimation;
    private TextureRegion mStarCraftBlue, mStarCraftYellow, mStarCraftRed;

    private float mStateTime;

    public Sorcerer(float xCoord, float yCoord, int width, int height) {
        mPosition = new Vector2(xCoord, yCoord);
        setPosition(xCoord, yCoord);
        setWidth(width);
        setHeight(height);
        mVelocity = new Vector2(0, 0);
        mAcceleration = new Vector2(0, 0);

        mStateTime = 0;

        mStarCraftBlue = AssetManager.starCraftBlue;
        mStarCraftYellow = AssetManager.starCraftYellow;
        mStarCraftRed = AssetManager.starCraftRed;
        mStarCraftAnimation = AssetManager.starCraftAnimation;
    }

    public void onClick() {
        mVelocity.x = 50;
        mAcceleration.x = -2;
    }

    public boolean isAccelerating() {
        return mAcceleration.x != 0;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Gdx.app.log("SORCERER_DRAW_TAG", "DRAWING SORC");

        if (this.isAccelerating()) {
            batch.draw(mStarCraftRed,
                    this.getXCoord(), this.getYCoord(), this.getWidth(),
                    this.getHeight());
        } else {
            batch.draw(mStarCraftAnimation.getKeyFrame(mStateTime),
                    this.getXCoord(), this.getYCoord(), this.getWidth(),
                    this.getHeight());
        }

    }

    @Override
    public void act(float delta) {
        Gdx.app.log("HOHOHOHOHOH", "SIGH -_-");
        super.act(delta);

        mVelocity.add(mAcceleration.cpy().scl(delta));

        if (mVelocity.x > 700) {
            mVelocity.x = 700;
        }

        if (mVelocity.x < 0) {
            mVelocity.x = 0;
            mAcceleration.x = 0;
        }

        mStateTime += delta;

        mPosition.add(mVelocity.cpy().scl(delta));
    }

    @Override
    public boolean fire(Event event) {
        return super.fire(event);
    }

    public float getRotation() {
        return mRotation;
    }

    public void setRotation(float rotation) {
        this.mRotation = rotation;
    }

    public Vector2 getPosition() {
        return mPosition;
    }

    public void setPosition(Vector2 position) {
        this.mPosition = position;
    }

    public float getXCoord() {
        return this.mPosition.x;
    }

    public float getYCoord() {
        return this.mPosition.y;
    }

    public Vector2 getVelocity() {
        return mVelocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.mVelocity = velocity;
    }

    public Vector2 getAcceleration() {
        return mAcceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.mAcceleration = acceleration;
    }
}
