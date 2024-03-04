package com.cennaapp.appdeviagens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cennaapp.appdeviagens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        if(view.id == R.id.button_Calculate){
            calculate()
        }
    }

    private fun calculate(){
        Toast.makeText(this, "Você realizou um click", Toast.LENGTH_SHORT).show()
    }


}