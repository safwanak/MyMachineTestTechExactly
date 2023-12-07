package com.user.nestmarket.utils

import android.Manifest

object AppString {
    const val appName = "Inmate Inbox"

    /*** App Version ***/
    const val appVersion = "4.0"

    const val PERMISSIONS_REQUEST_CODE = 102

    val appPermissions =
        arrayOf(
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

    const val inbox = "Inbox/Archived"
    const val draft = "Draft"
    const val writeMessage = "Write Message/Photo"
    const val sentPhotos = "Sent Photos"
    const val myContact = "My Contacts"
    const val purchaseCredit = "Purchase Credit"
    const val myAccount = "My Account"
    const val findInmate = "Find Inmates"
    const val settings = "Settings"
    const val support = "Support"
    const val logout = "Logout"

    const val terms = "Terms and Conditions"
    const val privacy = "Privacy Policy"
    const val PREF_IMAGE_URI = "prefimageuri"
}