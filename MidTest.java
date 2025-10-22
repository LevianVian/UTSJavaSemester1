import java.util.Scanner; //import java libraries

interface Gradeable { //bikin interface Gradeable
    void calculateFinalScore();
    void determineGrade();
    double getFinalScore();
    String getLetterGrade();
    String getStatus();
}


//class Subject yakni berisi mata kuliah yang mengimplementasi interface Gradeable
class Subject implements Gradeable {
    private final String name;
    private double uts, uas, tugas;
    private double finalScore;
    private String letterGrade;
    private String status;

    //String name untuk nama mata kuliah dan nantinya dipakai ke nama Mahasiswa
    public Subject(String name) {
        this.name = name;
    }

    //method inputData untuk memasukkan nilai UTS, UAS, dan Tugas
    public void inputData(Scanner input) {
        System.out.println("---- Mata Kuliah: " + " ----");
        System.out.print("Nilai UTS: ");
        uts = input.nextDouble();
        System.out.print("Nilai UAS: ");
        uas = input.nextDouble();
        System.out.print("Nilai Tugas: ");
        tugas = input.nextDouble();
    }

    //method calculateFinalScore untuk menghitung nilai akhir
    //override berfungsi untuk mengimplementasi method dari interface Gradeable
    @Override
    public void calculateFinalScore() {
        finalScore = (0.3 * uts) + (0.4 * uas) + (0.3 * tugas);
        determineGrade();
    }


    //method determineGrade untuk menentukan grade dan status kelulusan
    //override berfungsi untuk mengimplementasi method dari interface Gradeable
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

    
    //getfinalscore, getlettergrade, getstatus untuk mengambil nilai finalScore, letterGrade, dan status
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


//class UndergraduateStudent untuk menyimpan data mahasiswaq
class UndegraduateStudent{
    private String name;
    private String nim;
    private Subject subject1;
    private Subject subject2;
    

    //method inputData untuk memasukkan data mahasiswa dan mata kuliah
    public void inputData(Scanner input) {
        System.out.println("-----    INPUT DATA MAHASISWA -----");
        System.out.print("Nama  : ");
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
        //method displayResults untuk menampilkan hasil penilaian mahasiswa 
        public void displayResults() {
        System.out.println("\n------    HASIL PENILIAIAN MAHASISWA ------");
        System.out.println("Nama  : " );
        System.out.println("NIM   : " + nim);
        System.out.println();
        System.out.printf("%-25s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "Mata Kuliah", "UTS", "UAS", "Tugas", "Akhir", "Grade", "Status");
        subject1.displayCourse();
        subject2.displayCourse();

        double avg = (subject1.getFinalScore() + subject2.getFinalScore()) / 2;
        String semesterStatus;

         //menentukan status kelulusan semester
         if (subject1.getStatus().equals("LULUS") && subject2.getStatus().equals("LULUS")) {
            if (avg >= 70) {
                semesterStatus = "LULUS";
            } else {
                semesterStatus = "TIDAK LULUS";
            }
        } else {
            semesterStatus = "TIDAK LULUS";
        }
        System.out.printf("Rata-rata Nilai Akhir: ", avg);
        System.out.println("Status Semester: " + semesterStatus);
    }

}

public class MidTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UndegraduateStudent student = new UndegraduateStudent();
        student.inputData(input);
        student.displayResults();
        input.close();
    }
}
