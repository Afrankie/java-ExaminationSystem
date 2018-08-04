package practice;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zoujian on 2018/7/22.
 */
public class StudentManager {
    private JLabel nameLabel;
    private SystemDb db;

    public StudentManager(){
        nameLabel = new JLabel();
    }
    private void showStudetName(){
        String id = "123";
        db = new SystemDb();
        Student student = db.getStudentById(id);
        String name = student.getName();
        nameLabel.setText(name);
    }

    public static Boolean isGrade5(){
        return true;
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.showStudetName();
        StudentManager.isGrade5();
    }
}
