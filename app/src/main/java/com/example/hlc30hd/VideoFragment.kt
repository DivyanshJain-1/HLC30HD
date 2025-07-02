package com.example.hlc30hd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class VideoFragment : Fragment() {

    private lateinit var selectedDate: String

    companion object {
        fun newInstance(date: String): VideoFragment {
            val fragment = VideoFragment()
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
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        val listView = view.findViewById<ListView>(R.id.videoListView)

        // Dummy video list using selected date
        val dummyVideos = listOf("Video 1 on $selectedDate", "Video 2 on $selectedDate")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, dummyVideos)
        listView.adapter = adapter

        return view
    }
}
