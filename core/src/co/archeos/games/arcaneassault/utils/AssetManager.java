package co.archeos.games.arcaneassault.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;

/**
 * Created by Ajay on 2015-04-12.
 */
// TODO: Replace this with the libgdx AssetManager

public class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    private ArcaneAssaultGame mArcaneAssaultGame;

    public AssetManager(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;
    }

    public void loadEssentialGameAssets() {
        loadMainMenuScreenResources();
        loadLevelSelectScreenResources();
        loadGameScreenResources();
    }

    public void loadSplashScreenResources() {
        mArcaneAssaultGame.getAssetManager().load(GameConstants.SplashScreen.PACK_LOCATION,
                TextureAtlas.class);

        mArcaneAssaultGame.getAssetManager().finishLoading();
    }

    public void disposeSplashScreenResources() {
        mArcaneAssaultGame.getAssetManager().unload(GameConstants.SplashScreen.PACK_LOCATION);
    }

    public void loadLoadingScreenResources() {
        mArcaneAssaultGame.getAssetManager().load(GameConstants.LoadingScreen.PACK_LOCATION,
                TextureAtlas.class);
        mArcaneAssaultGame.getAssetManager().load(GameConstants.UI.LoadingBar.PACK_LOCATION,
                TextureAtlas.class);

        mArcaneAssaultGame.getAssetManager().finishLoading();
    }

    public void disposeLoadingScreenResources() {
        mArcaneAssaultGame.getAssetManager().unload(GameConstants.LoadingScreen.PACK_LOCATION);
    }

    public void loadMainMenuScreenResources() {
        mArcaneAssaultGame.getAssetManager().load(GameConstants.General.BLACK_FONT_PACK_LOCATION,
                BitmapFont.class);
        mArcaneAssaultGame.getAssetManager().load(GameConstants.UI.Button.PACK_LOCATION,
                TextureAtlas.class);
        mArcaneAssaultGame.getAssetManager().load(GameConstants.MainMenuScreen.BACKGROUND_MUSIC,
                Sound.class);
    }

    public void disposeMainMenuScreenResources() {
        mArcaneAssaultGame.getAssetManager().unload(GameConstants.LoadingScreen.PACK_LOCATION);
    }

    public void loadLevelSelectScreenResources() {


    }

    public void disposeLevelSelectScreenResources() {

    }

    public void loadGameScreenResources() {
        mArcaneAssaultGame.getAssetManager().load(GameConstants.GameScreen.BACKGROUND_MUSIC,
                Sound.class);
    }

    public void disposeGameScreenResources() {

    }

    public static Texture mTexture;
    public static TextureRegion backgroundSky, backgroundGround;

    public static Animation starCraftAnimation;
    public static TextureRegion starCraftBlue, starCraftRed, starCraftYellow;
    public static TextureRegion fireButton, fireButtonPressed, projectile;
    public static TextureRegion tree;

    public void load() {
        mTexture = new Texture(Gdx.files.internal("texture.png"));
        mTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        backgroundSky = new TextureRegion(mTexture, 0, 0, 400, 85);
        backgroundSky.flip(false, false);

        backgroundGround = new TextureRegion(mTexture, 0, 85, 400, 155);
        backgroundGround.flip(false, false);

        starCraftBlue = new TextureRegion(mTexture, 400, 0, 65, 36);
        starCraftBlue.flip(false, false);

        starCraftRed = new TextureRegion(mTexture, 465, 0, 65, 36);
        starCraftRed.flip(false, false);

        starCraftYellow = new TextureRegion(mTexture, 530, 0, 65, 36);
        starCraftYellow.flip(false, false);

        fireButton = new TextureRegion(mTexture, 615, 0, 90, 55);
        fireButtonPressed = new TextureRegion(mTexture, 615, 60, 90, 55);
        projectile = new TextureRegion(mTexture, 720, 0, 44, 44);

        tree = new TextureRegion(mTexture, 768, 0, 45, 90);
        tree.flip(false, false);

        TextureRegion[] starCraftFrames = {starCraftBlue, starCraftRed, starCraftYellow};
        starCraftAnimation = new Animation(0.6f, starCraftFrames);
        starCraftAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public void dispose() {
        mTexture.dispose();
    }
}
