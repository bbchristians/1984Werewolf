package dev.benchristians.a1984werewolf

import android.content.Context
import android.util.AttributeSet
import android.widget.ToggleButton

class RoleSelectView(c: Context, a: AttributeSet): ToggleButton(c,a) {

    fun init() {
        this.post {
            this.height = this.width
        }
        this.setOnCheckedChangeListener { _, isChecked ->
            // TODO
        }
    }
}