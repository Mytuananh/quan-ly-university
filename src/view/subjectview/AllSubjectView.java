package view.subjectview;

import java.util.Scanner;

public class AllSubjectView {
    private static final English english = English.getInstance();
    private static final Hydraulic hydraulic = Hydraulic.getInstance();
    private static final Math math = Math.getInstance();
    private static final Mechanics mechanics = Mechanics.getInstance();
    public void runAllSub() {

        int choice = -2;

        while (choice != -1) {
            System.out.println("-----Danh sách môn học-----");
            System.out.println("1. Danh sách bộ môn tiếng anh");
            System.out.println("2. Danh sách bộ môn thủy công");
            System.out.println("3. Danh sách bộ môn toán");
            System.out.println("4. Danh sách bộ môn cơ học");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Danh sách bộ môn tiếng anh");
                    english.runEnglish();
                    break;
                }
                case 2: {
                    System.out.println("2. Danh sách bộ môn thủy công");
                    hydraulic.runHydraulic();
                    break;
                }
                case 3: {
                    System.out.println("3. Danh sách bộ môn toán");
                    math.runMath();
                    break;
                }
                case 4: {
                    System.out.println("4. Danh sách bộ môn cơ học");
                    mechanics.runMechanics();
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Không tìm thấy yêu cầu!");
                }
            }
        }
    }



}
