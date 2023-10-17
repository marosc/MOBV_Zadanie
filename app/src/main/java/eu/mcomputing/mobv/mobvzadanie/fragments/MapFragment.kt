package eu.mcomputing.mobv.mobvzadanie.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mapbox.maps.Style
import eu.mcomputing.mobv.mobvzadanie.R
import eu.mcomputing.mobv.mobvzadanie.databinding.FragmentMapBinding
import eu.mcomputing.mobv.mobvzadanie.widgets.bottomBar.BottomBar

class MapFragment : Fragment(R.layout.fragment_map) {
    private var binding: FragmentMapBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMapBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
        }.also { bnd ->
            bnd.bottomBar.setActive(BottomBar.MAP)
            bnd.mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS)
        }
    }


}