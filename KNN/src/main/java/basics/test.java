package basics;

import java.util.Arrays;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {

        KNN.Student[] students = new KNN.Student[] {
                new KNN.Student(new double[]{100,100}, true),
                new KNN.Student(new double[]{90,91}, true),
                new KNN.Student(new double[]{80,75}, true),
                new KNN.Student(new double[]{70,65}, false),
                new KNN.Student(new double[]{70,33}, false),
                new KNN.Student(new double[]{70,50}, true),
                new KNN.Student(new double[]{70,54}, true),
                new KNN.Student(new double[]{30,48}, false),
                new KNN.Student(new double[]{90,10}, false),
                new KNN.Student(new double[]{0,100}, true),
                new KNN.Student(new double[]{30,40}, true),
                new KNN.Student(new double[]{20,30}, false),
                new KNN.Student(new double[]{45,33}, false),
        };
        double [] grades = new double[]{66,20};
        KNN.Student comp = new KNN.Student(grades, false);
        Arrays.sort(students, new Comparator<KNN.Student>() {
            @Override
            public int compare(KNN.Student o1, KNN.Student o2) {
                int result = (int) Math.round(KNN.euclideanDistance(o1.grades, comp.grades) - KNN.euclideanDistance(o2.grades, comp.grades));
                // System.out.println(result);
                return result;
            }
        });
        for (KNN.Student student : students) {
            System.out.println(Arrays.toString(student.grades) + " with Euclidian distance from target : " + (int) Math.round(KNN.euclideanDistance(student.grades, comp.grades)));
        }
    }
}
