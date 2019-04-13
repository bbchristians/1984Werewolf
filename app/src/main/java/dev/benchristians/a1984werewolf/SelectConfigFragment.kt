package dev.benchristians.a1984werewolf

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SelectConfigFragment: Fragment() {

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_select_config, container, false)

        // Initialize all buttons
        this.rootView?.findViewById<ViewGroup>(R.id.role_button_container)?.let { container ->
            (0 until container.childCount).forEach {
                (container.getChildAt(it) as? ViewGroup)?.let { child_container ->
                    (0 until child_container.childCount).forEach {
                        (container.getChildAt(it) as? RoleSelectView)?.init()
                    }
                }
            }
        }

        return rootView
    }

}