package parallelization;


import java.util.concurrent.*;

public class ExamGrader {

    // You can add new methods, inner classes, etc.

    public interface RoundingFunction {
        int roundGrade(double grade);
    }


    public static class ExamQuestion {
        private double pointsObtained;
        private ExamQuestion nextQuestion;

        public ExamQuestion(double points, ExamQuestion next) {
            this.pointsObtained = points;
            this.nextQuestion = next;
        }

        public double getPointsObtained() {
            return pointsObtained;
        }

        public ExamQuestion getNextQuestion() {
            return nextQuestion;
        }
    }

    /**
     * Write a method calculateExamGrade that calculates the grade
     * obtained for an exam. The grade is the sum of the points
     * obtained in all questions. The questions are provided in a
     * linked list (class ExamQuestion).
     * <p>
     * However, the points are real numbers, while the exam grade
     * is a natural number. To round the grade, the caller of this
     * method provides a rounding function that you have to use
     * to obtain the final result.
     * <p>
     * Look at the test "testWithTwoQuestions" to see how users will
     * call this method.
     * <p>
     * You can assume that all points are positive numbers and that
     * the list of questions is not empty.
     */
    public static int calculateExamGrade(ExamQuestion questions, RoundingFunction roundingFunction) {


        int grade = 0;
        while (questions != null) {
            grade += roundingFunction.roundGrade(questions.getPointsObtained());
            questions = questions.getNextQuestion();
        }


        return grade;
    }


    /**
     * Write a method gradeExams that calculates the grades of two exams
     * using two threads to accelerate the grading (one exam graded per thread).
     * The method must return the two grades in an int array.
     * Like for the method calculateExamGrade, the caller of this method
     * provides a rounding function.
     * <p>
     * Look at the test "testTwoShortExams" to see how users will
     * call this method.
     * <p>
     * You MUST use threads (or a threadpool).
     * Catch (and ignore) all exceptions.
     */
    public static int[] gradeExams(ExamQuestion exam1, ExamQuestion exam2, RoundingFunction roundingFunction){
        int[] examGrades = new int[2];
        class CallGradeExam implements Callable<Integer> {
            ExamQuestion exam;
            RoundingFunction roundingFunction;

            CallGradeExam(ExamQuestion exam, RoundingFunction roundingFunction) {
                this.exam = exam;
                this.roundingFunction = roundingFunction;
            }

            @Override
            public Integer call() throws Exception {
                if (exam == null || roundingFunction == null) {
                    throw new Exception();
                }
                return calculateExamGrade(exam, roundingFunction);
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = executor.submit(new CallGradeExam(exam1, roundingFunction));
        Future<Integer> result2 = executor.submit(new CallGradeExam(exam2, roundingFunction));
        try {
            examGrades[0] = result1.get();
            examGrades[1] = result2.get();
        } catch (Exception ignored){}


        executor.shutdown();
        return examGrades;
    }
}

