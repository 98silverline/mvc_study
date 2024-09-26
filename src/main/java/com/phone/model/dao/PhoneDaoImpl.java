package com.phone.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phone.model.dto.Member;
import com.phone.model.dto.Phone;
import com.phone.util.DBUtil;

public class PhoneDaoImpl implements PhoneDao {

	@Override
	public List<Phone> selectAll() throws SQLException {
		String sql = "select serial_number, model, price, description\r\n"
				+ "from phone";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<Phone> list = new ArrayList<>();
			while(rs.next()) {
				int serialNumber = rs.getInt("serial_number");
				String model = rs.getString("model");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				Phone phone = new Phone(serialNumber, model, price, description);
				
				list.add(phone);
			}
			return list;
			
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public Phone findBySerialNumber(int serialNumber) throws SQLException {
		String sql = "select serial_number, model, price, description\r\n"
				+ "from phone\r\n"
				+ "where serial_number = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serialNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String model = rs.getString("model");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				Phone phone = new Phone(serialNumber, model, price, description);
				
				return phone;
			}
			return null;
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public int add(Phone phone) throws SQLException {
		String sql = "insert into phone\r\n"
				+ "(model, price, description)\r\n"
				+ "values\r\n"
				+ "(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone.getModel());
			pstmt.setInt(2, phone.getPrice());
			pstmt.setString(3, phone.getDescription());
			int cnt  = pstmt.executeUpdate();
			
			return cnt;
		} finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public int deleteBySerialNumber(int serialNumber) throws SQLException {
		String sql = "delete from phone\r\n"
				+ "where serial_number = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serialNumber);
			int cnt  = pstmt.executeUpdate();
			
			return cnt;
		} finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public int update(Phone phone) throws SQLException {
		String sql = "update phone\r\n"
				+ "set model=?, price=?, description=?\r\n"
				+ "where serial_number = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone.getModel());
			pstmt.setInt(2, phone.getPrice());
			pstmt.setString(3, phone.getDescription());
			pstmt.setInt(4,  phone.getSerialNumber());
			int cnt  = pstmt.executeUpdate();
			
			return cnt;
		} finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public Member login(Member loginInfo) throws SQLException {
		String sql = "select id, name\r\n"
				+ "from member\r\n"
				+ "where id=? and password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginInfo.getId());
			pstmt.setString(2, loginInfo.getPassword());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				return new Member(id, null, name);
			}
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return null;
	}

}
