package com.technicalrupu.learningweek1.firebase

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.technicalrupu.learningweek1.R
import android.content.SharedPreferences
import com.squareup.picasso.Picasso
import androidx.annotation.NonNull
import com.google.android.gms.auth.api.signin.GoogleSignIn

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class Profile : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val personName = intent.getStringExtra("personName")
        val personGivenName = intent.getStringExtra("personGivenName")
        val personFamilyName = intent.getStringExtra("personFamilyName")
        val personEmail = intent.getStringExtra("personEmail")
        val personId = intent.getStringExtra("personId")
        val uri = intent.getStringExtra("personPhoto")

        val name = findViewById<TextView>(R.id.txtName)
        name.text = "Name : $personName"

        val givenName = findViewById<TextView>(R.id.txtGivenName)
        givenName.text = "Given Name : $personGivenName"

        val familyName = findViewById<TextView>(R.id.txtFamilyName)
        familyName.text = "Family Name : $personFamilyName"

        val email = findViewById<TextView>(R.id.txtEmail)
        email.text = "Email : $personEmail"

        val id = findViewById<TextView>(R.id.txtId)
        id.text = "ID : $personId"

         if(uri!=null) {
             val photo = findViewById<ImageView>(R.id.photo)
             Picasso.get().load(uri).into(photo)
         }

        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this, OnCompleteListener<Void?> {
                val preferences = getSharedPreferences("Google_SignIn", 0)
                preferences.edit().remove("email").remove("id").apply()
                finish()
            })
    }
}