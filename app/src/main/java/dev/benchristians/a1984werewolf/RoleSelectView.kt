package dev.benchristians.a1984werewolf

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.ToggleButton

class RoleSelectView(c: Context, a: AttributeSet): ToggleButton(c,a) {

    var role: Role? = null

    fun init(role: Role) {
        this.role = role
        this.setOnCheckedChangeListener { _, isChecked ->
            Log.e("Selected", this.role.toString())
        }
    }
}