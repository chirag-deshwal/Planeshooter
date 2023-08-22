package com.dtrand.shooter.plane;


import android.app.Activity;
import android.os.Bundle;


/**
 * Created by Recording on 8/16/2017.
 */

public class StartGame extends Activity {

    GameView gameView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.Companion.fullScreen(this);
        gameView = new GameView(this);
        setContentView(gameView);
    }
}
