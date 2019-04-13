package dev.benchristians.a1984werewolf

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

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
}