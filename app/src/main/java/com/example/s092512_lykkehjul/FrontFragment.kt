package com.example.s092512_lykkehjul

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class FrontFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_front, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        val startGameButton: Button = view.findViewById(R.id.startGameButton)
        startGameButton.setOnClickListener() {
            Navigation.findNavController(requireView()).navigate(R.id.action_frontFragment_to_playGameFragment)
        }


        }
    }

