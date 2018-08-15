package db;

import models.Lesson;
import models.Student;

public class DBLesson {

    public static void addStudentToLesson(Student student, Lesson lesson){
        student.addToLesson(lesson);
        lesson.addToStudent(student);
        DBHelper.update(student);
    }
}
