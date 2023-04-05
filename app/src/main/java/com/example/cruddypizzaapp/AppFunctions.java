package com.example.cruddypizzaapp;

import static com.example.cruddypizzaapp.OrderPage.*;

import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.util.regex.*;


public class AppFunctions {

    //regex for name input -- https://stackoverflow.com/a/66910482
    static String nameRegex = "^[A-Za-z]{2,15}(?:\\h+[A-Za-z]{2,20})?$";
    //needs work -- https://stackoverflow.com/a/33623344
    static String nameRegexZh = "^([\\P{sc=Han}]*[\\p{sc=Han}]){2,4}.*$";
    static Pattern namePattern = Pattern.compile(nameRegex);
    static Pattern namePatternZh = Pattern.compile(nameRegexZh);

    //regex for phone input -- https://stackoverflow.com/a/16699507
    static String phoneRegex = "^\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
    static Pattern phonePattern = Pattern.compile(phoneRegex);

    static Matcher matcher;
    static Matcher matcherZh;
    static boolean bool;
    static boolean boolZh;

    static int checkboxNum;//counter to prevent selecting more than 3 toppings
    static int sameTopTotal;
    //counter for additional of same topping
    static int top1;//green pepper
    static int top2;//mushroom
    static int top3;//pepperoni
    static int top4;//sausage
    static int top5;//diced ham
    static int top6;//pineapple

    //-------SUBMIT VALIDATIONS-------//
    //validate name
    public static boolean validateName(String input) {
        matcher = namePattern.matcher(input);
        matcherZh = namePatternZh.matcher(input);
        bool = matcher.matches();
        boolZh = matcherZh.matches();

        //fix for chinese characters
//        if (!bool || !boolZh) {
//            return false;
//        } else {
//            return bool;
//        }
        return bool;
    }//end name validation

    //validate phone number
    public static boolean validatePhone(String input) {
        matcher = phonePattern.matcher(input);
        bool = matcher.matches();

        return bool;
    }//end phone validation

    //radio button validation
    public static boolean validateRadios(int count, RadioGroup radiogroup) {
        for (int i = 0; i < count; i++) {
            RadioButton x = (RadioButton) radiogroup.getChildAt(i);
            if (x.isChecked()) {
                bool = true;
                break;
            } else {
                bool = false;
            }
        }
        return bool;
    }//end radio validation

    //checkbox validation
    public static boolean validateCheckBoxes(CheckBox pep, CheckBox mush, CheckBox roni,
                                             CheckBox saus, CheckBox ham, CheckBox pine) {
        return pep.isChecked() || mush.isChecked() || roni.isChecked() || saus.isChecked() ||
                ham.isChecked() || pine.isChecked();
    }
    //-------END SUBMIT VALIDATIONS-------//


    //-------TOPPING VALIDATIONS-------//
    //check if topping can be selected
    public static boolean validateTopping(int checkNum) {
        if (checkNum == LIMIT) {
            bool = false;
        } else if (checkNum == 2 && sameTopTotal == 0) {
            bool = true;
        } else if (checkNum == 1 && sameTopTotal <= 1) {
            bool = true;
        } else if (checkNum == 0) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    //check if topping can be increased
    public static boolean validateExtraTopping (int topNum, int num) {
        switch (num) {
            case 1:
                top1 = topNum;
                break;
            case 2:
                top2 = topNum;
                break;
            case 3:
                top3 = topNum;
                break;
            case 4:
                top4 = topNum;
                break;
            case 5:
                top5 = topNum;
                break;
            case 6:
                top6 = topNum;
                break;
        }
        //updates total
        sameTopTotal = top1 + top2 + top3 + top4 + top5 + top6;

        if (checkboxNum == LIMIT) {
            bool = false;
        } else if ((checkboxNum + sameTopTotal) > LIMIT) {
            bool = false;
        } else if (checkboxNum == 2 && topNum == 1 && valid) {
            bool = true;
//        } else if (checkNum == 2 && sameTopNum == 1 && !valid) {
//            bool = true;
        } else if (checkboxNum == 1 && (topNum == 1 || topNum == 2) && sameTopTotal <= 2) {
            bool = true;
        } else {
            bool = false;
        }

        return bool;
    }//end additional same topping validation
    //-------END TOPPING VALIDATIONS-------//
}//end AppFunctions class