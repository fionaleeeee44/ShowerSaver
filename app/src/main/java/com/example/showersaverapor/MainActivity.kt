import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.showersaverapor.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            Toast.makeText(this, "Pressed Login!", Toast.LENGTH_SHORT).show()
        }

        btnRegister.setOnClickListener {
            Toast.makeText(this, "Pressed Register!", Toast.LENGTH_SHORT).show()
        }
    }
}
