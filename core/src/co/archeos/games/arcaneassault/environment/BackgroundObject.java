package co.archeos.games.arcaneassault.environment;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import co.archeos.games.arcaneassault.utils.AssetManager;

/**
 * Created by Ajay on 2015-06-22.
 */
public class BackgroundObject extends Actor {
    private TextureRegion mTextureRegion;

    public BackgroundObject(float xCoord, float yCoord, float height, float width, String
            textureRegion) {
        setPosition(xCoord, yCoord);
        setHeight(height);
        setWidth(width);

        mTextureRegion = AssetManager.tree;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.begin();
        batch.draw(mTextureRegion, getX(), getY());
        batch.end();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
