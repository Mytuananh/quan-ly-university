package view.teacherview;


import cotroller.teachermanager.HydraulicTeacherManager;
import model.teachers.HydraulicTeacher;
import storage.teachertext.HydraulicReadWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class HydraulicTeacherView {
    private static HydraulicTeacherView hydraulicTeacherView = new HydraulicTeacherView();
    private HydraulicTeacherView() {
    }

    public static HydraulicTeacherView getInstance() {
        return hydraulicTeacherView;
    }
    public void runHydraulic() {
        HydraulicTeacherManager hydraulicTeacherManager = HydraulicTeacherManager.getInstance();
        try {
            hydraulicTeacherManager.setHydraulicTeacherArrayList(HydraulicReadWriteFile.getInstance().readFile());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -2;
        while (choice != 0) {
            System.out.println("Danh sách giảng viên bộ môn Thủy Công!");
            System.out.println("1. Thêm giảng viên");
            System.out.println("2. Sửa thông tin giảng viên");
            System.out.println("3. Xóa giảng viên");
            System.out.println("4. Tìm kiếm giảng viên");
            System.out.println("5. Danh sách giảng viên");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("1. Thêm giảng viên");
                    addTeacher(hydraulicTeacherManager);
                    break;
                }
                case 2: {
                    System.out.println("2. Sửa thông tin giảng viên");
                    editTeacher(hydraulicTeacherManager);
                    break;
                }
                case 3: {
                    System.out.println("3. Xóa giảng viên");
                    removeTeacher(hydraulicTeacherManager);
                    break;
                }
                case 4: {
                    System.out.println("4. Tìm kiếm giảng viên");
                    searchTeacher(hydraulicTeacherManager);
                    break;
                }
                case 5: {
                    System.out.println("5. Danh sách giảng viên");
                    hydraulicTeacherManager.showHydraulicTeacher();
                    break;
                }
                case 0:

            }
        }
    }

    public static HydraulicTeacher inputTeacher() {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = scanner4.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập ngày tháng năm sinh: ");
        String dateOfBirth = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner2.nextLine();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập quê quán: ");
        String homeTown = scanner.nextLine();

        return new HydraulicTeacher(name, dateOfBirth, codeTeacher, homeTown);
    }
    private void addTeacher(HydraulicTeacherManager hydraulicTeacherManager) {
        hydraulicTeacherManager.addNewTeacher(inputTeacher());
    }
    private void editTeacher(HydraulicTeacherManager hydraulicTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        hydraulicTeacherManager.editHydraulicTeacherArrayList(codeTeacher, inputTeacher());
    }
    private void removeTeacher(HydraulicTeacherManager hydraulicTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        hydraulicTeacherManager.removeTeacher(codeTeacher);
    }
    private void searchTeacher(HydraulicTeacherManager hydraulicTeacherManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã giảng viên: ");
        String codeTeacher = scanner.nextLine();
        HydraulicTeacher hydraulicTeacher = hydraulicTeacherManager.searchTeacher(codeTeacher);
        System.out.println(hydraulicTeacher);
    }
}
