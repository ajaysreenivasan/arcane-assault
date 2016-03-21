package co.archeos.games.arcaneassault.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import co.archeos.games.arcaneassault.entity.common.Projectile;
import co.archeos.games.arcaneassault.entity.common.Sorcerer;
import co.archeos.games.arcaneassault.utils.GameConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 2015-04-12.
 */
public class GameWorld {
    private final static String LOG_TAG_GAMEWORLD_UPDATE = "GameWorld: UPDATE";

    private final static int MAX_BUTTON_COUNT = GameConstants.GameScreen.HUDStage.HUDSTAGE_BUTTON_COUNT;

    //  mGameWidth = mGscreenWidth / (screenHeight / gameHeight);

    private float mGameHeight;
    private float mGameWidth;

    private Sorcerer mSorcerer;
    public Pool<Projectile> mProjectilePool;
    public List<Projectile> mProjectileList;

    private String[] mHUDButtonList;

    // TODO: Pass in the type of projectile to make a pool with..idk..reflection?

    public GameWorld(float gameHeight, float gameWidth) {
        this.mGameHeight = gameHeight;
        this.mGameWidth = gameWidth;

        this.mSorcerer = new Sorcerer(100, 50, 17, 12);

        this.mProjectilePool = new Pool<Projectile>() {
            @Override
            protected Projectile newObject() {
                return new Projectile(mSorcerer.getXCoord(), mSorcerer.getYCoord(), 10f, 10f);
            }
        };

        this.mProjectileList = new ArrayList<Projectile>();
        this.mHUDButtonList = new String[MAX_BUTTON_COUNT];

        for (int i = 0; i < MAX_BUTTON_COUNT; i++) {
            this.mHUDButtonList[i] = "Button " + i;
        }
    }

    public void update(float delta) {
        Gdx.app.log(LOG_TAG_GAMEWORLD_UPDATE, "Update called.");
        Gdx.app.log(LOG_TAG_GAMEWORLD_UPDATE, "" + mProjectilePool.getFree() + "");

        for (int i = 0; i < mProjectileList.size(); i++) {
            Projectile p = mProjectileList.get(i);
            if (isOffScreen(p)) {
                mProjectilePool.free(p);
                mProjectileList.remove(p);
            }
        }
    }

    private boolean isOffScreen(Projectile projectile) {
        if (projectile.getXCoord() > mGameWidth + projectile.getWidth())
            return true;
        else
            return false;
    }

    public void onButtonPress(int buttonIndex) {
        Gdx.app.log(LOG_TAG_GAMEWORLD_UPDATE, "PRESSED: " + mHUDButtonList[buttonIndex]);

        if (buttonIndex == 0) {
            mSorcerer.onClick();
        } else if (buttonIndex == 1) {
            Projectile p = mProjectilePool.obtain();
            p.setPosition(new Vector2(mSorcerer.getXCoord(), mSorcerer.getYCoord()));
            mProjectileList.add(p);
        }
    }

    public Sorcerer getSorcerer() {
        return mSorcerer;
    }

    public String[] getHUDButtonList() {
        return mHUDButtonList;
    }

    public float getGameHeight(){
        return mGameHeight;
    }

    public float getGameWidth(){
        return mGameWidth;
    }
}
