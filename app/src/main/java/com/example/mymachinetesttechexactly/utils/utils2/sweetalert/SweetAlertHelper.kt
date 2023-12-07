package com.user.nestmarket.utils.sweetalert

//import android.app.Activity
//import android.graphics.Color
//import cn.pedant.SweetAlert.SweetAlertDialog
//
//object SweetAlertHelper {
//    const val sweetOk = "Ok"
//    const val sweetCancel = "Cancel"
//    const val sweetConfirm = "Confirm"
//    const val sweetYes = "Yes"
//    const val sweetNo = "No"
//    const val sweetAlert = "Alert!"
//    const val sweetSuccess = "Success"
//    const val sweetLoading = "Loading... Please wait..."
//    const val sweetExit = "Are you sure to exit?"
//
//    fun showAlertProgress(sweetAlertDialog: SweetAlertDialog, message: String) {
//        sweetAlertDialog.invalidateOptionsMenu()
//        sweetAlertDialog.titleText = message
//        sweetAlertDialog.progressHelper.barColor = Color.parseColor("#633708")
//        sweetAlertDialog.setCancelable(false)
//        sweetAlertDialog.show()
//    }
//
//    /*const val NORMAL_TYPE = 0
//    const val ERROR_TYPE = 1
//    const val SUCCESS_TYPE = 2
//    const val WARNING_TYPE = 3
//    const val CUSTOM_IMAGE_TYPE = 4
//    const val PROGRESS_TYPE = 5*/
//
//    fun showAlertDialog(
//        activity: Activity,
//        type: Int,
//        title: String,
//        message: String,
//        confirm: String,
//        confirmListener: SweetAlertDialog.OnSweetClickListener?
//    ) {
//        val sw = SweetAlertDialog(activity, type)
//            .setTitleText(title)
//            .setContentText(message)
//            .setConfirmText(confirm)
//            .showCancelButton(false)
//        when {
//            confirmListener != null -> {
//                sw.setConfirmClickListener(confirmListener)
//            }
//
//            else -> {
//                sw.setConfirmClickListener { it.dismissWithAnimation() }
//            }
//        }
//        sw.setCancelable(false)
//        sw.setCanceledOnTouchOutside(false)
//        sw.confirmButtonBackgroundColor = Color.parseColor("#946132")
//        sw.cancelButtonBackgroundColor = Color.parseColor("#946132")
//        sw.show()
//    }
//
//    fun showAlertDialogWithCancel(
//        activity: Activity,
//        type: Int,
//        title: String,
//        message: String,
//        confirm: String,
//        cancel: String,
//        confirmListener: SweetAlertDialog.OnSweetClickListener?,
//        cancelListener: SweetAlertDialog.OnSweetClickListener?
//    ) {
//        val sw = SweetAlertDialog(activity, type)
//            .setTitleText(title)
//            .setContentText(message)
//            .setConfirmText(confirm)
//            .setCancelText(cancel)
//            .showCancelButton(false)
//        when {
//            confirmListener != null -> {
//                sw.setConfirmClickListener(confirmListener)
//            }
//
//            else -> {
//                sw.setConfirmClickListener { it.dismissWithAnimation() }
//            }
//        }
//        when {
//            cancelListener != null -> {
//                sw.setCancelClickListener(cancelListener)
//            }
//
//            else -> {
//                sw.setCancelClickListener { it.dismissWithAnimation() }
//            }
//        }
//        sw.setCancelable(false)
//        sw.setCanceledOnTouchOutside(false)
//        sw.confirmButtonBackgroundColor=Color.parseColor("#946132")
//        sw.cancelButtonBackgroundColor=Color.parseColor("#946132")
//        sw.show()
//    }
//
//    fun hideProgress(sweetAlertDialog: SweetAlertDialog) {
//        when (sweetAlertDialog.isShowing) {
//            true -> {
//                sweetAlertDialog.dismiss()
//            }
//
//            else -> {
//
//            }
//        }
//    }
//
//    /* @SuppressLint("SetJavaScriptEnabled")
//     fun showExtraInfo(activity: Activity, info: String) {
//         val sw = SweetAlertDialog(activity)
//         val bind: DialogExtraInformationBinding =
//         DialogExtraInformationBinding.inflate(activity.layoutInflater)
//         bind.defContent.webViewClient = WebViewClient()
//         bind.defContent.settings.javaScriptEnabled = true
//         bind.defContent.settings.domStorageEnabled = true
//         bind.defContent.settings.loadsImagesAutomatically = true
//         bind.defContent.settings.setAppCacheEnabled(true)
//         bind.defContent.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
//         val str = "<html><body>${info}</body></html>"
//         println(info)
//         bind.defContent.loadDataWithBaseURL(null, str, "text/html", "utf-8", null)
//
//         sw.setCanceledOnTouchOutside(false)
//         sw.setCustomView(bind.root)
//             .setConfirmText("Close")
//             .show()
//     }*/
//}
