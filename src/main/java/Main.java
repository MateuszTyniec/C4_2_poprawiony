/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("\nSwitch:");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyświetl studentow");
        System.out.println("3. wyjscie");
        System.out.print("Wybor: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
          case 1:
            System.out.print("imie studenta: ");
            String name = scanner.nextLine();
            System.out.print("wiek studenta: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            s.addStudent(new Student(name, age));

            break;
          case 2:
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("brak studentow");
            } else {
              System.out.println("\nstudenci: ");
              for (Student current : students) {
                System.out.println(current.ToString());
              }
            }
            break;
          case 3:
            System.exit(0);
          default:
            System.out.println("zly wybor");
        }
      }
    } catch (IOException e) {

    }
  }
}