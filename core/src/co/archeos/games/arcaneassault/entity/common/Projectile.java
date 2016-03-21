package co.archeos.games.arcaneassault.entity.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import co.archeos.games.arcaneassault.utils.AssetManager;

/**
 * Created by Ajay on 2015-04-13.
 */
public class Projectile extends Actor {
    private float mWidth;
    private float mHeight;
    private float mRotation;

    private Vector2 mPosition;
    private Vector2 mVelocity;
    private Vector2 mAcceleration;

    private TextureRegion mProjectileTexture;

    public Projectile(float xCoord, float yCoord, float width, float height) {
        this.mWidth = width;
        this.mHeight = height;

        this.mPosition = new Vector2(xCoord, yCoord);
        this.mVelocity = new Vector2(150, 0);
        this.mAcceleration = new Vector2(100, 1);

        this.mProjectileTexture = AssetManager.projectile;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.begin();

        batch.draw(mProjectileTexture, this.getXCoord(), this.getYCoord(), this.getWidth(),
                this.getHeight());

        batch.end();
    }

    @Override
    public void act(float delta) {
        Gdx.app.log("PROJECTILELALALALALLAAGAGAGAG", "" + getXCoord() + ", " + getYCoord());
        super.act(delta);
    //    mVelocity.add(mAcceleration.cpy()).scl(delta);
        mPosition.add(mVelocity.cpy().scl(delta));
    }

    public boolean isAccelerating() {
        return mAcceleration.x != 0;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        this.mHeight = height;
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