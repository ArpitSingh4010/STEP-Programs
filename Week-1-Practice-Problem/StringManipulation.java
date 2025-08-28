public class StringManipulation{
public static void main(String[] args) {
String str1=new String("Java Programming");
String str="Java Programming";
char[] str2 = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r',
'a', 'm', 'm', 'i', 'n', 'g'};
System.out.println(str1);
System.out.println(str);
for(int i=0;i<str2.length;i++){
System.out.print(str2[i]);
}
System.out.println();
System.out.println(str1 == str);
System.out.println(str1.equals(str));
}
}