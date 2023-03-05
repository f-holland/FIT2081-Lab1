package com.fholland.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // Instantiate empty variables for all components that need to be interacted with.

    // EditViews
    EditText bookIdEdit;
    EditText titleEdit;
    EditText isbnEdit;
    EditText authorEdit;
    EditText descEdit;
    EditText priceEdit;

    // Buttons
    Button addBookBtn;
    Button clearFieldsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associate all variables with their components.
        bookIdEdit = findViewById(R.id.bookIdEdit);
        titleEdit = findViewById(R.id.titleEdit);
        isbnEdit = findViewById(R.id.isbnEdit);
        authorEdit = findViewById(R.id.authorEdit);
        descEdit = findViewById(R.id.descEdit);
        priceEdit = findViewById(R.id.priceEdit);
        addBookBtn = findViewById(R.id.addBookBtn);
        clearFieldsBtn = findViewById(R.id.clearFieldsBtn);

        // Create a listener for the 'Add Book' button.
        addBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Grab the String values of all the EditViews.
                String bookId = bookIdEdit.getText().toString();
                String title = titleEdit.getText().toString();
                String isbn = isbnEdit.getText().toString();
                String author = authorEdit.getText().toString();
                String desc = descEdit.getText().toString();
                String price = priceEdit.getText().toString();

                // Check if any values are left empty.
                if (bookId.isEmpty() || title.isEmpty() || isbn.isEmpty() || author.isEmpty() || desc.isEmpty() || price.isEmpty()) {
                    // If so, show an error message to the user.
                    Toast.makeText(getApplicationContext(), "One or more fields are empty. Please try again.", Toast.LENGTH_LONG).show();
                } else {
                    // Otherwise, continue with adding the book.
                    String notifString = "Successfully added " + title + " ($" + price + ")";
                    Toast.makeText(getApplicationContext(), notifString, Toast.LENGTH_LONG).show();
                }
            }
        });

        // Create a listener for the 'Clear Fields' button.
        clearFieldsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Set the value of all EditViews to an empty string.
                bookIdEdit.setText("");
                titleEdit.setText("");
                isbnEdit.setText("");
                authorEdit.setText("");
                descEdit.setText("");
                priceEdit.setText("");

                // Send an alert to the user to confirm the clear.
                Toast.makeText(getApplicationContext(), "Cleared all fields.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}