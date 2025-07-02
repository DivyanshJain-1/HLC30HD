package com.example.hlc30hd


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import java.util.Calendar

class EvidenceFragment : Fragment() {

    private lateinit var btnSnap: Button
    private lateinit var btnVideos: Button
    private lateinit var btnGo: Button
    private lateinit var textViewSelectedDate: TextView
    private lateinit var calendarIcon: ImageView
    private var selectedDate: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_evidence, container, false)

        btnSnap = view.findViewById(R.id.btnSnap)
        btnVideos = view.findViewById(R.id.btnVideos)
        btnGo = view.findViewById(R.id.btnGo)
        textViewSelectedDate = view.findViewById(R.id.textViewSelectedDate)
        calendarIcon = view.findViewById(R.id.imageViewCalendarIcon)

        val dateClickListener = View.OnClickListener { showDatePicker() }
        textViewSelectedDate.setOnClickListener(dateClickListener)
        calendarIcon.setOnClickListener(dateClickListener)

        btnGo.setOnClickListener { loadCurrentFragment() }

        return view
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, y, m, d ->
            selectedDate = String.format("%04d-%02d-%02d", y, m + 1, d)
            textViewSelectedDate.text = selectedDate
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun loadCurrentFragment() {
        if (selectedDate.isEmpty()) {
            Toast.makeText(requireContext(), "Please select a date", Toast.LENGTH_SHORT).show()
            return
        }

        val fragmentToLoad: Fragment = when {
            btnSnap.isPressed -> SnapFragment.newInstance(selectedDate)
            btnVideos.isPressed -> VideoFragment.newInstance(selectedDate)
            else -> SnapFragment.newInstance(selectedDate) // default
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.flSnapAndVid, fragmentToLoad)
            .commit()
    }
}
