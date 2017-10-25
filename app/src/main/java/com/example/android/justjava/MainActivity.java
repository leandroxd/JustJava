package com.example.android.justjava; /**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package="com.example.android.justjava";
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;

//        package="com.example.android.justjava";
/*   import android.support.v7.app.ActionBarActivity;*/

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    EditText edtNome, edtEmail;
    ListView listV_dados;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
        /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = (EditText)findViewById(R.id.editEmail);
        edtNome = (EditText)findViewById(R.id.editNome);
        listV_dados = (ListView)findViewById(R.id.listV_dados);

       // inicializarFirebase();
    }

   /* private void inicializarFirebase() {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getReference();
    }*/

    public void increaseOrder(View view) {
        quantity++;
        display(quantity);
    }

    public void decreaseOrder(View view) {
        quantity--;
        if(quantity<0)
            quantity = 0;

        display(quantity);

    }
    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity*5);
    }

    public void cancelOrder(View view) {
        quantity = 0;
        display(0);
        displayPrice(0);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}