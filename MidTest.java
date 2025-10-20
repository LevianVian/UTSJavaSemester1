import java.util.Scanner;

interface Gradeable{
    void CalculateFinalGrade();
    void determineGrade();
    double getGrade();
    String getLetterGrade();
    String getName();
    String getStatus();
}

class Course implements Gradeable {
    private String name;
    private double uts, uas, tugas;
    private double finalScore;
    private String letterGrade;
    private String status;

    public Course(String name) {
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
    public void CalculateFinalGrade() {
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
    public double getGrade() {
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


public class MidTest {
    public static void main(String[] args) {
        System.out.println("===== Program Penghitung Nilai Akhir Mahasiswa =====");
    }
}