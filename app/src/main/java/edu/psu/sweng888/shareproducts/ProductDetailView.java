package edu.psu.sweng888.shareproducts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailView extends AppCompatActivity {
    private TextView title;
    private TextView subtitle;
    private Button backButton;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_view);

        // initialize class variables
        this.title = findViewById(R.id.title);
        this.subtitle = findViewById(R.id.subtitle);
        this.backButton = findViewById(R.id.backButton);
        this.shareButton = findViewById(R.id.shareButton);

        // get the selected Product from the Intent extras
        Product selected = (Product) getIntent().getSerializableExtra("selected_product");

        // concatenate title values together
        String titleText = selected.getName();

        // concatenate subtitle values together
        String subtitleText = "Description: " + selected.getDescription() + " |  Sold by: " + selected.getSeller() + " | Price: $" + selected.getPrice() + ".00";

        // display Product values
        this.title.setText(titleText);
        this.subtitle.setText(subtitleText);

        // when backButton is clicked
        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailView.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Returned successfully.", Toast.LENGTH_SHORT).show();
            }
        });

        // when shareButton is clicked
        this.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                String[] to = {"sweng888mobileapps@gmail.com", ""};
                emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ollie's Bargain Outlet");
                emailIntent.putExtra(Intent.EXTRA_TEXT, selected.toString());
                Intent chooser = Intent.createChooser(emailIntent, "Send email");

                try {
                    startActivity(chooser);
                    Toast.makeText(getApplicationContext(), "Shared successfully.", Toast.LENGTH_SHORT).show();
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "Failed to share.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
