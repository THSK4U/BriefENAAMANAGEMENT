import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Menu :");
        System.out.println("1- َAdministrateur");
        System.out.println("2- Apprenant");
        System.out.print("votre choix : ");
            Scanner c =new Scanner(System.in);

            int premierchoix = c.nextInt();
switch (premierchoix){
    case 1:
        Administrateur.AdminItrateur();
        break;
    case 2:
        System.out.println("test2");
        break;
    default:
        System.out.println("test default");
}
    }}