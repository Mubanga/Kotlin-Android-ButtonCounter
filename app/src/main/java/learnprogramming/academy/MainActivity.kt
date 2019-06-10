package learnprogramming.academy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {

    private var txtView_ButtonCounter:TextView? = null
    private var numberOfTimesClicked:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenge_layout_1)

        val userInput:EditText = findViewById(R.id.editText_MainActivity)
        val textBox:TextView = findViewById(R.id.textView_MainActivity_ButtonCount)
        val buttonConfirm:Button = findViewById(R.id.button_MainActivity)
        txtView_ButtonCounter = findViewById(R.id.textView_MainActivity_ButtonCount)
        txtView_ButtonCounter?.text = ""
        txtView_ButtonCounter?.movementMethod = ScrollingMovementMethod()
        userInput.setText(" ")

        buttonConfirm.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
//                numberOfTimesClicked+=1
                Log.d(TAG,"onClick: called")
                txtView_ButtonCounter?.append(userInput.text)
                txtView_ButtonCounter?.append("\n")
                userInput.setText("")
//                if(numberOfTimesClicked>1)
//                {
//                   txtView_ButtonCounter?.append("(s)")
//                }
            }
        })




    }

    override fun onStart() {
        Log.d(TAG,"onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG,"onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        txtView_ButtonCounter?.text = savedInstanceState?.getString(TEXT_CONTENTS,"")
    }

    override fun onPause() {
        Log.d(TAG,"onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG,"onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS,txtView_ButtonCounter?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG,"onStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy: called")
        super.onDestroy()
    }
}
