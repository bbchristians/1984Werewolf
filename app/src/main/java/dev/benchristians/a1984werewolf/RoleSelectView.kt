package dev.benchristians.a1984werewolf

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageButton
import android.widget.ToggleButton

class RoleSelectView(c: Context, a: AttributeSet): ImageButton(c,a) {

    var role: Role? = null
    var isChecked: Boolean = false

    fun init(role: Role) {
        this.role = role
        this.setOnClickListener { _ ->
            this.isChecked = !this.isChecked
            Log.e("Selected", this.role.toString())
            if( isChecked ) {
                this.setBackgroundResource(R.drawable.role_select_button)
            } else {
                this.setBackgroundResource(R.drawable.role_select_button_deselected)
            }
        }
        this.setImageResource(role.portrait)
    }
}