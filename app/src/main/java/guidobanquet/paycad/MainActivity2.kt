package guidobanquet.paycad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import guidobanquet.paycad.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this,MainActivity3::class.java))
        }
    }
}