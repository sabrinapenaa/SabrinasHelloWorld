package com.example.sabrinashelloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = ((TextView) findViewById(R.id.text));
        //we want to be able to tap on button to change the text color of the label
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change the text color of the label
                ((TextView) findViewById(R.id.text)).setTextColor(getResources().getColor(R.color.textColorChanged));
            }
        });

        //User can change background color by tapping button
        findViewById(R.id.changeBackgroundButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.bgd));
            }
        });

        //User can change the text of the label by tapping button
        findViewById(R.id.changeTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView) findViewById(R.id.text)).setText("Android is Awesome!");
            }
        });

        //user can tap the background to reset all views to defualt settings
        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. reset text to "Hello from Sabrina" text id = @id/text
                ((TextView) findViewById(R.id.text)).setText("Hello from Sabrina!");
                //2.reset color of text to original color
                textView.setTextColor(getResources().getColor(R.color.textColor));
                //original text color - #2c4e55 , text id = @id/text
                //3. reset the background color -R.color.textColor
                findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.orig));
            }
        });


        //User can update the label text with custon text entered into the text field

        //User can tap the change text string button to update the label
        findViewById(R.id.changeCustomTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change the text view to waht is in the edited text view
                String userEnteredText = ( (EditText) findViewById(R.id.editText)).getText().toString();

                // uf the text field is empty, update label with defualt text string
                if(userEnteredText.isEmpty()){
                    textView.setText("Enter your own text!");
                }
                else textView.setText(userEnteredText);
            }
        });


    }
}