package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.JUnit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CryptTypen;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CrypterException;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CrypterFactory;



public class JUnit {
	
	@Test
	public void test(){
		
		CrypterFactory crypFac = new CrypterFactory();
		
		Crypter cryp = crypFac.createCrypter(CryptTypen.CAESAR, "B");
		
		try {
	        System.out.println(cryp.encrypt("HALLO"));
	        List<String> testList = new ArrayList<>();
	        testList.add("Blub");
	        testList.add("ENIGMA");
	        
	        List<String> cryptoList= cryp.encrypt(testList);
	        System.out.println(cryptoList);
	        
	        System.out.println(cryp.decrypt(cryptoList));
	        
        } catch (CrypterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		
	}
}
