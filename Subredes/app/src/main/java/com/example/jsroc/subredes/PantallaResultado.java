package com.example.jsroc.subredes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PantallaResultado extends AppCompatActivity {
    TextView NumSubR,NumBSubred,NumHost,NumbHost,MascSR,MascSRB,Sal,Sr;
    Button VerSR;
    String nSubR,nbSred,MasS,MasSB,nHost,nBHost,nsalto,nTotal,sr;
    Integer i,total;
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

        Sr.setText(sr);
        Sal.setText(nsalto);
        MascSR.setText(MasS);
        NumBSubred.setText(nbSred);
        NumSubR.setText(nSubR);
        MascSRB.setText(MasSB);
        NumHost.setText(nHost);
        NumbHost.setText(nBHost);


    }
}
