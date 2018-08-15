import db.DBCourse;
import db.DBHelper;
import db.DBInstructor;
import db.DBLesson;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Course course1 = new Course(" Climate Change", "MSc");
        Course course2 = new Course("Business Management","BAHons");
        DBHelper.save(course1);
        DBHelper.save(course2);

        Instructor instructor1 = new Instructor("Pawel");
        Instructor instructor2 = new Instructor("Alex");
        DBHelper.save(instructor1);
        DBHelper.save(instructor2);

        Lesson lesson1 = new Lesson("Science of Climate Change", 20, course1, instructor1);
        Lesson lesson2 = new Lesson("Business of Climate Change", 12, course1, instructor2);
        Lesson lesson3 = new Lesson("Accounting", 23, course2, instructor1);
        DBHelper.save(lesson1);
        DBHelper.save(lesson2);
        DBHelper.save(lesson3);

        Student student1 = new Student("Mulan", 21, 123, course1);
        Student student2 = new Student("Moana", 17, 124, course2);
        Student student3 = new Student("Mickey", 67, 125, course1);

        DBHelper.save(student1);
        DBHelper.save(student2);
        DBHelper.save(student3);

        Mentor mentor1 = new Mentor("Vicky Jackson", student1);
        Mentor mentor2 = new Mentor("Pawel", student2);

        DBHelper.save(mentor1);
        DBHelper.save(mentor2);

        List<Student> studentsOnCourse = DBCourse.getListOfStudentsForCouse(course1);
        Student foundStudent = DBHelper.findById(Student.class, 1);
        Course foundCourse = DBHelper.findById(Course.class, 2);
        List<Lesson> lessonsOfInstructor = DBInstructor.getListOfLessonsOfInstructor(instructor1);

        List<Lesson> lessonsOfCourse = DBCourse.getListOfLessonsOfCourse(course1);

        DBLesson.addStudentToLesson(student1, lesson1);

    }
}
