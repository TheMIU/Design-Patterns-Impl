package O1_creational_design_patterns.singleton;

// usage
class SingletonTest {
    public static void main(String[] args) {
        SingletonObject instance1 = SingletonObject.getInstance();
        SingletonObject instance2 = SingletonObject.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }
}

//////////////////////////////////////////////////
/*
    Creational Design Patterns 
    >> Singleton
    * Class එකෙන් හැදෙන්නෙ එක instance එකයි.

    Key Components
    ==============
    1. private static instance
    2. private constructor
    3. public static method to get instance
*/

class SingletonObject {
    // private static instance
    private static SingletonObject instance;

    // private constructor
    private SingletonObject() {
        System.out.println("Object created");
    }

    // public static method to get instance
    public static SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObject();
        }
        return instance;
    }
}