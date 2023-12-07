package com.example.mymachinetesttechexactly.utils.utils2.aes;

import android.app.Activity;
import android.util.Log;

//import com.evgenii.jsevaluator.interfaces.JsCallback;
//import com.example.mymachinetesttechexactly.utils.utils2.aes.aesinterface.JsEncryptorInterface;
//import com.user.nestmarket.utils.aes.AESResponse;
//
//public class Encrypt {
//    Activity mActivity;
//    JsEncryptorInterface mJsEncryptor;
//    String encryptedPassword = "";
//
//    public Encrypt(Activity activity) {
//        mActivity = activity;
//        mJsEncryptor = JsEncryptor.evaluateAllScripts(activity);;
//    }
//
//    public AESResponse encryptAndUpdate(String password, String secret) {
//        AESResponse aes = new AESResponse();
//        mJsEncryptor.encrypt(password, secret,
//                new JsCallback() {
//                    @Override
//                    public void onResult(final String encryptedMessage) {
//                        aes.setSuccess(true);
//                        aes.setMessage(encryptedMessage);
//                        encryptedPassword= encryptedMessage;
//                        Log.d("encrypt2", encryptedMessage);
//                    }
//
//                    @Override
//                    public void onError(String errorMessage) {
//                        // Process JavaScript error here.
//                        // This method is called in the UI thread.
//                        Log.d("encrypt5", errorMessage);
//                        aes.setSuccess(false);
//                        aes.setMessage(errorMessage);
//                    }
//                });
//        return aes;
//    }
//
//
//    public String getEncryptedPassword() {
//        return encryptedPassword;
//    }
//}
