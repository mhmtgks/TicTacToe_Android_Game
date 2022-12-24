package com.example.xox_game

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.util.rangeTo

class MainActivity : AppCompatActivity() {
    val a = booleanArrayOf(false,false,false,false,false,false,false,false,false);
    val x = booleanArrayOf(false,false,false,false,false,false,false,false,false);
    val o = booleanArrayOf(false,false,false,false,false,false,false,false,false);
    var mod =1 ; var modb =0; //1 = x   , 2=o
    var clickTime = 0;
    var redpuan=0;
    var blackpuan=0;
    var ix=9;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn1 : ImageButton= findViewById(R.id.imageButton2)
        var btn2 : ImageButton= findViewById(R.id.imageButton3)
        var btn3 : ImageButton= findViewById(R.id.imageButton4)
        var btn4 : ImageButton= findViewById(R.id.imageButton6)
        var btn5 : ImageButton= findViewById(R.id.imageButton7)
        var btn6 : ImageButton= findViewById(R.id.imageButton5)
        var btn7 : ImageButton= findViewById(R.id.imageButton11)
        var btn8 : ImageButton= findViewById(R.id.imageButton9)
        var btn9 : ImageButton= findViewById(R.id.imageButton10)
        var txt1 :TextView =findViewById(R.id.textView)
        var txt4 :TextView =findViewById(R.id.textView4)

        btn1.setOnClickListener(){
           handler(btn1,0 ,txt1,txt4);
        }
        btn2.setOnClickListener(){
            handler(btn2,1,txt1,txt4);
        }
        btn3.setOnClickListener(){
            handler(btn3,2,txt1,txt4);
        }
        btn4.setOnClickListener(){
            handler(btn4,3,txt1,txt4);
        }
        btn5.setOnClickListener(){
            handler(btn5,4,txt1,txt4);
        }
        btn6.setOnClickListener(){
            handler(btn6,5,txt1,txt4);
        }
        btn7.setOnClickListener(){
            handler(btn7,6,txt1,txt4);
        }
        btn8.setOnClickListener(){
            handler(btn8,7,txt1,txt4);
        }
        btn9.setOnClickListener(){
            handler(btn9,8,txt1,txt4);
        }





    }
    fun handler(btn: ImageButton,i : Int,txt1: TextView,txt4 : TextView)
    {
        if(a[i]==false)
        {
            if(mod==1)
            {

                btn.setImageResource(R.drawable.x);
                x[i]=true;
                mod=2;
                clickTime++;
                Thread.sleep(5)
                txt4.setText("Sıra : O");
            }else
            {
                o[i]=true;
                //btn.setBackgroundColor(Color.RED);
                btn.setImageResource(R.drawable.op1);
                Thread.sleep(5)
                txt4.setText("Sıra : X");
                mod=1;
                clickTime++;
            }
            a[i]=true;
            ix=i;
            if(clickTime>=4){
                winning(txt1);
            }
            if(clickTime==9){
                modb=1;
                winning(txt1)
            }


        }
    }
    fun winning(txt1 : TextView)
    {
        if(mod==1) // this mod 1 for o because we change it early in another method
        {
            if(  (o[0]&&o[1]&&o[2]) || (o[3]&&o[4]&&o[5]) || (o[6]&&o[7]&&o[8]) || (o[0]&&o[4]&&o[8]) || (o[2]&&o[4]&&o[6])   || (o[0]&&o[3]&&o[6]) || (o[1]&&o[4]&&o[7]) || (o[2]&&o[5]&&o[8]) )
            {
                txt1.setText(" O kazandı") ;
                redpuan++;
                restart();


            }
        }else if(mod==2) {
            if(  (x[0]&&x[1]&&x[2])||(x[3]&&x[4]&&x[5])||(x[6]&&x[7]&&x[8])||(x[0]&&x[4]&&x[8]) || (x[2]&&x[4]&&x[6]) || (x[0]&&x[3]&&x[6]) || (x[1]&&x[4]&&x[7]) || (x[2]&&x[5]&&x[8] ))
            {
                txt1.setText(" X kazandı") ;
                blackpuan++;

                restart();

            }
        }
        if(modb==1){
            txt1.setText(" Berabere") ;
            restart();
            modb=0;
        }
    }

    fun restart(){
        Thread.sleep(1000)
        var i =0
        for(i in 0..8){
            a[i]=false;
            x[i]=false;
            o[i]=false;

        }
        var btn1 : ImageButton= findViewById(R.id.imageButton2)
        var btn2 : ImageButton= findViewById(R.id.imageButton3)
        var btn3 : ImageButton= findViewById(R.id.imageButton4)
        var btn4 : ImageButton= findViewById(R.id.imageButton6)
        var btn5 : ImageButton= findViewById(R.id.imageButton7)
        var btn6 : ImageButton= findViewById(R.id.imageButton5)
        var btn7 : ImageButton= findViewById(R.id.imageButton11)
        var btn8 : ImageButton= findViewById(R.id.imageButton9)
        var btn9 : ImageButton= findViewById(R.id.imageButton10)

        resButtoncolor(btn1)
        resButtoncolor(btn2)
        resButtoncolor(btn3)
        resButtoncolor(btn4)
        resButtoncolor(btn5)
        resButtoncolor(btn6)
        resButtoncolor(btn7)
        resButtoncolor(btn8)
        resButtoncolor(btn9)
        clickTime=0;
        var txt2 :TextView =findViewById(R.id.textView2)
        var txt3 :TextView =findViewById(R.id.textView3)
        txt2.setText("O Puan : ${redpuan}")
        txt3.setText("X Puan : ${blackpuan}")


    }
    fun resButtoncolor(btn : ImageButton){
        btn.setBackgroundColor(Color.LTGRAY)
        btn.setImageResource(0);
    }


}
