package com.mycompany.bmiapp;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        int a = 9;
        boolean result;
        if(a>0)
            result = true;
        else
            result = false;
    }
}
