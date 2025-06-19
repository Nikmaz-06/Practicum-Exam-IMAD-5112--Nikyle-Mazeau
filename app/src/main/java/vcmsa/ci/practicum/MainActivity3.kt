package vcmsa.ci.practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//Nikyle Mazeau
//ST10469340

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        // Link variables to their views using the corresponding IDs
        val allSongsText = findViewById<TextView>(R.id.allsongsText)
        val mainMenuButton = findViewById<Button>(R.id.mainmenubutton)
        val allSongsButton = findViewById<Button>(R.id.showAllBtn)

        //Receive data from previous screen
        val songs = intent.getStringArrayListExtra("songs") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getStringArrayListExtra("ratings")?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        //Show all the songs in the playlist
        allSongsButton.setOnClickListener {
            val list = songs.indices.joinToString( "\n") {
                //This format means we display the list in the following way: "Happier (Marshmello) - 4 : Dance song"
                "${songs[it]} (${artists[it]}) - ${ratings[it]}: ${comments[it]}"
            }
            //Error text displayed if the user did not add in the songs details
            allSongsText.text = list.ifBlank { "No songs added" }
        }

        //Navigate back to the main menu
        mainMenuButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}