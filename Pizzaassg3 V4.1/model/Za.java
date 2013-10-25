package model;

import java.util.*;

public class Za extends Viewable
{   private double money = 1000;
    private Stock stock = new Stock();
    private LinkedList<Pizza> pizzas = new LinkedList<Pizza>();
    public Order order = new Order();
    
    public Za()
    {   String[] pepperoniTops = {"pepperoni", "mushroom", "olive"};
        add("pepperoni", pepperoniTops, 4.50);
        String[] marinaraTops = {"prawn", "olive"};
        add("marinara", marinaraTops, 6.70);
        String[] vegetarianTops = {"zucchini", "artichoke"};
        add("vegetarian", vegetarianTops, 8.90);
        
     
           }
        
    public void add(String name, String[] tops, double price)
    {   add(new Pizza(name, tops, price));  
        update();
    }
                
    public void add(Pizza pizza)
    {   pizzas.add(pizza);
        for (String top: pizza.tops())
            if (!stock.has(top))
                stock.add(top); 
        update();
                }
                

                    
    public Pizza pizza(String name)
    {   
        for (Pizza pizza: pizzas)
            if (pizza.matches(name))
            return pizza;
        return null;   }
        
            
    public void add(double amount)
        
    {   money += amount;
        update();   
            }
    
    public double money()
    {   return money;   }
    
    public Stock stock()
    {   return stock;   }
    
    public LinkedList<Pizza> pizzas()
    {   
        return pizzas; 
    }
    
    public Order order()
    {  return order;   }
}
