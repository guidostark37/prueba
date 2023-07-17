package guidobanquet.paycad

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import guidobanquet.paycad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       WindowInsetsControllerCompat(window,window.decorView).hide(WindowInsetsCompat.Type.systemBars())
        var time=3
        var timer=object:CountDownTimer(4000,1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.textView.text=time.toString()
                time--

            }

            override fun onFinish() {
                var prueba=getSharedPreferences("codigo", Context.MODE_PRIVATE).getString("monto","")
                if (prueba!=""){

                    startActivity(Intent(this@MainActivity,MainActivityhome::class.java))
                }else {
                    startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                }

            }

        }
        timer.start()


    }
}