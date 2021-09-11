import data.MedicalHistory;
import data.base.Vaccine;
import data.users.Client;
import data.users.HealthCareProfessional;
import data.vaccines.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class VaccineTracker {

    private static Scanner
            scanner = new Scanner(System.in);
    private static int selectedOption = 0;

    private static ArrayList<Client> clients = new ArrayList<>();

    public static void main(String[] args) {

        do {
            System.out.print("[1] On-site Registration \n" +
                    "[2] Search person \n" +
                    "[3] Reporting \n" +
                    "[4] Exit \n" +
                    "Please select an option: ");

            int selectedOption = scanner.nextInt();

            redirect(selectedOption);
        } while (selectedOption != 4);

    }

    private static void redirect(int option) {

        switch (option) {
            case 1: {
                proceedToRegistration();
                break;
            }
            case 2: {
                proceedToSearch();
                break;
            }
            case 3: {
                // proceedToReports();
                proceedToReportEnhanced();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
        }
    }

    private static void proceedToRegistration() {
        clearScreen();

        Client client = new Client();
        System.out.println("Enter First Name:");
        client.setFirstName(scanner.next());

        System.out.println("Enter Middle Name:");
        client.setMiddleName(scanner.next());

        System.out.println("Enter Last Name:");
        client.setLastName(scanner.next());

      /*  System.out.println("Enter BirthDate:");
        client.setBirthday(scanner.next());*/

        System.out.println("Enter Address:");
        client.setAddress(scanner.next());

        client.setMedicalHistory(fillMedicalHistory());
        client.setVaccine(selectVaccine());
        client.setAssistedBy(inputHealthCareProfessionalInfo());

        clearScreen();
        System.out.println("Account successfully created: " + client.toString() + "\nSecond dose schedule:" + client.computeAppointment(Calendar.getInstance().getTime()));
        clients.add(client);
    }

    private static void proceedToSearch() {

        System.out.println("Enter First name:");
        String firstName = scanner.next();

        System.out.println("Enter Last name:");
        String lastName = scanner.next();

        System.out.println("Enter Middle name:");
        String middleName = scanner.next();

        Client result = null;
        for (Client c : clients) {
            if (firstName.equalsIgnoreCase(c.getFirstName()) && lastName.equalsIgnoreCase(c.getLastName()) && middleName.equalsIgnoreCase(c.getMiddleName())) {
                result = c;
            }
        }
        clearScreen();

        if (result != null) {
            System.out.println("User Found: \n\n" + result.toString() + "\nSecond dose schedule:" + result.computeAppointment(Calendar.getInstance().getTime()));

        } else {
            System.out.println("User not found");
        }

    }

    private static void proceedToReports() {

        System.out.println("Do you want to save all input to file? [Y/N]");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("Y")) {
            try {
                for (Client client : clients) {
                    FileWriter out = new FileWriter("clients.txt");
                    out.write(client.toString() + "Second visit schedule: " + client.computeAppointment(Calendar.getInstance().getTime()));
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("All users are now saved to file.");
            }
        }


    }

    private static void proceedToReportEnhanced() {
        System.out.println("Do you want to save all input to file? [Y/N]");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("Y")) {
            try {

                for (Client client : clients) {
                    BufferedWriter out = new BufferedWriter(new FileWriter("bufferedText.txt"));
                    out.write(client.toString() + "Second visit schedule: " + client.computeAppointment(Calendar.getInstance().getTime()));
                    out.flush();
                    out.close();
                }

            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                System.out.println("All users are now saved to file.");
            }
        }

    }

    private static HealthCareProfessional inputHealthCareProfessionalInfo() {
        HealthCareProfessional professional = new HealthCareProfessional();
        professional.setFirstName("Juan");
        professional.setMiddleName("Luzviminda");
        professional.setLastName("Dela Cruz");
        professional.setAddress("123 ABC Street Maginhawa Quezon City MetroManila");
        professional.setLicenseNo("JLDC101");
        return professional;
    }

    private static MedicalHistory fillMedicalHistory() {
        MedicalHistory medicalHistory = new MedicalHistory();
        System.out.println("Do you have any known medical condition/s [Y/N] :");
        medicalHistory.setWithCommorbidies(scanner.next().equalsIgnoreCase("Y") ? true : false);

        System.out.println("Do you have allergies on medicinal allergies? [Y/N] :");
        medicalHistory.setWithMedicationAllergy(scanner.next().equalsIgnoreCase("Y") ? true : false);

        System.out.println("Do you have food allergies? [Y/N] :");
        medicalHistory.setWithMedicationAllergy(scanner.next().equalsIgnoreCase("Y") ? true : false);

        return medicalHistory;
    }

    private static Vaccine selectVaccine() {
        System.out.println("Please select preferred vaccine: \n" +
                "[1] - Pfizer\n" +
                "[2] - Moderna\n" +
                "[3] - Astrazeneca\n" +
                "[4] - Johnson and Johnson\n"+
                "[5] - Sinovac\n");

        int preferredVaccine = scanner.nextInt();

        switch (preferredVaccine) {

            case 1: {
                Pfizer prizer = new Pfizer();
                prizer.setBatchNo("P101");
                return prizer;
            }
            case 2: {
                Moderna moderna = new Moderna();
                moderna.setBatchNo("M101");
                return moderna;
            }
            case 3: {
                AstraZeneca astraZeneca = new AstraZeneca();
                astraZeneca.setBatchNo("A101");
                return astraZeneca;
            }
            case 4: {
                Jansen jansen = new Jansen();
                jansen.setBatchNo("J101");
                return jansen;
            }
            case 5: {
                Sinovac sinovac = new Sinovac();
                sinovac.setBatchNo("S101");
                return sinovac;
            }

            default: {
                return null;
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}
