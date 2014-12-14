package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class CrypterXOR implements Crypter {

	private Deque<Integer> keyDeque;
	private String key;
	private ArrayList<Character> alphabet;

	Function<String, String> cryp = (x) -> {
		Iterator<Integer> iterator = keyDeque.iterator();
		String erg = "";
		int tmp = -1;
		int tmp2 = -1;

		for (int i = 0; i < x.length(); i++) {

			if (this.alphabet.contains(x.charAt(i))) {

				if (iterator.hasNext()) {
					tmp = iterator.next();
				} else {
					iterator = keyDeque.iterator();
					tmp = iterator.next();
				}

				tmp = alphabet.indexOf((char) tmp);
				tmp2 = alphabet.indexOf(x.charAt(i));
			
					erg += alphabet.get((tmp ^ tmp2)-26);
				
			} else {
				erg += x.charAt(i);
			}
		}

		return erg;
	};

	Function<String, String> decryp = (x) -> {
		Iterator<Integer> iterator = keyDeque.iterator();
		String erg = "";
		int tmp = -1;
		int tmp2 = -1;

		for (int i = 0; i < x.length(); i++) {

			if (this.alphabet.contains(x.charAt(i))) {

				if (iterator.hasNext()) {
					tmp = iterator.next();
				} else {
					iterator = keyDeque.iterator();
					tmp = iterator.next();
				}

				tmp = alphabet.indexOf((char) tmp);
				tmp2 = alphabet.indexOf(x.charAt(i));

				if ((tmp ^ tmp2) < 26) {
					erg += alphabet.get(tmp ^ tmp2);
				} else {
					erg += alphabet.get((tmp ^ tmp2)-26);
				}
			} else {
				erg += x.charAt(i);

			}
		}

		return erg;
	};

	private ArrayList<Character> fillAlphabet() {
		ArrayList<Character> list = new ArrayList<>();

		list.add('@');
		for (int i = 65; i < 91; i++) {
			list.add((char) i);
		}
		list.add('[');
		list.add('\\');
		list.add(']');
		list.add('^');
		list.add('_');
		return list;
	}

	public CrypterXOR(String key) {

		this.keyDeque = new ArrayDeque<Integer>();
		this.addToDeque(key);
		this.alphabet = this.fillAlphabet();

	}

	private void addToDeque(String key) {
		keyDeque.clear();
		for (char intValue : key.toCharArray()) {
			keyDeque.add((int) intValue);
		}
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return this.cryp.apply(message);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> list = new LinkedList<>();
		for (String msg : messages) {
			list.add(this.encrypt(msg));
		}

		return list;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return this.decryp.apply(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
	        throws CrypterException {
		List<String> list = new ArrayList<>();
		for (String msg : cypherTexte) {

			list.add(this.decrypt(msg));
		}
		return list;
	}
}