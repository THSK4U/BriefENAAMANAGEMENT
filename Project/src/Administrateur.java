import java.util.Scanner;
public class Administrateur {
    public static void AdminItrateur() {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("Hello admin.");
            System.out.println("Menu principal :");
            System.out.println("1- Gérer les apprenants");
            System.out.println("2- Gérer les classes de l'école");
            System.out.print("votre choix : ");
            int premierchoix = scanner.nextInt();
            scanner.nextLine();

            switch (premierchoix) {
                case 1:
                Apprenant.gererApprenants();
                    break;
                case 2:
                    classes.gererClasses();
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
        scanner.close();
    }}
