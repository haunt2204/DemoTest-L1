package com.mycompany.services;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class BMIService {
    public static int tinhBMI(double w, double h){
        double bmi = w/Math.pow(h, 2);
        if(bmi<18.5)
            return 1;
        else if(bmi<23)
            return 2;
        else
            return 3;
    }
}
