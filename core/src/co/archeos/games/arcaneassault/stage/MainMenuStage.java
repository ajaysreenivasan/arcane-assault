package co.archeos.games.arcaneassault.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.model.GameWorld;
import co.archeos.games.arcaneassault.utils.GameConstants;

/**
 * Created by Ajay on 2015-06-25.
 */
public class MainMenuStage extends AbstractStage {
    private TextureAtlas mMainMenuStageAtlas;

    private Skin mMainMenuStageSkin;

    private OrthographicCamera mMenuCamera;

    private float mScreenWidth;
    private float mScreenHeight;

    private Table mMenuTable;
    private TextButton mPlayButton; // TODO: Change to button that can be skinned.
    private TextButton mOptionsButton;
    private TextButton mHelpButton;
    private TextButton mAboutButton;


    public MainMenuStage(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        setDebugAll(true);
    }

    public void createStage() {
        mMainMenuStageSkin = new Skin(mArcaneAssaultGame.getAssetManager().get(GameConstants
                .UI.Button.PACK_LOCATION, TextureAtlas.class));

        mScreenWidth = Gdx.graphics.getWidth();
        mScreenHeight = Gdx.graphics.getHeight();

        mMenuCamera = new OrthographicCamera();
        mMenuCamera.setToOrtho(false, mScreenWidth, mScreenHeight);

        mMenuTable = new Table(mMainMenuStageSkin);
        mMenuTable.setSize(mScreenWidth, mScreenHeight);
        mMenuTable.setBounds(0, 0, mScreenWidth, mScreenHeight);
        mMenuTable.setFillParent(true);
        mMenuTable.defaults().space(50);

        BitmapFont black = mArcaneAssaultGame.getAssetManager().get(GameConstants
                .General.BLACK_FONT_PACK_LOCATION, BitmapFont.class);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = mMainMenuStageSkin.getDrawable("button_up");
        textButtonStyle.down = mMainMenuStageSkin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;

        mPlayButton = new TextButton(GameConstants.MainMenuScreen.MainMenuStage.BUTTON_TEXT_PLAY,
                textButtonStyle);
        mPlayButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                mArcaneAssaultGame.setScreen(mArcaneAssaultGame.getLevelSelectScreen());
            }
        });
        mMenuTable.add(mPlayButton);

        mMenuTable.row();

        mOptionsButton = new TextButton(GameConstants.MainMenuScreen.MainMenuStage.BUTTON_TEXT_OPTIONS, textButtonStyle);
        mOptionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log(LOG_TAG_STAGE_ACT, "OPTIONS PRESSED");
            }
        });
        mMenuTable.add(mOptionsButton);

        mMenuTable.row();

        mHelpButton = new TextButton(GameConstants.MainMenuScreen.MainMenuStage.BUTTON_TEXT_HELP,
                textButtonStyle);
        mHelpButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GameWorld gameWorld = new GameWorld(400, 240);
                mArcaneAssaultGame.getGameScreen().setGameWorld(gameWorld);
                mArcaneAssaultGame.getGameScreen().createStages();
                mArcaneAssaultGame.setScreen(mArcaneAssaultGame.getGameScreen());
            }
        });
        mMenuTable.add(mHelpButton);

        mMenuTable.row();

        mAboutButton = new TextButton(GameConstants.MainMenuScreen.MainMenuStage.BUTTON_TEXT_ABOUT, textButtonStyle);
        mAboutButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GameWorld gameWorld = new GameWorld(400, 240);
                mArcaneAssaultGame.getGameScreen().setGameWorld(gameWorld);
                mArcaneAssaultGame.getGameScreen().createStages();
                mArcaneAssaultGame.setScreen(mArcaneAssaultGame.getGameScreen());
            }
        });
        mMenuTable.add(mAboutButton);

        addActor(mMenuTable);

        mArcaneAssaultGame.getAssetManager().get(GameConstants.MainMenuScreen.BACKGROUND_MUSIC,
                Sound.class).loop();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        mMenuTable.act(delta);
    }
}


