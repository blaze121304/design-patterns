package com.rusty.builder.effectjava;


public class PizzaTest {

    public static void main(String[] args) {

        Pizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION).build();


        Pizza calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.PEPPER)
                .sauceInside().build();

        System.out.println(nyPizza);
        System.out.println(calzone);
    }

}