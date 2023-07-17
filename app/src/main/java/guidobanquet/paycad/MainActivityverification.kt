package guidobanquet.paycad

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import guidobanquet.paycad.databinding.ActivityMainActivityverificationBinding

class MainActivityverification : AppCompatActivity() {
    lateinit var binding: ActivityMainActivityverificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainActivityverificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var guardar = getSharedPreferences("codigo", Context.MODE_PRIVATE)
        var mostrar= guardar.getString("name","")
        binding.txtanuncio.text=mostrar+"!!"
        var code= guardar.getString("code"," ")



       binding.button3.setOnClickListener {
           var codigo = binding.txtnum1.text.toString() + binding.txtnum2.text.toString()+ binding.txtnum3.text.toString() + binding.txtnum4.text.toString() + binding.txtnum5.text.toString()
           if (codigo == code) {

               startActivity(Intent(this,MainActivityhome::class.java))
           }else{
               Toast.makeText(this, "el codigo no es igual", Toast.LENGTH_SHORT).show()
           }

       }

        binding.btngetnewcode.setOnClickListener {
            startActivity(Intent(this,MainActivity3::class.java))
        }
    }
}