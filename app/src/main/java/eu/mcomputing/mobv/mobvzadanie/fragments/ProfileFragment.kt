package eu.mcomputing.mobv.mobvzadanie.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import eu.mcomputing.mobv.mobvzadanie.R
import eu.mcomputing.mobv.mobvzadanie.databinding.FragmentProfileBinding
import eu.mcomputing.mobv.mobvzadanie.widgets.bottomBar.BottomBar

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var binding: FragmentProfileBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
        }.also { bnd ->
            bnd.bottomBar.setActive(BottomBar.PROFILE)
        }
    }
}