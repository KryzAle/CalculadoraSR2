package com.example.jsroc.subredes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ps,Pms,p1,p2,p3,p4;
    Button BtnCalcular;
    Double NumSubredes,NumHost,NumBHost,MascaSubredB,BSR;
    int paux,Salto,con,s,t,octeto1,octeto2,octeto3,octeto4,tiponumber;
    String SR,SRAux,tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1= (EditText) findViewById(R.id.parte1);
        p2= (EditText) findViewById(R.id.parte2);
        p3= (EditText) findViewById(R.id.parte3);
        p4= (EditText) findViewById(R.id.parte4);

        ps= (EditText) findViewById(R.id.et_subredes);
        Pms= (EditText) findViewById(R.id.pmascara);
        BtnCalcular= (Button) findViewById(R.id.btn_calcular);

        BtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double Ms1=0.0,Ms2=0.0,Ms3=0.0,Ms4=0.0;
                Integer c=7,m=1;
                subred s1=new subred();
                Intent v1=new Intent(MainActivity.this,PantallaResultado.class);

                NumSubredes=Math.pow(2.00,s1.calNumRed(Double.parseDouble(ps.getText().toString())));
                MascaSubredB=s1.calNumRed(Double.parseDouble(ps.getText().toString()))+Double.parseDouble(Pms.getText().toString());
                NumHost=32-MascaSubredB;
                NumBHost=Math.pow(2.00,NumHost)-2.00;

                while (c>=0 && m<=(int) MascaSubredB.doubleValue()){
                    if (m<=(int) MascaSubredB.doubleValue()) {
                        Ms1 = Ms1 + Math.pow(2.00, c);
                        c--;
                        m++;
                    }else {
                         Ms1 = Ms1 + 0;
                    }
                }
                c=7;
                while (c>=0 && m<=(int) MascaSubredB.doubleValue()){
                    if (m<=(int) MascaSubredB.doubleValue()) {
                        Ms2 = Ms2 + Math.pow(2.00, c);
                        c--;
                        m++;
                    }else {
                              Ms1 = Ms1 + 0;
                    }
                }
                c=7;
                while (c>=0 && m<=(int) MascaSubredB.doubleValue()){
                    if (m<=(int) MascaSubredB.doubleValue()) {
                        Ms3 = Ms3 + Math.pow(2.00, c);
                        c--;
                        m++;
                    }else {
                     Ms3 = Ms3 + 0;
                    }
                }
                c=7;
                while (c>=0 && m<=(int) MascaSubredB.doubleValue()){
                    if (m<=(int) MascaSubredB.doubleValue()) {
                        Ms4 = Ms4 + Math.pow(2.00, c);
                        c--;
                        m++;
                    } else {
                        Ms4 = Ms4 + 0;
                    }
                }
                if(Ms1!=255){
                    paux=(int)Ms1.doubleValue();
                    con=1;
                }else if (Ms2!=255){
                    paux=(int)Ms2.doubleValue();
                    con=2;
                }else if (Ms3!=255){
                    paux=(int)Ms3.doubleValue();
                    con=3;
                }else {
                    paux=(int)Ms4.doubleValue();
                    con=4;
                }
                Salto=256-paux;
                s=0;
                t=256-Salto;
                if(con==2){
                    SR= p1.getText().toString()+"."+String.valueOf(s)+"."+"0"+"."+"0";
                    SRAux= p1.getText().toString()+"."+String.valueOf(t)+"."+"0"+"."+"0";
                    octeto1 = Integer.parseInt(p1.getText().toString());
                    octeto2 = Integer.parseInt(String.valueOf(s));
                    octeto3 = 0;
                    octeto4 = 0;
                    tipo="A";
                    tiponumber=1;
                }else if(con==3){
                    SR= p1.getText().toString()+"."+p2.getText().toString()+"."+String.valueOf(s)+"."+"0";
                    SRAux= p1.getText().toString()+"."+p2.getText().toString()+"."+String.valueOf(t)+"."+"0";
                    octeto1 = Integer.parseInt(p1.getText().toString());
                    octeto2 = Integer.parseInt(p2.getText().toString());
                    octeto3 = Integer.parseInt(String.valueOf(s));
                    octeto4 = 0;
                    tipo="B";
                    tiponumber=2;
                }else{
                    SR= p1.getText().toString()+"."+p2.getText().toString()+"."+p3.getText().toString()+"."+String.valueOf(s);
                    SRAux= p1.getText().toString()+"."+p2.getText().toString()+"."+p3.getText().toString()+"."+String.valueOf(t);
                    octeto1 = Integer.parseInt(p1.getText().toString());
                    octeto2 = Integer.parseInt(p2.getText().toString());
                    octeto3 = Integer.parseInt(p3.getText().toString());
                    octeto4 = Integer.parseInt(String.valueOf(s));
                    tipo="C";
                    tiponumber=3;
                }


                BSR=(s1.calNumRed(Double.parseDouble(ps.getText().toString())));


                v1.putExtra("Total",String.valueOf(paux));
                v1.putExtra("salto",String.valueOf(Salto));
                v1.putExtra("bSred",String.valueOf((int)BSR.doubleValue()));
                v1.putExtra("RSubred",String.valueOf((int)NumSubredes.doubleValue()));
                v1.putExtra("Msc",String.valueOf((int) Ms1.doubleValue())+"."+String.valueOf((int) Ms2.doubleValue())+"."+String.valueOf((int) Ms3.doubleValue())+"."+String.valueOf((int) Ms4.doubleValue()));
                v1.putExtra("NHost",String.valueOf((int)NumHost.doubleValue()));
                v1.putExtra("NBHost",String.valueOf((int)NumBHost.doubleValue()));
                v1.putExtra("bMs","/"+String.valueOf((int)MascaSubredB.doubleValue()));
                v1.putExtra("octeto1",octeto1);
                v1.putExtra("octeto2",octeto2);
                v1.putExtra("octeto3",octeto3);
                v1.putExtra("octeto4",octeto4);
                v1.putExtra("tipo",tipo);
                v1.putExtra("tiponumber",tiponumber);
                startActivity(v1);
            }
        });

    }
}
