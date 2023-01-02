package com.aristotele.foodappmvp.retrofit.ui.detail.player



import com.aristotele.foodappmvp.databinding.ActivityPlayerBinding
import com.aristotele.foodappmvp.retrofit.utils.VIDEO_ID
import com.aristotele.foodappmvp.retrofit.utils.YOUTUBE_API_KEY
import com.aristotele.foodappmvp.utils.showSnackBar
import android.os.Bundle
import android.view.WindowManager
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer



@Suppress("DEPRECATION")
class PlayerActivity : YouTubeBaseActivity() {
    //Binding
    private lateinit var binding: ActivityPlayerBinding

    //Other
    private var videoId = ""
    private lateinit var player: YouTubePlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        //Full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        //Get data
        videoId = intent.getStringExtra(VIDEO_ID).toString()
        //InitViews
        binding.apply {
            val listener = object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer, p2: Boolean) {
                    player = p1
                    player.loadVideo(videoId)
                    player.play()
                }

                override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                    root.showSnackBar("Error")
                }

            }
            videoPlayer.initialize(YOUTUBE_API_KEY, listener)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}