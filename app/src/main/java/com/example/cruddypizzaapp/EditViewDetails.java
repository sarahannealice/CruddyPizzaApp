package com.example.cruddypizzaapp;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditViewDetails extends AppCompatActivity {

    //display order details for details page
    public static void DisplayOrderDetails(Order orderToDisplay) {
        String orderNum =Integer.toString((orderToDisplay.getOrderNum() + 1000));
        String details = orderToDisplay.getName() + "\n" + orderToDisplay.getPhone()
                + "\nsize: " + orderToDisplay.getSize() + "\ntoppings:\n\t\t" + orderToDisplay.getTop1()
                + "\n\t\t" + orderToDisplay.getTop2() + "\n\t\t" + orderToDisplay.getTop3();


        System.out.println("\norder: " + orderToDisplay.orderNum +
                "\nname: " + orderToDisplay.name +
                "\nphone: " + orderToDisplay.phone +
                "\nsize: " + orderToDisplay.size +
                "\ntop1: " + orderToDisplay.top1 +
                "\ntop2: " + orderToDisplay.top2 +
                "\ntop3: " + orderToDisplay.top3 + "\n");

        //set textviews on details page
        DetailsPage.orderNumTV.append(orderNum);
        DetailsPage.detailsTV.setText(details);

    }//end display order details

    //display order detail on order page
    public static void DisplayOrderEdit(Order orderToEdit) {
        System.out.println("\norder: " + orderToEdit.orderNum +
                "\nname: " + orderToEdit.name +
                "\nphone: " + orderToEdit.phone +
                "\nsize: " + orderToEdit.size +
                "\ntop1: " + orderToEdit.top1 +
                "\ntop2: " + orderToEdit.top2 +
                "\ntop3: " + orderToEdit.top3 + "\n");

        //setting up edit text views
        //https://stackoverflow.com/a/4594761
        OrderPage.textName.setText(orderToEdit.getName(), TextView.BufferType.EDITABLE);
        OrderPage.textPhone.setText(orderToEdit.getPhone(), TextView.BufferType.EDITABLE);

        //setting up radio buttons
        switch (orderToEdit.size) {
            case 1:
                OrderPage.radioSmall.setChecked(true);
                OrderPage.size = 1;
                break;
            case 2:
                OrderPage.radioMedium.setChecked(true);
                OrderPage.size = 2;
                break;
            case 3:
                OrderPage.radioLarge.setChecked(true);
                OrderPage.size = 3;
                break;
            case 4:
                OrderPage.radioXlarge.setChecked(true);
                OrderPage.size = 4;
                break;
        }

        DisplayEditCheckboxes(orderToEdit.top1, orderToEdit.top2, orderToEdit.top3);
    }//end display edit order

    //display edit checkboxes
    public static void DisplayEditCheckboxes(int one, int two, int three) {
        //reset toppings arraylist
        OrderPage.toppings.clear();

        //PEPPER//
        if (one == 1 || two == 1 || three == 1) {
            OrderPage.checkPepper.setChecked(true);
            OrderPage.vertical10_1.setVisibility(View.VISIBLE);
            OrderPage.btnPepper.setVisibility(View.VISIBLE);
            //setup toppings arraylist
            OrderPage.toppings.add(1);
            //checks if adjacent topping is visible or not
            if (OrderPage.btnMushroom.getVisibility() == View.GONE) {
                OrderPage.btnMushroom.setVisibility(View.INVISIBLE);
            }
            if (((one == 1 && two == 1) && three != 1) || ((two == 1 && three == 1) && one != 1)) {
                DisplayToppings.displaySameToppings("dblPep");
                //setup toppings arraylist
                OrderPage.toppings.add(1);
            } else if (one == 1 && two == 1 && three == 1) {
                DisplayToppings.displaySameToppings("triPep");
                //setup toppings arraylist
                OrderPage.toppings.add(1);
                OrderPage.toppings.add(1);
            }
        }

        //MUSHROOM//
        if (one == 2 || two == 2 || three == 2) {
            OrderPage.checkMushroom.setChecked(true);
            OrderPage.vertical10_1.setVisibility(View.VISIBLE);
            OrderPage.btnMushroom.setVisibility(View.VISIBLE);
            OrderPage.toppings.add(2);
            if (OrderPage.btnPepper.getVisibility() == View.GONE) {
                OrderPage.btnPepper.setVisibility(View.INVISIBLE);
            }
            if (((one == 2 && two == 2) && three != 2) || ((two == 2 && three == 2) && one != 2)) {
                DisplayToppings.displaySameToppings("dblMush");
                OrderPage.toppings.add(2);
            } else if (one == 2 && two == 2 && three == 2) {
                DisplayToppings.displaySameToppings("triMush");
                OrderPage.toppings.add(2);
                OrderPage.toppings.add(2);
            }
        }

        //PEPPERONI//
        if (one == 3 || two == 3 || three == 3) {
            OrderPage.checkPepperoni.setChecked(true);
            OrderPage.vertical12_1.setVisibility(View.VISIBLE);
            OrderPage.btnPepperoni.setVisibility(View.VISIBLE);
            OrderPage.toppings.add(3);
            if (OrderPage.btnSausage.getVisibility() == View.GONE) {
                OrderPage.btnSausage.setVisibility(View.INVISIBLE);
            }
            if (((one == 3 && two == 3) && three != 3) || ((two == 3 && three == 3) && one != 3)) {
                DisplayToppings.displaySameToppings("dblRoni");
                OrderPage.toppings.add(3);
            } else if (one == 3 && two == 3 && three == 3) {
                DisplayToppings.displaySameToppings("triRoni");
                OrderPage.toppings.add(3);
                OrderPage.toppings.add(3);
            }
        }

        //SAUSAGE//
        if (one == 4 || two == 4 || three == 4) {
            OrderPage.checkSausage.setChecked(true);
            OrderPage.vertical12_1.setVisibility(View.VISIBLE);
            OrderPage.btnSausage.setVisibility(View.VISIBLE);
            OrderPage.toppings.add(4);
            if (OrderPage.btnPepperoni.getVisibility() == View.GONE) {
                OrderPage.btnPepperoni.setVisibility(View.INVISIBLE);
            }
            if (((one == 4 && two == 4) && three != 4) || ((two == 4 && three == 4) && one != 4)) {
                DisplayToppings.displaySameToppings("dblSaus");
                OrderPage.toppings.add(4);
            } else if (one == 4 && two == 4 && three == 4) {
                DisplayToppings.displaySameToppings("triSaus");
                OrderPage.toppings.add(4);
                OrderPage.toppings.add(4);
            }
        }

        //DICED HAM//
        if (one == 5 || two == 5 || three == 5) {
            OrderPage.checkHam.setChecked(true);
            OrderPage.vertical14_1.setVisibility(View.VISIBLE);
            OrderPage.btnHam.setVisibility(View.VISIBLE);
            OrderPage.toppings.add(5);
            if (OrderPage.btnPineapple.getVisibility() == View.GONE) {
                OrderPage.btnPineapple.setVisibility(View.INVISIBLE);
            }
            if (((one == 5 && two == 5) && three != 5) || ((two == 5 && three == 5) && one != 5)) {
                DisplayToppings.displaySameToppings("dblHam");
                OrderPage.toppings.add(5);
            } else if (one == 5 && two == 5 && three == 5) {
                DisplayToppings.displaySameToppings("triHam");
                OrderPage.toppings.add(5);
            }
        }

        //PINEAPPLE//
         if (one == 6 || two == 6 || three == 6) {
            OrderPage.checkPineapple.setChecked(true);
            OrderPage.vertical14_1.setVisibility(View.VISIBLE);
            OrderPage.btnPineapple.setVisibility(View.VISIBLE);
             OrderPage.toppings.add(6);
             if (OrderPage.btnHam.getVisibility() == View.GONE) {
                 OrderPage.btnHam.setVisibility(View.INVISIBLE);
             }
            if (((one == 6 && two == 6) && three != 6) || ((two == 6 && three == 6) && one != 6)) {
                DisplayToppings.displaySameToppings("dblPine");
                OrderPage.toppings.add(6);
            } else if (one == 6 && two == 6 && three == 6) {
                DisplayToppings.displaySameToppings("triPine");
                OrderPage.toppings.add(6);
            }
        }
    }//end display checkbox and mini buttons for edit order
}//end display details class