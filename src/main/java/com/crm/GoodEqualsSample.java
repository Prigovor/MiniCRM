package com.crm;

import com.crm.entity.good.Good;
import com.crm.entity.good.selected_good.SelectedGood;

/**
 * Created by Bohdan on 24.02.2017.
 */
public class GoodEqualsSample
{
    public static void main(String[] args)
    {
        Good good = new Good("HP", 2, 100D);
        SelectedGood selectedGood = new SelectedGood("HP", 1, 100D, null);

        System.out.println(good.equals(selectedGood));
    }
}
