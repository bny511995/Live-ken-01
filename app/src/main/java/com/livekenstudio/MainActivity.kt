
package com.livekenstudio

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {

    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.rgb(10, 12, 25)
        window.navigationBarColor = Color.rgb(10, 12, 25)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 20, 28, 20)
            setBackgroundColor(Color.rgb(10, 12, 25))
        }

        val title = TextView(this).apply {
            text = "LIVE KEN STUDIO"
            textSize = 30f
            setTextColor(Color.CYAN)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "MOBILE GAME STREAMING"
            textSize = 13f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        status = TextView(this).apply {
            text = "STATUS: SIAP LIVE"
            textSize = 17f
            setTextColor(Color.GREEN)
            gravity = Gravity.CENTER
            setPadding(10, 25, 10, 25)
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(status)

        addButton(layout, "MULAI LIVE") {
            status.text = "STATUS: MENUNGGU PENGATURAN STREAM"
        }

        addButton(layout, "PENGATURAN STREAMING") {
            status.text = "PENGATURAN STREAMING"
        }

        addButton(layout, "KAMERA ON / OFF") {
            status.text = "KAMERA: PENGATURAN SIAP"
        }

        addButton(layout, "MIKROFON ON / OFF") {
            status.text = "MIKROFON: PENGATURAN SIAP"
        }

        addButton(layout, "BERHENTI LIVE") {
            status.text = "STATUS: TIDAK LIVE"
        }

        setContentView(layout)
    }

    private fun addButton(
        layout: LinearLayout,
        label: String,
        action: () -> Unit
    ) {
        val button = Button(this).apply {
            text = label
            textSize = 14f
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.rgb(35, 75, 145))
            setOnClickListener { action() }
        }

        layout.addView(
            button,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                58
            ).apply {
                setMargins(0, 7, 0, 7)
            }
        )
    }
}
