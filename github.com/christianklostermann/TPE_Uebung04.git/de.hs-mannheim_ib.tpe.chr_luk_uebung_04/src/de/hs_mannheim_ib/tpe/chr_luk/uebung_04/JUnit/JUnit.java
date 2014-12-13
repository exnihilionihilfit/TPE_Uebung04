package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.JUnit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CryptTypen;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CrypterException;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CrypterFactory;

public class JUnit {

	private String text = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\[\\U_]YDVZABDZT\\V\\SKB@X";

	public void test() {
		CrypterFactory crypFac = new CrypterFactory();
		Crypter cryp = crypFac.createCrypter(CryptTypen.CAESAR, "B");

		try {
			System.out.println(cryp.encrypt("HALLO"));
			List<String> testList = new ArrayList<>();
			testList.add("Blub");
			testList.add("ENIGMA");
			List<String> cryptoList = cryp.encrypt(testList);
			System.out.println(cryptoList);
			System.out.println(cryp.decrypt(cryptoList));

		} catch (CrypterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCrypSub() throws CrypterException {
		List<String> testList = new ArrayList<>();
		testList.add(this.text);	
		
		CrypterFactory crypFac = new CrypterFactory();
		Crypter crypS = crypFac.createCrypter(CryptTypen.SUBSTITUTION,
		        "MNBVCXYLKJHGFDSAPOIUZTREWQ");
		Crypter crypC = crypFac.createCrypter(CryptTypen.CAESAR, "L");
		Crypter crypX = crypFac.createCrypter(CryptTypen.XOR,
		        "IAMTHEONEWHOKNOCKS");
		Crypter crypR = crypFac.createCrypter(CryptTypen.REVERSE, "");
		
		
		
		text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
List<String> list = new ArrayList<>();
list.add(text);
		list = crypC.encrypt(list);
		
		list = crypC.decrypt(list);

		
		
	
	   

		System.out.println(list.toString());
	}

	public void testCrypXor() {
		CrypterFactory crypFac = new CrypterFactory();
		Crypter cryp = crypFac.createCrypter(CryptTypen.XOR,
		        "IAMTHEONEWHOKNOCKS");

		try {
			String test = cryp.encrypt("HALLO DAS ");
			System.out.println(test);
			System.out.println(cryp.decrypt(test));
		} catch (CrypterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
