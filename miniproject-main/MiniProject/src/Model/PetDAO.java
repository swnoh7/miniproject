package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	private void getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://project-db-campus.smhrd.com:3307/cgi_23K_BIG23_p1_2";
			String user = "cgi_23K_BIG23_p1_2";
			String password = "smhrd2";

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int update(PetDTO petDto) {
	      int row = 0;
	      
	      try {
	         getConn();
	         
	         String sql = "update cgi_23K_BIG23_p1_2.pet set Hp = ?, Fullness = ?, Love = ?, money = ?, snack = ?, feed = ?, supply_st = ?, supply_rd = ? where p_name = ?";

	         psmt = conn.prepareStatement(sql);

	         psmt.setInt(1, petDto.getHp());
	         psmt.setInt(2, petDto.getFullness());
	         psmt.setInt(3, petDto.getLove());
	         psmt.setInt(4,  petDto.getMoney());
	         psmt.setInt(5, petDto.getSnack());
	         psmt.setInt(6, petDto.getFeed());
	         psmt.setBoolean(7, petDto.isSupply1());
	         psmt.setBoolean(8, petDto.isSupply2());
	         psmt.setString(9, petDto.getName());

	         row = psmt.executeUpdate();

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         getClose();
	      }

	      return row;
	   }
	
	public int delete(PetDTO petDto) {
		  int row = 0;
	      
	      try {
	         getConn();
	         
	         String sql = "delete from pet where p_name = ?";

	         psmt = conn.prepareStatement(sql);

	         psmt.setString(1, petDto.getName());

	         row = psmt.executeUpdate();

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         getClose();
	      }

	      return row;
	}
	
	
}
