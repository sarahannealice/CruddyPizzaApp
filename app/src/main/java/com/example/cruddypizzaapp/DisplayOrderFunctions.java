package com.example.cruddypizzaapp;

import static com.example.cruddypizzaapp.AppFunctions.checkboxNum;
import static com.example.cruddypizzaapp.OrderPage.*;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayOrderFunctions extends AppCompatActivity {

    //*****EXTREMELY LARGE METHOD*****//
    //checkbox display method
    public static boolean displayCheckboxes(String topping) {
        boolean bool = true;
        switch (topping) {
            //GREEN PEPPER//
            case "pepper":
                if (!AppFunctions.validateTopping(checkboxNum) && checkPepper.isChecked()) {
                    checkPepper.setChecked(false);
                    bool = false;
                //pepper is selected
                } else if (checkPepper.isChecked()) {
                    btnPepper.setVisibility(View.VISIBLE);
                    toppings.add(1);
                    checkboxNum += 1;
                    //when mushroom is deselected
                    if (!checkMushroom.isChecked()) {
                        vertical10_1.setVisibility(View.VISIBLE);
                        btnMushroom.setVisibility(View.INVISIBLE);
                    }
                //pepper is deselected when mushroom is selected
                } else if (!checkPepper.isChecked() && checkMushroom.isChecked()) {
                    resetMiniButtons("pepper");
                    btnPepper.setVisibility(View.INVISIBLE);
                    toppings.removeAll(pepper);
                    checkboxNum -= 1;
                //pepper is deselected when mushroom is deselected
                }else if (!checkPepper.isChecked()) {
                    resetMiniButtons("pepper");
                    vertical10_1.setVisibility(View.GONE);
                    toppings.removeAll(pepper);
                    checkboxNum -= 1;
                }
                break;

            //MUSHROOM//
            case "mushroom":
                if (!AppFunctions.validateTopping(checkboxNum) && checkMushroom.isChecked()) {
                    checkMushroom.setChecked(false);
                    bool =  false;
                //mushroom is selected
                } else if (checkMushroom.isChecked()) {
                    btnMushroom.setVisibility(View.VISIBLE);
                    toppings.add(2);
                    checkboxNum += 1;
                    //when pepper is deselected
                    if (!checkPepper.isChecked()) {
                        vertical10_1.setVisibility(View.VISIBLE);
                        btnPepper.setVisibility(View.INVISIBLE);
                    }
                //mushroom is deselected when pepper is selected
                } else if (!checkMushroom.isChecked() && checkPepper.isChecked()) {
                    resetMiniButtons("mush");
                    btnMushroom.setVisibility(View.INVISIBLE);
                    toppings.removeAll(mush);
                    checkboxNum -= 1;
                //mushroom is deselected when pepper is deselected
                } else if (!checkMushroom.isChecked()) {
                    resetMiniButtons("mush");
                    vertical10_1.setVisibility(View.GONE);
                    toppings.removeAll(mush);
                    checkboxNum -= 1;
                }
                break;

            //PEPPERONI//
            case "pepperoni":
                if (!AppFunctions.validateTopping(checkboxNum) && checkPepperoni.isChecked()) {
                    checkPepperoni.setChecked(false);
                    bool = false;
                } else if (checkPepperoni.isChecked()) {
                    btnPepperoni.setVisibility(View.VISIBLE);
                    toppings.add(3);
                    checkboxNum += 1;
                    if (!checkSausage.isChecked()) {
                        vertical12_1.setVisibility(View.VISIBLE);
                        btnSausage.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkPepperoni.isChecked() && checkSausage.isChecked()) {
                    resetMiniButtons("roni");
                    btnPepperoni.setVisibility(View.INVISIBLE);
                    toppings.removeAll(roni);
                    checkboxNum -= 1;
                } else if (!checkPepperoni.isChecked()) {
                    resetMiniButtons("roni");
                    vertical12_1.setVisibility(View.GONE);
                    toppings.removeAll(roni);
                    checkboxNum -= 1;
                }
                break;

            //SAUSAGE//
            case "sausage":
                if (!AppFunctions.validateTopping(checkboxNum) && checkSausage.isChecked()) {
                    checkSausage.setChecked(false);
                    bool = false;
                } else if (checkSausage.isChecked()) {
                    btnSausage.setVisibility(View.VISIBLE);
                    toppings.add(4);
                    checkboxNum += 1;
                    if (!checkPepperoni.isChecked()) {
                        vertical12_1.setVisibility(View.VISIBLE);
                        btnPepperoni.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkSausage.isChecked() && checkPepperoni.isChecked()) {
                    resetMiniButtons("saus");
                    btnSausage.setVisibility(View.INVISIBLE);
                    toppings.removeAll(saus);
                    checkboxNum -= 1;
                } else if (!checkSausage.isChecked()) {
                    resetMiniButtons("saus");
                    vertical12_1.setVisibility(View.GONE);
                    toppings.removeAll(saus);
                    checkboxNum -= 1;
                }
                break;

            //DICED HAM//
            case "ham":
                if (!AppFunctions.validateTopping(checkboxNum) && checkHam.isChecked()) {
                    checkHam.setChecked(false);
                    bool = false;
                } else if (checkHam.isChecked()) {
                    btnHam.setVisibility(View.VISIBLE);
                    toppings.add(5);
                    checkboxNum += 1;
                    if (!checkPineapple.isChecked()) {
                        vertical14_1.setVisibility(View.VISIBLE);
                        btnPineapple.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkHam.isChecked() && checkPineapple.isChecked()) {
                    resetMiniButtons("ham");
                    btnHam.setVisibility(View.INVISIBLE);
                    toppings.removeAll(ham);
                    checkboxNum -= 1;
                } else if (!checkHam.isChecked()) {
                    resetMiniButtons("ham");
                    vertical14_1.setVisibility(View.GONE);
                    toppings.removeAll(ham);
                    checkboxNum -= 1;
                }
                break;

            //PINEAPPLE//
            case "pineapple":
                if (!AppFunctions.validateTopping(checkboxNum) && checkPineapple.isChecked()) {
                    checkPineapple.setChecked(false);
                    bool = false;
                } else if (checkPineapple.isChecked()) {
                    btnPineapple.setVisibility(View.VISIBLE);
                    toppings.add(6);
                    checkboxNum += 1;
                    if (!checkHam.isChecked()) {
                        vertical14_1.setVisibility(View.VISIBLE);
                        btnHam.setVisibility(View.INVISIBLE);
                    }
                } else if (!checkPineapple.isChecked() && checkHam.isChecked()) {
                    resetMiniButtons("pine");
                    btnPineapple.setVisibility(View.INVISIBLE);
                    toppings.removeAll(pine);
                    checkboxNum -= 1;
                } else if (!checkPineapple.isChecked()) {
                    resetMiniButtons("pine");
                    vertical14_1.setVisibility(View.GONE);
                    toppings.removeAll(pine);
                    checkboxNum -= 1;
                }
                break;
        }//end switch statement
        return bool;
    }//end checkbox display method

    //*****LARGE METHOD*****//
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