package view.studentview;



import cotroller.studentmanager.AdministrationManager;
import model.students.AdministrationStudent;
import storage.studenttext.AdministrationReadWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class AdministrationStudentView {
    private static final AdministrationStudentView administrationStudentView = new AdministrationStudentView();
    private AdministrationStudentView() {
    }
    public static AdministrationStudentView getInstance() {
        return administrationStudentView;
    }
    public void runAdministration() {
        AdministrationManager administrationManager = AdministrationManager.getInstance();
        try {
            administrationManager.setAdministrationStudentArrayList(AdministrationReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -2;
        while (choice !=0) {
            System.out.println("Danh sách sinh viên ngành Quản Lý");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Tìm kiếm sinh viên");
            System.out.println("5. Danh sách sinh viên");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Thêm sinh viên");
                    addStudent(administrationManager);
                    break;
                }
                case 2: {
                    System.out.println("2. Sửa thông tin sinh viên");
                    editStudent(administrationManager);
                    break;
                }
                case 3: {
                    System.out.println("3. Xóa sinh viên");
                    removeStudent(administrationManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Tìm kiếm sinh viên");
                    searchStudents(administrationManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Danh sách sinh viên");
                    administrationManager.showAdministrationStudent();
                }
                case 0:


            }
        }
    }

    public static AdministrationStudent inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập ngày tháng năm sinh: ");
        String dateOfBirth = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập tên lớp: ");
        String className = scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập quê quán: ");
        String homeTown = scanner4.nextLine();

        return new AdministrationStudent(name, dateOfBirth, codeStudent, className, homeTown);
    }
    private void addStudent(AdministrationManager administrationManager) {

        administrationManager.addNewStudent(inputStudent());
    }
    private void editStudent(AdministrationManager administrationManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        administrationManager.editAdministrationStudentArrayList(codeStudent, inputStudent());
    }
    private void removeStudent(AdministrationManager administrationManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        administrationManager.removeStudent(codeStudent);
    }
    private void searchStudents(AdministrationManager administrationManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        String codeStudent = scanner.nextLine();
        AdministrationStudent administrationStudent1 = administrationManager.searchStudent(codeStudent);
        System.out.println(administrationStudent1);
    }
}
