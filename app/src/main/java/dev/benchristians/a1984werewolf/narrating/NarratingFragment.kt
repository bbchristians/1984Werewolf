package dev.benchristians.a1984werewolf.narrating

import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton
import dev.benchristians.a1984werewolf.AudioQueue
import dev.benchristians.a1984werewolf.R
import java.util.*

class NarratingFragment: Fragment() {

    var rootView: View? = null

    var player: MediaPlayer? = null
    set(other) {
        field?.pause()
        field?.release()
        field = other
    }

    private var musicPlayer: MediaPlayer? = null
    set(other) {
        field?.pause()
        field?.release()
        field = other
    }

    private var audioSequence: List<AudioQueue?> = listOf()
    private var narrationStopped = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_narration, container, false)

        val roles = (this.activity as? NarratingActivity)?.getSelectedRoles()?.map {
            it.toString()
        }?.joinToString(", ")

        // Set Fonts
        context?.applicationContext?.assets?.let { assetManager->
            val typeface = Typeface.createFromAsset(
                assetManager,
                String.format(Locale.US, "fonts/%s", "Industria_Solid.ttf")
            )
            this.rootView?.findViewById<TextView>(R.id.top_text_1)?.typeface = typeface
            this.rootView?.findViewById<TextView>(R.id.top_text_2)?.typeface = typeface
        }

        initiateNarration()

        // Pause Button
        rootView?.findViewById<ToggleButton>(R.id.pause_button)?.setOnCheckedChangeListener { _, isChecked ->
            if( isChecked && this.player?.isPlaying == true ) {
                this.player?.pause()
            } else {
                this.player?.start()
            }
        }

        // Stop Button
        rootView?.findViewById<Button>(R.id.stop_button)?.setOnClickListener {
            this.stopNarration()
        }

        return rootView
    }

    private fun initiateNarration() {
        val roles = (this.activity as? NarratingActivity)?.getSelectedRoles()?.map {
            it
        }?.filter {
            it.order != -1
        }?.sortedBy { role ->
            role.order
        }

        val mp3s = roles?.flatMap {
            listOf(it.introMP3, it.outroMP3)
        }?.toTypedArray() ?: return

        this.audioSequence = listOf(
            AudioQueue(R.raw.orwell_intro2, 500L),
            AudioQueue(R.raw.orwell_brotherhood1, 6000L),
            AudioQueue(R.raw.orwell_brotherhood2, 1500L),
            *mp3s,
            AudioQueue(R.raw.orwell_outro2, 0L))
        startNarration(0)
        this.startMusicPlayer()
    }

    private fun startNarration(fromPoint: Int) {
        if( fromPoint >= this.audioSequence.size && !narrationStopped ) {
            // Narration complete
            hideNarrationButtons()
            return
        }
        val audioQueue = this.audioSequence[fromPoint] ?: return
        this.context?.let { context ->
            this.player = MediaPlayer.create(context, audioQueue.mp3)
            this.player?.setOnCompletionListener {
                Handler().postDelayed({
                    startNarration(fromPoint+1)
                }, audioQueue.pauseDur)
            }
            this.player?.start()
        }
    }

    private fun startMusicPlayer() {
        this.context?.let { context ->
            this.musicPlayer = MediaPlayer.create(context, R.raw.background_music)
            this.musicPlayer?.isLooping = true
            this.musicPlayer?.setVolume(.15f, .15f)
            this.musicPlayer?.start()
        }
    }

    private fun hideNarrationButtons() {
        rootView?.findViewById<View>(R.id.narration_buttons)?.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()
        this.musicPlayer?.pause()
        this.player?.pause()
    }

    override fun onStart() {
        super.onStart()
        this.musicPlayer?.start()
        this.player?.start()
    }

    private fun stopNarration() {
        narrationStopped = true
        this.player?.stop()
        this.musicPlayer?.stop()
    }
}