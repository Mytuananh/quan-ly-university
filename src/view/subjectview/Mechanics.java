package view.subjectview;

import cotroller.management.SubjectManager;
import model.subject.Subject;

import java.util.ArrayList;

public class Mechanics {
    public void runMechanics() {
        SubjectManager subjectManager = SubjectManager.getInstance();
        ArrayList<Subject> mechanicsArrayList = new ArrayList<>();
        Subject subject = new Subject("Cơ học cơ sở I", 320, "Hong Thanh", "C1");
        Subject subject1 = new Subject("Cơ học cơ sở II", 320, "Thuy Hanh", "C2");
        Subject subject2 = new Subject("Cơ học chất lỏng", 640, "Ngo An", "CL1");
        subjectManager.setSubjectArrayList(mechanicsArrayList);
        subjectManager.addNewSubject(subject);
        subjectManager.addNewSubject(subject1);
        subjectManager.addNewSubject(subject2);
        subjectManager.showSubject();
    }
}