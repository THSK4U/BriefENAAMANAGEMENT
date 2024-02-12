import java.util.Scanner;

public class classes {
    public static void gererClasses() {
        boolean retourMenu = false;
        ClassesDetails classesDetails = new ClassesDetails();
        Scanner scanner = new Scanner(System.in);

        while (!retourMenu) {
            System.out.println("Menu :");
            System.out.println("1- Ajouter une nouvelle classe.");
            System.out.println("2- Afficher la liste des classes.");
            System.out.println("3- Modifier une classe existante");
            System.out.println("4- Supprimer une classe existante.");
            System.out.println("5- Filtrer les apprenants par classe.");
            System.out.println("6- Retour au menu principal");
            System.out.print("votre choix : ");
            int classesChoix = scanner.nextInt();
            scanner.nextLine();

            switch (classesChoix) {
                case 1:
                    ajouterClasse(classesDetails, scanner);
                    break;
                case 2:
                    afficherListeClasses(classesDetails);
                    break;
                case 3:
                    ModifierClasse.modifierClasse(classesDetails, scanner);
                    break;
                case 4:
                    SupprimerClasse.supprimerClasse(classesDetails, scanner);
                    break;
                case 5:
                    FiltrerApprenantsParClasse.filtrerApprenantsParClasse(classesDetails, scanner);
                    break;
                case 6:
                    retourMenu = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    public static void ajouterClasse(ClassesDetails classesDetails, Scanner scanner) {
        if (classesDetails.n < ClassesDetails.MAX_APPRENANT) {
            System.out.print("Numero de classe : ");
            classesDetails.numeroClasse[classesDetails.n] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nom : ");
            classesDetails.setNom(classesDetails.n, scanner.nextLine());
            System.out.print("Effectif : ");
            classesDetails.setEffectif(classesDetails.n, scanner.nextLine());
            classesDetails.n++;
        } else {
            System.out.println("Limite maximale de classes atteinte : Si vous en voulez plus, contactez l'administrateur.");
        }
    }

    public static void afficherListeClasses(ClassesDetails classesDetails) {
        System.out.println("Liste des classes :");
        for (int i = 0; i < classesDetails.n; i++) {
            System.out.println("Numero de classe :" + classesDetails.numeroClasse[i]);
            System.out.print("\t Nom : " + classesDetails.getNom(i));
            System.out.print("\t Effectif : " + classesDetails.getEffectif(i));
            System.out.println("---------------------");
        }
    }
}

class ClassesDetails {
    private String[] nom;
    private String[] effectif;
    public int[] numeroClasse;
    public int n;
    static final int MAX_APPRENANT = 10;

    public ClassesDetails() {
        nom = new String[MAX_APPRENANT];
        effectif = new String[MAX_APPRENANT];
        numeroClasse = new int[MAX_APPRENANT];
        n = 0;
    }

    public String getNom(int index) {
        return nom[index];
    }

    public void setNom(int index, String newNom) {
        this.nom[index] = newNom;
    }

    public String getEffectif(int index) {
        return effectif[index];
    }

    public void setEffectif(int index, String newEffectif) {
        this.effectif[index] = newEffectif;
    }
}

class ModifierClasse {
    public static void modifierClasse(ClassesDetails classesDetails, Scanner scanner) {
        classes.afficherListeClasses(classesDetails);

        System.out.print("Saisissez l'index de la classe que vous souhaitez modifier: ");
        int choixModi = scanner.nextInt();
        int choixModifiCation = choixModi - 1;
        System.out.println("Sélectionnez le champ que vous souhaitez modifier: ");
        System.out.println("1. Nom \t 2. Effectif \t 3. Numero de classe");
        int modification = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Saisissez la nouvelle valeur : ");
        String newValue = scanner.nextLine();
        switch (modification) {
            case 1:
                classesDetails.setNom(choixModifiCation, newValue);
                break;
            case 2:
                classesDetails.setEffectif(choixModifiCation, newValue);
                break;
            case 3:
                classesDetails.setEffectif(choixModifiCation, newValue);
                break;
            default:
                System.out.println("Invalide");
        }
    }
}

class SupprimerClasse {
    public static void supprimerClasse(ClassesDetails classesDetails, Scanner scanner) {
        classes.afficherListeClasses(classesDetails);

        System.out.print("Saisissez l'index que vous souhaitez Supprimer: ");
        int choixSupprimer = scanner.nextInt();
        int choixSup = choixSupprimer - 1;
        if (choixSup >= 0 && choixSup < classesDetails.n) {
            for (int i = choixSup; i < classesDetails.n - 1; i++) {
                classesDetails.setNom(i, classesDetails.getNom(i + 1));
                classesDetails.setEffectif(i, classesDetails.getEffectif(i + 1));
                classesDetails.numeroClasse[i] = classesDetails.numeroClasse[i + 1];
            }
            System.out.println("Supprimer avec succès");
            classesDetails.n--;
        } else {
            System.out.println("La classe n'existe pas \n");
        }
    }
}

class FiltrerApprenantsParClasse {
    public static void filtrerApprenantsParClasse(ClassesDetails classesDetails, Scanner scanner) {
    }
}
