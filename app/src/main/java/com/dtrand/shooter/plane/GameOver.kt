package com.dtrand.shooter.plane

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class GameOver : Activity() {

    private var tvScore: TextView? = null
    private var tvPersonalBest: TextView? = null

    private lateinit var adView: AdView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_over)

        initViews()

        val score = intent.extras!!.getInt("score")
        val pref = getSharedPreferences("MyPref", 0)
        var scoreSP = pref.getInt("scoreSP", 0)
        val editor = pref.edit()
        if (score > scoreSP) {
            scoreSP = score
            editor.putInt("scoreSP", scoreSP)
            editor.apply()
        }
        tvScore = findViewById<View>(R.id.tvScore) as TextView
        tvPersonalBest = findViewById<View>(R.id.tvPersonalBest) as TextView
        tvScore!!.text = "" + score
        tvPersonalBest!!.text = "" + scoreSP


    }

    private fun initViews() {
        adView = findViewById(R.id.adView)


        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)


        findViewById<View>(R.id.restartGameBtn).setOnClickListener {
            // Loading new Game
             Intent(this@GameOver, StartGame::class.java).apply {
                startActivity(this)
                finish()
            }
        }

        findViewById<View>(R.id.exitGameBtn).setOnClickListener {
            Intent(this@GameOver, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }


    override fun onPause() {
        adView.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        adView.resume()
    }

    override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }

}