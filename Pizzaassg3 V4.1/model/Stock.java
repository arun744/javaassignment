package model; 

import java.util.*;

public class Stock 
{   private LinkedList<Topping> toppings = new LinkedList<Topping>();
            
    public void add(String topping)
    {   toppings.add(new Topping(topping));
   
        }
        
    public void sub(String name)
    {   topping(name).sub();    }
    
    public boolean has(String name)
    {   return topping(name) != null;   }
        
    public Topping topping(String name)
    {   for (Topping top: toppings)
            if (top.matches(name))
                return top;
        return null;    }
        
    public int size()
    	
    { return toppings.size(); }
}
