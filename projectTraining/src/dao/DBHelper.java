
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��Ŀ����: librarymanagesystem
 * ������: DBHelper
 * ������: ���ݿ�����࣬�ѳ��õ����ݿ����Ӻ�����ɾ���ġ����װ��һ��ͨ�õİ����࣬���Ч�ʡ�
 * ������: 
 * �޸���: 
 * �޸�ʱ��: 2017��6��18�� ����10:35:21
 * �޸ı�ע: 
 * @version 1.0.0
 */
public class DBHelper implements DBConfig {
private static Connection conn;//����Connection���͵�����   //Connection- java.sql
private static Statement stat;//����Statement���͵�����
private static ResultSet rs;//����RS���͵�����

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        DBHelper.rs = rs;
    }

    public static Connection getConnection() {//���Connection���͵Ķ���
	try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		return conn;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	
}

public static Statement openStatement() {//���Statement���͵Ķ���
	try {
		stat=getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		return stat;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public static int update(String sql) {//������ݵĸ��²��������Խ������ݵ�����insert����ɾ(delete)���ģ�update��
	try {
		return openStatement().executeUpdate(sql);  //executeUpdate()ִ����ɾ�����
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return -1;  //���ݿ���ʧ�ܷ���-1
}

public  static  ResultSet query(String sql) {//������ݵĲ�ѯ���������Խ������ݵĲ�ѯselect
	try {     //����resultset����
		return openStatement().executeQuery(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public static void close() {//�ͷŸ�����Դ
	if (rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if (stat!=null) {
		try {
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	if (conn!=null) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

}
