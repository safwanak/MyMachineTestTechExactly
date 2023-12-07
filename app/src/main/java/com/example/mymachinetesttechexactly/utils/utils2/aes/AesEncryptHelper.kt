package com.user.nestmarket.utils.aes

import android.content.Context
import android.util.Log
//import com.evgenii.jsevaluator.interfaces.JsCallback
//import com.example.mymachinetesttechexactly.utils.utils2.aes.JsEncryptor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//object AesEncryptHelper {
//    suspend fun getEncryptPassword(activity: Context, password:String, encryptSecretKey:String): String = suspendCoroutine { continuation ->
//        JsEncryptor.evaluateAllScripts(activity).encrypt(password, encryptSecretKey,
//            object : JsCallback {
//                override fun onResult(encryptedMessage: String) {
//                    Log.d("CoroutineJob", encryptedMessage)
//                    continuation.resume(encryptedMessage)
//
//                }
//
//                override fun onError(errorMessage: String) {
//                    // Process JavaScript error here.
//                    // This method is called in the UI thread.
//                    Log.d("encrypt5", errorMessage)
//                    continuation.resume("")
//                }
//            })
//    }
//}