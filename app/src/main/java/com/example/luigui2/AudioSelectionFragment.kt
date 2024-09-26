package com.example.luigui2

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class AudioSelectionFragment : Fragment() {
    private lateinit var spinner: Spinner
    private var listener: OnAudioSelectedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_audio_selection, container, false)

        spinner = view.findViewById(R.id.audioSpinner)
        val audioList = arrayOf("audio1", "audio2", "audio3", "audio4", "audio5")
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, audioList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                listener?.onAudioSelected(spinner.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        return view
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (activity is OnAudioSelectedListener) {
            listener = activity
        } else {
            throw RuntimeException("$activity must implement OnAudioSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnAudioSelectedListener {
        fun onAudioSelected(audioName: String)
    }
}