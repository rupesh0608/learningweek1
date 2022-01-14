package com.technicalrupu.learningweek1.firebase

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.tasks.Task
import com.technicalrupu.learningweek1.R

class GoogleSigInActivity : AppCompatActivity() {
    lateinit var gso: GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_sig_in)

        gso= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        val googleSignIn = findViewById<SignInButton>(R.id.btnGoogleSignIn)
        googleSignIn.setSize(SignInButton.SIZE_STANDARD)

        check()

        googleSignIn.setOnClickListener {
            signIn(mGoogleSignInClient)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun check() {
        val sharedPref = this.getSharedPreferences(
            "Google_SignIn", Context.MODE_PRIVATE
        )
        val email=sharedPref.getString("email","")
        val id=sharedPref.getString("id","")
        if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(id))
        {
            return
        }else{
            val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {
                val intent=Intent(this,Profile::class.java)
                intent.putExtra( "personName" ,acct.displayName.toString())
                intent.putExtra( "personGivenName",acct.givenName.toString())
                intent.putExtra( "personFamilyName",acct.familyName.toString())
                intent.putExtra( "personEmail" ,acct.email.toString())
                intent.putExtra( "personId" ,acct.id.toString())
                val url=acct.photoUrl
                if(url!=null) {
                    intent.putExtra("personPhoto", acct.photoUrl.toString())
                }
                startActivity(intent)
                finish()
            }
        }
    }

    private fun signIn(mGoogleSignInClient: GoogleSignInClient) {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, 101)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {

                saveToSharedPreference(acct)
                 openProfileActivity(acct)
            }else{
                Toast.makeText(this,"Some thing went Wrong",Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {

            Toast.makeText(this,"Error: ${e.message}",Toast.LENGTH_LONG).show()
        }
    }

    private fun openProfileActivity(acct: GoogleSignInAccount) {
        val intent=Intent(this,Profile::class.java)
        intent.putExtra( "personName" ,acct.displayName.toString())
        intent.putExtra( "personGivenName",acct.givenName.toString())
        intent.putExtra( "personFamilyName",acct.familyName.toString())
        intent.putExtra( "personEmail" ,acct.email.toString())
        intent.putExtra( "personId" ,acct.id.toString())
        val url=acct.photoUrl
        if(url!=null) {
            intent.putExtra("personPhoto", acct.photoUrl.toString())
        }
        startActivity(intent)
    }

    private fun saveToSharedPreference(acct: GoogleSignInAccount) {
        val sharedPref = this.getSharedPreferences(
            "Google_SignIn", Context.MODE_PRIVATE
        )
        val email=acct.email.toString()
        val id=acct.id.toString()
        sharedPref.edit()
            .putString("email", email)
            .putString("id", id)
            .apply()
    }
}