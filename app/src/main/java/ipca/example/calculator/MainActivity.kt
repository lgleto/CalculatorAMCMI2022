package ipca.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewDisplay = findViewById<TextView>(R.id.textViewDisplay)
        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            if (textViewDisplay.text == "0") {
                textViewDisplay.text = "1"
            }else{
                textViewDisplay.text = textViewDisplay.text.toString() + "1"
            }

        }

    }

}