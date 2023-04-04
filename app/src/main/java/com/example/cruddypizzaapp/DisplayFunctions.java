package com.example.cruddypizzaapp;

import static com.example.cruddypizzaapp.OrderPage.*;

import android.content.res.ColorStateList;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayFunctions extends AppCompatActivity {

    //display same topping buttons
    public static void displaySameToppings(String topAmount) {
        //GREEN PEPPER
        switch (topAmount) {
            case "normPep":
                normalPepper.setImageResource(R.drawable.normal_selected);
                doublePepper.setImageResource(R.drawable.double_deselected);
                triplePepper.setImageResource(R.drawable.triple_deselected);
                break;
            case "dblPep":
                normalPepper.setImageResource(R.drawable.normal_deselected);
                doublePepper.setImageResource(R.drawable.double_selected);
                triplePepper.setImageResource(R.drawable.triple_deselected);
                break;
            case "triPep":
                normalPepper.setImageResource(R.drawable.normal_deselected);
                doublePepper.setImageResource(R.drawable.double_deselected);
                triplePepper.setImageResource(R.drawable.triple_selected);
                break;
            case "normMush":
                normalMushroom.setImageResource(R.drawable.normal_selected);
                doubleMushroom.setImageResource(R.drawable.double_deselected);
                tripleMushroom.setImageResource(R.drawable.triple_deselected);
                break;
            case "dblMush":
                normalMushroom.setImageResource(R.drawable.normal_deselected);
                doubleMushroom.setImageResource(R.drawable.double_selected);
                tripleMushroom.setImageResource(R.drawable.triple_deselected);
                break;
            case "triMush":
                normalMushroom.setImageResource(R.drawable.normal_deselected);
                doubleMushroom.setImageResource(R.drawable.double_deselected);
                tripleMushroom.setImageResource(R.drawable.triple_selected);
                break;
            case "normRoni":
                normalPepperoni.setImageResource(R.drawable.normal_selected);
                doublePepperoni.setImageResource(R.drawable.double_deselected);
                triplePepperoni.setImageResource(R.drawable.triple_deselected);
                break;
            case "dblRoni":
                normalPepperoni.setImageResource(R.drawable.normal_deselected);
                doublePepperoni.setImageResource(R.drawable.double_selected);
                triplePepperoni.setImageResource(R.drawable.triple_deselected);
                break;
            case "triRoni":
                normalPepperoni.setImageResource(R.drawable.normal_deselected);
                doublePepperoni.setImageResource(R.drawable.double_deselected);
                triplePepperoni.setImageResource(R.drawable.triple_selected);
                break;
            case "normSaus":
                normalSausage.setImageResource(R.drawable.normal_selected);
                doubleSausage.setImageResource(R.drawable.double_deselected);
                tripleSausage.setImageResource(R.drawable.triple_deselected);
                break;
            case "dblSaus":
                normalSausage.setImageResource(R.drawable.normal_deselected);
                doubleSausage.setImageResource(R.drawable.double_selected);
                tripleSausage.setImageResource(R.drawable.triple_deselected);
                break;
            case "triSaus":
                normalSausage.setImageResource(R.drawable.normal_deselected);
                doubleSausage.setImageResource(R.drawable.double_deselected);
                tripleSausage.setImageResource(R.drawable.triple_selected);
                break;
            case "normHam":
                normalHam.setImageResource(R.drawable.normal_selected);
                doubleHam.setImageResource(R.drawable.double_deselected);
                tripleHam.setImageResource(R.drawable.triple_deselected);
                break;
            case "dblHam":
                normalHam.setImageResource(R.drawable.normal_deselected);
                doubleHam.setImageResource(R.drawable.double_selected);
                tripleHam.setImageResource(R.drawable.triple_deselected);
                break;
            case "triHam":
                normalHam.setImageResource(R.drawable.normal_deselected);
                doubleHam.setImageResource(R.drawable.double_deselected);
                tripleHam.setImageResource(R.drawable.triple_selected);
                break;
            case "normPine":
                normalPineapple.setImageResource(R.drawable.normal_selected);
                doublePineapple.setImageResource(R.drawable.double_deselected);
                triplePineapple.setImageResource(R.drawable.triple_deselected);
                break;
            case "dblPine":
                normalPineapple.setImageResource(R.drawable.normal_deselected);
                doublePineapple.setImageResource(R.drawable.double_selected);
                triplePineapple.setImageResource(R.drawable.triple_deselected);
                break;
            case "triPine":
                normalPineapple.setImageResource(R.drawable.normal_deselected);
                doublePineapple.setImageResource(R.drawable.double_deselected);
                triplePineapple.setImageResource(R.drawable.triple_selected);
                break;
        }
    }//end same topping display method


    //reset mini buttons for toppings
    public static void resetMiniButtons(String topping) {
        switch (topping) {
            case "pepper":
                normalPepper.setImageResource(R.drawable.normal_selected);
                doublePepper.setImageResource(R.drawable.double_deselected);
                triplePepper.setImageResource(R.drawable.triple_deselected);
                break;
            case "mush":
                normalMushroom.setImageResource(R.drawable.normal_selected);
                doubleMushroom.setImageResource(R.drawable.double_deselected);
                tripleMushroom.setImageResource(R.drawable.triple_deselected);
                break;
            case "roni":
                normalPepperoni.setImageResource(R.drawable.normal_selected);
                doublePepperoni.setImageResource(R.drawable.double_deselected);
                triplePepperoni.setImageResource(R.drawable.triple_deselected);
                break;
            case "saus":
                normalSausage.setImageResource(R.drawable.normal_selected);
                doubleSausage.setImageResource(R.drawable.double_deselected);
                tripleSausage.setImageResource(R.drawable.triple_deselected);
                break;
            case "ham":
                normalHam.setImageResource(R.drawable.normal_selected);
                doubleHam.setImageResource(R.drawable.double_deselected);
                tripleHam.setImageResource(R.drawable.triple_deselected);
                break;
            case "pine":
                normalPineapple.setImageResource(R.drawable.normal_selected);
                doublePineapple.setImageResource(R.drawable.double_deselected);
                triplePineapple.setImageResource(R.drawable.triple_deselected);
                break;
        }
    }//end reset mini buttons
}//end display class
