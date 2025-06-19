package vcmsa.ci.practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//Nikyle Mazeau
//ST10469340

class MainActivity2 : AppCompatActivity() {
    //These are array lists where we are going to store each packing items details
    private val songs = arrayListOf<String>()       //Stores the name of the Song
    private val artists = arrayListOf<String>()  //Stores the name of the Artist
    private val ratings = arrayListOf<Int>()     //Stores the Rating of each song
    private val comments = arrayListOf<String>()    //Stores the Comment of each line
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //Linking UI elements to their respective IDs in the display
        val songInput = findViewById<EditText>(R.id.songtitleInput)
        val artistInput = findViewById<EditText>(R.id.artistnameInput)
        val ratingInput = findViewById<EditText>(R.id.ratingsInput)
        val commentsInput = findViewById<EditText>(R.id.commentInput)

        val addButton = findViewById<Button>(R.id.addButton)
        val displayButton = findViewById<Button>(R.id.nextScreen)
        val exitButton = findViewById<Button>(R.id.exitButton)

        //When the user clicks the "Add to Playlist" button, this block of code runs
        addButton.setOnClickListener {
            //Store the user input from each text box into a temporary variable
            val song = songInput.text.toString()
            val artist = artistInput.text.toString()
            val ratingText = ratingInput.text.toString()
            val comment = commentsInput.text.toString()

            //Validate input fields, check if the user left any fields blank
            if (song.isBlank() || artist.isBlank() || ratingText.isBlank() || comment.isBlank()){
                //Error message shown when any of the fields are left blank
                Toast.makeText(this, "Please fill in all the required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Try to convert the Rating input (which is text) into a number (int)
            val rating = ratingText.toIntOrNull()
            if (rating == null || rating > 5) {
                //if the number is invalid or greater than 5, show an error message
                Toast.makeText(this, "Rating must be a positive and not more than 5!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //If all input is valid, add each piece of information into its corresponding list
            songs.add(song)         //Add song name to songs list
            artists.add(artist)     //Add artist to artists list
            ratings.add(rating)     //Add rating to ratings list
            comments.add(comment)   //Add comment to comments list

            //Let the user know their song was successfully added to the Playlist
            Toast.makeText(this, "Song added to Playlist!", Toast.LENGTH_SHORT).show()

            //Clear the input fields so the user can enter another song
            songInput.text.clear()
            artistInput.text.clear()
            ratingInput.text.clear()
            commentsInput.text.clear()
        }

        //When the user clicks the "View Playlist" button, run this code
        displayButton.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)

            //Attaching all the lists as extras and send them to the next screen
            intent.putStringArrayListExtra("songs" , songs)
            intent.putStringArrayListExtra("artists" , artists)
            intent.putIntegerArrayListExtra("rating" , ratings)
            intent.putStringArrayListExtra("comments" , comments)

            //Start the 3rd screen
            startActivity(intent)
        }

        //"Exit" Button click listener
        exitButton.setOnClickListener {
            finishAffinity()// Terminates the app
        }
    }
}