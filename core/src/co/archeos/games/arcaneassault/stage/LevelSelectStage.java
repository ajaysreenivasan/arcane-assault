package co.archeos.games.arcaneassault.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.entity.ui.GameButton;
import co.archeos.games.arcaneassault.utils.GameConstants;
import co.archeos.games.arcaneassault.utils.PagedScrollPane;

/**
 * Created by Ajay on 2015-06-25.
 */
public class LevelSelectStage extends Stage {
    private final static String LOG_TAG_LEVELSELECTSTAGE_ACT = "LevelSelectStage: ACT";
    private final static String LOG_TAG_LEVELSELECTSTAGE_DRAW = "LevelSelectStage: DRAW";
    private final static String LOG_TAG_LEVELSELECTSTAGE_RESIZE = "LevelSelectStage: RESIZE";
    private final static String LOG_TAG_LEVELSELECTSTAGE_PAUSE = "LevelSelectStage: PAUSE";
    private final static String LOG_TAG_LEVELSELECTSTAGE_RESUME = "LevelSelectStage: RESUME";
    private final static String LOG_TAG_LEVELSELECTSTAGE_HIDE = "LevelSelectStage: HIDE";
    private final static String LOG_TAG_LEVELSELECTSTAGE_DISPOSE = "LevelSelectStage: DISPOSE";


    private ArcaneAssaultGame mArcaneAssaultGame;
    private TextureAtlas mLevelSelectStageAtlas;

    private Skin mLevelSelectStageSkin;

    private OrthographicCamera mMenuCamera;

    private float mScreenWidth;
    private float mScreenHeight;

    PagedScrollPane mLevelSelectPane;

    public LevelSelectStage(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        setDebugAll(true);
    }

    public void createStage() {
        mLevelSelectStageSkin = new Skin(mArcaneAssaultGame.getAssetManager().get(GameConstants
                .UI.Button.PACK_LOCATION, TextureAtlas.class));

        mLevelSelectPane = new PagedScrollPane();
        mLevelSelectPane.setFlingTime(0.1f);
        mLevelSelectPane.setPageSpacing(25f);
        mLevelSelectPane.setScrollingDisabled(false, true);
        mLevelSelectPane.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        int c = 1;
        for (int i = 0; i < 5; i++) {
            Table levelTable = new Table().pad(50);
            levelTable.defaults().pad(20, 40, 20, 40);
            for (int j = 0; j < 3; j++) {
                levelTable.row();
                for (int k = 0; k < 4; k++) {
                    levelTable.add(getLevelButton(c++)).expand().fill();
                }
            }
            mLevelSelectPane.addPage(levelTable);
        }

        addActor(mLevelSelectPane);
    }

    public GameButton getLevelButton(int level) {
        GameButton newButton = new GameButton();
        Button.ButtonStyle newButtonStyle = new Button.ButtonStyle();
        newButtonStyle.up = mLevelSelectStageSkin.getDrawable("button_up");
        newButtonStyle.down = mLevelSelectStageSkin.getDrawable("button_down");
        newButtonStyle.pressedOffsetX = 1;
        newButtonStyle.pressedOffsetY = -1;
        newButton.setStyle(newButtonStyle);

        BitmapFont black = mArcaneAssaultGame.getAssetManager().get(GameConstants
                .General.BLACK_FONT_PACK_LOCATION, BitmapFont.class);

//        Label buttonLabel = new Label(Integer.toString(level), mLevelSelectStageSkin);
//        buttonLabel.setFontScale(2f);
//        buttonLabel.setAlignment(Align.center);

        newButton.stack(new Image(mLevelSelectStageSkin.getDrawable("button_up"))).expand()
                .fill();

        newButton.row();
        //newButtonadd(starTable).height(30);

        newButton.setName("Level" + Integer.toString(level));
        //newButton.addListener(levelClickListener);

        return newButton;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        getBatch().setProjectionMatrix(getCamera().combined);
    }
}
