package com.technicalrupu.learningweek1

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.common.SignInButton
import com.technicalrupu.learningweek1.firebase.SimpleLoginSignupActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.api.ApiException
import com.technicalrupu.learningweek1.firebase.GoogleSigInActivity


class FireBaseActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_base)
        title = "Firebase Connection"

        val simpleLogin = findViewById<Button>(R.id.btnSimpleSignupLogin)
        simpleLogin.setOnClickListener {
            startActivity(Intent(this, SimpleLoginSignupActivity::class.java))
        }
        val googleSignIn = findViewById<Button>(R.id.btnGoogleSignIn)
        googleSignIn.setOnClickListener {
            startActivity(Intent(this, GoogleSigInActivity::class.java))
        }


    }

}