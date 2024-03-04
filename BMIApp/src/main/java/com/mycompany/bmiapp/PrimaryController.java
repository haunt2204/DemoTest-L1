package com.mycompany.bmiapp;

import com.mycompany.services.BMIService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PrimaryController {
    @FXML private TextField txtHeight;
    @FXML private TextField txtWeight;
    @FXML private Label lbResult;
    
    public void tinhBMI(ActionEvent ae){
        double h = Double.parseDouble(txtHeight.getText());
        double w = Double.parseDouble(txtWeight.getText());
        
        int bmi = BMIService.tinhBMI(w, h);
        String result = "";
        
        if(bmi==1){
            result = "Gầy";
            lbResult.setTextFill(Color.RED);
        }else if(bmi==2){
            result = "Bình thường";
            lbResult.setTextFill(Color.BLUE);
        }else{
            result = "Béo phì";
            lbResult.setTextFill(Color.GOLD);
        }
        lbResult.setText(result);
    }
}
