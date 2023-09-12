package eu.mcomputing.mobv.mobvzadanie

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.submit_button).apply {
            setOnClickListener {
                val username: String =
                    findViewById<EditText>(R.id.edit_text_username).text.toString()
                val password: String =
                    findViewById<EditText>(R.id.edit_text_password).text.toString()
                login(username, password)
            }
        }

    }

    private fun login(username: String, password: String) {

    }
}