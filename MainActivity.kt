import android.os.Bundle
import android.media.MediaPlayer
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set Dark Mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        // Play Sound
        val mediaPlayer = MediaPlayer.create(this, R.raw.sound_file)  // Use your sound file
        mediaPlayer.start()  // Start playing the sound

        // Timer to stop sound after 30 seconds
        val countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                mediaPlayer.stop() // Stop the sound
            }
        }
        countDownTimer.start() // Start the timer
    }
}
