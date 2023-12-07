package com.user.nestmarket.utils

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.user.nestmarket.MainActivity
import com.user.nestmarket.R
import com.user.nestmarket.ui.component.login.LoginSignUpActivity
import com.user.nestmarket.utils.localsp.GetAndSetSP
import com.user.nestmarket.utils.network.NetworkToken

object ActivityHelper {
    fun <T : Any> clearAllActivity(mActivity: T) {
        GetAndSetSP(mActivity as AppCompatActivity).setSP(
            NetworkToken.netWorkTokenTitle, NetworkToken.netWorkToken, ""
        )
        val intent = Intent(mActivity as AppCompatActivity, LoginSignUpActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        /*** From Right to Right ***/
        val options = ActivityOptions.makeCustomAnimation(
            mActivity as AppCompatActivity,
            R.anim.push_right_in,
            R.anim.push_right_out,
        )
        mActivity.startActivity(intent, options.toBundle())
    }

    fun <T : Any, S : Any> clearActivityWithGivenActivity(fromActivity: T, toActivity: Class<S>) {
        val intent = Intent(fromActivity as AppCompatActivity, toActivity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val options = ActivityOptions.makeCustomAnimation(
            fromActivity as AppCompatActivity,
            R.anim.push_right_in,
            R.anim.push_left_out,
        )
        fromActivity.startActivity(intent, options.toBundle())
    }

    fun <T : Any, S : Any> goToCertainActivity(fromActivity: T, toActivity: Class<S>) {
        val intent = Intent(fromActivity as AppCompatActivity, toActivity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        /*** From Left to Left ***/
        val options = ActivityOptions.makeCustomAnimation(
            fromActivity as AppCompatActivity,
            R.anim.push_left_in,
            R.anim.push_left_out,
        )
        fromActivity.startActivity(intent, options.toBundle())
    }

    fun <T : Any> goToDashBoardActivity(mActivity: T) {
        /*Testing Start*/
        val intent = Intent(mActivity as AppCompatActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        /*** From Right to Right ***/
        val options = ActivityOptions.makeCustomAnimation(
            mActivity as AppCompatActivity,
            R.anim.push_right_in,
            R.anim.push_right_out,
        )
        mActivity.startActivity(intent, options.toBundle())
    }

    fun <T : Any, S : Any> goLeftInAndLeftOut(fromActivity: T, toActivity: Class<S>) {
        val intent = Intent(fromActivity as AppCompatActivity, toActivity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        /*** From Left to Left ***/
        val options = ActivityOptions.makeCustomAnimation(
            fromActivity as AppCompatActivity,
            R.anim.push_left_in,
            R.anim.push_left_out,
        )
        fromActivity.startActivity(intent, options.toBundle())
    }

    fun <T : Any, S : Any> goRightInRightOut(fromActivity: T, toActivity: Class<S>) {
        val intent = Intent(fromActivity as AppCompatActivity, toActivity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        /*** From Left to Left ***/
        val options = ActivityOptions.makeCustomAnimation(
            fromActivity as AppCompatActivity,
            R.anim.push_right_in,
            R.anim.push_right_out,
        )
        fromActivity.startActivity(intent, options.toBundle())
    }

}