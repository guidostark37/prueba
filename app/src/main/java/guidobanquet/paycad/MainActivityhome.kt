package guidobanquet.paycad

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import guidobanquet.paycad.databinding.ActivityMainActivityhomeBinding

class MainActivityhome : AppCompatActivity() {
    lateinit var binding: ActivityMainActivityhomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainActivityhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var guardar = getSharedPreferences("codigo", Context.MODE_PRIVATE)
        binding.txtnombre.text=guardar.getString("name","")
        binding.txtsueldo.text = guardar.getString("monto","")

        binding.button4.setOnClickListener {
            var suma = guardar.getString("monto", "")!!.toInt() + binding.txtamount.text.toString().toInt()


            getSharedPreferences("codigo", Context.MODE_PRIVATE)
                .edit()
                .putString("monto", suma.toString())
                .commit()


            binding.txtsueldo.text = guardar.getString("monto", "")
            binding.txtamount.setText(" ")
        }
        binding.imageButton.setOnClickListener {
            getSharedPreferences("codigo", Context.MODE_PRIVATE)
                .edit()
                .putString("monto", "")
                .putString("name","")
                .putString("code","")
                .commit()
                finishAffinity()

        }


    }

    override fun onRestart() {
        super.onRestart()
        var prueba=getSharedPreferences("codigo", MODE_PRIVATE).getString("monto", "")
        startActivity(Intent(this,MainActivity::class.java))

    }
}