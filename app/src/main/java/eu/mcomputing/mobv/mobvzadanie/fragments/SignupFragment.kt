package eu.mcomputing.mobv.mobvzadanie.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import eu.mcomputing.mobv.mobvzadanie.R
import eu.mcomputing.mobv.mobvzadanie.data.api.DataRepository
import eu.mcomputing.mobv.mobvzadanie.viewmodels.AuthViewModel


class SignupFragment : Fragment(R.layout.fragment_signup) {
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity(), object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AuthViewModel(DataRepository.getInstance()) as T
            }
        })[AuthViewModel::class.java]

        viewModel.registrationResult.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                requireView().findNavController().navigate(R.id.action_signup_feed)
            } else {
                Snackbar.make(
                    view.findViewById(R.id.submit_button),
                    it,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        view.findViewById<TextView>(R.id.submit_button).apply {
            setOnClickListener {
                viewModel.registerUser(
                    view.findViewById<EditText>(R.id.edit_text_username).text.toString(),
                    view.findViewById<EditText>(R.id.edit_text_email).text.toString(),
                    view.findViewById<EditText>(R.id.edit_text_password).text.toString()
                )
            }
        }
    }

}