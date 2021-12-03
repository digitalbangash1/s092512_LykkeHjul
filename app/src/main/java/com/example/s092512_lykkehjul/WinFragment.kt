package com.example.s092512_lykkehjul

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class WinFragment : Fragment() {
    lateinit var goBackWin: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_win, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBackWin= view.findViewById(R.id.goBackbutton_win)
        goBackWin.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_winFragment_to_frontFragment)
        }


    }
}