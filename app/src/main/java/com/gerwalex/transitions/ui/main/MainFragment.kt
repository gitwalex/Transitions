package com.gerwalex.transitions.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gerwalex.lib.main.BasicFragment
import com.gerwalex.transitions.R
import com.gerwalex.transitions.databinding.FragmentMainBinding

class MainFragment : BasicFragment() {

    private val mapRadioBtn2Transition = mapOf(
        R.id.slide_out_left to R.anim.slide_out_left,
        R.id.slide_out_right to R.anim.slide_out_right,
        R.id.slide_out_top to R.anim.slide_out_top,
        R.id.slide_out_bottom to R.anim.slide_out_bottom,
        R.id.slide_in_left to R.anim.slide_in_left,
        R.id.slide_in_right to R.anim.slide_in_right,
        R.id.slide_in_top to R.anim.slide_in_top,
        R.id.slide_in_bottom to R.anim.slide_in_bottom,
        R.id.puff_in to R.anim.puff_in,
        R.id.puff_out to R.anim.puff_out,
        R.id.scale_in to R.anim.scale_in,
        R.id.scale_out to R.anim.scale_out,
    )
    private val mapRadioBtn2PopTransition = mapOf(
        R.id.slide_out_left to R.anim.slide_in_left,
        R.id.slide_out_right to R.anim.slide_in_right,
        R.id.slide_out_top to R.anim.slide_in_top,
        R.id.slide_out_bottom to R.anim.slide_in_bottom,
        R.id.slide_in_left to R.anim.slide_out_left,
        R.id.slide_in_right to R.anim.slide_out_right,
        R.id.slide_in_top to R.anim.slide_out_top,
        R.id.slide_in_bottom to R.anim.slide_out_bottom,
        R.id.puff_in to R.anim.puff_out,
        R.id.puff_out to R.anim.puff_in,
        R.id.scale_in to R.anim.scale_out,
        R.id.scale_out to R.anim.scale_in,
    )
    private var conainerid: Int = -1
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        conainerid = container?.id ?: -1
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startButton.setOnClickListener {
            val exit = mapRadioBtn2Transition.get(binding.exitTransition.checkedRadioButtonId)!!
            val enter = mapRadioBtn2Transition.get(binding.enterTransition.checkedRadioButtonId)!!
            val popExit = mapRadioBtn2PopTransition.get(binding.exitTransition.checkedRadioButtonId)!!
            val popEnter = mapRadioBtn2PopTransition.get(binding.enterTransition.checkedRadioButtonId)!!
            requireActivity().supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(enter, exit, popExit, popEnter)
                .replace(conainerid,
                    FragmentPicture())
                .addToBackStack(null)
                .commit()
        }
    }
}