public class Q4 {
public static void main(String[] args) {
// TODO: Implement performance tests for different approaches
// Test 1: String concatenation performance
System.out.println("=== PERFORMANCE COMPARISON ===");
// TODO: Test string concatenation with regular String (slowmethod)

long startTime = System.nanoTime();
String result1 = concatenateWithString(1000);
long endTime = System.nanoTime();
System.out.println("String concatenation time: " + (endTime -startTime) + " ns");
// TODO: Test string concatenation with StringBuilder (fast method)
startTime = System.nanoTime();
String result2 = concatenateWithStringBuilder(1000);
endTime = System.nanoTime();
System.out.println("StringBuilder concatenation time: " + (endTime -startTime) + " ns");
// TODO: Test string concatenation with StringBuffer (thread-safemethod)
startTime = System.nanoTime();
String result3 = concatenateWithStringBuffer(1000);
endTime = System.nanoTime();
System.out.println("StringBuffer concatenation time: " + (endTime -startTime) + " ns");

// TODO: Compare memory usage (approximate)
System.out.println("=== MEMORY USAGE COMPARISON ===");
System.out.println("String memory usage: " + (result1.length() * 2) + " bytes");
System.out.println("StringBuilder memory usage: " + (result2.length() * 2) + " bytes");
System.out.println("StringBuffer memory usage: " + (result3.length() * 2) + " bytes");  

// TODO: Demonstrate thread safety differences
demonstrateThreadSafety();

// TODO: Create practical examples showing when to use each approach
System.out.println("=== PRACTICAL EXAMPLES ===");
demonstrateStringBuilderMethods();

}
// TODO: Method using String concatenation (inefficient)
public static String concatenateWithString(int iterations) {
String result = "";
for (int i = 0; i < iterations; i++) {
result += "Java " + i + " ";
}

return result;
}


// TODO: Method using StringBuilder (efficient, not thread-safe)
public static String concatenateWithStringBuilder(int iterations) {
StringBuilder sb = new StringBuilder();
for (int i = 0; i < iterations; i++) {
sb.append("Java ").append(i).append(" ");
}
return sb.toString();
}
// Your code here

// TODO: Method using StringBuffer (efficient, thread-safe)
public static String concatenateWithStringBuffer(int iterations) {
StringBuffer sb = new StringBuffer();
for (int i = 0; i < iterations; i++) {  
sb.append("Java ").append(i).append(" ");
}
return sb.toString();
// Your code here
}
// TODO: Method to demonstrate StringBuilder methods
public static void demonstrateStringBuilderMethods() {
StringBuilder sb = new StringBuilder("Hello World");
// TODO: Use the following StringBuilder methods:
// 1. append() - Add text to end
sb.append(" - Java Programming");
System.out.println("After append: " + sb.toString());
// 2. insert() - Insert text at specific position
sb.insert(6, "Beautiful ");
System.out.println("After insert: " + sb.toString());
// 3. delete() - Remove characters from range
sb.delete(6, 16);
System.out.println("After delete: " + sb.toString());
// 4. deleteCharAt() - Remove character at index
sb.deleteCharAt(5);
System.out.println("After deleteCharAt: " + sb.toString());
// 5. reverse() - Reverse the string
sb.reverse();
System.out.println("After reverse: " + sb.toString());
// 6. replace() - Replace substring
sb.replace(0, 5, "Hi");
System.out.println("After replace: " + sb.toString());

// 7. setCharAt() - Change character at index
sb.setCharAt(0, 'H');
System.out.println("After setCharAt: " + sb.toString());
// 8. capacity() - Show current capacity
System.out.println("Current capacity: " + sb.capacity());
// 9. ensureCapacity() - Set minimum capacity
sb.ensureCapacity(100);
System.out.println("After ensureCapacity: " + sb.capacity());
// 10. trimToSize() - Reduce capacity to current length
sb.trimToSize();
System.out.println("After trimToSize: " + sb.capacity());
// Your code here
}
// TODO: Method to demonstrate StringBuffer thread safety
public static void demonstrateThreadSafety() {
// Create multiple threads that modify the same StringBuffer
StringBuffer sb = new StringBuffer("Thread-Safe Example");
Runnable task = () -> {
    for (int i = 0; i < 5; i++) {
        sb.append(" Thread ").append(Thread.currentThread().getName());
        try {
            Thread.sleep(100); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
};
// Show that StringBuffer is thread-safe while StringBuilder is not
Thread thread1 = new Thread(task, "A");
Thread thread2 = new Thread(task, "B");
thread1.start();
thread2.start();
try {
    thread1.join();
    thread2.join();
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
System.out.println("Final StringBuffer: " + sb.toString());
// Your code here
}
// TODO: Method to compare string comparison methods



public static void compareStringComparisonMethods() {
String str1 = "Hello";
String str2 = "Hello";
String str3 = new String("Hello");
// TODO: Compare using:
// 1. == operator (reference comparison)
System.out.println("Using == operator: " + (str1 == str2)); // true, same reference
System.out.println("Using == operator: " + (str1 == str3)); // false, different reference

// 2. equals() method (content comparison)
System.out.println("Using equals(): " + str1.equals(str2)); // true, same content
System.out.println("Using equals(): " + str1.equals(str3)); // true, same

// 3. equalsIgnoreCase() method
System.out.println("Using equalsIgnoreCase(): " + str1.equalsIgnoreCase(str2)); // true, same content
System.out.println("Using equalsIgnoreCase(): " + str1.equalsIgnoreCase("hello"));
// 4. compareTo() method (lexicographic comparison)
System.out.println("Using compareTo(): " + str1.compareTo(str2)); // 0, same content
System.out.println("Using compareTo(): " + str1.compareTo("Hello!")); //
// 5. compareToIgnoreCase() method
System.out.println("Using compareToIgnoreCase(): " + str1.compareToIgnoreCase("hello")); // 0, same content
System.out.println("Using compareToIgnoreCase(): " + str1.compareToIgnoreCase("Hello!")); // negative, "Hello" < "Hello!"
// TODO: Explain the differences and when to use each
System.out.println("=== STRING COMPARISON METHODS ===");
System.out.println("== operator: Checks reference equality, not content.");
System.out.println("equals(): Checks content equality, not reference.");
System.out.println("equalsIgnoreCase(): Case-insensitive content comparison.");
// Your code here
}
// TODO: Method to demonstrate memory efficiency
public static void demonstrateMemoryEfficiency() {
// TODO: Show memory usage before and after different stringoperations
String str1 = "Java";
String str2 = "Java";
String str3 = new String("Java");   
System.out.println("Memory usage with string literals:");
System.out.println("str1 and str2 point to the same memory location: " + (str1 == str2)); // true
System.out.println("str3 is a new object in memory: " + (str1 == str3)); // false
System.out.println("Memory usage with string literals: " + (str1.length() * 2) + " bytes");
System.out.println("Memory usage with new String: " + (str3.length() * 2) + " bytes");
// TODO: Demonstrate string pool behavior
System.out.println("=== STRING POOL BEHAVIOR ===");
System.out.println("String literals are stored in the string pool, " + "which allows for memory efficiency and reuse.");    

// TODO: Show StringBuilder capacity management
System.out.println("=== STRINGBUILDER CAPACITY MANAGEMENT ===");
StringBuilder sb = new StringBuilder("Hello");
System.out.println("Initial capacity: " + sb.capacity());
sb.append(" World");
System.out.println("After append: " + sb.capacity());
sb.ensureCapacity(100);
System.out.println("After ensureCapacity(100): " + sb.capacity());
System.out.println("StringBuilder grows dynamically, " + "but can be preallocated for efficiency.");

// Your code here
}
}