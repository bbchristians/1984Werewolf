package dev.benchristians.a1984werewolf

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.benchristians.a1984werewolf.narrating.NarratingActivity

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val configFragment = SelectConfigFragment()
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.content_root, configFragment)
            .commit()
    }

    fun switchToNarration(selectedRoles: List<Role>) {
        val narrationIntent = Intent(this, NarratingActivity::class.java)
        narrationIntent.putExtra("ROLES", selectedRoles.map { role ->
            Role.values().indexOf(role)
        }.toIntArray())
        startActivity(narrationIntent)
    }
}