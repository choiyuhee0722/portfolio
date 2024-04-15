package biz;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDao;
import vo.GeulVO;
import vo.UserVO;

	

public class UserService {
	
	UserDao dao = new UserDao();
	
	public int userInsert(UserVO user) throws SQLException {
		int n = dao.UserInsert(user);
		return n;
	}
	
	public int geulInsert(GeulVO geul) throws SQLException {
		int n = dao.geulInsert(geul);
		return n;
	}
	
	public ArrayList<GeulVO> List(){
		ArrayList<GeulVO> list = dao.List();
		return list;
	}
	public GeulVO getGeul(Integer geul_num) {
		GeulVO geul = dao.getGeul(geul_num);
		return geul;
	}
	
	public int geulUpdate(GeulVO geul) throws SQLException {
		int n = dao.geulUpdate(geul);
		return n;
	}
	public int geulDelete(int geul_num) {
		int n = dao.geulDelete(geul_num);
		return n;
	}
	
	public int getMaxGeul_num() {
		int geul_num = dao.getMaxGeul_num();
		return geul_num;
	}
	
	
	
}
