package programmers.learn.courses.no30.lessons.lv01.no250125;

public class Main {

    public static void main(String[] args) {
        No250125 no = new No250125();
        System.out.println(no.solution(
                new String[][]{
                        {"yellow", "green", "blue"},
                        {"blue", "green", "yellow"},
                        {"yellow", "blue", "blue"}},
                0,
                1)
        );
    }
}