package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.JUnit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CryptTypen;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CrypterException;
import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.CrypterFactory;

public class JUnit {

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
	public void testCrypSub() {
		CrypterFactory crypFac = new CrypterFactory();
		Crypter cryp = crypFac.createCrypter(CryptTypen.SUBSTITUTION,
		        "BCDEFGHIJKLMNOPQRSTUVWXYZA");
		System.out.println("Sub");
		try {
			List<String> testList = new ArrayList<>();
			testList.add("AAAHAB");
			testList.add("Baum");
			// System.out.println(cryp.encrypt("Baum"));
			String tmp = cryp.encrypt("Baum");
			// System.out.println(cryp.decrypt(tmp));
		} catch (CrypterException e) {
			System.out.println("test");
			e.printStackTrace();
		}
	}

	@Test
	public void testCrypXor() {
		CrypterFactory crypFac = new CrypterFactory();
		Crypter cryp = crypFac.createCrypter(CryptTypen.XOR,
		        "BCDEFGHIJKLMNOPQRSTUVWXYZA@[\\]^_");

		try {
			String test = cryp.encrypt("Three  to die,One for the Dark Lord on his dark throneIn the Land of Mordor where the Shadows lie.One Ring to rule them all, One Ring to find them,One Ring to bring them all and in the darkness bind themIn the Land of Mordor where the Shadows lie.");
			System.out.println(test);
			System.out.println(cryp.decrypt(test));
		} catch (CrypterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
