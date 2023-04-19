/**
 * 
 */
package com.ejercicio.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.crud.dao.IPartyDAO;
import com.ejercicio.crud.dto.Party;


/**
 * @author camila
 *
 */
@Service
public class PartyServiceImpl implements IPartyService{

	@Autowired
	IPartyDAO iPartyDAO; // me traigo el dao y dto en impots. 
	
	@Override
	public List<Party> listarParty() {
		
		return iPartyDAO.findAll();
	}
	
	@Override
	public Party guardarParty(Party Party) {
		
		return iPartyDAO.save(Party);
	}

	@Override
	public Party PartyXID(Long id_Party) {
		
		return iPartyDAO.findById(id_Party).get();
	}

	@Override
	public Party actualizarParty(Party Party) {
		
		return iPartyDAO.save(Party);
	}

	@Override
	public void eliminarParty(Long id_party) {
		
		iPartyDAO.deleteById(id_party);
		
	}
}