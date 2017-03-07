package com.kaivanshah.assignment53;

/**
 * Created by kaivanrasiklal.s on 07-03-2017.
 */

public class Contact {

    private String name;
    private String phoneum;

    public Contact(String Name,String PhonNum)
    {
        name = Name;
        phoneum =  PhonNum;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneum;
    }

    public void setName( String Name) {
        name = Name;
    }

    public void setPhoneNum(String PhonNum) {
        phoneum = PhonNum;
    }
}
