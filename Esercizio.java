// LEGGERE LE ISTRUZIONI NEL FILE README.md

// Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    static class CalcoloPeso {
        public static void calcolaPesoIdeale() {
            Scanner input = new Scanner(System.in);
            System.out.print("Inserisci sesso (M/F): ");
            String genere = input.nextLine().toUpperCase();
            System.out.print("Inserisci altezza in cm: ");
            int altezzaCm = input.nextInt();
            System.out.print("Inserisci età: ");
            int anni = input.nextInt();

            int pesoStimato = altezzaCm - 100;
            if (genere.equals("F")) {
                pesoStimato -= pesoStimato * 15 / 100;
            }

            System.out.println("Peso ideale stimato (Broca): " + pesoStimato + " kg");
        }
    }

    static class GestioneCalorie {
        private double fabbisognoCalorico = 0;
        private double calorieConsumate = 0;

        public void calcolaFabbisogno() {
            Scanner input = new Scanner(System.in);
            System.out.print("Inserisci sesso (M/F): ");
            String genere = input.nextLine().toUpperCase();
            System.out.print("Inserisci età: ");
            int eta = input.nextInt();
            System.out.print("Inserisci peso (kg): ");
            double pesoKg = input.nextDouble();
            System.out.print("Inserisci altezza (cm): ");
            int altezza = input.nextInt();
            System.out.print("Livello attività (1-bassa, 2-media, 3-alta): ");
            int livelloAttivita = input.nextInt();

            double energia;
            if (genere.equals("M")) {
                energia = 10 * pesoKg + 6.25 * altezza - 5 * eta + 5;
            } else {
                energia = 10 * pesoKg + 6.25 * altezza - 5 * eta - 161;
            }

            double moltiplicatore = 1.2;
            if (livelloAttivita == 2) moltiplicatore = 1.55;
            if (livelloAttivita == 3) moltiplicatore = 1.9;

            fabbisognoCalorico = energia * moltiplicatore;
            System.out.println("Fabbisogno calorico giornaliero: " + fabbisognoCalorico + " kcal");
        }

        public void aggiungiAlimento() {
            Scanner input = new Scanner(System.in);
            System.out.print("Nome alimento consumato: ");
            String alimento = input.nextLine();
            System.out.print("Calorie per 100g: ");
            double caloriePer100g = input.nextDouble();
            System.out.print("Quantità consumata (g): ");
            double quantitaGrammi = input.nextDouble();

            double calorieCalcolate = caloriePer100g * quantitaGrammi / 100;
            calorieConsumate += calorieCalcolate;

            System.out.println("Calorie aggiunte: " + calorieCalcolate + " kcal");
        }

        public void mostraTotale() {
            System.out.println("Calorie totali consumate oggi: " + calorieConsumate + " kcal");
            if (fabbisognoCalorico > 0) {
                if (calorieConsumate > fabbisognoCalorico) {
                    System.out.println("Attenzione: superato il fabbisogno calorico.");
                } else if (calorieConsumate < fabbisognoCalorico * 0.75) {
                    System.out.println("Attenzione: assunzione calorica insufficiente.");
                } else {
                    System.out.println("Assunzione calorica adeguata.");
                }
            } else {
                System.out.println("Prima calcola il fabbisogno calorico.");
            }
        }

        public void resetGiornata() {
            calorieConsumate = 0;
            System.out.println("Dati giornalieri azzerati.");
        }
    }

    public static class SaluteCalorie {
        public static void main(String[] args) {
            GestioneCalorie gestione = new GestioneCalorie();
            boolean continua = true;

            while (continua) {
                System.out.println("\nMENU:");
                System.out.println("1. Calcola peso ideale");
                System.out.println("2. Calcola fabbisogno calorico");
                System.out.println("3. Aggiungi alimento consumato");
                System.out.println("4. Mostra calorie totali");
                System.out.println("5. Reset dati giornata");
                System.out.println("6. Esci");
                System.out.print("Scegli opzione: ");
                int scelta = new Scanner(System.in).nextInt();

                switch (scelta) {
                    case 1:
                        CalcoloPeso.calcolaPesoIdeale();
                        break;
                    case 2:
                        gestione.calcolaFabbisogno();
                        break;
                    case 3:
                        gestione.aggiungiAlimento();
                        break;
                    case 4:
                        gestione.mostraTotale();
                        break;
                    case 5:
                        gestione.resetGiornata();
                        break;
                    case 6:
                        continua = false;
                        System.out.println("Programma terminato.");
                        break;
                    default:
                        System.out.println("Opzione non valida.");
                }
            }
        }
    }
}
