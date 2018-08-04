package practice;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;

/**
 * Created by zoujian on 2018/7/22.
 */
public class SystemDb {

    public Student getStudentById(String id) {
        String result = "{\n" +
                "\t\"subjectName\": \"数学\",\n" +
                "\t\"grade\": 5,\n" +
                "\t\"studentId\": \"123\",\n" +
                "  \"name\":\"张三\"\n" +
                "}";
        Gson gson = new Gson();
        Student student = gson.fromJson(result,Student.class);
        return student;
    }
}
