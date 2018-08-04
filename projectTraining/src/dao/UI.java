package dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

/**
 * Created by zoujian on 2018/7/30.
 */
public class UI extends JFrame implements ActionListener{
    JMenuBar menuBar;
    JMenu menuQuery;
    JMenu menuInsert;
    JMenu menuUpdate;
    JMenu menuDelete;
    JMenuItem queryStu;
    JMenuItem querySpecificStu;
    JMenuItem querySingleStu;
    JMenuItem insertStu;
    StudentManage studentManage;
    SystemDb systemDb;
    UI(){
        setSize(900,700);
        setVisible(true);
        queryStu = new JMenuItem("查询所有学生");
        querySingleStu = new JMenuItem("按学号查询学生");
        querySpecificStu = new JMenuItem("按条件查询学生");
        insertStu = new JMenuItem("选择导入文件");
        menuQuery = new JMenu("查询");
        menuInsert = new JMenu("导入");
        menuUpdate = new JMenu("更新");
        menuDelete = new JMenu("删除");
        menuQuery.add(querySingleStu);
        menuQuery.add(querySpecificStu);
        menuQuery.add(queryStu);
        menuInsert.add(insertStu);
        menuBar=new JMenuBar();
        menuBar.add(menuQuery);
        menuBar.add(menuDelete);
        menuBar.add(menuUpdate);
        menuBar.add(menuInsert);
        setJMenuBar(menuBar);
        systemDb=new SystemDb();
        try {
            studentManage=new StudentManage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        querySpecificStu.addActionListener(this);
        queryStu.addActionListener(this);
        querySingleStu.addActionListener(this);
        insertStu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==queryStu){
            remove(studentManage.getjScrollPane());
            String sql="select * from examinee";
            try {
                studentManage.showAllStudent(sql);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            JScrollPane jScrollPane = studentManage.getjScrollPane();
            add(jScrollPane);
        }
        if (e.getSource()==querySpecificStu){
            remove(studentManage.getjScrollPane());
            String sentence = JOptionPane.showInputDialog("请输入条件表达式:");
            systemDb.showSpecificField(sentence);
            String sql="select "+systemDb.getBasicInfoField()+","+systemDb.getSubjectField()+",region,type from examinee where region "+systemDb.getRegionRange()+" and type "+systemDb.getTypeRange()+"";
            try {
                studentManage.showSepecificStudent(sql,systemDb);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            JScrollPane jScrollPane = studentManage.getjScrollPane();
            add(jScrollPane);
        }
        if (e.getSource()==querySingleStu){
            remove(studentManage.getjScrollPane());
            String sid = JOptionPane.showInputDialog("请输入您要查找的学生的学号:");
            String sql="select * from examinee where sid="+sid+"";
            try {
                studentManage.showSingleStudent(sql);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            JScrollPane jScrollPane = studentManage.getjScrollPane();
            add(jScrollPane);
        }
        if (e.getSource()==insertStu){
            studentManage.insertStuVal(systemDb);
        }
    }

    public static void main(String[] args) {
        UI ui=new UI();
    }
}
