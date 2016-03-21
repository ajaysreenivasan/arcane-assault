package co.archeos.games.arcaneassault.utils;

/**
 * Created by Ajay on 2015-07-02.
 */
public abstract class GameRunnable implements Runnable {
    private boolean mIsRunning = false;

    public void setIsRunning(boolean isRunning){
        mIsRunning = isRunning;
    }

    public boolean isRunning(){
        return mIsRunning;
    }
}
