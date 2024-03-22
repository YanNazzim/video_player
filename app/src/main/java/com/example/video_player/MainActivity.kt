package com.example.video_player

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.testView)

        // Specify the location of the media file
        val uri: Uri = Uri.parse("android.resource://$packageName/raw/drift")

        // Setting URI and starting the videoView
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        // Creating MediaController
        val mediaController = object : MediaController(this) {
            override fun show() {
                super.show(0) // Show the controls without hiding
            }
        }

        mediaController.setAnchorView(videoView)

        // Set MediaController to VideoView
        videoView.setMediaController(mediaController)
    }
}
