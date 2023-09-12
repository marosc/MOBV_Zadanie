package eu.mcomputing.mobv.mobvzadanie

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Mojtag", "moja info")

        val myButton: Button = findViewById(R.id.button1)
        myButton.setOnClickListener {
            // Kód, ktorý sa vykoná po kliknutí na tlačidlo
            Log.d("Mojtag", "klik")
        }
    }


}