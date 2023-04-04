package com.example.cruddypizzaapp;

import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.util.regex.*;


public class AppFunctions {

    //regex for name input -- https://stackoverflow.com/a/66910482
    static String nameRegex = "^[A-Za-z]{2,15}(?:\\h+[A-Za-z]{2,20})?$";
    //needs work -- https://stackoverflow.com/a/33623344
    static String nameRegexZh = "^(\\P{sc=Han}*\\p{sc=Han}){2,4}.*$";
    static Pattern namePattern = Pattern.compile(nameRegex);
    static Pattern namePatternZh = Pattern.compile(nameRegexZh);

    //regex for phone input -- https://stackoverflow.com/a/16699507
    static String phoneRegex = "^\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
    static Pattern phonePattern = Pattern.compile(phoneRegex);

    static Matcher matcher;
    static Matcher matcherZh;
    static boolean bool;
    static boolean boolZh;

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

    //check if topping can be increased
    public static boolean validateExtraTopping(int checkNum, int sameTopNum, int sameTopTotal) {
        if ((checkNum + sameTopTotal) >= 3) {
            bool = false;
        } else if (checkNum == 2 && sameTopNum == 0 && sameTopTotal < 3) {
            bool = true;
        } else if (checkNum == 1 && (sameTopNum == 1 || sameTopNum == 2) && sameTopTotal < 3) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }//end additional same topping validation

}//end AppFunctions class


