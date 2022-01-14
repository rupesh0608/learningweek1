package com.technicalrupu.learningweek1.firebase

import android.R.attr
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.technicalrupu.learningweek1.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult


import com.google.android.gms.tasks.OnCompleteListener

import android.os.Build
import android.text.TextUtils
import androidx.annotation.RequiresApi


class SimpleLoginSignupActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_login_signup)
        title = "Simple Signup and Login"
        auth = FirebaseAuth.getInstance();

        val edtUsername = findViewById<EditText>(R.id.txtUsername)
        edtUsername.requestFocus()
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            disableKeyboard()
            signUp()
        }
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {

            login()
        }
    }

    private fun login() {
        val edtUsername = findViewById<EditText>(R.id.txtUsername)
        val edtPassword = findViewById<EditText>(R.id.txtPassword)

        if (!edtUsername.text.contains("@gmail.com")) {
            Toast.makeText(this, "Enter Valid Email as username", Toast.LENGTH_LONG).show()
        } else {
            if (TextUtils.isEmpty(edtUsername.text) || TextUtils.isEmpty(edtPassword.text))
                Toast.makeText(
                    this,
                    "Email Address or Password is not provided",
                    Toast.LENGTH_LONG
                ).show()
            else {
                auth!!.signInWithEmailAndPassword(
                    edtUsername.text.toString(),
                    edtPassword.text.toString()
                )
                    .addOnCompleteListener(this,
                        OnCompleteListener<AuthResult?> { task ->
                            if (task.isSuccessful) {
                                edtUsername.setText("")
                                edtPassword.setText("")
                                Toast.makeText(
                                    this, "Logged In Successfully" + task.exception,
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                Toast.makeText(
                                    this, "Authentication failed" + task.exception,
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                        })
            }
        }
    }

    private fun signUp() {
        val edtUsername = findViewById<EditText>(R.id.txtUsername)
        val edtPassword = findViewById<EditText>(R.id.txtPassword)

        if (!edtUsername.text.contains("@gmail.com")) {
            Toast.makeText(this, "Enter Valid Email as username", Toast.LENGTH_LONG).show()
        } else {
            if (TextUtils.isEmpty(edtUsername.text) || TextUtils.isEmpty(edtPassword.text))
                Toast.makeText(
                    this,
                    "Email Address or Password is not provided",
                    Toast.LENGTH_LONG
                ).show()
            else {
                auth!!.createUserWithEmailAndPassword(
                    edtUsername.text.toString(),
                    edtPassword.text.toString()
                ).addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val user = auth!!.currentUser
                        if (user != null) {
                            edtUsername.setText("")
                            edtPassword.setText("")
                            Toast.makeText(this, "Sign Up SuccessFully", Toast.LENGTH_SHORT)
                                .show()
                        }

                    } else {
                        Toast.makeText(this, "Sign Up Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun disableKeyboard() {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}