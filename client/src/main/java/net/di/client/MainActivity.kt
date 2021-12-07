package net.di.client

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import net.di.ipc.IAdd
import net.di.ipc.IMessage

class MainActivity : AppCompatActivity() {
    lateinit var iAdd: IAdd
    lateinit var iMessage: IMessage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initConnection()
    }

    private fun initConnection() {
        val intent = Intent(IAdd::class.java.name)
        intent.action = "service.calc"
        intent.setPackage("net.di.aidlasreturntype")
        bindService(intent, serviceConnection, BIND_AUTO_CREATE)
    }

    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
            Log.d("kajal", "Service Connected:componentName$componentName")
            iAdd = IAdd.Stub.asInterface(iBinder)
            val res=iAdd.getSum(2,4)
            Log.d("kajal", "result:$res")
        }
        override fun onServiceDisconnected(componentName: ComponentName) {
            Log.d("kajal", "Service Disconnected")
        }
    }
}









//
//val intent2 = Intent(IMessage::class.java.name)
///*this is service name which has been declared in the server's manifest file in service's intent-filter*/
//intent2.action = "service.calc"
//intent2.putExtra("Id", 2);
//intent2.setPackage("net.di.aidlasreturntype")

//bindService(intent2, serviceConnection2, BIND_AUTO_CREATE)


//
//private val serviceConnection2: ServiceConnection = object : ServiceConnection {
//    override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
//        Log.d("kajal", "Service Connected:componentName$componentName")
//        messageService = IMessage.Stub.asInterface(iBinder)
//        messageService.displayMessage()
//    }
//
//    override fun onServiceDisconnected(componentName: ComponentName) {
//        Log.d("kajal", "Service Disconnected message")
//    }
//}