package com.example.jsroc.subredes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PantallaResultado extends AppCompatActivity {
    TextView NumSubR,NumBSubred,NumHost,NumbHost,MascSR,MascSRB,Sal,Sr;
    Button VerSR;
    String nSubR,nbSred,MasS,MasSB,nHost,nBHost,nsalto,nTotal,sr,tipo;
    int octeto1,octeto2,octeto3,octeto4,tiponumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultado);

        NumSubR= (TextView) findViewById(R.id.txt_Sred);
        NumBSubred= (TextView) findViewById(R.id.txt_bSred);
        MascSR= (TextView) findViewById(R.id.txt_Ms);
        MascSRB= (TextView) findViewById(R.id.txt_MsB);
        NumbHost= (TextView) findViewById(R.id.txt_bHost);
        NumHost= (TextView) findViewById(R.id.txt_Host);
        Sal= (TextView) findViewById(R.id.txt_salto);
        VerSR = (Button) findViewById(R.id.btn_rangos);

        Sr= (TextView) findViewById(R.id.txt_Sr);

        Bundle extra=getIntent().getExtras();
        nSubR=extra.getString("RSubred");
        nbSred=extra.getString("bSred");
        MasSB=extra.getString("bMs");
        nHost=extra.getString("NHost");
        nBHost=extra.getString("NBHost");
        nsalto=extra.getString("salto");
        nTotal=extra.getString("Total");
        sr=extra.getString("SR");
        MasS=extra.getString("Msc");

        octeto1 = extra.getInt("octeto1");
        octeto2 = extra.getInt("octeto2");
        octeto3 = extra.getInt("octeto3");
        octeto4 = extra.getInt("octeto4");
        tipo = extra.getString("tipo");
        tiponumber = extra.getInt("tiponumber");

        Sr.setText(sr);
        Sal.setText(nsalto);
        MascSR.setText(MasS);
        NumBSubred.setText(nbSred);
        NumSubR.setText(nSubR);
        MascSRB.setText(MasSB);
        NumHost.setText(nHost);
        NumbHost.setText(nBHost);


        /*VerSR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"tipo: "+tipo+" "+octeto1+" "+octeto2+" "+octeto3+" "+octeto4+" ",Toast.LENGTH_LONG).show();
            }
        });*/


        VerSR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v1=new Intent(PantallaResultado.this,PantallaSubred.class);
                v1.putExtra("octeto1",octeto1);
                v1.putExtra("octeto2",octeto2);
                v1.putExtra("octeto3",octeto3);
                v1.putExtra("octeto4",octeto4);
                v1.putExtra("mascaradecimal",MasS);
                v1.putExtra("mascaraslash",MasSB);
                v1.putExtra("salto",nsalto);
                v1.putExtra("tipo",tiponumber);
                startActivity(v1);
            }
        });
    }
}
