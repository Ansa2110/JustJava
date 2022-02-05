package com.example.justjava;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.write_name);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();


        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);



        String priceMessage="Name: " + name +
                "\nAdd whipped cream? " + hasWhippedCream +
                "\nAdd cholocate? " + hasChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: " + price +
                "\nThank you!";

        displayMessage(priceMessage);
    }
    public void increment(View view) {
        quantity=quantity+1;
        display(quantity);
    }
    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity=quantity-1;
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    private int calculatePrice(boolean WhippedCream, boolean Chocolate)
    {

        int basePrice = 5;

        if (WhippedCream) {
            basePrice = basePrice + 1;
        }

        if (Chocolate) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }
}