package gui;

/**
 * 1. polja ili properties ili fields 1.1 objektno 1.2 static
 * <li>
 * 2. konstruktor -> svrha klase : kreiranje objekta ... konstruktor
 * <li>
 * 3. metode ili funkcije 3.1 3.2
 * <li>
 * 4. ugniježdene klase
 *
 * @author emir
 */
public class Person {

    public static int counter = 0;
    private String name;
    private String surname;
    private int age;

    public Person() {
        super();
        counter++;
    }

    public Person(String name) {
        super();
        counter++;
    }

    
    //modifikator_vidljivosti  povratni_tip ime_funkcije()  return
    public int getAge() {
        return age;
    }

    //metoda
    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //objektna - nestatička
    public void printPerson() {
        System.out.println("Ja sam  " + name);

    }

    public static void printNumberOfPersons() {
        System.out.println("Broj persona = " + counter);
    }

}
