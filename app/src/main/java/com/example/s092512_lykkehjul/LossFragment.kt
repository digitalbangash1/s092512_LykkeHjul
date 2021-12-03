package com.example.s092512_lykkehjul

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class LossFragment : Fragment() {
    lateinit var goBackLoss: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loss, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBackLoss= view.findViewById(R.id.goBackbutton_loss)
        goBackLoss.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_lossFragment_to_frontFragment)
        }


    }
}