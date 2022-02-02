package com.sergioloc.parchis;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Stats extends AppCompatActivity {

    private int numDice,color;
    private TextView text1,text2,text3,last1,last2,last3;
    private ImageView base1,base2,base3,back1,back2,back3,arrow1,arrow2,arrow3,dice1A,dice1B,dice2A,
            dice2B,dice3A,dice3B,num1,num2,num3,num4,num5,num6,imgHotA,imgColdA,imgHotB,imgColdB,
            hotcold1,hotcold2,hotcold3;
    private Button button1,button2,button3;
    private Boolean arrowDown1,arrowDown2,arrowDown3;
    private ArrayList<Integer> arrayDice1A,arrayDice1B,arrayDice2A,arrayDice2B,arrayDice3A,arrayDice3B;
    private AlertDialog alertDialog;
    private Spinner spinner1,spinner2,spinner3;
    private int translationY1, translationY2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        init();
        initColors();
        initArrows();
        initButtons();
    }


    /**Inits**/
    public void init(){
        numDice = getIntent().getExtras().getInt("dice");
        color = getIntent().getExtras().getInt("color");

        //Base
        base1 = (ImageView) findViewById(R.id.base1);
        base2 = (ImageView) findViewById(R.id.base2);
        base3 = (ImageView) findViewById(R.id.base3);

        //Desplegale
        back1 = (ImageView) findViewById(R.id.back1);
        back2 = (ImageView) findViewById(R.id.back2);
        back3 = (ImageView) findViewById(R.id.back3);

        //Flechas
        arrow1 = (ImageView) findViewById(R.id.arrow1);
        arrow2 = (ImageView) findViewById(R.id.arrow2);
        arrow3 = (ImageView) findViewById(R.id.arrow3);
        arrowDown1 = true;
        arrowDown2 = true;
        arrowDown3 = true;

        //Ultima tirada
        last1 = (TextView) findViewById(R.id.last1);
        last2 = (TextView) findViewById(R.id.last2);
        last3 = (TextView) findViewById(R.id.last3);

        //Dados
        dice1A = (ImageView) findViewById(R.id.dice1A);
        dice1B = (ImageView) findViewById(R.id.dice1B);
        dice2A = (ImageView) findViewById(R.id.dice2A);
        dice2B = (ImageView) findViewById(R.id.dice2B);
        dice3A = (ImageView) findViewById(R.id.dice3A);
        dice3B = (ImageView) findViewById(R.id.dice3B);
        arrayDice1A = new ArrayList<>();
        arrayDice1B = new ArrayList<>();
        arrayDice2A = new ArrayList<>();
        arrayDice2B = new ArrayList<>();
        arrayDice3A = new ArrayList<>();
        arrayDice3B = new ArrayList<>();

        //Hot and Cold
        hotcold1 = (ImageView) findViewById(R.id.hotcold1);
        hotcold2 = (ImageView) findViewById(R.id.hotcold2);
        hotcold3 = (ImageView) findViewById(R.id.hotcold3);

        //Botones
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        //Texto
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);

        //Spinner
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        String[] letra = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.item_spinner,letra);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);



    }
    public void initColors(){
        try{
            if(color==1){ // Azul
                base1.setBackground(getResources().getDrawable(R.drawable.card_green));
                base2.setBackground(getResources().getDrawable(R.drawable.card_red));
                base3.setBackground(getResources().getDrawable(R.drawable.card_yellow));
                back1.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                back2.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                back3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
                button1.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                button2.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                button3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
            }else if(color==2){ // Verde
                base1.setBackground(getResources().getDrawable(R.drawable.card_blue));
                base2.setBackground(getResources().getDrawable(R.drawable.card_red));
                base3.setBackground(getResources().getDrawable(R.drawable.card_yellow));
                back1.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                back2.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                back3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
                button1.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                button2.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                button3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
            }else if(color==3){ // Rojo
                base1.setBackground(getResources().getDrawable(R.drawable.card_blue));
                base2.setBackground(getResources().getDrawable(R.drawable.card_green));
                base3.setBackground(getResources().getDrawable(R.drawable.card_yellow));
                back1.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                back2.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                back3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
                button1.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                button2.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                button3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
            }else if(color==4){ // Amarillo
                base1.setBackground(getResources().getDrawable(R.drawable.card_blue));
                base2.setBackground(getResources().getDrawable(R.drawable.card_green));
                base3.setBackground(getResources().getDrawable(R.drawable.card_red));
                back1.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                back2.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                back3.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                button1.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                button2.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                button3.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void initButtons(){

        dice1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDice(1);
                dialogDice(dice1A,arrayDice1A);
            }
        });
        dice1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDice(1);
                dialogDice(dice1B,arrayDice1B);
            }
        });
        dice2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDice(2);
                dialogDice(dice2A,arrayDice2A);
            }
        });
        dice2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDice(2);
                dialogDice(dice2B,arrayDice2B);
            }
        });
        dice3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDice(3);
                dialogDice(dice3A,arrayDice3A);
            }
        });
        dice3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDice(3);
                dialogDice(dice3B,arrayDice3B);
            }
        });

        hotcold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogHotCold(1);
                setImages(getHotCold(arrayDice1A),getHotCold(arrayDice1B));
            }
        });
        hotcold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogHotCold(2);
                setImages(getHotCold(arrayDice2A),getHotCold(arrayDice2B));
            }
        });
        hotcold3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogHotCold(3);
                setImages(getHotCold(arrayDice3A),getHotCold(arrayDice3B));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operate(spinner1,text1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operate(spinner2,text2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operate(spinner3,text3);
            }
        });

    }
    public void initArrows(){
        translationY2 = 0;
        final ViewTreeObserver observer = base1.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                translationY1 = base1.getHeight();
                //observer.removeOnGlobalLayoutListener(this);
            }
        });
        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrowDown1) { // Baja
                    animation(translationY1,arrow1,back1,dice1A,dice1B,last1,hotcold1,R.drawable.ic_action_arrow_up_black);
                    arrowDown1=false;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(color==1) back1.setBackground(getResources().getDrawable(R.drawable.card_green_light));
                            else if(color==2 | color==3 | color == 4) back1.setBackground(getResources().getDrawable(R.drawable.card_blue_light));
                        }
                    }, 150);


                } else { // Sube
                    animation(translationY2,arrow1,back1,dice1A,dice1B,last1,hotcold1,R.drawable.ic_action_arrow_down_black);
                    arrowDown1=true;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(color==1) back1.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                            else if(color==2 | color==3 | color == 4) back1.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                        }
                    }, 150);
                }

            }
        });
        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrowDown2) {
                    animation(translationY1,arrow2,back2,dice2A,dice2B,last2,hotcold2,R.drawable.ic_action_arrow_up_black);
                    arrowDown2=false;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(color==1 | color==2) back2.setBackground(getResources().getDrawable(R.drawable.card_red_light));
                            else if(color==3 | color == 4) back2.setBackground(getResources().getDrawable(R.drawable.card_green_light));
                        }
                    }, 150);

                } else {
                    animation(translationY2,arrow2,back2,dice2A,dice2B,last2,hotcold2,R.drawable.ic_action_arrow_down_black);
                    arrowDown2=true;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(color==1 | color==2) back2.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                            else if(color==3 | color == 4) back2.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                        }
                    }, 150);

                }

            }
        });
        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrowDown3) {
                    animation(translationY1,arrow3,back3,dice3A,dice3B,last3,hotcold3,R.drawable.ic_action_arrow_up_black);
                    arrowDown3=false;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(color==1 | color==2 | color==3) back3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light));
                            else if(color == 4) back3.setBackground(getResources().getDrawable(R.drawable.card_red_light));
                        }
                    }, 150);

                } else {
                    animation(translationY2,arrow3,back3,dice3A,dice3B,last3,hotcold3,R.drawable.ic_action_arrow_down_black);
                    arrowDown3=true;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            if(color==1 | color==2 | color==3) back3.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
                            else if(color == 4) back3.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                        }
                    }, 150);

                }

            }
        });
    }


    /**Functions**/
    public void operate(Spinner spinner, TextView text){
        int x = Integer.parseInt(spinner.getSelectedItem().toString());
        if(x==1)
            text.setText("30%");
        else if(x==2)
            text.setText("33%");
        else if(x==3)
            text.setText("36%");
        else if(x==4)
            text.setText("39%");
        else if(x==5)
            text.setText("42%");
        else if(x==6)
            text.setText("44%");
        else if(x==7)
            text.setText("17%");
        else if(x==8)
            text.setText("14%");
        else if(x==9)
            text.setText("11%");
        else if(x==10)
            text.setText("8%");
        else if(x==11)
            text.setText("5%");
        else if(x==12)
            text.setText("3%");
    }
    public void setImages(int[] valuesA, int[] valuesB ){
        if(valuesA[0]==1)
            imgHotA.setImageResource(R.drawable.hot_num1);
        else if(valuesA[0]==2)
            imgHotA.setImageResource(R.drawable.hot_num2);
        else if(valuesA[0]==3)
            imgHotA.setImageResource(R.drawable.hot_num3);
        else if(valuesA[0]==4)
            imgHotA.setImageResource(R.drawable.hot_num4);
        else if(valuesA[0]==5)
            imgHotA.setImageResource(R.drawable.hot_num5);
        else if(valuesA[0]==6)
            imgHotA.setImageResource(R.drawable.hot_num6);

        if(valuesA[1]==1)
            imgColdA.setImageResource(R.drawable.cold_num1);
        else if(valuesA[1]==2)
            imgColdA.setImageResource(R.drawable.cold_num2);
        else if(valuesA[1]==3)
            imgColdA.setImageResource(R.drawable.cold_num3);
        else if(valuesA[1]==4)
            imgColdA.setImageResource(R.drawable.cold_num4);
        else if(valuesA[1]==5)
            imgColdA.setImageResource(R.drawable.cold_num5);
        else if(valuesA[1]==6)
            imgColdA.setImageResource(R.drawable.cold_num6);

        if(valuesB[0]==1)
            imgHotB.setImageResource(R.drawable.hot_num1);
        else if(valuesB[0]==2)
            imgHotB.setImageResource(R.drawable.hot_num2);
        else if(valuesB[0]==3)
            imgHotB.setImageResource(R.drawable.hot_num3);
        else if(valuesB[0]==4)
            imgHotB.setImageResource(R.drawable.hot_num4);
        else if(valuesB[0]==5)
            imgHotB.setImageResource(R.drawable.hot_num5);
        else if(valuesB[0]==6)
            imgHotB.setImageResource(R.drawable.hot_num6);

        if(valuesB[1]==1)
            imgColdB.setImageResource(R.drawable.cold_num1);
        else if(valuesB[1]==2)
            imgColdB.setImageResource(R.drawable.cold_num2);
        else if(valuesB[1]==3)
            imgColdB.setImageResource(R.drawable.cold_num3);
        else if(valuesB[1]==4)
            imgColdB.setImageResource(R.drawable.cold_num4);
        else if(valuesB[1]==5)
            imgColdB.setImageResource(R.drawable.cold_num5);
        else if(valuesB[1]==6)
            imgColdB.setImageResource(R.drawable.cold_num6);
    }
    public void animation(float translationY, ImageView arrow, ImageView back, ImageView diceA, ImageView diceB, TextView last, ImageView hotcold, int img){
        arrow.setImageResource(img);
        back.animate().translationY(translationY).start();
        diceA.animate().translationY(translationY).start();
        diceB.animate().translationY(translationY).start();
        last.animate().translationY(translationY).start();
        hotcold.animate().translationY(translationY).start();
    }


    /**Dialogs**/
    public void openDialogDice(int i){
        AlertDialog.Builder alert = new AlertDialog.Builder(Stats.this);
        View alertView = getLayoutInflater().inflate(R.layout.dialog_historial, null);

        //Set the view
        alert.setView(alertView);

        alertDialog = alert.show();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        ImageView closeButton = (ImageView) alertView.findViewById(R.id.closeButton);
        RelativeLayout container = (RelativeLayout) alertView.findViewById(R.id.alertContainer);

        num1 = (ImageView) alertView.findViewById(R.id.num1);
        num2 = (ImageView) alertView.findViewById(R.id.num2);
        num3 = (ImageView) alertView.findViewById(R.id.num3);
        num4 = (ImageView) alertView.findViewById(R.id.num4);
        num5 = (ImageView) alertView.findViewById(R.id.num5);
        num6 = (ImageView) alertView.findViewById(R.id.num6);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if(color==1){
            if(i==1) {
                container.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                closeButton.setImageResource(R.drawable.close_green);
            }else if(i==2) {
                container.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                closeButton.setImageResource(R.drawable.close_red);
            }else if(i==3) {
                container.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
                closeButton.setImageResource(R.drawable.close_yellow);
            }
        }else if(color==2){
            if(i==1) {
                container.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                closeButton.setImageResource(R.drawable.close_blue);
            }else if(i==2) {
                container.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                closeButton.setImageResource(R.drawable.close_red);
            }else if(i==3) {
                container.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
                closeButton.setImageResource(R.drawable.close_yellow);
            }
        }else if(color==3){
            if(i==1) {
                container.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                closeButton.setImageResource(R.drawable.close_blue);
            }else if(i==2) {
                container.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                closeButton.setImageResource(R.drawable.close_green);
            }else if(i==3) {
                container.setBackground(getResources().getDrawable(R.drawable.card_yellow_light_2));
                closeButton.setImageResource(R.drawable.close_yellow);
            }
        }else if(color==4){
            if(i==1) {
                container.setBackground(getResources().getDrawable(R.drawable.card_blue_light_2));
                closeButton.setImageResource(R.drawable.close_blue);
            }else if(i==2) {
                container.setBackground(getResources().getDrawable(R.drawable.card_green_light_2));
                closeButton.setImageResource(R.drawable.close_green);
            }else if(i==3) {
                container.setBackground(getResources().getDrawable(R.drawable.card_red_light_2));
                closeButton.setImageResource(R.drawable.close_red);
            }
        }




    }
    public void openDialogHotCold(int i){
        AlertDialog.Builder alert = new AlertDialog.Builder(Stats.this);
        View alertView = getLayoutInflater().inflate(R.layout.custom_hotcold, null);

        //Set the view
        alert.setView(alertView);

        alertDialog = alert.show();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        ImageView closeButton = (ImageView) alertView.findViewById(R.id.closeButton);

        imgHotA = (ImageView) alertView.findViewById(R.id.imgHotA);
        imgColdA = (ImageView) alertView.findViewById(R.id.imgColdA);
        imgHotB = (ImageView) alertView.findViewById(R.id.imgHotB);
        imgColdB = (ImageView) alertView.findViewById(R.id.imgColdB);

        if(color==1){
            if(i==1) {
                closeButton.setImageResource(R.drawable.close_green);
            }else if(i==2) {
                closeButton.setImageResource(R.drawable.close_red);
            }else if(i==3) {
                closeButton.setImageResource(R.drawable.close_yellow);
            }
        }else if(color==2){
            if(i==1) {
                closeButton.setImageResource(R.drawable.close_blue);
            }else if(i==2) {
                closeButton.setImageResource(R.drawable.close_red);
            }else if(i==3) {
                closeButton.setImageResource(R.drawable.close_yellow);
            }
        }else if(color==3){
            if(i==1) {
                closeButton.setImageResource(R.drawable.close_blue);
            }else if(i==2) {
                closeButton.setImageResource(R.drawable.close_green);
            }else if(i==3) {
                closeButton.setImageResource(R.drawable.close_yellow);
            }
        }else if(color==4){
            if(i==1) {
                closeButton.setImageResource(R.drawable.close_blue);
            }else if(i==2) {
                closeButton.setImageResource(R.drawable.close_green);
            }else if(i==3) {
                closeButton.setImageResource(R.drawable.close_red);
            }
        }


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
    public void dialogDice(final ImageView dice, final ArrayList array){
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice.setImageResource(R.drawable.num1);
                array.add(1);
                alertDialog.dismiss();
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice.setImageResource(R.drawable.num2);
                array.add(2);
                alertDialog.dismiss();
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice.setImageResource(R.drawable.num3);
                array.add(3);
                alertDialog.dismiss();
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice.setImageResource(R.drawable.num4);
                array.add(4);
                alertDialog.dismiss();
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice.setImageResource(R.drawable.num5);
                array.add(5);
                alertDialog.dismiss();
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice.setImageResource(R.drawable.num6);
                array.add(6);
                alertDialog.dismiss();
            }
        });
    }
    public int[] getHotCold(ArrayList array){
        int num1=0,num2=0,num3=0,num4=0,num5=0,num6=0,hot=0,cold=0;

        // Recount
        for(int i=0;i<array.size();i++){
            if(array.get(i).equals(1))
                num1++;
            else if(array.get(i).equals(2))
                num2++;
            else if(array.get(i).equals(3))
                num3++;
            else if(array.get(i).equals(4))
                num4++;
            else if(array.get(i).equals(5))
                num5++;
            else if(array.get(i).equals(6))
                num6++;
        }

        // Hot
        if(num1>=num2 && num1>=num3 && num1>=num4 && num1>=num5 && num1>=num6)
            hot=1;
        else if(num2>=num1 && num2>=num3 && num2>=num4 && num2>=num5 && num2>=num6)
            hot=2;
        else if(num3>=num1 && num3>=num2 && num3>=num4 && num3>=num5 && num3>=num6)
            hot=3;
        else if(num4>=num1 && num4>=num2 && num4>=num3 && num4>=num5 && num4>=num6)
            hot=4;
        else if(num5>=num1 && num5>=num2 && num5>=num3 && num5>=num4 && num5>=num6)
            hot=5;
        else if(num6>=num1 && num6>=num2 && num6>=num3 && num6>=num4 && num6>=num5)
            hot=6;

        // Cold
        if(num1<=num2 && num1<=num3 && num1<=num4 && num1<=num5 && num1<=num6)
            cold=1;
        else if(num2<=num1 && num2<=num3 && num2<=num4 && num2<=num5 && num2<=num6)
            cold=2;
        else if(num3<=num1 && num3<=num2 && num3<=num4 && num3<=num5 && num3<=num6)
            cold=3;
        else if(num4<=num1 && num4<=num2 && num4<=num3 && num4<=num5 && num4<=num6)
            cold=4;
        else if(num5<=num1 && num5<=num2 && num5<=num3 && num5<=num4 && num5<=num6)
            cold=5;
        else if(num6<=num1 && num6<=num2 && num6<=num3 && num6<=num4 && num6<=num5)
            cold=6;

        int[] result = {hot,cold};
        return result;

    }



}
