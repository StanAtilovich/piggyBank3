package ru.stan.piggybank3

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import ru.stan.piggybank3.fragmentFirst.BlankFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container2)
            val blankFragment = BlankFragment()

            supportFragmentManager.beginTransaction()
                .replace(fragmentContainer.id, blankFragment)
                .commit()
        }
    }
}





