package eu.mcomputing.mobv.mobvzadanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Mojtag","moja info")
        findViewById<TextView>(R.id.text).text="kk"
    }


}