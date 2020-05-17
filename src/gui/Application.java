package gui;

/**
 *
 * Klasa - svrha ???
 *
 *
 *
 * @author emir
 */
public class Application {

    public static void main(String[] args) {

        System.out.println("Lenght =  " + args.length);
        System.out.println(args[0] + args[1]);
        Person personObject1 = new Person("Mirza");
        Person.printNumberOfPersons();//Broj persona = counter -> Broj persona = 1
        personObject1.printPerson();//Ja sam name -> Ja sam Mirza
        Person personObject2 = new Person("Emir");
        Person.printNumberOfPersons();// -> Broj persona = 2
        personObject2.printPerson();//-> Ja sam Emir
        Person.printNumberOfPersons();// -> Broj persona = 2

        //Primitivni ili prosti tipovi:  byte, short, int, long, float, double, char, boolean
        int number = 23;
        number = 34;
        //Složeni ili objektni
        int[] numbers = new int[3];
        numbers[0] = 23;
        numbers[1] = 24;
        //numbers[2] = "Bakir";
        //još bolji slozeni
        Person p = new Person("Bakir");
        p.setAge(23);
    }
}
