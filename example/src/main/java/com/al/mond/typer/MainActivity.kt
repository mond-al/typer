package com.al.mond.typer

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.input)
        val output = findViewById<TextView>(R.id.output)
        val useCursor = findViewById<CheckBox>(R.id.use_cursor)
        val play = findViewById<View>(R.id.play)
        val reverse = findViewById<View>(R.id.reverse)
        val stop = findViewById<View>(R.id.stop)

        input.setText("한글을 이렇게 입력하고 Typer.typing()를 호출하면...")

        play.setOnClickListener {
            Typer.typing(output, input.text.toString(), useCursor.isChecked){
                Toast.makeText(this, "타이핑 끝", Toast.LENGTH_SHORT).show()
            }
        }

        reverse.setOnClickListener {
            Typer.erasing(output, useCursor.isChecked) {
                Toast.makeText(this, "지우기 끝", Toast.LENGTH_SHORT).show()
            }
        }

        stop.setOnClickListener {
            Typer.stop()
        }
    }
}