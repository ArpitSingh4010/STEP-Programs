public class GameBattle {
// TODO: Create an 'attack' method that takes damage (int) and prints "Basic attack for [damage] points!"
int damage;
String weapon;
boolean isCritical;

public void attack(int damage) {
// ... (implementation)
System.out.println("Basic attack for "+damage+" points!");
}
// TODO: Overload 'attack' method to take damage and weapon name
// Print "Attacking with [weapon] for [damage] points!"
public void attack(int damage, String weapon) {
// ... (implementation)
System.out.println("Attacking with "+weapon+" for "+damage+" points!");
}
// TODO: Overload 'attack' method for critical hits (damage, weapon, isCritical)
// If critical: "CRITICAL HIT! [weapon] deals [damage*2] points!"
// Else: use the previous overloaded method
public void attack(int damage, String weapon, boolean isCritical)
{
// ... (implementation)
if (isCritical) {
System.out.println("CRITICAL HIT! "+weapon+" deals "+damage*2+" points!");
}
else {
attack(damage, weapon);
}

}
// TODO: Overload 'attack' for team attacks (damage, String[]teammates)
// Print "Team attack with [teammate names] for [damage * teamsize] total damage!"
public void attack(int damage, String[] teammates) {
System.out.print("Team attack with ");
for (int i = 0; i < teammates.length; i++) {
System.out.print(teammates[i]);
if (i < teammates.length - 1) {
System.out.print(", ");
}
}
System.out.println(" for "+damage*teammates.length+" total damage!");


// ... (implementation)
}
public static void main(String[] args) {
// TODO: Gaming Battle Simulation:
// 1. Create a GameBattle object
// 2. Test all overloaded attack methods:
// - Basic attack with 50 damage
// - Sword attack with 75 damage
// - Critical bow attack with 60 damage
// - Team attack with {"Alice", "Bob"} for 40 base damage
// 3. Observe how the compiler chooses the correct methodbased on parameters
GameBattle game = new GameBattle();
game.attack(50);
game.attack(75, "sword");
game.attack(60, "bow", true);
game.attack(40, new String[]{"Arpit", "Ayush"});
}
}