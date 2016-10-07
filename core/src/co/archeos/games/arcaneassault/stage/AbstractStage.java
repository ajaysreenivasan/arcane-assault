package co.archeos.games.arcaneassault.stage;

import com.badlogic.gdx.scenes.scene2d.Stage;

import co.archeos.games.arcaneassault.ArcaneAssaultGame;

/**
 * Created by Ajay on 2016-10-06.
 */

public class AbstractStage extends Stage {
    protected final String LOG_TAG_STAGE_ACT = this.getClass().getSimpleName() + " ACT";
    protected final String LOG_TAG_STAGE_DRAW = this.getClass().getSimpleName() + " DRAW";

    protected ArcaneAssaultGame mArcaneAssaultGame;

    public void createStage(){

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
