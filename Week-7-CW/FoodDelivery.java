class Restaurant {
protected String name;
Restaurant(String name) {
this.name = name;
}
// TODO: Create 'prepareFood()' method that prints "[name] is preparing generic food"
void prepareFood() {
// ... (implementation)
System.out.println(name+" is preparing generic food");
}
// TODO: Create 'estimateTime()' method that prints "Estimated time: 30 minutes"
void estimateTime() {
// ... (implementation)
System.out.println("Estimated time: 30 minutes");
}
}
class PizzaPlace extends Restaurant {
PizzaPlace(String name) {
super(name);
}
// TODO: Override 'prepareFood()' to print " [name] is making delicious pizza with fresh toppings!"
@Override
public void prepareFood() {
// ... (implementation)
System.out.println(name+" is making delicious pizza with fresh toppings!");
}
// TODO: Override 'estimateTime()' to print "Pizza ready in 20 minutes! "
@Override
public void estimateTime() {
// ... (implementation)
System.out.println("Pizza ready in 20 minutes!");
}
}
class SushiBar extends Restaurant {
SushiBar(String name) {
super(name);
}
// TODO: Override 'prepareFood()' to print "[name] is crafting fresh sushi with precision!"
@Override
public void prepareFood() {
// ... (implementation)
System.out.println(name+" is crafting fresh sushi with precision!");
}



// TODO: Override 'estimateTime()' to print "Sushi will be ready in 25 minutes! "
@Override
 void estimateTime() {
// ... (implementation)
System.out.println("Sushi will be ready in 25 minutes!");
}
}
public class FoodDelivery {
public static void main(String[] args) {
// TODO: Dynamic Food Ordering System:
// 1. Create a Restaurant reference variable
// 2. Assign new PizzaPlace("Mario's Pizza") to it
// 3. Call prepareFood() and estimateTime() - observe Pizza methods execute
// 4. Reassign to new SushiBar("Tokyo Sushi")
// 5. Call same methods again - observe Sushi methods execute
// 6. Explain how JVM knows which method to call at runtime!
Restaurant restaurant = new Restaurant("Generic Restaurant");
restaurant.prepareFood();
restaurant.estimateTime();
Restaurant restaurant1 = new PizzaPlace("Mario's Pizza");
restaurant1.prepareFood();
restaurant1.estimateTime();
restaurant1 = new SushiBar("Tokyo Sushi");
restaurant1.prepareFood();
restaurant1.estimateTime();

}
}

