package co.archeos.games.arcaneassault.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 2015-06-03.
 */
public class Background extends Actor {
    private TextureRegion mBackgroundSkyTexture;
    private TextureRegion mBackgroundGroundTexture;

    float currentBGSkyX, currentBGGroundX;
    long lastTimeBGGround, lastTimeBGSky;

    private List<BackgroundObject> mBackgroundObjectList;

    public Background(TextureRegion backgroundSkyTexture, TextureRegion backgroundGroundTexture) {
        mBackgroundSkyTexture = backgroundSkyTexture;
        mBackgroundGroundTexture = backgroundGroundTexture;
        lastTimeBGGround = TimeUtils.nanoTime();
        lastTimeBGSky = TimeUtils.nanoTime();

        currentBGSkyX = 400;
        currentBGGroundX = 400;

        mBackgroundObjectList = new ArrayList<BackgroundObject>();
    }

    public void addBackgroundObject(BackgroundObject newBGObject){
        mBackgroundObjectList.add(newBGObject);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
         batch.begin();

        for(int i = 0; i < 5; i++){
            batch.draw(mBackgroundSkyTexture, currentBGSkyX * i, 155);
            batch.draw(mBackgroundGroundTexture, currentBGGroundX * i, 0);
        }

        batch.end();

        for(BackgroundObject backgroundObject : mBackgroundObjectList){
            backgroundObject.draw(batch, parentAlpha);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        for(BackgroundObject backgroundObject : mBackgroundObjectList){
            backgroundObject.act(delta);
        }
    }

    @Override
    public boolean fire(Event event) {
        return super.fire(event);
    }

    @Override
    public boolean notify(Event event, boolean capture) {
        return super.notify(event, capture);
    }
}
