class LibraryUser {
    String name;
    LibraryUser(String name) {
        this.name = name;
    }
    void accessLibrary() {
        System.out.println(name + " is accessing the library.");
    }
}

class Student extends LibraryUser {
    Student(String name) {
        super(name);
    }
    void accessLibrary() {
        System.out.println(name + " borrows books and uses library computers.");
    }
}

class Faculty extends LibraryUser {
    Faculty(String name) {
        super(name);
    }
    void accessLibrary() {
        System.out.println(name + " reserves books and accesses research databases.");
    }
}

class Guest extends LibraryUser {
    Guest(String name) {
        super(name);
    }
    void accessLibrary() {
        System.out.println(name + " can only browse books.");
    }
}

public class UniversityLibrary {
    public static void main(String[] args) {
        LibraryUser u1 = new Student("Arpit");
        LibraryUser u2 = new Faculty("Dr. Sharma");
        LibraryUser u3 = new Guest("Visitor");

        LibraryUser[] users = {u1, u2, u3};
        for(LibraryUser user : users) {
            user.accessLibrary();
        }
    }
}
