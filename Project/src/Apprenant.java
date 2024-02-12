import java.util.Scanner;

public class Apprenant {
    public static void gererApprenants() {
        boolean retourMenu = false;
        ApprenantDetails apprenantDetails = new ApprenantDetails();
        Scanner scanner = new Scanner(System.in);

        while (!retourMenu) {
            System.out.println("Menu :");
            System.out.println("1- Ajouter un nouvel apprenant.");
            System.out.println("2- Consulter la liste des apprenants.");
            System.out.println("3- Modifier les informations.");
            System.out.println("4- Supprimer un apprenant.");
            System.out.println("5- Rechercher un apprenant.");
            System.out.println("6- Retour au menu principal");
            System.out.print("votre choix : ");
            int apprenantschoix = scanner.nextInt();
            scanner.nextLine();

            switch (apprenantschoix) {
                case 1:
                    ajouter(apprenantDetails, scanner);
                    break;
                case 2:
                    afficherListeApprenants(apprenantDetails);
                    break;
                case 3:
                    ModifierApprenant.modifierApprenant(apprenantDetails, scanner);
                    break;
                case 4:
                    SupprimerApprenant.supprimerApprenant(apprenantDetails, scanner);
                    break;
                case 5:
                    RechercherApprenant.rechercherApprenant(apprenantDetails, scanner);
                    break;
                case 6:
                    retourMenu = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    public static void ajouter(ApprenantDetails apprenantDetails, Scanner scanner) {
        if (apprenantDetails.n < ApprenantDetails.MAX_APPRENANT) {
            System.out.print("Nom : ");
            apprenantDetails.setNom(apprenantDetails.n, scanner.nextLine());
            System.out.print("Prénom : ");
            apprenantDetails.setPrenom(apprenantDetails.n, scanner.nextLine());
            System.out.print("Date de naissance : ");
            apprenantDetails.setDateNaissance(apprenantDetails.n, scanner.nextInt());
            scanner.nextLine();
            System.out.print("Adresse : ");
            apprenantDetails.setAdresse(apprenantDetails.n, scanner.nextLine());
            System.out.print("Contact : ");
            apprenantDetails.setContact(apprenantDetails.n, scanner.nextInt());
            System.out.print("Numéro de classe : ");
            apprenantDetails.numeroClasse[apprenantDetails.n] = scanner.nextInt();
            scanner.nextLine();
            apprenantDetails.n++;
        } else {
            System.out.println("Max apprenant limit 10 : Si vous en voulez plus, payez 100 dirhams pour 10 places.");
        }
    }

    public static void afficherListeApprenants(ApprenantDetails apprenantDetails) {
        System.out.println("Liste des apprenants :");
        for (int i = 0; i < apprenantDetails.n; i++) {
            System.out.println("Numéro de d'identifiant :" + (i + 1));
            System.out.print("\t Nom : " + apprenantDetails.getNom(i));
            System.out.print("\t Prénom : " + apprenantDetails.getPrenom(i));
            System.out.print("\t Date de naissance : " + apprenantDetails.getDateNaissance(i));
            System.out.print("\t Adresse : " + apprenantDetails.getAdresse(i));
            System.out.print("\t Contact : " + apprenantDetails.getContact(i));
            System.out.println("\t Numéro de classe : " + apprenantDetails.numeroClasse[i]);
            System.out.println("---------------------");
        }
    }
}
class ApprenantDetails {
    private String[] nom;
    private String[] prenom;
    private int[] dateNaissance;
    private String[] adresse;
    private int[] contact;
    public int[] numeroClasse;
    public int n;
    static final int MAX_APPRENANT = 10;

    public ApprenantDetails() {
        nom = new String[MAX_APPRENANT];
        prenom = new String[MAX_APPRENANT];
        dateNaissance = new int[MAX_APPRENANT];
        adresse = new String[MAX_APPRENANT];
        contact = new int[MAX_APPRENANT];
        numeroClasse = new int[MAX_APPRENANT];
        n = 0;
    }

    public String getNom(int index) {
        return nom[index];
    }

    public void setNom(int index, String newNom) {
        this.nom[index] = newNom;
    }

    public String getPrenom(int index) {
        return prenom[index];
    }

    public void setPrenom(int index, String newPrenom) {
        this.prenom[index] = newPrenom;
    }

    public int getDateNaissance(int index) {
        return dateNaissance[index];
    }

    public void setDateNaissance(int index, int newDateNaissance) {
        this.dateNaissance[index] = newDateNaissance;
    }

    public String getAdresse(int index) {
        return adresse[index];
    }

    public void setAdresse(int index, String newAdresse) {
        this.adresse[index] = newAdresse;
    }

    public int getContact(int index) {
        return contact[index];
    }

    public void setContact(int index, int newContact) {
        this.contact[index] = newContact;
    }
}

class ModifierApprenant {
    public static void modifierApprenant(ApprenantDetails apprenantDetails, Scanner scanner) {
        Apprenant.afficherListeApprenants(apprenantDetails);

        System.out.print("Saisissez l'index de l'apprenant que vous souhaitez modifier: ");
        int choixMod = scanner.nextInt();
        int choixModification = choixMod - 1;
        System.out.println("Sélectionnez le champ que vous souhaitez modifier: ");
        System.out.println("1. Nom \t 2. Prénom \t 3. Date de naissance \t 4. Adresse \t 5. Contact \t 6. Numéro de classe ");
        int modification = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Saisissez la nouvelle : ");
        String newValue = scanner.nextLine();
        switch (modification) {
            case 1:
                apprenantDetails.setNom(choixModification, newValue);
                break;
            case 2:
                apprenantDetails.setPrenom(choixModification, newValue);
                break;
            case 3:
                apprenantDetails.setDateNaissance(choixModification, Integer.parseInt(newValue));
                break;
            case 4:
                apprenantDetails.setAdresse(choixModification, newValue);
                break;
            case 5:
                apprenantDetails.setContact(choixModification, Integer.parseInt(newValue));
                break;
            case 6:
                apprenantDetails.numeroClasse[choixModification] = Integer.parseInt(newValue);
                break;
            default:
                System.out.println("invalide");
        }
    }
}
class SupprimerApprenant {
    public static void supprimerApprenant(ApprenantDetails apprenantDetails, Scanner scanner) {
        Apprenant.afficherListeApprenants(apprenantDetails);

        System.out.print("Saisissez l'index que vous souhaitez Supprimer: ");
        int choixSupprimer = scanner.nextInt();
        int choixSup = choixSupprimer - 1;
        if (choixSup>=0 && choixSup<apprenantDetails.n){
            for(int i=choixSup;i<apprenantDetails.n-1;i++){
                apprenantDetails.setNom(i, apprenantDetails.getNom(i + 1));
                apprenantDetails.setPrenom(i, apprenantDetails.getPrenom(i + 1));
                apprenantDetails.setDateNaissance(i, apprenantDetails.getDateNaissance(i + 1));
                apprenantDetails.setAdresse(i, apprenantDetails.getAdresse(i + 1));
                apprenantDetails.setContact(i, apprenantDetails.getContact(i + 1));
                apprenantDetails.numeroClasse[i] = apprenantDetails.numeroClasse[i + 1];
            } System.out.println("Supprimer avec succes");
            apprenantDetails.n--;
        }else System.out.println("La tache n'existe pas \n");

        }
    }

class RechercherApprenant {
    public static void rechercherApprenant(ApprenantDetails apprenantDetails, Scanner scanner) {
        System.out.println("nombre des apprenant: " + apprenantDetails.n);
        System.out.println("Entrez la méthode de recherche : ");
        System.out.println("1. Nom et Prénom \t 2. Numéro de d'identifiant ");
        int methode = scanner.nextInt();
        scanner.nextLine();
        switch (methode) {
            case 1:
                System.out.print("Entrez Nom : ");
                String rechnom = scanner.next();
                System.out.print("Entrez prénom : ");
                String rechprénom = scanner.next();
                for (int i = 0; i < apprenantDetails.n; i++) {
                    if (apprenantDetails.getNom(i).equals(rechnom) && apprenantDetails.getPrenom(i).equals(rechprénom)) {
                        System.out.print("\t Nom : " + apprenantDetails.getNom(i));
                        System.out.print("\t Prénom : " + apprenantDetails.getPrenom(i));
                        System.out.print("\t Date de naissance : " + apprenantDetails.getDateNaissance(i));
                        System.out.print("\t Adresse : " + apprenantDetails.getAdresse(i));
                        System.out.print("\t Contact : " + apprenantDetails.getContact(i));
                        System.out.println("\t Numéro de classe : " + apprenantDetails.numeroClasse[i]);
                        System.out.println("---------------------");
                    } else {
                        System.out.println("Aucun apprenant ne possède cette information");
                    }
                }
                break;
            case 2:
                System.out.println("Entrez Numéro de d'identifiant : ");
                String id = scanner.next();
                int ID = Integer.parseInt(id) - 1;
                if (ID >= 0 && ID < apprenantDetails.n) {
                    System.out.print("\t Nom : " + apprenantDetails.getNom(ID));
                    System.out.print("\t Prénom : " + apprenantDetails.getPrenom(ID));
                    System.out.print("\t Date de naissance : " + apprenantDetails.getDateNaissance(ID));
                    System.out.print("\t Adresse : " + apprenantDetails.getAdresse(ID));
                    System.out.print("\t Contact : " + apprenantDetails.getContact(ID));
                    System.out.println("\t Numéro de classe : " + apprenantDetails.numeroClasse[ID]);
                    System.out.println("---------------------");
                } else {
                    System.out.println("Aucun apprenant ne possède cette information");
                }
                break;
            default:
                System.out.println("Choix invalide");


        }
    }
}