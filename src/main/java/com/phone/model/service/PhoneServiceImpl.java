package com.phone.model.service;

import java.sql.SQLException;
import java.util.List;

import com.phone.model.dao.PhoneDao;
import com.phone.model.dao.PhoneDaoImpl;
import com.phone.model.dto.Member;
import com.phone.model.dto.Phone;

public class PhoneServiceImpl implements PhoneService {
	private PhoneDao dao = new PhoneDaoImpl(); 
	
	@Override
	public List<Phone> selectAll() throws SQLException {
		return dao.selectAll();
	}

	@Override
	public Phone findBySerialNumber(int serialNumber) throws SQLException {
		return dao.findBySerialNumber(serialNumber);
	}

	@Override
	public int add(Phone phone) throws SQLException {
		return dao.add(phone);
	}

	@Override
	public int deleteBySerialNumber(int serialNumber) throws SQLException {
		return dao.deleteBySerialNumber(serialNumber);
	}

	@Override
	public Phone getUpdateInfo(int serialNumber) throws SQLException {
		return dao.findBySerialNumber(serialNumber);
	}

	@Override
	public int update(Phone phone) throws SQLException {
		return dao.update(phone);
	}

	@Override
	public Member login(Member loginInfo) throws SQLException {
		return dao.login(loginInfo);
	}

}
