package com.example.s092512_lykkehjul

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.*
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class PlayGameFragment : Fragment() {

    var totalLives = 5
    lateinit var randomWord: String
    lateinit var randomWordDisplay: String
    var randomWordDashes: MutableList<GuessChar> = ArrayList()
    lateinit var tvTotalLives: TextView
    lateinit var guessEditBox: EditText
    lateinit var spinButton: Button
    lateinit var guessButton: Button

    lateinit var wheel: ImageView
    lateinit var rvRandomWord: RecyclerView
    var randomWords = Data().loadRandomWords()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        guessEditBox = view.findViewById(R.id.etGuess)
        spinButton = view.findViewById(R.id.spin)
        guessButton = view.findViewById(R.id.btnGuess)
        wheel = view.findViewById(R.id.wheel)
        tvTotalLives = view.findViewById(R.id.total_lives)
        tvTotalLives.text = totalLives.toString()

        randomWord = randomWords.random();
        randomWordDisplay = randomWord
        var randomWordChars = randomWord.toCharArray()
        for (i in randomWordChars) {
            if (i.equals(' ')) {
                randomWordDashes.add(GuessChar(' ', true))
            } else {
                randomWordDashes.add(GuessChar('_', false))
            }
        }

        rvRandomWord = view.findViewById(R.id.rvRandomWord)
        rvRandomWord.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvRandomWord.setHasFixedSize(true)
        rvRandomWord.adapter = ItemAdapter(randomWordDashes)

        spin()
        guessButton.setOnClickListener { guessClickHandler() }

    }


    fun guessClickHandler() {
        var guess = guessEditBox.text.trim()
        if (guess.isEmpty()) {
            return
        }

        var guessedChar = guess.get(0)

        guessButton.isEnabled = false
        if (!randomWordDisplay.contains(guessedChar, true)) {
            // spin again
            totalLives--
            tvTotalLives.text = totalLives.toString()
            Toast.makeText(context, "Wrong guess. Spin the wheel again",Toast.LENGTH_SHORT).show()

            if (totalLives === 0) {
                spinButton.isEnabled = false
                Navigation.findNavController(requireView())
                    .navigate(R.id.action_playGameFragment_to_lossFragment)

            }

            return
        }

        var randomWordChars = randomWord.toCharArray()
        for ((i, item) in randomWordChars.withIndex()) {
            var word = randomWordDashes.get(i)
            if (item === guessedChar && word.isGuessed) {
                Toast.makeText(context, "Letter already used: " + guessedChar, Toast.LENGTH_SHORT)
                    .show()
                continue
            }


            if (item === guessedChar) {
                word.char = item
                word.isGuessed = true
            }
        }

        //update view with new guess chars
        rvRandomWord.adapter = ItemAdapter(randomWordDashes)

        //check if the whole random word is guessed
        var stillRemainingLetters = randomWordDashes.any { !it.isGuessed }
        if (!stillRemainingLetters) {
            //user guessed the whole word correctly
            spinButton.isEnabled = false
            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
            //TODO show fragment here..............
            Navigation.findNavController(requireView())
                .navigate(R.id.action_playGameFragment_to_winFragment)
        }
    }

    fun spin() {
        spinButton.setOnClickListener() {
            var rotateby = Random.nextInt(0, 7)
            var animator = wheel.animate()
            animator.rotationBy(-(720 + (rotateby) * 15).toFloat())
            animator.interpolator = DecelerateInterpolator(1.0f)
            animator.duration = 3200
            animator.start()
            animator.setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(a: Animator?) {
                    guessButton.isEnabled = false
                }

                override fun onAnimationRepeat(a: Animator?) {
                }

                override fun onAnimationEnd(a: Animator?) {
                    guessButton.isEnabled = true

                }

                override fun onAnimationCancel(a: Animator?) {

                }
            })
        }

    }


}

