package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.Function;

public class CrypterXOR implements Crypter {

	private Deque<Integer> keyDeque;
	private String key;
	
	Function<String, String> encryp = (x) -> {
		String erg = "";
		int tmp = 0;
		for (int i = 0; i < x.length(); i++) {
			tmp = keyDeque.getFirst();
			keyDeque.removeFirst();
			keyDeque.addLast(tmp);
			erg += (char) ((int) x.charAt(i) ^ tmp);
		}
		this.addToDeque(key);
		return erg;
	};
	Function<String, String> decryp = (x) -> {
		String erg = "";
		int tmp = 0;
		for (int i = 0; i < x.length(); i++) {
			tmp = keyDeque.getFirst();
			keyDeque.removeFirst();
			keyDeque.addLast(tmp);
			erg += (char) ((int) x.charAt(i) ^ tmp);
		}
		this.addToDeque(key);
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
		return this.encryp.apply(message);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {	
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return this.decryp.apply(cypherText);
	}
	@Override
	public List<String> decrypt(List<String> cypherTexte)
	        throws CrypterException {	
		return null;
	}
}