package dev.benchristians.a1984werewolf.narrating

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.benchristians.a1984werewolf.R

class NarratingFragment: Fragment() {

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_narration, container, false)

        val roles = (this.activity as? NarratingActivity)?.getSelectedRoles()?.map {
            it.toString()
        }?.joinToString(", ")

        rootView?.findViewById<TextView>(R.id.world)?.text = roles

        startNarration()

        return rootView
    }

    private fun startNarration() {
        val roles = (this.activity as? NarratingActivity)?.getSelectedRoles()?.map {
            it
        }?.filter {
            it.order != -1
        }?.sortedBy { role ->
            role.order
        }

        introNarration()

        roles?.forEach { role ->
            // TODO: Narrate for this role
        } // ?: TODO report error

        outroNarration()
    }

    private fun introNarration() {
        // TODO
    }

    private fun outroNarration() {
        // TODO
    }
}