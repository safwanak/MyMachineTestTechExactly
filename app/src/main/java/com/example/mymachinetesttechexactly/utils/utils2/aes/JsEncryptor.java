package com.example.mymachinetesttechexactly.utils.utils2.aes;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;
import com.evgenii.jsevaluator.interfaces.JsEvaluatorInterface;
import com.user.nestmarket.utils.aes.AssetsFileReader;import com.user.nestmarket.utils.aes.aesinterface.AssetsFileReaderInterface;
import com.user.nestmarket.utils.aes.aesinterface.JsEncryptorInterface;

import java.io.IOException;
import java.util.ArrayList;

/** Encrypts text using JavaScript library */
public class JsEncryptor implements JsEncryptorInterface {
    public static JsEncryptor evaluateAllScripts(Context context) {
        final AssetsFileReader assetsFileReader = new AssetsFileReader(context);
        final JsEvaluator jsEvaluator = new JsEvaluator(context.getApplicationContext());
        final JsEncryptor jsEncryptor = new JsEncryptor(assetsFileReader, jsEvaluator);
        try {
            jsEncryptor.readScripts();
        } catch (final IOException e) {
            System.out.println("Can not read JavaScript file.");
            System.out.println(e);
            Log.d("encrypt3", "Can not read JavaScript file.");
            Log.d("encrypt3", e.toString());
        }
        return jsEncryptor;
    }

    private final AssetsFileReaderInterface mAssetsFileReader;
    private final JsEvaluatorInterface mJsEvaluator;
    private final String cryptoJsFileNames = "crypto_js";
    private final String aesCryptoFileName = "aes_crypto";
    private final String jsRootDir = "javascript";

    private static final String prefix = "AESCryptoV10";

    private ArrayList<String> mScriptsText;

    public JsEncryptor(AssetsFileReaderInterface assetsFileReader, JsEvaluatorInterface jsEvaluator) {
        mAssetsFileReader = assetsFileReader;
        mJsEvaluator = jsEvaluator;
    }

    public String concatenateScripts() {
        final StringBuilder stringBuilder = new StringBuilder();
        final ArrayList<String> scripts = getScripts();
        for (final String scriptText : scripts) {
            stringBuilder.append(scriptText);
            stringBuilder.append("; ");
        }

        return stringBuilder.toString();
    }

    @Override
    public void decrypt(String text, String password, JsCallback callback) {
        final String libraryJsCode = concatenateScripts();
        mJsEvaluator.callFunction(libraryJsCode, callback, "aesCrypto.decrypt", text, password);
    }

    @Override
    public void encrypt(String text, String password, JsCallback callback) {
        final String libraryJsCode = concatenateScripts();
        mJsEvaluator.callFunction(libraryJsCode, callback, "aesCrypto.encrypt", text, password);
    }

    public ArrayList<String> getScripts() {
        if (mScriptsText == null) {
            mScriptsText = new ArrayList<String>();
        }
        return mScriptsText;
    }

    @Override
    public boolean isEncrypted(String text) {
        if (text == null)
            return false;

        return text.trim().startsWith(prefix);
    }

    public void readScripts() throws IOException {
        final ArrayList<String> scriptsToLoad = new ArrayList<String>();

        scriptsToLoad.add(jsRootDir + "/" + cryptoJsFileNames + ".js");
        scriptsToLoad.add(jsRootDir + "/" + aesCryptoFileName + ".js");

        final ArrayList<String> scriptsText = getScripts();

        for (final String scriptName : scriptsToLoad) {
            scriptsText.add(mAssetsFileReader.ReadFile(scriptName));
        }
    }
}
