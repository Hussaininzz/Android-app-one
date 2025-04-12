# Android-app-one
package com.sleepwell.app

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.os.Handler

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var darkModeTextView: TextView
    private lateinit var volumeControl: SeekBar
    private lateinit var timerButton: Button
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.calm_sound) // Replace with your sound file
        darkModeTextView = findViewById(R.id.darkModeTextView)
        volumeControl = findViewById(R.id.volumeSeekBar)
        timerButton = findViewById(R.id.timerButton)

        // Play sound when app starts
        mediaPlayer.start()

        // Dark mode text
        darkModeTextView.text = "Dark Mode Activated"

        // Volume control
        volumeControl.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mediaPlayer.setVolume(progress / 100f, progress / 100f)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Timer to stop sound
        timerButton.setOnClickListener {
            handler.postDelayed({
                mediaPlayer.stop()
            }, 60000) // Stops after 1 minute
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
