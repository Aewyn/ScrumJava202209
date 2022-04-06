package com.aewyn.enums;

import com.aewyn.persoon.Geslacht;
import com.aewyn.persoon.Persoon;

public class EnumMain {
    public static void main(String[] args) {
        try{
            var persoon = new Persoon("Xor", "Ipsum", Geslacht.VROUW);
            System.out.println(persoon);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
