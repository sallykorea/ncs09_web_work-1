package test.productDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.productDto.productDto;
import test.util.DbcpBean;

public class productDao {
	private static productDao dao;
	private productDao() {}
	public static productDao getInstance() {
		if(dao==null) {
			dao=new productDao();
		}
		return dao;
	}
	
	public List<productDto> getList() {
		List<productDto> list=new ArrayList<productDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DbcpBean().getConn();
			String sql = "SELECT * FROM product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				productDto dto=new productDto();
				dto.setNum(rs.getInt("num"));
				dto.setPhoto(rs.getString("photo"));
				dto.setTitle(rs.getString("title"));
				dto.setPrice(rs.getString("price"));
				dto.setContent(rs.getString("content"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				//connection pool 에 반납하기 
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
		
	}
	
	public boolean insert(productDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "INSERT INTO product"
					+ " (num,photo,title,price,quantity,content,regdate)"
					+ " VALUES(product_seq.NEXTVAL,?,?,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값 바인딩 하기
			pstmt.setString(1, dto.getPhoto());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getPrice());
			pstmt.setInt(4, dto.getQuantity());
			pstmt.setString(5, dto.getContent());
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}

	}
	
}
