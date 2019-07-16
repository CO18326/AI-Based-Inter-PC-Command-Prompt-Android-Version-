package com.example.ganesh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*
import java.io.*
import java.net.ServerSocket
import java.net.Socket
import android.R.id.message
import android.R.attr.port
import android.content.Context
import android.net.wifi.WifiManager
import android.os.AsyncTask
import android.os.StrictMode
import java.net.InetAddress


class MainActivity : AppCompatActivity() {

    /*class threds : Thread(){

        override fun run(){
            while (true){ser=ServerSocket(1419)
            var so=ser.accept()

            ot=DataOutputStream(so.getOutputStream())
            it=DataInputStream(BufferedInputStream(so.getInputStream()))}
        }

    }*/

    lateinit var ot : DataOutputStream
    lateinit var terc : EditText //= findViewById(R.id.ET)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        //StrictMode.setThreadPolicy(policy)

        // ser=ServerSocket(7800)
        //Toast.makeText(p[0],"123",Toast.LENGTH_SHORT)
        //var so=ser.accept()
        // Toast.makeText(p[0],"123",Toast.LENGTH_SHORT).show()
        //ot=DataOutputStream(so.getOutputStream())
    val butt : Button =findViewById(R.id.roll_butt)
        butt.setOnClickListener{act()}
        val butt1 : Button =findViewById(R.id.roll_but)
        butt1.setOnClickListener{act2()}
    }
    private fun action1(){
        //Toast.makeText(this,"I am Clicked",Toast.LENGTH_SHORT).show()
        //var tc : ImageView =findViewById(R.id.Tv)
        var imt  :ImageView=findViewById(R.id.Tv)
        imt.setImageResource(when (Random().nextInt(6)+1){
         1 -> R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            6->R.drawable.dice_6
            else->12
        })
    }
    private fun act(){
        //var jk : EditText = findViewById(R.id.ET)
       // var gh =Thread(threds())
       // gh.start()


              /*  Toast.makeText(this,"running",Toast.LENGTH_SHORT).show()
       var thread= Thread(Runnable{ var ser=ServerSocket(7800)
           //ser.bind("192.168.43.162")
           var so=ser.accept()

            //
             ot=DataOutputStream(so.getOutputStream())
            var it=DataInputStream(BufferedInputStream(so.getInputStream()))})

    thread.start()*/

        /*var tyu=ServerConnection()
            tyu.execute(this)
        Toast.makeText(this,"123",Toast.LENGTH_SHORT).show()*/
       terc = findViewById(R.id.ET)
        var drf=serverthread(this)
        drf.start()
    }
    private fun act2(){
        var wm : WifiManager = getApplicationContext().getSystemService(WIFI_SERVICE) as WifiManager
        var ip : String =wm.getConnectionInfo().getIpAddress().toString()
        Toast.makeText(this, ip,Toast.LENGTH_SHORT).show()
        //ot.writeUTF("browser")
    }

}
class serverthread : Thread{
    lateinit var jnm : MainActivity
    constructor(lk:MainActivity):super(){
        jnm=lk
    }
   override fun run(){
       //Toast.makeText(jnm,"rnning",Toast.LENGTH_SHORT)
       var serversock=ServerSocket(8080)
       var sock = serversock.accept()
        jnm.ot=DataOutputStream(sock.getOutputStream())
       //Toast.makeText(jnm,"connected",Toast.LENGTH_SHORT).show()

       jnm.ot.writeUTF(jnm.terc.text.toString())
       //}var t=Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

   }



}
class ServerConnection : AsyncTask<MainActivity, Void, Void>() {


    override fun doInBackground(vararg p:MainActivity): Void? {


       while (true){
        var ser=ServerSocket(7800)
        //Toast.makeText(p[0],"123",Toast.LENGTH_SHORT)
        var so=ser.accept()
       // Toast.makeText(p[0],"123",Toast.LENGTH_SHORT).show()
        var ot=DataOutputStream(so.getOutputStream())
       ot.writeUTF("browser")}
        //var it=DataInputStream(BufferedInputStream(so.getInputStream()))*/

        return null
    }
}