package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class CrypterSubstitution implements Crypter {

	private ArrayList<Character> alphabet;
	private ArrayList<Character> keyList;

	Function<String, String> encryp = (x) -> {
		String str = "";
		int tmp = -1;
		for (Character c : x.toCharArray()) {
			if (this.alphabet.indexOf(c) >= 0) {
				tmp = this.alphabet.indexOf(c);
				if (tmp >= 0) {
					str += this.keyList.get(tmp);
				}
			}else{
				str+=c;
			}
		}
		return str;
	};

	Function<String, String> decryp = (x) -> {
		String str = "";
		for (Character c : x.toCharArray()) {
			if (this.alphabet.indexOf(c) >= 0) {
			str += this.alphabet.get(this.keyList.indexOf(c));
			}else{
				str+=c;
			}
		}
		return str;
	};

	public CrypterSubstitution(String key) {
		this.alphabet = this.fillAlphabet();
		this.keyList = this.fillKeyList(key);

	}

	private ArrayList<Character> fillAlphabet() {
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 65; i < 91; i++) {
			list.add((char) i);
		}
		return list;
	}

	private ArrayList<Character> fillKeyList(String key) {
		ArrayList<Character> list = new ArrayList<>();
		for (Character c : key.toCharArray()) {
			list.add(c);
		}
		return list;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return this.encryp.apply(message);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> list = new LinkedList<>();
		for (String msg : messages) {
			list.add(this.encryp.apply(msg));
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

			list.add(this.decryp.apply(msg));
		}

		return list;
	}

}
