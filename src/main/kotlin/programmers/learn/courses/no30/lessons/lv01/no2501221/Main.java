package programmers.learn.courses.no30.lessons.lv01.no2501221;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        No250121 no = new No250121();
        int[][] ints = new int[][]{
                {1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}
        };
        System.out.println(
                no.solution(
                        ints,
                        "date",
                        20300501,
                        "remain"
                )
        );
    }
}
