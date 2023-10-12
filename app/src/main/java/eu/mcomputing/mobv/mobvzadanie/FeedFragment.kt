package eu.mcomputing.mobv.mobvzadanie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FeedFragment : Fragment(R.layout.fragment_feed) {
    private lateinit var viewModel: FeedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<BottomBar>(R.id.bottom_bar).setActive(BottomBar.FEED)

        // Inicializácia ViewModel
        viewModel = ViewModelProvider(this)[FeedViewModel::class.java]

        val recyclerView = view.findViewById<RecyclerView>(R.id.feed_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val feedAdapter = FeedAdapter()
        recyclerView.adapter = feedAdapter

        // Pozorovanie zmeny hodnoty
        viewModel.feed_items.observe(viewLifecycleOwner) { items ->
            // Tu môžete aktualizovať UI podľa hodnoty stringValue
            feedAdapter.updateItems(items)
        }

        viewModel.updateItems(
            listOf(
                MyItem(0, R.drawable.baseline_feed_24, "Prvy"),
                MyItem(1, R.drawable.baseline_map_24, "Druhy"),
                MyItem(2, R.drawable.baseline_account_box_24, "Treti"),
            )
        )

    }
}