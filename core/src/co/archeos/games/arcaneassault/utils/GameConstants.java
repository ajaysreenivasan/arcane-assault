package co.archeos.games.arcaneassault.utils;

/**
 * Created by Ajay on 2015-06-08.
 */
public class GameConstants {
    public class General {
        public static final String BLACK_FONT_PACK_LOCATION = "font/black.fnt";

        public static final float GAME_VIEWPORT_WIDTH = 400;
        public static final float GAME_VIEWPORT_HEIGHT = 240;
    }

    public class UI {
        public class Button{
            public static final String PACK_LOCATION = "ui/button/button.pack";

        }

        public class LoadingBar {
            public static final String PACK_LOCATION = "ui/loading_screen/loading.pack";

            public static final float BAR_WIDTH = 450;
            public static final float BAR_HEIGHT = 50;

            public static final String FRAME = "loading-frame";
            public static final String FRAME_BACKGROUND = "loading-frame-bg";
            public static final String HIDDEN = "loading-bar-hidden";
            public static final String ANIMATION = "loading-bar-anim";
        }
    }

    public class SplashScreen {
        public static final String PACK_LOCATION = "ui/splash_screen/splash_screen.pack";
        public static final String SPLASH_IMAGE = "splash_image";

        public class SplashStage {
            public static final float SPLASHSTAGE_VIEWPORT_WIDTH = General.GAME_VIEWPORT_WIDTH;
            public static final float SPLASHSTAGE_VIEWPORT_HEIGHT = General.GAME_VIEWPORT_HEIGHT;
        }

    }

    public class LoadingScreen {
        public static final String PACK_LOCATION = "ui/loading_screen/loading.pack";

        public static final String LOADING_SCREEN_BACKGROUND = "screen-bg";
    }

    public class MainMenuScreen {
        public static final String BACKGROUND_MUSIC = "bgm/mainmenu_screen/music_1.mp3";

        public class MainMenuStage {
            public static final String MENU_TABLE_SKIN = "ui/mainmenu_screen/mainmenu_screen.pack";

            public static final String BUTTON_TEXT_PLAY = "PLAY";
            public static final String BUTTON_TEXT_OPTIONS = "OPTIONS";
            public static final String BUTTON_TEXT_HELP = "HELP";
            public static final String BUTTON_TEXT_ABOUT = "ABOUT";
        }
    }

    public class LevelSelectScreen{
        public static final String BACKGROUND_MUSIC = "bgm/mainmenu_screen/music_1.mp3";

        public class LevelSelectStage{
            public static final String BACKGROUND_IMAGE = "";

        }
    }

    public class GameScreen {
        public static final String BACKGROUND_MUSIC = "bgm/game_screen/music_1.mp3";

        public class GameStage {
            public static final float GAMESTAGE_HEIGHT = 240;
            public static final float GAMESTAGE_VIEWPORT_WIDTH = 400;
            public static final float GAMESTAGE_VIEWPORT_HEIGHT = GAMESTAGE_HEIGHT + HUDStage.HUDSTAGE_BUTTON_ARRAY_HEIGHT;
        }

        public class HUDStage {
            public static final int HUDSTAGE_BUTTON_COUNT = 7;
            public static final float HUDSTAGE_BUTTON_ARRAY_HEIGHT = 50;

        }
    }
}
