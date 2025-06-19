package vcmsa.ci.practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Nikyle Mazeau
//ST10469340

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //Get Reference for the "Welcome Text" Textview by the ID from the display
        val welcomeText = findViewById<TextView>(R.id.WelcomeText)
        //Reference for the "Main Menu" Button in the display by its ID
        val mainmenuButton = findViewById<Button>(R.id.MainMenu)
        //Reference the "Exit App" Button by its ID in the display
        val exitButton = findViewById<Button>(R.id.ExitApp)


        //Set the Click listener for the "Main Menu" Button to respond to user interaction
        mainmenuButton.setOnClickListener {
            //Opens the 2nd Xml when clicked
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }

        //Set the Click Listener for the "Exit" Button to respond to user interaction
        exitButton.setOnClickListener {
            //Terminates the app when clicked
            finishAffinity()
        }

    }
}