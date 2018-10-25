package com.example.jsroc.subredes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorItemSubred extends BaseAdapter {
    Context myContext;
    ArrayList<RangoSubred> listaSubred;
    LayoutInflater inflador;

    public AdaptadorItemSubred(Context myContext, ArrayList<RangoSubred> listaSubred){
        this.myContext = myContext;
        this.listaSubred = listaSubred;
        inflador = LayoutInflater.from(myContext);
    }

    @Override
    public int getCount() {
        return listaSubred.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflador.inflate(R.layout.item_layout_subredes,null);
        TextView lblInicio = (TextView) view.findViewById(R.id.tv_inicio);
        TextView lblFin = (TextView) view.findViewById(R.id.tv_fin);
        TextView lblMascaraDecimal = (TextView) view.findViewById(R.id.tv_mascaradec);
        TextView lblMascaraSlash = (TextView) view.findViewById(R.id.tv_mascaraslash);

        lblInicio.setText(listaSubred.get(i).getInicio());
        lblFin.setText(listaSubred.get(i).getFin());
        lblMascaraDecimal.setText(listaSubred.get(i).getMascaradecimal());
        lblMascaraSlash.setText(listaSubred.get(i).getMascaraslash());

        return view;
    }

}
