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

    private fun isValid(): Boolean{
        return (binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "")
    }

    private fun calculate(){
        if(isValid()){
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            if(autonomy == 0f){
                Toast.makeText(this, R.string.value_invalid_field_Autonomia , Toast.LENGTH_SHORT).show()
                binding.textLabelResult.text = "R$ 0"
            } else {
                val totalValue = (price * distance) / autonomy
                binding.textLabelResult.text = "R$ ${"%.2f".format(totalValue)}"
            }

        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }


    }


}