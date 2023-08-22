package com.dtrand.shooter.plane

import android.app.Activity
import android.view.Window
import android.view.WindowManager


class Utils {



    companion object {

        fun fullScreen (activity: Activity) {
            activity.requestWindowFeature(Window.FEATURE_NO_TITLE)
            activity.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }

    }

}