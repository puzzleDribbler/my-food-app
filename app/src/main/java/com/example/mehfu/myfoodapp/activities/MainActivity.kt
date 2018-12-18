package com.example.mehfu.myfoodapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mehfu.myfoodapp.R
import com.example.mehfu.myfoodapp.config.Constants
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonLogin.setOnClickListener {

            //Getting Inputs
            val username = editTextUserName.text.toString().trim()
            val password = editTextPassword.text.toString().trim()


            //Validating Inputs
            if(username.isEmpty()){
                editTextUserName.error = "Username is required"
                editTextUserName.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                editTextPassword.error = "Password is required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            //Performing Login
            if(username.equals(Constants.USER_NAME) && password.equals(Constants.PASSWORD)){
                //Login Success
                val intent = Intent(this, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

            }else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show()
            }
        }

    }
}
