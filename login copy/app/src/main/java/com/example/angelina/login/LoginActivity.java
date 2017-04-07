package com.example.angelina.login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private EditText email;
    private EditText pass;
    DatabaseHelper helper = new DatabaseHelper(this);
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#e12929'>Sign In</font>"));
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // When Button Login clicked
    public void Signin(View v) {
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        String str = email.getText().toString();
        String strpass = pass.getText().toString();

        String password = helper.searchPass(str);


        //Calling method of field validation
        if (email.getText().toString().equals("")) {
            email.setError("Can't be Empty");

        } else if (pass.getText().toString().equals("")) {
            pass.setError("Can't be Empty");

        }
        else if (password.equals("nonono")){
            email.setError("Email not registered");
        }
        else if (strpass.equals(password)) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            i.putExtra("email", str);
            startActivity(i);
        } else {
            pass.setError("Password incorrect");
        }
    }


    //checking field are empty
   /* private boolean CheckFieldValidation() {
        boolean valid = true;
        if (email.getText().toString().equals("")) {
            email.setError("Can't be Empty");
            valid = false;
        } else if (pass.getText().toString().equals("")) {
            pass.setError("Can't be Empty");
            valid = false;
        }
        return valid;
    }*/


    //When Button Sign up clicked
    public void SignUp(View v) {

        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    /*public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Login Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }
    @Override
    public void onStart() {
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }
    @Override
    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
*/
}