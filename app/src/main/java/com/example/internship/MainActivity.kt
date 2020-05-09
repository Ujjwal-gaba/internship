package com.example.internship

import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout

import android.app.ActionBar
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.DataInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {
    // String url = "https://instagram.fjai5-1.fna.fbcdn.net/v/t51.2885-15/e35/95529855_237132100833842_410789908438787292_n.jpg?_nc_ht=instagram.fjai5-1.fna.fbcdn.net&_nc_cat=1&_nc_ohc=5KCcHl-wA-sAX9PFpVO&oh=a2856b07114e10c68f7a233d33b6803f&oe=5EDC7636";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener {
            val drawable = getDrawable(R.drawable.download)
            val bitmap = (drawable as BitmapDrawable).bitmap
//            var url: URL? = null
//            try {
//                url = URL("https://instagram.fjai5-1.fna.fbcdn.net/v/t51.2885-15/e35/95529855_237132100833842_410789908438787292_n.jpg?_nc_ht=instagram.fjai5-1.fna.fbcdn.net&_nc_cat=1&_nc_ohc=5KCcHl-wA-sAX9PFpVO&oh=a2856b07114e10c68f7a233d33b6803f&oe=5EDC7636")
//            } catch (e: MalformedURLException) {
//                e.printStackTrace()
//            }
//            //Bitmap bitmap = BitmapFactory.decodeFile();
//            var bitmap: Bitmap? = null
//            try {
//                assert(url != null)
//                bitmap = BitmapFactory.decodeStream(url!!.openConnection().getInputStream())
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//
            val file: File

            val path = Environment.getExternalStorageDirectory().toString()
            file = File(path, "UniqueFileName" + ".jpg")

            try {

                var stream: OutputStream? = null
                stream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)


                stream.flush()

                stream.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }


            val savedImageURI = Uri.parse(file.absolutePath)
            iv_saved.setImageURI(savedImageURI)
            tv_saved.text = "Image saved in external storage.\n$savedImageURI"
        }


    }
}


