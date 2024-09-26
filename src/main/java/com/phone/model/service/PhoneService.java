package com.phone.model.service;

import java.sql.SQLException;
import java.util.List;

import com.phone.model.dto.Member;
import com.phone.model.dto.Phone;

public interface PhoneService {

	//휴대폰 전체 목록 조회
	List<Phone> selectAll() throws SQLException;
	
	//시리얼 넘버로 휴대폰 상세 조회
	Phone findBySerialNumber(int serialNumber) throws SQLException;
	
	//휴대폰 정보 추가
	int add(Phone phone) throws SQLException;
	
	//휴대폰 정보 삭제
	int deleteBySerialNumber(int serialNumber) throws SQLException;
	
	//휴대폰 수정 정보 조회
	Phone getUpdateInfo(int serialNumber) throws SQLException;
	
	//휴대폰 정보 수정
	int update(Phone phone) throws SQLException;
	
	Member login(Member loginInfo) throws SQLException;
	
}
