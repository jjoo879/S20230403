
package com.example.Sukbak.service.lysService;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.Sukbak.dao.lysDao.AccomAllDao;
import com.example.Sukbak.model.Accom;

import lombok.RequiredArgsConstructor; import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j 
public class DefaultServiceImple implements DefaultService { 
	private final AccomAllDao 	d06;
	@Override
	public List<Accom> searchAc(Accom accom) { 
		List<Accom> searchAc
		=d06.searchAc(accom); 

		return searchAc; 
	}

}