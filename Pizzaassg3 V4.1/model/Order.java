package model; 

import java.util.*;

public class Order 
{   private LinkedList<Pizza> pizzas = new LinkedList<Pizza>();
        
    public void add(Pizza pizza)
    {   pizzas.add(pizza);}
    
    public double price()
    {   double price = 0;
        for (Pizza pizza: pizzas)
            price += pizza.price();
        return price;   }
        
    public void clear()
    {   pizzas.clear(); }
    
    public int size()
    {   return pizzas.size();    }
    
    public LinkedList<Pizza> pizzas()
    {   return pizzas;  }
}
