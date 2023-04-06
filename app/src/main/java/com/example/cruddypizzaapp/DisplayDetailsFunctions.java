package com.example.cruddypizzaapp;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayDetailsFunctions extends AppCompatActivity {

    //display order details for details page
    public static void DisplayOrderDetails(Order orderToDisplay) {
        String orderNum =Integer.toString((orderToDisplay.getOrderNum() + 1000));
        String details = orderToDisplay.getName() + "\n" + orderToDisplay.getPhone()
                + "\nsize: " + orderToDisplay.getSize() + "\ntoppings:\n\t\t" + orderToDisplay.getTop1()
                + "\n\t\t" + orderToDisplay.getTop2() + "\n\t\t" + orderToDisplay.getTop3();

        //set textviews on details page
        DetailsPage.orderNumTV.append(orderNum);
        DetailsPage.detailsTV.setText(details);

    }//end display order details

    //display order detail on order page
    public static void DisplayOrderEdit(Order orderToEdit) {
        //setting up edit text views
        //https://stackoverflow.com/a/4594761
        OrderPage.textName.setText(orderToEdit.getName(), TextView.BufferType.EDITABLE);
        OrderPage.textPhone.setText(orderToEdit.getPhone(), TextView.BufferType.EDITABLE);

        //setting up radio buttons
        switch (orderToEdit.size) {
            case 1:
                OrderPage.radioSmall.setChecked(true);
                break;
            case 2:
                OrderPage.radioMedium.setChecked(true);
                break;
            case 3:
                OrderPage.radioLarge.setChecked(true);
                break;
            case 4:
                OrderPage.radioXlarge.setChecked(true);
                break;
        }

        DisplayEditCheckboxes(orderToEdit.top1, orderToEdit.top2, orderToEdit.top3);
    }//end display edit order

    //display edit checkboxes
    public static void DisplayEditCheckboxes(int one, int two, int three) {
        //PEPPER//
        if (one == 1 || two == 1 || three == 1) {
            OrderPage.checkPepper.setChecked(true);
            OrderPage.vertical10_1.setVisibility(View.VISIBLE);
            OrderPage.btnPepper.setVisibility(View.VISIBLE);
            //checks if adjacent topping is visible or not
            if (OrderPage.btnMushroom.getVisibility() == View.GONE) {
                OrderPage.btnMushroom.setVisibility(View.INVISIBLE);
            }
            if (((one == 1 && two == 1) && three != 1) || ((two == 1 && three == 1) && one != 1)) {
                DisplayOrderFunctions.displaySameToppings("dblPep");
            } else if (one == 1 && two == 1 && three == 1) {
                DisplayOrderFunctions.displaySameToppings("triPep");
            }
        }

        //MUSHROOM//
        if (one == 2 || two == 2 || three == 2) {
            OrderPage.checkMushroom.setChecked(true);
            OrderPage.vertical10_1.setVisibility(View.VISIBLE);
            OrderPage.btnMushroom.setVisibility(View.VISIBLE);
            if (OrderPage.btnPepper.getVisibility() == View.GONE) {
                OrderPage.btnPepper.setVisibility(View.INVISIBLE);
            }
            if (((one == 2 && two == 2) && three != 2) || ((two == 2 && three == 2) && one != 2)) {
                DisplayOrderFunctions.displaySameToppings("dblMush");
            } else if (one == 2 && two == 2 && three == 2) {
                DisplayOrderFunctions.displaySameToppings("triMush");
            }
        }

        //PEPPERONI//
        if (one == 3 || two == 3 || three == 3) {
            OrderPage.checkPepperoni.setChecked(true);
            OrderPage.vertical12_1.setVisibility(View.VISIBLE);
            OrderPage.btnPepperoni.setVisibility(View.VISIBLE);
            if (OrderPage.btnSausage.getVisibility() == View.GONE) {
                OrderPage.btnSausage.setVisibility(View.INVISIBLE);
            }
            if (((one == 3 && two == 3) && three != 3) || ((two == 3 && three == 3) && one != 3)) {
                DisplayOrderFunctions.displaySameToppings("dblRoni");
            } else if (one == 3 && two == 3 && three == 3) {
                DisplayOrderFunctions.displaySameToppings("triRoni");
            }
        }

        //SAUSAGE//
        if (one == 4 || two == 4 || three == 4) {
            OrderPage.checkSausage.setChecked(true);
            OrderPage.vertical12_1.setVisibility(View.VISIBLE);
            OrderPage.btnSausage.setVisibility(View.VISIBLE);
            if (OrderPage.btnPepperoni.getVisibility() == View.GONE) {
                OrderPage.btnPepperoni.setVisibility(View.INVISIBLE);
            }
            if (((one == 4 && two == 4) && three != 4) || ((two == 4 && three == 4) && one != 4)) {
                DisplayOrderFunctions.displaySameToppings("dblSaus");
            } else if (one == 4 && two == 4 && three == 4) {
                DisplayOrderFunctions.displaySameToppings("triSaus");
            }
        }

        //DICED HAM//
        if (one == 5 || two == 5 || three == 5) {
            OrderPage.checkHam.setChecked(true);
            OrderPage.vertical14_1.setVisibility(View.VISIBLE);
            OrderPage.btnHam.setVisibility(View.VISIBLE);
            if (OrderPage.btnPineapple.getVisibility() == View.GONE) {
                OrderPage.btnPineapple.setVisibility(View.INVISIBLE);
            }
            if (((one == 5 && two == 5) && three != 5) || ((two == 5 && three == 5) && one != 5)) {
                DisplayOrderFunctions.displaySameToppings("dblHam");
            } else if (one == 5 && two == 5 && three == 5) {
                DisplayOrderFunctions.displaySameToppings("triHam");
            }
        }

        //PINEAPPLE//
         if (one == 6 || two == 6 || three == 6) {
            OrderPage.checkPineapple.setChecked(true);
            OrderPage.vertical14_1.setVisibility(View.VISIBLE);
            OrderPage.btnPineapple.setVisibility(View.VISIBLE);
             if (OrderPage.btnHam.getVisibility() == View.GONE) {
                 OrderPage.btnHam.setVisibility(View.INVISIBLE);
             }
            if (((one == 6 && two == 6) && three != 6) || ((two == 6 && three == 6) && one != 6)) {
                DisplayOrderFunctions.displaySameToppings("dblPine");
            } else if (one == 6 && two == 6 && three == 6) {
                DisplayOrderFunctions.displaySameToppings("triPine");
            }
        }
    }//end display checkbox and mini buttons for edit order
}//end display details class