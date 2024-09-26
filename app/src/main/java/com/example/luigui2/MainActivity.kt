//autor:luigui alexander huanca capira
//Fecha de creación: 2024-09-25
//Última modificación: 2024-09-25

package com.example.luigui2

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity(), AudioSelectionFragment.OnAudioSelectedListener {
    private lateinit var playerControlFragment: PlayerControlFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, AudioSelectionFragment())
                .commit()

            playerControlFragment = PlayerControlFragment()
            fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, playerControlFragment)
                .commit()
        }
    }

    override fun onAudioSelected(audioName: String) {
        playerControlFragment.setSelectedAudio(audioName)
    }
}