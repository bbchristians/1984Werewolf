package dev.benchristians.a1984werewolf

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.graphics.Typeface
import android.R.attr.typeface
import android.content.res.AssetManager
import java.util.*


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

        // Set Fonts
        context?.applicationContext?.assets?.let { assetManager->
            val typeface = Typeface.createFromAsset(
                assetManager,
                String.format(Locale.US, "fonts/%s", "Industria_Solid.ttf")
            )
            this.rootView?.findViewById<TextView>(R.id.top_text_1)?.typeface = typeface
            this.rootView?.findViewById<TextView>(R.id.top_text_2)?.typeface = typeface
        }


        return rootView
    }

}