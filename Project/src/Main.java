import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("user : Administrateur");
        System.out.print("password : ");
        Scanner c =new Scanner(System.in);
        String password = c.next();
        if (password.equals("admin")) {
            System.out.println("Password correct!");
            Administrateur.AdminItrateur();
        }else {
            System.out.println("Password incorrect!");
    }}}