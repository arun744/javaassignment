import model.*;

public class test {

   // public test() {
   	//public static Order order;
   	 private Pizza[] pizza;
    	public static void main (String[] args) {
    		Za za = new Za();
    		//Order order = new Order();
    		String[] goldTop = {"room", "mushroom", "olive"};
    		Pizza pizza = new Pizza("gold", goldTop, 4.50) ;
    		
    		String[] pepperoniTop = {"pepperoni", "checker", "olive"};
    		za.order.add(za.pizza("pepperoni"));
    		za.order.add(za.pizza("pepperoni"));
    		
    	   // za.add("gold", goldTop, 4.50);
    	     za.add(new Pizza("gold", goldTop, 4.50));
//    	    for (Pizza pizzas:za.pizzas())
//    	    za.add(new Pizza(pizza.name(),pizza.tops(), pizza.price()));
int number = za.pizzas().size();
    	   pizza = new Pizza[4];
    	   for (int i =0; i < za.pizzas().size(); i++)
           System.out.println(pizza[i].name());
    	    
    	   	
    	
    	//	order.clear();
    		
    	
    			
    		
    		
    		
    		
//}
    }
    
    
}