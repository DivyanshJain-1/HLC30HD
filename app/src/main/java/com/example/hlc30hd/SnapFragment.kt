package com.example.hlc30hd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment

class SnapFragment : Fragment() {

    private lateinit var selectedDate: String

    companion object {
        fun newInstance(date: String): SnapFragment {
            val fragment = SnapFragment()
            val args = Bundle()
            args.putString("date", date)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedDate = arguments?.getString("date") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_snap, container, false)
        val listView = view.findViewById<ListView>(R.id.snapListView)

        val dummySnaps = listOf("Snap 1 on $selectedDate", "Snap 2 on $selectedDate")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dummySnaps)
        listView.adapter = adapter

        return view
    }
}
