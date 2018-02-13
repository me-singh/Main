package com.dev.apay.utils

import android.content.Context
import android.net.ConnectivityManager
import com.dev.apay.BuildConfig


/**
 * @author Pankaj Arora
 */
class GlobalConstants {
    companion object {
        const val BaseURL = BuildConfig.SERVER_URL
        const val LoginURL = ""
        const val RegisterURL = ""
        const val VerifyOTPURL = ""

        fun isConnectedToNetwork(ctx: Context): Boolean {
            val connectivityManager = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivityManager.activeNetworkInfo
            return info != null && info.isConnected
        }
    }
}