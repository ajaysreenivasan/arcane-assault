package co.archeos.games.arcaneassault.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import co.archeos.games.arcaneassault.model.GameWorld;

/**
 * Created by Ajay on 2015-04-13.
 */
public class LevelLoader {
    private Json mJson;

    public LevelLoader(){
        mJson = new Json();
        mJson.setTypeName(null);
        // TODO: Use prototypes.
        mJson.setUsePrototypes(false);
        mJson.setIgnoreUnknownFields(true);
        mJson.setOutputType(JsonWriter.OutputType.json);
    }


    public void loadLevel(GameWorld gameWorld){

    }

    public void readLevelFile(FileHandle file){

    }
}
