package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {

        private Customer object;
        private Contact object2;


        public DataAdapter(Customer customer, Contact contact) {
            this.object=customer;
            this.object2=contact;
        }

        @Override
        public String getCountryCode()
        {
            String country = object.getCountryName();
            String countryCode = "";

            for (Map.Entry<String, String> pair : countries.entrySet())
            {
                if (country.equals(pair.getValue()))
                {
                    return pair.getKey();
                }
            }

            return countryCode;
        }

        @Override
        public String getCompany()
        {
            return object.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String s=object2.getName();
            String name="";
            boolean b=true;
            for (int i=0; i<s.length(); i++){
                char c=s.charAt(i);
                if (b==false)
                {
                    name = name + c;
                }
                if (c==' '){
                    b=false;
                }
            }
            return name;
        }

        @Override
        public String getContactLastName()
        {
            String s=object2.getName();
            String famil="";
            for (int i=0; i<s.length(); i++){
                char c=s.charAt(i);
                if (c==','){
                    break;
                }
                famil=famil+c;
            }
            return famil;
        }

        @Override
        public String getDialString()
        {
            return "callto://"+object2.getPhoneNumber().replaceAll("[()-]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static void main(String[] args)
    {
        Customer customer = new Customer() {
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact = new Contact() {
            public String getName() {
                return "Ivanov, Ivan";
            }

            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };

        RowItem rowItem = new DataAdapter(customer, contact);
        System.out.println(rowItem.getCountryCode());
        System.out.println(rowItem.getCompany());
        System.out.println(rowItem.getContactFirstName());
        System.out.println(rowItem.getContactLastName());
        System.out.println(rowItem.getDialString());
    }
}