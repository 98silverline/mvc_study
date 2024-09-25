package com.phone.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.phone.model.dto.Phone;

public interface PhoneDao {

	/**
	 * 전체목록 조회
	 */
	List<Phone> selectAll() throws SQLException;
	
	/**
	 * 상세 조회
	 */
	Phone findBySerialNumber(int serialNumber) throws SQLException;
	
	/**
	 * 추가
	 */
	int add(Phone phone) throws SQLException;
	
	/**
	 * 삭제
	 */
	int deleteBySerialNumber(int serialNumber) throws SQLException;
	
	/**
	 * 수정
	 */
	int update(Phone phone) throws SQLException;
	
}
