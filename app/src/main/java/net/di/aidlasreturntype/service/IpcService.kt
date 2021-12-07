package net.di.aidlasreturntype.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import net.di.ipc.IAdd
import net.di.ipc.IMessage

class IpcService : Service() {

    override fun onBind(intent: Intent?): IBinder {
        return iAdd
    }

    val iAdd = object : IAdd.Stub() {

        override fun getSum(a: Int, b: Int): Int {
            return a + b
        }

//        fun getMessage(): IBinder {
//            val iMessage = object : IMessage.Stub() {
//                override fun displayMessage() {
//                    Log.d("kajal", "displayMessage-in A")
//                }
//            }
//            return iMessage
//        }
    }
    val iMessage = object : IMessage.Stub() {
        override fun displayMessage() {
            Log.d("kajal", "displayMessage-in A")
        }
    }
}


//val id= intent?.getIntExtra("Id",0)