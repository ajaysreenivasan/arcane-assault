package co.archeos.games.arcaneassault.screen;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;
import co.archeos.games.arcaneassault.stage.LevelSelectStage;

/**
 * Created by Ajay on 2015-06-25.
 */
public class LevelSelectScreen extends AbstractScreen {
    public LevelSelectScreen(ArcaneAssaultGame arcaneAssaultGame) {
        mArcaneAssaultGame = arcaneAssaultGame;

        mScreenStage = new LevelSelectStage(arcaneAssaultGame);
    }
}

