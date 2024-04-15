package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.GeulVO;
import vo.UserVO;

public class UserDao {
	public int UserInsert(UserVO user) throws SQLException{
		//insert 회원가입 
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps =  conn.prepareStatement("Insert into user_tbl values(?,?,?,?)");
			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getUser_password());
			ps.setString(3, user.getUser_name());
			ps.setString(4, user.getUser_major());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	//list 글쓰기 조회
	public ArrayList<GeulVO> List() {
		ArrayList<GeulVO> list = new ArrayList<GeulVO>();
		System.out.println("list 값 : "+list);
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
				
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select geul_num, geul_id,geul_content,substr(start_date,1,2)||'년'||substr(start_date,4,2)||'월'||substr(start_date,7,2)||'일' start_date,\r\n"
					+ "substr(modify_date,1,2)||'년'||substr(modify_date,4,2)||'월'||substr(modify_date,7,2)||'일' modify_date\r\n"
					+ "from geul_tbl");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				GeulVO vo = new GeulVO();
				vo.setGeul_num(rs.getInt("geul_num"));
				vo.setGeul_id(rs.getString("geul_id"));
				vo.setGeul_content(rs.getString("geul_content"));
				vo.setStart_date(rs.getString("start_date"));
				vo.setModify_date(rs.getString("modify_date"));
				list.add(vo);
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
				DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}
	
	public GeulVO getGeul(Integer geul_num) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		GeulVO  vo = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select geul_num, geul_id, geul_content, start_date, modify_date\r\n"
					+ "from geul_tbl \r\n"
					+ "where geul_num=?");
			ps.setInt(1, geul_num);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				vo = new GeulVO();
				vo.setGeul_num(rs.getInt("geul_num"));
				vo.setGeul_id(rs.getString("geul_id"));
				vo.setGeul_content(rs.getString("geul_content"));
				vo.setStart_date(rs.getString("start_date"));
				vo.setModify_date(rs.getString("modify_date"));

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return vo;
	}

	//update
	public int geulUpdate(GeulVO geul) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0 ;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" update geul_tbl \r\n"
					+ "set geul_id=?, geul_content=?, start_date=?, modify_date=?\r\n"
					+ "where geul_num=?");
			ps.setString(1, geul.getGeul_id());
			ps.setString(2, geul.getGeul_content());
			ps.setString(3, geul.getStart_date());
			ps.setString(4, geul.getModify_date());
			ps.setInt(5, geul.getGeul_num());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	
	//delete
	public int geulDelete(int geul_num) {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			String sql = " Delete from geul_tbl where geul_num = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, geul_num);
			n = ps.executeUpdate();
			if(n>0) {		
				DBUtils.commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			DBUtils.rollack(conn);
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	//geulinsert
	public int geulInsert(GeulVO geul) throws SQLException{
		//insert 회원가입 
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps =  conn.prepareStatement("Insert into user_tbl values(?,?,?,?)");
			ps.setString(1, geul.getGeul_id());
			ps.setString(1, geul.getGeul_content());
			ps.setString(2, geul.getGeul_post());
			ps.setString(3, geul.getStart_date());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	
	public int getMaxGeul_num() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int geul_num = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps =  conn.prepareStatement("select max(geul_num)+1 geul_num from geul_tbl");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				geul_num = rs.getInt("geul_num");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return geul_num;
	}
}
