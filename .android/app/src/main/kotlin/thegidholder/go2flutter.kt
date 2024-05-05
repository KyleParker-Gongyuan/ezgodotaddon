package thegidholder

import android.content.Context
import android.content.Intent
import androidx.annotation.NonNull
import godotplugin.godotpluginMaster

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodChannel

class go2flutter: FlutterActivity()  {
    private val METHOD_CHNNEL_NAME = "com.kaiyo.ezgodot/method";
    private val GENERIC_CHNNEL_NAME = "com.kaiyo.ezgodot/generic";
    private val DATABASE_CHNNEL_NAME = "com.kaiyo.ezgodot/database"
    private val EXIT_CHNNEL_NAME = "com.kaiyo.ezgodot/exit"

    private val eventName =  "kaiyo.ezgodot/generic";
    //private HelloWorld helloWorld = new MainActivitytwo();
    //val helloWorld = godotpluginMaster();
    val helloWorld = godotpluginMaster(null);

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)



        val events = EventChannel(flutterEngine.dartExecutor.binaryMessenger, eventName).setStreamHandler(helloWorld);
    }

    override fun onDestroy() {

        super.onDestroy()
    }
}