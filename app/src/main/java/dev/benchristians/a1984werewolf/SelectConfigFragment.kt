package dev.benchristians.a1984werewolf

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.graphics.Typeface
import android.widget.Button
import java.util.*


class SelectConfigFragment: Fragment() {

    val ROLE_CONFIG = listOf(
        Role.BROTHERHOOD_MEMBER_1,
        Role.BROTHERHOOD_MEMBER_2,
        Role.SCAPEGOAT,
        Role.INVESTIGATOR,
        Role.LEXICOGRAPHER,
        Role.DOUBLETHINKER,
        Role.THOUGHT_POLICE,
        Role.UNPERSON,
        Role.INTERROGATOR,
        Role.NEIGHBOR_1,
        Role.NEIGHBOR_2,
        Role.SINGER,
        Role.PROLE,
        Role.PROLE,
        Role.PROLE
    )

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_select_config, container, false)

        var roleCount = 0
        // Initialize all buttons
        getAllRoleSelectButtons().forEach {
            it?.init(ROLE_CONFIG[roleCount])
            if( it != null ) {
                roleCount++
            }
        }

        // Set Fonts
        context?.applicationContext?.assets?.let { assetManager->
            val typeface = Typeface.createFromAsset(
                assetManager,
                String.format(Locale.US, "fonts/%s", "Industria_Solid.ttf")
            )
            this.rootView?.findViewById<TextView>(R.id.top_text_1)?.typeface = typeface
            this.rootView?.findViewById<TextView>(R.id.top_text_2)?.typeface = typeface
        }

        // Set Onclick
        rootView?.findViewById<Button>(R.id.play_button)?.setOnClickListener {
            (activity as? MainActivity)?.switchToNarration(this.getSelectedRoles())
        }

        return rootView
    }

    private fun getAllRoleSelectButtons(): List<RoleSelectView?> {
        return this.rootView?.findViewById<ViewGroup>(R.id.role_button_container)?.let { container ->
            (0 until container.childCount).flatMap {
                (container.getChildAt(it) as? ViewGroup)?.let { child_container ->
                    (0 until child_container.childCount).map {
                        child_container.getChildAt(it) as? RoleSelectView
                    }
                }?: listOf()
            }
        } ?: listOf()
    }

    private fun getSelectedRoles(): List<Role> {
        return getAllRoleSelectButtons().asSequence().filter { roleSelectView: RoleSelectView? ->
            roleSelectView?.isChecked ?: false
        }.mapNotNull {
            it?.role
        }.toList()
    }

}