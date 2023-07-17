package guidobanquet.paycad

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import guidobanquet.paycad.databinding.ActivityMainActivityfourBinding

class MainActivityfour : AppCompatActivity() {
    lateinit var binding: ActivityMainActivityfourBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainActivityfourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {

            var isValid = true
           if (binding.txtmonto.text.isNullOrEmpty()){
                binding.txtmonto.error="Campo obligatorio"
               isValid = false
            }
             if (binding.txtnombre.text.isNullOrEmpty()){
                binding.txtnombre.error="Campo obligatorio"
                 isValid = false
            }


             if(isValid){
                var guardar = getSharedPreferences("codigo", Context.MODE_PRIVATE).edit()
                guardar.putString("name",binding.txtnombre.text.toString()).commit()
                guardar.putString("monto",binding.txtmonto.text.toString()).commit()
                Toast.makeText(this, "se guardaron correctamente", Toast.LENGTH_SHORT).show()
                 startActivity(Intent(this,MainActivityverification::class.java))
            }



        }

    }
}