package com.sergioloc.parchis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Color extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final int numDice = getIntent().getExtras().getInt("dice");

        //Azul
        findViewById(R.id.color1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Color.this,Stats.class);
                i.putExtra("color",1);
                i.putExtra("dice",numDice);
                startActivity(i);
            }
        });

        //Verde
        findViewById(R.id.color2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Color.this,Stats.class);
                i.putExtra("color",2);
                i.putExtra("dice",numDice);
                startActivity(i);
            }
        });

        //Rojo
        findViewById(R.id.color3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Color.this,Stats.class);
                i.putExtra("color",3);
                i.putExtra("dice",numDice);
                startActivity(i);
            }
        });

        //Amarillo
        findViewById(R.id.color4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Color.this,Stats.class);
                i.putExtra("color",4);
                i.putExtra("dice",numDice);
                startActivity(i);
            }
        });

    }
}