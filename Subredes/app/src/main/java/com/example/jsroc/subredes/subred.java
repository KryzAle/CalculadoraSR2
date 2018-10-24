package com.example.jsroc.subredes;

import android.widget.Toast;

/**
 * Created by jsroc on 28/1/2018.
 */

public class subred {


    public double calNumRed (double ns){
        double i=1;
        while ((Math.pow(2.00,i)<ns)){
            i++;
        }
        return i;
    }
}

