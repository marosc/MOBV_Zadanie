package eu.mcomputing.mobv.mobvzadanie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MapFragment : Fragment(R.layout.fragment_map) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<BottomBar>(R.id.bottom_bar).setActive(BottomBar.MAP)
    }
}