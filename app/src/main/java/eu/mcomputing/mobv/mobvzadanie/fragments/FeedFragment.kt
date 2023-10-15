package eu.mcomputing.mobv.mobvzadanie.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.mcomputing.mobv.mobvzadanie.R
import eu.mcomputing.mobv.mobvzadanie.adapters.FeedAdapter
import eu.mcomputing.mobv.mobvzadanie.viewmodels.FeedViewModel
import eu.mcomputing.mobv.mobvzadanie.widgets.bottomBar.BottomBar

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private lateinit var viewModel: FeedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<BottomBar>(R.id.bottom_bar).setActive(BottomBar.FEED)

        // Inicializácia ViewModel
        viewModel = ViewModelProvider(requireActivity())[FeedViewModel::class.java]

        val recyclerView = view.findViewById<RecyclerView>(R.id.feed_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val feedAdapter = FeedAdapter()
        recyclerView.adapter = feedAdapter

        // Pozorovanie zmeny hodnoty
        viewModel.feed_items.observe(viewLifecycleOwner) { items ->
            Log.d("FeedFragment", "nove hodnoty $items")
            feedAdapter.updateItems(items)
        }

        view.findViewById<Button>(R.id.btn_generate).setOnClickListener {
            viewModel.updateItems()
        }

    }
}