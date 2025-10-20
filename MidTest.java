import java.util.Scanner;

interface Gradable {
    void calculateFinalScore();
    void determineGrade();
    double getFinalScore();
    String getLetterGrade();
    String getStatus();
}

class Subject implements Gradable {
    private String name;
    private double uts, uas, tugas;
    private double finalScore;
    private String letterGrade;
    private String status;

    public Subject(String name) {
        this.name = name;
    }

    public void inputData(Scanner input) {
        System.out.println("---- Mata Kuliah: " + name + " ----");
        System.out.print("Nilai UTS: ");
        uts = input.nextDouble();
        System.out.print("Nilai UAS: ");
        uas = input.nextDouble();
        System.out.print("Nilai Tugas: ");
        tugas = input.nextDouble();
    }

    @Override
    public void calculateFinalScore() {
        finalScore = (0.3 * uts) + (0.4 * uas) + (0.3 * tugas);
        determineGrade();
    }

    @Override
    public void determineGrade() {
        if (finalScore >= 80 && finalScore <= 100) {
            letterGrade = "A";
        } else if (finalScore >= 73) {
            letterGrade = "B+";
        } else if (finalScore >= 65) {
            letterGrade = "B";
        } else if (finalScore >= 60) {
            letterGrade = "C+";
        } else if (finalScore >= 50) {
            letterGrade = "C";
        } else if (finalScore >= 39) {
            letterGrade = "D";
        } else {
            letterGrade = "E";
        }

        status = (finalScore >= 60) ? "LULUS" : "TIDAK LULUS";
    }

    @Override
    public double getFinalScore() {
        return finalScore;
    }

    @Override
    public String getLetterGrade() {
        return letterGrade;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void displayCourse() {
        System.out.printf("%-25s %-10.0f %-10.0f %-10.0f %-10.2f %-10s %-10s%n",
                name, uts, uas, tugas, finalScore, letterGrade, status);
    }
}

class UndegraduateStudent{
    private String name;
    private String nim;
    private Subject subject1;
    private Subject subject2;

     public void inputData(Scanner input) {
        System.out.println("-----    INPUT DATA MAHASISWA -----");
        System.out.print("Nama  : ");
        input.nextLine(); 
        name = input.nextLine();
        System.out.print("NIM   : ");
        nim = input.nextLine();

        subject1 = new Subject("Algoritma dan Pemrograman");
        subject1.inputData(input);
        subject1.calculateFinalScore();

        subject2 = new Subject("Struktur Data");
        subject2.inputData(input);
        subject2.calculateFinalScore();
    }
}

public class MidTest {
    public static void main(String[] args) {
        System.out.println("");
    }
}