package com.example.pesanmakan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=0;
    int quantityRawon = 0;
    int quantityPecel = 0;
    int quantitySoto = 0;
    int quantityEscampur = 0;
    int quantityKopi = 0;
    int quantityEsdegan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incrementRawon(View view){
        if(quantityRawon==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityRawon = quantityRawon + 1;
        displayRawon(quantityRawon);
    }

    public void incrementPecel(View view){
        if(quantityPecel==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityPecel = quantityPecel + 1;
        displayPecel(quantityPecel);
    }

    public void incrementSoto(View view){
        if(quantitySoto==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantitySoto = quantitySoto + 1;
        displaySoto(quantitySoto);
    }

    public void incrementEscampur(View view){
        if(quantityEscampur==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityEscampur = quantityEscampur + 1;
        displayEscampur(quantityEscampur);
    }

    public void incrementKopi(View view){
        if(quantityKopi==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityKopi = quantityKopi + 1;
        displayKopi(quantityKopi);
    }

    public void incrementEsdegan(View view){
        if(quantityEsdegan==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityEsdegan = quantityEsdegan + 1;
        displayEsdegan(quantityEsdegan);
    }

    public void decrementRawon(View view){
        if (quantityRawon==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityRawon = quantityRawon - 1;
        displayRawon(quantityRawon);
    }

    public void decrementPecel(View view){
        if (quantityPecel==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityPecel = quantityPecel - 1;
        displayPecel(quantityPecel);
    }

    public void decrementSoto(View view){
        if (quantitySoto==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantitySoto = quantitySoto - 1;
        displaySoto(quantitySoto);
    }

    public void decrementEscampur(View view){
        if (quantityEscampur==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityEscampur = quantityEscampur - 1;
        displayEscampur(quantityEscampur);
    }

    public void decrementKopi(View view){
        if (quantityKopi==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityKopi = quantityKopi - 1;
        displayKopi(quantityKopi);
    }

    public void decrementEsdegan(View view){
        if (quantityEsdegan==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantityEsdegan = quantityEsdegan - 1;
        displayEsdegan(quantityEsdegan);
    }

    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
        boolean haswhippedcream = whippedcreamChekBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+haswhippedcream);

        CheckBox chocolateChekBox= (CheckBox) findViewById(R.id.Chocolate_checkbox);
        boolean haschocolate=chocolateChekBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+haschocolate);

        CheckBox rawonChekBox = (CheckBox) findViewById(R.id.Rawon_checkbox);
        boolean rawon = rawonChekBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+rawon);

        CheckBox pecelCheckBox = (CheckBox) findViewById(R.id.Pecel_checkbox);
        boolean pecel = pecelCheckBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+pecel);

        CheckBox sotoCheckBox = (CheckBox) findViewById(R.id.Soto_checkbox);
        boolean soto = sotoCheckBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+soto);

        CheckBox campurCheckBox = (CheckBox) findViewById(R.id.Escampor_checkbox);
        boolean esCampur = campurCheckBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+esCampur);

        CheckBox kopiCheckBox = (CheckBox) findViewById(R.id.Kopi_checkbox);
        boolean kopi = kopiCheckBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+kopi);

        CheckBox deganChecked = (CheckBox) findViewById(R.id.Esdegan_checkbox);
        boolean degan = deganChecked.isChecked();
        Log.v("MainActivity","has whippedcream:"+degan);

        int price=calculateprice(rawon, pecel, soto, esCampur, kopi, degan, haswhippedcream,haschocolate);
        String pricemessage=createOrderSummary(price, name);


        displayMessage(pricemessage);

    }

    public void getTotal(View view) {
        int total = quantityRawon + quantityPecel + quantitySoto + quantityEscampur + quantityKopi + quantityEsdegan;
        String totalmessage = createTotal(total);

        displayTotalItem(totalmessage);
    }


    private int calculateprice(boolean addRawon, boolean addPecel, boolean addSoto, boolean addCampur, boolean addKopi, boolean addDegan, boolean addwhipedcream, boolean addchocolate){
        int harga=0;

        if(addRawon){
            harga = harga + 10000 * quantityRawon;
        }

        if(addPecel){
            harga = harga + 7000 * quantityPecel;
        }

        if(addSoto){
            harga = harga + 8000 * quantitySoto;
        }

        if(addCampur){
            harga = harga + 4000 * quantityEscampur;
        }

        if(addKopi){
            harga = harga + 3000 * quantityKopi;
        }

        if(addDegan){
            harga = harga + 2000 * quantityEsdegan;
        }

        if(addwhipedcream){
            harga = harga + 1000;
        }

        if (addchocolate){
            harga = harga + 2000;
        }

        return harga;
    }

    private String createOrderSummary(int price, String name) {
        String pricemessage = "Nama = "+name;
        pricemessage+="\n Harga = "+price;
        return  pricemessage;
    }

    private String createTotal(int total) {
        String totalmessage=" Total = "+total;
        return  totalmessage;
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }

    private void displayTotalItem(String message){
        TextView priceTextView = (TextView) findViewById(R.id.total_item);
        priceTextView.setText(message);
    }

    private void displayRawon(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_rawon);
        quantityTextView.setText("" + number);
    }

    private void displayPecel(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_pecel);
        quantityTextView.setText("" + number);
    }

    private void displaySoto(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_soto);
        quantityTextView.setText("" + number);
    }

    private void displayEscampur(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_escampur);
        quantityTextView.setText("" + number);
    }

    private void displayKopi(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_kopi);
        quantityTextView.setText("" + number);
    }

    private void displayEsdegan(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_esdegan);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

