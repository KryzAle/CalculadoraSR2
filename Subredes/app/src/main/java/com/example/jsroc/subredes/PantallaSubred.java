package com.example.jsroc.subredes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class PantallaSubred extends AppCompatActivity {
    ListView lstVistaSubredes;
    ArrayList<RangoSubred> listaSubredes;
    int octeto1,octeto2,octeto3,octeto4,tipo,salto,auxiliarSaltos;
    String mascaraDecimal,mascaraSlash,saltos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_subred);
        lstVistaSubredes = (ListView) findViewById(R.id.lv_datosSubred);
        listaSubredes =new  ArrayList<RangoSubred>();


        Bundle extra=getIntent().getExtras();
        octeto1=extra.getInt("octeto1");
        octeto2=extra.getInt("octeto2");
        octeto3=extra.getInt("octeto3");
        octeto4=extra.getInt("octeto4");
        mascaraDecimal=extra.getString("mascaradecimal");
        mascaraSlash=extra.getString("mascaraslash");
        salto= Integer.parseInt(extra.getString("salto"));
        tipo = extra.getInt("tipo");

        switch (tipo){
            case 1:
                auxiliarSaltos=octeto2;
                do {
                    auxiliarSaltos=((octeto2+salto)-1);
                    listaSubredes.add(new RangoSubred(""+octeto1+"."+octeto2+"."+octeto3+"."+octeto4+"",
                            ""+octeto1+"."+auxiliarSaltos+".255.255"," "+mascaraDecimal,""+mascaraSlash));
                    octeto2 = octeto2 + salto;
                }while (octeto2<256);
                break;
            case 2:
                auxiliarSaltos=octeto3;
                do {
                    auxiliarSaltos=((octeto3+salto)-1);
                    listaSubredes.add(new RangoSubred(""+octeto1+"."+octeto2+"."+octeto3+"."+octeto4+"",
                            ""+octeto1+"."+octeto2+"."+auxiliarSaltos+".255"," "+mascaraDecimal,""+mascaraSlash));
                    octeto3 = octeto3 + salto;
                }while (octeto3<256);
                break;
            case 3:
                auxiliarSaltos=octeto4;
                do {
                    auxiliarSaltos=((octeto4+salto)-1);
                    listaSubredes.add(new RangoSubred(""+octeto1+"."+octeto2+"."+octeto3+"."+octeto4+"",
                            ""+octeto1+"."+octeto2+"."+octeto3+"."+auxiliarSaltos," "+mascaraDecimal,""+mascaraSlash));
                    octeto4 = octeto4 + salto;
                }while (octeto4<256);
                break;
        }

        //listaSubredes.add(new RangoSubred(""+octeto1+"."+octeto2+"."+octeto3+"."+octeto4,"esta: "+salto+" tipo"+tipo,mascaraDecimal,mascaraSlash));
        AdaptadorItemSubred ven = new AdaptadorItemSubred(this,listaSubredes);
        lstVistaSubredes.setAdapter(ven);
    }
}
