package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Lukas
 *
 */
public class CrypterSubstitution implements Crypter {

	/**
	 * Private character arraylist
	 */
	private ArrayList<Character> alphabet;
	/**
	 * Private character arraylist
	 */
	private ArrayList<Character> keyList;

	/**
	 * Encrypts given String according to Substitution encryption.
	 * 
	 * @param s
	 *            String that should be encrypted
	 * @return encrypted String
	 */
	Function<String, String> encryp = (x) -> {
		String str = "";
		int tmp = -1;
		for (Character c : x.toCharArray()) {
			if (this.alphabet.indexOf(c) >= 0) {
				tmp = this.alphabet.indexOf(c);
				if (tmp >= 0) {
					str += this.keyList.get(tmp);
				}
			} else {
				str += c;
			}
		}
		return str;
	};

	/**
	 * Decrypts given String according to Substitution encryption.
	 * 
	 * @param s
	 *            String that should be decrypted
	 * @return decrypted String
	 */
	Function<String, String> decryp = (x) -> {
		String str = "";
		for (Character c : x.toCharArray()) {
			if (this.alphabet.indexOf(c) >= 0) {
				str += this.alphabet.get(this.keyList.indexOf(c));
			} else {
				str += c;
			}
		}
		return str;
	};

	/**
	 * Creates a Substitution encrypter Object using the keyset provided for the
	 * encryption.
	 * 
	 * @param key
	 *            Keyset as a String that is used for the encryption.
	 * 
	 */
	public CrypterSubstitution(String key) {
		this.alphabet = this.fillAlphabet();
		this.keyList = this.fillKeyList(key);

	}

	/**
	 * Fills the given List with the alphabet
	 * 
	 * @return list with filled alphabet
	 */
	private ArrayList<Character> fillAlphabet() {
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 65; i < 91; i++) {
			list.add((char) i);
		}
		return list;
	}
	/**
	 * Fills given List with given keys
	 * traverses the list until the wanted key is found
	 * 
	 * @param key
	 *            wanted key as char
	 */
	private ArrayList<Character> fillKeyList(String key) {
		ArrayList<Character> list = new ArrayList<>();
		for (Character c : key.toCharArray()) {
			list.add(c);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#encrypt(java.lang
	 * .String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		return this.encryp.apply(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#encrypt(java.util
	 * .List)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> list = new LinkedList<>();
		for (String msg : messages) {
			list.add(this.encryp.apply(msg));
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#decrypt(java.lang
	 * .String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return this.decryp.apply(cypherText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#decrypt(java.util
	 * .List)
	 */
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
