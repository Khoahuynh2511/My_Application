package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the VideoView class by its id
        val videoView = findViewById<VideoView>(R.id.testView)

        // Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Specify the location of media file
        val uri: Uri = Uri.parse(
            "android.resource://" + packageName + "/" + R.raw.sample_video
        )

        // Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}


