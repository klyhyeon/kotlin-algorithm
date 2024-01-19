package programmers.learn.courses.no30.lessons.lv01.no2501221;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/* * PCCE 기출 10번 / 데이터 분석
 * - 성공
 * */
public class No250121 {

    public List<List<Integer>> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<String, Integer> columnMap = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );
        int extIndex = columnMap.get(ext);
//        LocalDate extDate = null;
//        if (ext.equals("date")) {
//            extDate = parseDate(val_ext);
//            for (int i = 0; i < data.length; i++) {
//                if (parseDate(data[i][extIndex]).isBefore(extDate)) {
//                    List<Integer> temp = new ArrayList<>();
//                    for (int j = 0; j < data[i].length; j++) {
//                        temp.add(data[i][j]);
//                    }
//                    answer.add(temp);
//                }
//            }
//        } else {
        for (int i = 0; i < data.length; i++) {
            if (data[i][extIndex] < val_ext) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < data[i].length; j++) {
                    temp.add(data[i][j]);
                }
                answer.add(temp);
            }
        }
//        }

//        if (sort_by.equals("date")) {
//            answer.sort(((o1, o2) -> parseDate(o2.get(extIndex)).compareTo(parseDate(o1.get(extIndex)))));
//        } else {
        int sortIndex = columnMap.get(sort_by);
        answer.sort(Comparator.comparing(o -> o.get(sortIndex)));
//        }

        return answer;
    }

//    public LocalDate parseDate(int date) {
//        return LocalDate.parse(
//                String.valueOf(date), DateTimeFormatter.ofPattern("yyyyMMdd")
//        );
//    }
}
