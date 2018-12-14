package edu.rosehulman.colorchooser

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.builder.ColorPickerDialogBuilder
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    private var currentBackgroundColor: Int = 0
    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        message = "Hello World"
        currentBackgroundColor = Color.GRAY
        updateUI()

        activity_input_button.setOnClickListener {
            showColorDialog()
        }
    }

    private fun updateUI() {
        activity_input_message.setText(message)
        activity_input_layout.setBackgroundColor(currentBackgroundColor)
    }

    // From https://android-arsenal.com/details/1/1693
    private fun showColorDialog() {
        val builder = ColorPickerDialogBuilder.with(this)
        builder.setTitle("Choose HSV color")
        builder.initialColor(currentBackgroundColor)
        builder.wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
        builder.density(6)
        builder.setOnColorSelectedListener { selectedColor ->
            Toast.makeText(
                this@InputActivity,
                "onColorSelected: 0x" + Integer.toHexString(selectedColor),
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setPositiveButton(android.R.string.ok) { dialog, selectedColor, allColors ->
            currentBackgroundColor = selectedColor
            message = activity_input_message.text.toString()
            updateUI()
            // TODO: Use an intent to send info back to the
            // activity that called this one for a result.
        }
        builder.setNegativeButton(getString(android.R.string.cancel), null)
        builder.build().show()
    }
}