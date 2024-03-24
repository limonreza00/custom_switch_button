package com.torchtech.custom_switch_button

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val switchButton = findViewById<SwitchCompat>(R.id.switchButton)
        val display = findViewById<TextView>(R.id.display)

        switchButton.isChecked = false
        display.text= getString(R.string.switch_is_off)
        switchButton.setOnCheckedChangeListener { _, _ ->
            if (switchButton.isChecked) display.text= getString(R.string.switch_is_on)
            else display.text=getString(R.string.switch_is_off)
        }
    }
}