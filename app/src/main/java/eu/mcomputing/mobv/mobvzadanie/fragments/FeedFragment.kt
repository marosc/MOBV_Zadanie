package eu.mcomputing.mobv.mobvzadanie.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import eu.mcomputing.mobv.mobvzadanie.R
import eu.mcomputing.mobv.mobvzadanie.adapters.FeedAdapter
import eu.mcomputing.mobv.mobvzadanie.databinding.FragmentFeedBinding
import eu.mcomputing.mobv.mobvzadanie.viewmodels.FeedViewModel
import eu.mcomputing.mobv.mobvzadanie.widgets.bottomBar.BottomBar

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private lateinit var viewModel: FeedViewModel
    private var binding: FragmentFeedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[FeedViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFeedBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
        }.also { bnd ->
            bnd.bottomBar.setActive(BottomBar.FEED)

            bnd.feedRecyclerview.layoutManager = LinearLayoutManager(context)
            val feedAdapter = FeedAdapter()
            bnd.feedRecyclerview.adapter = feedAdapter

            // Pozorovanie zmeny hodnoty
            viewModel.feed_items.observe(viewLifecycleOwner) { items ->
                Log.d("FeedFragment", "nove hodnoty $items")
                feedAdapter.updateItems(items)
            }

            bnd.btnGenerate.setOnClickListener {
                viewModel.updateItems()
            }
        }

    }
}