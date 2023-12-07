package com.user.nestmarket.utils.validation

import android.app.Activity
import android.util.Patterns
import cn.pedant.SweetAlert.SweetAlertDialog
import com.user.nestmarket.utils.sweetalert.SweetAlertHelper
import java.util.regex.Pattern

object AppValidation {
    fun isValidEmail(s: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(s).matches()
    }

    fun isEmpty(s: String): Boolean {
        return s.isEmpty()
    }

    fun isNotEmpty(s: String): Boolean {
        return s.isNotEmpty()
    }

    private const val nameRegex = "^[A-Za-z\\s]+[.]?[A-Za-z\\s]*$"
    private const val zipRegex = "^[0-9]{5}\$"
    private const val letterOnlyRegex = "^[A-Za-z\\s]*$"
    private const val numberOnlyRegex = "^[0-9\\s]*$"
    private const val passwordRegex =
        "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{8,}\$"
    private const val newPasswordRegex =
        "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}\$"

    private const val hasUppercaseRegex = "^(?=.*[A-Z]).+$"
    private const val hasLowercaseRegex = "^(?=.*[a-z]).+$"
    private const val hasNumberRegex = "^(?=.*[0-9]).+$"
    private const val hasSpecialCharacterRegex = "^(?=.*?[#?!@\$%^&*-]).+$"

    fun checkName(name: String): Boolean {
        return Pattern.compile(nameRegex).matcher(name).matches()
    }

    fun checkPassword(password: String): Boolean {
        return Pattern.compile(newPasswordRegex).matcher(password).matches()
    }

    fun hasUpperCase(password: String): Boolean {
        return Pattern.compile(hasUppercaseRegex).matcher(password).matches()
    }

    fun hasLowerCase(password: String): Boolean {
        return Pattern.compile(hasLowercaseRegex).matcher(password).matches()
    }

    fun hasNUmber(password: String): Boolean {
        return Pattern.compile(hasNumberRegex).matcher(password).matches()
    }

    fun hasSpecialCharacter(password: String): Boolean {
        return Pattern.compile(hasSpecialCharacterRegex).matcher(password).matches()
    }


    fun checkZipCode(zip: String): Boolean {
        return Pattern.compile(zipRegex).matcher(zip).matches()
    }

    fun letterOnly(letterOnlyText: String): Boolean {
        return Pattern.compile(letterOnlyRegex).matcher(letterOnlyText).matches()
    }

    fun numberOnly(numberOnlyText: String): Boolean {
        return Pattern.compile(numberOnlyRegex).matcher(numberOnlyText).matches()
    }

    fun isPriceValid(inputPrice: String, context: Activity): Boolean {
        val price = inputPrice.trim()
        return when {
            price.isEmpty() -> {
                SweetAlertHelper.showAlertDialog(
                    context,
                    SweetAlertDialog.WARNING_TYPE,
                    SweetAlertHelper.sweetAlert,
                    "Kindly enter the price",
                    SweetAlertHelper.sweetOk,
                    null
                )
                false
            }

            price == "." -> {
                SweetAlertHelper.showAlertDialog(
                    context,
                    SweetAlertDialog.WARNING_TYPE,
                    SweetAlertHelper.sweetAlert,
                    "Kindly enter valid price",
                    SweetAlertHelper.sweetOk,
                    null
                )
                false
            }

            (price.toFloat() < 1000) -> {
                SweetAlertHelper.showAlertDialog(
                    context,
                    SweetAlertDialog.WARNING_TYPE,
                    SweetAlertHelper.sweetAlert,
                    "Kindly add price above \$1000 to proceed further",
                    SweetAlertHelper.sweetOk,
                    null
                )
                false
            }

            else -> {
                true
            }
        }
    }

    fun isValidMobile(phone: String): Boolean {
        return phone.length >= 10 && Patterns.PHONE.matcher(phone).matches() && phone.length <= 20
    }
}
