package com.dtrand.shooter.plane

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

       // Utils.fullScreen(this)

    }



    private fun initViews() {

        findViewById<View>(R.id.startGameText).setOnClickListener {
            startGame()
        }


    }

    private  fun startGame() {
        val intent = Intent(this, StartGame::class.java)
        startActivity(intent)
        finish()
    }
}