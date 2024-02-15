package ru.stan.piggybank3

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import ru.stan.piggybank3.databinding.ActivityMainBinding
import ru.stan.piggybank3.fragmentFirst.BlankFragment


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container2)
            val blankFragment = BlankFragment()

            supportFragmentManager.beginTransaction()
                .replace(fragmentContainer.id, blankFragment)
                .commit()
        }
    }
}





