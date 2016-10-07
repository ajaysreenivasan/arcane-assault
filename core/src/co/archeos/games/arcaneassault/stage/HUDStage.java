package co.archeos.games.arcaneassault.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import co.archeos.games.arcaneassault.entity.ui.bar.HealthBar;
import co.archeos.games.arcaneassault.entity.ui.bar.ManaBar;
import co.archeos.games.arcaneassault.model.GameWorld;
import co.archeos.games.arcaneassault.utils.GameConstants;

/**
 * Created by Ajay on 2015-06-03.
 */
public class HUDStage extends AbstractStage {
    private final static int MAX_BUTTON_COUNT = GameConstants.GameScreen.HUDStage.HUDSTAGE_BUTTON_COUNT;

    private GameWorld mGameWorld;

    private OrthographicCamera mGameCamera;

    private SpriteBatch mSpriteBatch;

    private float mScreenHeight;
    private float mScreenWidth;

    private TextButton[] mButtonList;

    private TextureAtlas mHUDStageAtlas;
    private Skin skin;
    private Table table;
    private BitmapFont white, black;

    private HealthBar mHealthBar;
    private ManaBar mManaBar;

    public HUDStage(GameWorld gameWorld, float screenWidth, float screenHeight) {
        mGameWorld = gameWorld;

        mScreenHeight = screenHeight;
        mScreenWidth = screenWidth;

        mGameCamera = new OrthographicCamera();
        mGameCamera.setToOrtho(false, mScreenWidth, mScreenHeight);

        mSpriteBatch = new SpriteBatch();
        mSpriteBatch.setProjectionMatrix(mGameCamera.combined);

        mHUDStageAtlas = new TextureAtlas("ui/button/button.pack");
        skin = new Skin(mHUDStageAtlas);

        table = new Table(skin);
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        table.setFillParent(true);

        white = new BitmapFont(Gdx.files.internal("font/white.fnt"), false);

        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = white;

        table.setFillParent(true);

        this.mButtonList = new TextButton[MAX_BUTTON_COUNT];

        for (int i = 0; i < MAX_BUTTON_COUNT; i++) {
            mButtonList[i] = new TextButton(this.mGameWorld.getHUDButtonList()[i],
                    textButtonStyle);
            mButtonList[i].pad(15f);

            final int j = i;
            mButtonList[i].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    mGameWorld.onButtonPress(j);
                }
            });
            table.add(mButtonList[i]);
        }

        table.pad(2f);

        table.left().bottom();
        addActor(table);
/*
        mHealthBar = new HealthBar();
        mManaBar = new ManaBar();

        addActor(mHealthBar);
        addActor(mManaBar);*/
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        table.act(delta);
    }

}
