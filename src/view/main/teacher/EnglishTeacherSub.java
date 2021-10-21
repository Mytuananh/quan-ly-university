package view.main.teacher;

import cotroller.management.SubjectStudentManager;
import cotroller.studentmanager.AccountantManager;
import cotroller.studentmanager.AdministrationManager;
import cotroller.studentmanager.ConstructionManager;
import cotroller.teachermanager.EnglishTeacherManager;
import model.subject.SubjectStudent;
import model.teachers.EnglishTeacher;
import storage.studenttext.AccountantReadWriteFile;
import storage.studenttext.AdministrationReadWriteFile;
import storage.studenttext.ConstructionReadWriteFile;
import storage.subjecttext.SubjectStudentText;
import storage.teachertext.EnglishReadWriteFile;
import view.main.student.AccountantStudentSub;
import view.main.student.AdministrationStudentSub;
import view.main.student.ConstructionStudentSub;
import view.subjectview.English;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EnglishTeacherSub {
   private static final AccountantStudentSub accountantStudentSub = new AccountantStudentSub();
   private static final AdministrationStudentSub administrationStudentSub = new AdministrationStudentSub();
   private static final ConstructionStudentSub constructionStudentSub = new ConstructionStudentSub();
   ArrayList<SubjectStudent> subjectStudentArrayList = new ArrayList<>();
public void runView() {
    EnglishTeacherManager englishTeacherManager = EnglishTeacherManager.getInstance();
    try {
        englishTeacherManager.setEnglishTeacherArrayList(EnglishReadWriteFile.getInstance().readFile());
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    AccountantManager accountantManager = AccountantManager.getInstance();
    try {
        accountantManager.setAccountantStudentArrayList(AccountantReadWriteFile.getInstance().readFile());
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    AdministrationManager administrationManager =AdministrationManager.getInstance();
    try {
        administrationManager.setAdministrationStudentArrayList(AdministrationReadWriteFile.getInstance().readFile());
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    ConstructionManager constructionManager = ConstructionManager.getInstance();
    try {
        constructionManager.setConstructionStudentArrayList(ConstructionReadWriteFile.getInstance().readFile());
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    SubjectStudentManager subjectStudentManager = SubjectStudentManager.getInstance();
    try {
        subjectStudentManager.setSubjectStudentArrayList(SubjectStudentText.getInstance().readFile());
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    English english = English.getInstance();
    english.runEnglish();
    int choice = -2;

    while (choice != 0) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        for (EnglishTeacher eng: englishTeacherManager.getEnglishTeacherArrayList()) {
            if (eng.getName().equals(name)) {
                System.out.println(eng);
                break;
            }
        }
        System.out.println("---Giảng viên bộ môn Tiếng Anh---");
        System.out.println("1. Xem danh sách sinh viên đã đăng ký");
        System.out.println("2. Xem lương giảng viên");
        System.out.println("0. Quay lại");
        choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("1. Xem danh sách sinh viên đã đăng ký");
                displayStudent();
                break;
            }
            case 2: {
                System.out.println("2. Xem lương giảng viên");
                totalMoney();
                break;
            }
            case 0:
        }

    }
}

    private void totalMoney() {
        Scanner scanner2 = new Scanner(System.in);
        String nameTeacher = scanner2.nextLine();

        if (accountantStudentSub.searchSubjectStudentEnglish(nameTeacher) != null) {
            subjectStudentArrayList.add(accountantStudentSub.searchSubjectStudentEnglish(nameTeacher));
        }
        if (administrationStudentSub.searchSubjectStudentEnglish(nameTeacher) != null) {
            subjectStudentArrayList.add(administrationStudentSub.searchSubjectStudentEnglish(nameTeacher));
        }
        if (constructionStudentSub.searchSubjectStudentEnglish(nameTeacher) != null) {
            subjectStudentArrayList.add(constructionStudentSub.searchSubjectStudentEnglish(nameTeacher));
        }
        double total = 0;
        for (SubjectStudent sub: subjectStudentArrayList) {
            total += sub.getSubject().getTuition();
        }
        System.out.println(total);

    }

    private void displayStudent() {
        Scanner scanner1 = new Scanner(System.in);
        String nameTeacher = scanner1.nextLine();
        if (accountantStudentSub.searchSubjectStudentEnglish(nameTeacher) != null) {
            subjectStudentArrayList.add(accountantStudentSub.searchSubjectStudentEnglish(nameTeacher));
        }
        if (administrationStudentSub.searchSubjectStudentEnglish(nameTeacher) != null) {
            subjectStudentArrayList.add(administrationStudentSub.searchSubjectStudentEnglish(nameTeacher));
        }
        if (constructionStudentSub.searchSubjectStudentEnglish(nameTeacher) != null) {
            subjectStudentArrayList.add(constructionStudentSub.searchSubjectStudentEnglish(nameTeacher));
        }
        for (SubjectStudent sub: subjectStudentArrayList) {
            System.out.println(sub.getAccountantStudent());
            System.out.println(sub.getAdministrationStudent());
            System.out.println(sub.getConstructionStudent());
        }
    }
}
