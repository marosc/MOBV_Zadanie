package eu.mcomputing.mobv.mobvzadanie

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val submitButton: Button = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {

            // Logika po kliknutí na tlačidlo, napríklad na získanie textu z EditText
            val input1: String = findViewById<EditText>(R.id.editText1).text.toString()
            val input2: String = findViewById<EditText>(R.id.editText2).text.toString()

            // Spracovanie dát alebo iné akcie
            Log.d("vstupy", "$input1 a $input2")
        }
    }
}