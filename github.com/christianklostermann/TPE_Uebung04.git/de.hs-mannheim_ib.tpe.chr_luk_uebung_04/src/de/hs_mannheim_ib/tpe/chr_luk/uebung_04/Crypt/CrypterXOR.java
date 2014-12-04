package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class CrypterXOR implements Crypter {

	private Deque<Integer> keyDeque;
	private String key;

	Function<String, String> cryp = (x) -> {
		Iterator<Integer> iterator = keyDeque.iterator();
		String erg = "";
		int tmp = 0;
		for (int i = 0; i < x.length(); i++) {
			if (iterator.hasNext()) {				
				tmp = iterator.next();
			}else{
				iterator = keyDeque.iterator();
				tmp = iterator.next();
			}
			erg += (char) ((int) x.charAt(i) ^ tmp);
		}
	
		return erg;
	};
	

	public CrypterXOR(String key) {
		this.key = key;
		this.keyDeque = new ArrayDeque<Integer>();
		this.addToDeque(key);

	}

	private void addToDeque(String key) {
		keyDeque.clear();
		for (char intValue : key.toCharArray()) {
			keyDeque.add((int) intValue + 65);
		}
	}
	@Override
	public String encrypt(String message) throws CrypterException {
		return this.cryp.apply(message);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return this.cryp.apply(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
	        throws CrypterException {
		return null;
	}
}