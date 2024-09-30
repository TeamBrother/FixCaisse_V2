package com.example.vehiclemaintenanceapp

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_entry.*

class AddEntryActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE_ODOMETER = 1
    private val REQUEST_IMAGE_CAPTURE_INVOICE = 2
    private var photoOdometer: Bitmap? = null
    private var photoInvoice: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        btnTakePhotoOdometer.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_ODOMETER)
            }
        }

        btnTakePhotoInvoice.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_INVOICE)
            }
        }

        btnSaveEntry.setOnClickListener {
            // Sauvegarder les informations de l'entrée de maintenance et les photos
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE_OD
