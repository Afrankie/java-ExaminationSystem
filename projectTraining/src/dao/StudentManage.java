package dao;

import com.opencsv.CSVReader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;

/**
 * Created by zoujian on 2018/7/29.
 */
public class StudentManage {
    JFileChooser fc;
    private String CSV_FILE_PATH;
    private JTable jTable;
    private DefaultTableModel defaultTableModel;
    private JScrollPane jScrollPane;
    ResultSet rs;
    DBHelper dbHelper;

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    StudentManage() throws Exception{
        fc = new JFileChooser();
        dbHelper=new DBHelper();
        defaultTableModel=new DefaultTableModel();
        jTable=new JTable(defaultTableModel);
        jScrollPane=new JScrollPane(jTable);

    }

    public void showAllStudent(String sql) throws Exception{

        defaultTableModel=new DefaultTableModel();

        jTable=new JTable(defaultTableModel);

        jScrollPane=new JScrollPane(jTable);

        rs=dbHelper.query(sql);

        defaultTableModel.addColumn("考号");

        defaultTableModel.addColumn("姓名");

        defaultTableModel.addColumn("年龄");

        defaultTableModel.addColumn("语文");

        defaultTableModel.addColumn("数学");

        defaultTableModel.addColumn("英语");

        defaultTableModel.addColumn("历史");

        defaultTableModel.addColumn("地理");

        defaultTableModel.addColumn("物理");

        defaultTableModel.addColumn("艺术");

        defaultTableModel.addColumn("总分");

        defaultTableModel.addColumn("地区");

        defaultTableModel.addColumn("考生类型");

        while (rs.next()){
            String sid=rs.getString("sid");

            String name=rs.getString("name");

            String age=rs.getString("age");

            int chinese=rs.getInt("chinese");

            int math=rs.getInt("math");

            int english=rs.getInt("english");

            int history=rs.getInt("history");

            int geography=rs.getInt("geography");

            int physics=rs.getInt("physics");

            int art=rs.getInt("art");

            int total=rs.getInt("total");

            String region=rs.getString("region");

            String type=rs.getString("type");

            defaultTableModel.addRow(new Object[]{sid,name,age,chinese,math,english,history,geography,physics,art,total,region,type});
        }

    }

    public void showSepecificStudent(String sql,SystemDb systemDb) throws Exception{

        defaultTableModel=new DefaultTableModel();

        jTable=new JTable(defaultTableModel);

        jScrollPane=new JScrollPane(jTable);

        rs=dbHelper.query(sql);

        String arrayBasicInfo[]=systemDb.getBasicInfo().split("，");

        String arraySubject[]=systemDb.getSubject().split("，");

        for (int i=0;i<arrayBasicInfo.length;i++){
            defaultTableModel.addColumn(""+arrayBasicInfo[i]+"");
        }

        for (int i=0;i<arraySubject.length;i++){
            defaultTableModel.addColumn(""+arraySubject[i]+"");
        }

        defaultTableModel.addColumn(systemDb.getRegion());

        defaultTableModel.addColumn(systemDb.getType());

        Object arrayBasicInfoValue[]=new String[arrayBasicInfo.length];

        Object arraySubjectValue[]=new Integer[arraySubject.length];

        Object arrayTypeAndRegionValue[]=new String[2];

        Object threeArray[]=new Object[arrayBasicInfoValue.length+arraySubjectValue.length+arrayTypeAndRegionValue.length];

        while (rs.next()) {

            for (int i = 0; i < arrayBasicInfo.length; i++) {
                arrayBasicInfoValue[i] = rs.getString(i+1);
            }

            for (int i = 0; i < arraySubject.length; i++) {
                arraySubjectValue[i] = rs.getInt(i + arrayBasicInfo.length+1);
            }

            arrayTypeAndRegionValue[0] = rs.getString("region");

            arrayTypeAndRegionValue[1] = rs.getString("type");

            System.arraycopy(arrayBasicInfoValue, 0, threeArray, 0, arrayBasicInfoValue.length);

            System.arraycopy(arraySubjectValue, 0, threeArray, arrayBasicInfoValue.length, arraySubjectValue.length);

            System.arraycopy(arrayTypeAndRegionValue, 0, threeArray, arrayBasicInfoValue.length + arraySubjectValue.length, arrayTypeAndRegionValue.length);

            defaultTableModel.addRow(threeArray);

        }

    }

    public void showSingleStudent(String sql) throws Exception{

        defaultTableModel=new DefaultTableModel();

        jTable=new JTable(defaultTableModel);

        jScrollPane=new JScrollPane(jTable);

        defaultTableModel.addColumn("考号");

        defaultTableModel.addColumn("姓名");

        defaultTableModel.addColumn("年龄");

        defaultTableModel.addColumn("语文");

        defaultTableModel.addColumn("数学");

        defaultTableModel.addColumn("英语");

        defaultTableModel.addColumn("历史");

        defaultTableModel.addColumn("地理");

        defaultTableModel.addColumn("物理");

        defaultTableModel.addColumn("艺术");

        defaultTableModel.addColumn("总分");

        defaultTableModel.addColumn("地区");

        defaultTableModel.addColumn("考生类型");

        rs=dbHelper.query(sql);

        while (rs.next()){
            String sid=rs.getString("sid");

            String name=rs.getString("name");

            String age=rs.getString("age");

            int chinese=rs.getInt("chinese");

            int math=rs.getInt("math");

            int english=rs.getInt("english");

            int history=rs.getInt("history");

            int geography=rs.getInt("geography");

            int physics=rs.getInt("physics");

            int art=rs.getInt("art");

            int total=rs.getInt("total");

            String region=rs.getString("region");

            String type=rs.getString("type");

            defaultTableModel.addRow(new Object[]{sid,name,age,chinese,math,english,history,geography,physics,art,total,region,type});

        }
    }

    public void insertDate(String sql){
        dbHelper.update(sql);
    }

    public void insertStuVal(SystemDb systemDb){
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
            CSV_FILE_PATH = file.getPath();
            try
            {
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
                // Reading Records One by One in a String array
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {

                    systemDb.setSidVal(nextRecord[0]);
                    systemDb.setNameVal( nextRecord[1]);
                    systemDb.setAgeVal( nextRecord[2]);
                    systemDb.setGenderVal( nextRecord[3]);
                    systemDb.setSchoolVal( nextRecord[4]);
                    systemDb.setChineseVal( nextRecord[5]);
                    systemDb.setMathVal( nextRecord[6]);
                    systemDb.setEnglishVal( nextRecord[7]);
                    systemDb.setPhysicsVal( nextRecord[8]);
                    systemDb.setHistoryVal( nextRecord[9]);
                    systemDb.setGeographyVal( nextRecord[10]);
                    systemDb.setArtVal( nextRecord[11]);
                    systemDb.setTotalVal( nextRecord[12]);
                    systemDb.setRegionVal( nextRecord[13]);
                    systemDb.setTypeVal(nextRecord[14]);
                    String sid=systemDb.getSidVal();
                    String name=systemDb.getNameVal();
                    String age=systemDb.getAgeVal();
                    String gender=systemDb.getGenderVal();
                    String school=systemDb.getSchoolVal();
                    String chinese=systemDb.getChineseVal();
                    String math=systemDb.getMathVal();
                    String english=systemDb.getEnglishVal();
                    String physics=systemDb.getPhysicsVal();
                    String history=systemDb.getHistoryVal();
                    String geography=systemDb.getGeographyVal();
                    String art=systemDb.getArtVal();
                    String total=systemDb.getTotalVal();
                    String region=systemDb.getRegionVal();
                    String type=systemDb.getTypeVal();
                    sid=sid.replace("\uFEFF","");
                    if (!physics.equals("")){
                        String sql = "insert into examinee(sid,name,age,gender,school,chinese,math,english,physics,total,region,type) values('"+sid+"','"+name+"','"+age+"','"+gender+"','"+school+"','"+chinese+"','"+math+"','"+english+"','"+physics+"','"+total+"','"+region+"','"+type+"')";
                        insertDate(sql);
                    }
                    if (!history.equals("")){
                        String sql = "insert into examinee(sid,name,age,gender,school,chinese,math,english,history,geography,total,region,type) values('"+sid+"','"+name+"','"+age+"','"+gender+"','"+school+"','"+chinese+"','"+math+"','"+english+"','"+history+"','"+geography+"','"+total+"','"+region+"','"+type+"')";
                        insertDate(sql);
                    }
                    if (!art.equals("")){
                        String sql = "insert into examinee(sid,name,age,gender,school,chinese,math,english,art,total,region,type) values('"+sid+"','"+name+"','"+age+"','"+gender+"','"+school+"','"+chinese+"','"+math+"','"+english+"','"+art+"','"+total+"','"+region+"','"+type+"')";
                        insertDate(sql);
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
