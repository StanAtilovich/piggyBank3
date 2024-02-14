package ru.stan.piggybank3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import ru.stan.piggybank3.fragmentFirst.BlankFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container)
        val blankFragment = BlankFragment()

        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer.id, blankFragment)
            .commit()
    }
}




