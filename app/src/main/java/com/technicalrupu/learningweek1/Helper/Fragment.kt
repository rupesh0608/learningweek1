package com.technicalrupu.learningweek1.Helper

import androidx.fragment.app.Fragment
import com.technicalrupu.learningweek1.FragmentActivity


class Fragment(context: FragmentActivity) {

    private var ref: FragmentActivity = context


    fun change(containerId: Int, fragment: Fragment) {

        ref.supportFragmentManager.beginTransaction().replace(containerId, fragment).commit()
    }

    fun setDefaultTransition(
        containerId: Int,
        fragment: Fragment,
        transition: Int
    ) {
        ref.supportFragmentManager.beginTransaction()
            .setTransition(transition)
            .replace(containerId, fragment)
            .commit()
    }

    fun setCustomAnimation(
        containerId: Int,
        fragment: Fragment,
        animation: Int
    ) {
        ref.supportFragmentManager.beginTransaction()
            .setCustomAnimations(animation, animation)
            .replace(containerId, fragment)
            .commit()
    }
}