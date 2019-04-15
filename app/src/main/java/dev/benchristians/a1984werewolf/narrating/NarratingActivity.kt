package dev.benchristians.a1984werewolf.narrating

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.benchristians.a1984werewolf.R
import dev.benchristians.a1984werewolf.Role

class NarratingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val narratingFragment = NarratingFragment()
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.content_root, narratingFragment)
            .commit()
    }

    fun getSelectedRoles(): List<Role> {
        return this.intent.extras?.getIntArray("ROLES")?.map { roleIndex ->
            Role.values()[roleIndex]
        } ?: listOf()
    }
}