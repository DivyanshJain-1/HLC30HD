package com.example.hlc30hd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class EvidenceFragment : Fragment() {
    private lateinit var evidenceview :TextView
    private lateinit var myButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_evidence, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val evidencetext = view.findViewById<TextView>(R.id.tvEvidence)
        evidencetext.text = "Evidence will be displayed here"
    }
}