//autor:luigui alexander huanca capira
//Fecha de creación: 2024-09-25
//Última modificación: 2024-09-25
package com.example.luigui2

import android.app.Fragment
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

class PlayerControlFragment : Fragment() {
    private lateinit var playButton: Button
    private lateinit var stopButton: Button
    private lateinit var audioInfo: ImageView
    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false
    private var selectedAudio: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_player_control, container, false)

        playButton = view.findViewById(R.id.playButton)
        stopButton = view.findViewById(R.id.stopButton)
        audioInfo = view.findViewById(R.id.audioInfo)

        playButton.setOnClickListener {
            selectedAudio?.let { audioName -> playAudio(audioName) }
        }

        stopButton.setOnClickListener {
            stopAudio()
        }

        return view
    }

    fun setSelectedAudio(audioName: String) {
        selectedAudio = audioName
    }

    private fun playAudio(audioName: String) {
        if (isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }

        val resId = resources.getIdentifier(audioName, "raw", activity.packageName)

        if (resId != 0) {
            mediaPlayer = MediaPlayer.create(activity, resId)
            mediaPlayer.start()
            isPlaying = true
        }
    }

    private fun stopAudio() {
        if (isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
            isPlaying = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isPlaying) {
            mediaPlayer.release()
        }
    }
}