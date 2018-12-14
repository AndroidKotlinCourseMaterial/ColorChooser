package edu.rosehulman.colorchooser

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.RelativeLayout
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    // CONSIDER: Would be better bundled as a data object.
    private val message = "This is your phone. Please rescue me!"
    private val backgroundColor = Color.GREEN


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            // TODO: Send an email with the message field as the body

        }

        updateUI()
    }

    private fun updateUI() {
        content_main_message.text = message
        content_main_layout.setBackgroundColor(backgroundColor)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info ->
                // TODO: Launch a new Info Activity that is a ScrollingActivity.
                true
            R.id.action_change_color ->
                // TODO: Launch the InputActivity to get a result
                true

            else -> super.onOptionsItemSelected(item)
        }
    }
}
