package dev.benchristians.a1984werewolf.narrating

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.benchristians.a1984werewolf.R

class NarratingFragment: Fragment() {

    var rootView: View? = null

    var player: MediaPlayer? = null
    private var audioSequence: List<Int> = listOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_narration, container, false)

        val roles = (this.activity as? NarratingActivity)?.getSelectedRoles()?.map {
            it.toString()
        }?.joinToString(", ")

        rootView?.findViewById<TextView>(R.id.world)?.text = roles

        initiateNarration()

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

        var mediaPlayer: MediaPlayer? = null
        val mp3s = roles?.map {
            it.mp3Res
        }?.toTypedArray() ?: return

        // TODO replace with INTRO and OUTRO audio files
        this.audioSequence = listOf(R.raw.snaps, *mp3s, R.raw.snaps)
        startNarration(0)
    }

    private fun startNarration(fromPoint: Int) {
        if( fromPoint >= this.audioSequence.size ) return // Narration complete
        this.player = MediaPlayer.create(this.context, this.audioSequence[fromPoint])
        this.player?.setOnCompletionListener {
            startNarration(fromPoint+1)
        }
        this.player?.start()
    }
}