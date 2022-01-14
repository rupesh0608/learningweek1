package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.net.Uri
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.technicalrupu.learningweek1.R
import java.net.URI

class VideoView(val ref:Activity) {

    fun create(videoPlayerId:Int):VideoView{
        return ref.findViewById(videoPlayerId)
    }
    fun start(videoPlayerId:Int,uri:Uri){
        val videoPlayer =ref.findViewById<VideoView>(videoPlayerId)
        var mediaControls: MediaController? = null
        if (mediaControls == null) {
            mediaControls = MediaController(ref)
            mediaControls.setAnchorView(videoPlayer as View)
        }
        videoPlayer.setMediaController(mediaControls)
        videoPlayer.setVideoURI(uri)

        videoPlayer.requestFocus()
        videoPlayer.setZOrderOnTop(true);
        videoPlayer.start()
        videoPlayer.setOnCompletionListener {
            Toast.makeText(
                ref.applicationContext, "Video completed",
                Toast.LENGTH_LONG
            ).show()
        }
        videoPlayer!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(
                ref.applicationContext, "Error Occurred While Playing Video....", Toast.LENGTH_LONG
            ).show()
            false
        }
    }
}