package guidobanquet.paycad

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import guidobanquet.paycad.databinding.ActivityMain3Binding
import guidobanquet.paycad.databinding.ActivityMainActivityfourBinding
import kotlin.concurrent.timer
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {
    lateinit var binding:ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var time=10
        binding.txtcodigo.text= Random.nextInt(10000,99999).toString()
        var timer=object: CountDownTimer(11000,1000){

            override fun onTick(millisUntilFinished: Long) {
                binding.txttiempo.text=time.toString()+"s"
                --time


            }


            override fun onFinish() {
               binding.txtcodigo.text= Random.nextInt(10000,99999).toString()
                time=10
                this.start()
            }

        }
        timer.start()
        binding.button2.setOnClickListener {

            var guardar=getSharedPreferences("codigo",Context.MODE_PRIVATE).edit()
            guardar.putString("code",binding.txtcodigo.text.toString()).commit()
            var prueba=getSharedPreferences("codigo",Context.MODE_PRIVATE).getString("name","")
             if (prueba!=""){
                 startActivity(Intent(this@MainActivity3,MainActivityverification::class.java))
             }else {
                 Toast.makeText(this, "se guardo correctamente", Toast.LENGTH_SHORT).show()
                 startActivity(Intent(this@MainActivity3, MainActivityfour::class.java))
             }
        }

    }

}