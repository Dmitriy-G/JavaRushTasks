package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData object;

        IncomeDataAdapter(IncomeData object){
            this.object=object;
        }

        @Override
        public String getName()
        {
            return this.object.getContactLastName()+", "+this.object.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            String s=String.valueOf(this.object.getPhoneNumber());
                for (int i=0; i<10-s.length(); i++)
                {
                    s = s + "0";
                }
            String m = String.format("+%d(%2$s)%3$s-%4$s-%5$s",object.getCountryPhoneCode(),
                    String.format("%010d", object.getPhoneNumber()).substring(0, 3),
                    String.format("%010d", object.getPhoneNumber()).substring(3, 6),
                    String.format("%010d", object.getPhoneNumber()).substring(6, 8),
                    String.format("%010d", object.getPhoneNumber()).substring(8));

            return m;
        }

        @Override
        public String getCompanyName()
        {
            return this.object.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(object.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}