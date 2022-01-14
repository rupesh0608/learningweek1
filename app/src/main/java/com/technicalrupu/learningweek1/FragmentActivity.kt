package com.technicalrupu.learningweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.technicalrupu.learningweek1.Fragments.CloseFragment
import com.technicalrupu.learningweek1.Fragments.FadeFragment
import com.technicalrupu.learningweek1.Fragments.NormalFragment
import com.technicalrupu.learningweek1.Fragments.OpenFragment
import com.technicalrupu.learningweek1.Helper.Fragment

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        title="Fragments"

        val btn=com.technicalrupu.learningweek1.Helper.Button(this)
        val fragment = Fragment(this)

        val normalFragmentBtn = btn.create(R.id.btnNormal)

        normalFragmentBtn.setOnClickListener {
            fragment.change(R.id.fragmentContainer, NormalFragment())
        }

        val defaultBtnOpen = btn.create(R.id.btnOpen)
        defaultBtnOpen.setOnClickListener {
            fragment.setDefaultTransition(
                R.id.fragmentContainer,
                OpenFragment(),
                FragmentTransaction.TRANSIT_FRAGMENT_OPEN
            )
        }

        val defaultBtnClose =btn.create(R.id.btnClose)
        defaultBtnClose.setOnClickListener {
            fragment.setDefaultTransition(
                R.id.fragmentContainer,
                CloseFragment(),
                FragmentTransaction.TRANSIT_FRAGMENT_CLOSE
            )
        }

        val defaultBtnFade = btn.create(R.id.btnFade)
        defaultBtnFade.setOnClickListener {
            fragment.setDefaultTransition(
                R.id.fragmentContainer,
                FadeFragment(),
                FragmentTransaction.TRANSIT_FRAGMENT_FADE
            )
        }

        // Custom Animation

        val btnUp = btn.create(R.id.btnUp)
        btnUp.setOnClickListener {
            fragment.setCustomAnimation(
                R.id.fragmentContainer,
                FadeFragment(),
                R.anim.slide_in_up
            )
        }

        val btnDown =btn.create(R.id.btnDown)
        btnDown.setOnClickListener {
            fragment.setCustomAnimation(
                R.id.fragmentContainer,
                FadeFragment(),
                R.anim.slide_in_down
            )
        }

        val btnLeft =btn.create(R.id.btnLeft)
        btnLeft.setOnClickListener {
            fragment.setCustomAnimation(
                R.id.fragmentContainer,
                FadeFragment(),
                R.anim.slide_in_left
            )
        }

        val btnRight =btn.create(R.id.btnRight)
        btnRight.setOnClickListener {
            fragment.setCustomAnimation(
                R.id.fragmentContainer,
                FadeFragment(),
                R.anim.slide_in_right
            )
        }

    }



}