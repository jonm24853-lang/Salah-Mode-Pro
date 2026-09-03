package com.faris.salahmodepro

import android.app.Activity
import android.app.NotificationManager
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(40, 40, 40, 40)
            layoutDirection = LinearLayout.LAYOUT_DIRECTION_RTL
        }

        val title = TextView(this).apply {
            text = "🕌 Salah Mode Pro"
            textSize = 28f
            gravity = Gravity.CENTER
        }

        val description = TextView(this).apply {
            text = "\nوضع الصلاة الصامت\n\nسيتم لاحقًا إضافة أوقات الصلاة والتفعيل التلقائي."
            textSize = 18f
            gravity = Gravity.CENTER
        }

        val button = Button(this).apply {
            text = "⚙️ السماح بوضع عدم الإزعاج"
            setOnClickListener {
                openNotificationPolicySettings()
            }
        }

        layout.addView(title)
        layout.addView(description)
        layout.addView(button)

        setContentView(layout)
    }

    private fun openNotificationPolicySettings() {
        val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
        startActivity(intent)
    }
}
