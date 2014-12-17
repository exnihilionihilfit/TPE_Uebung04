package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Lukas und Christian
 *
 */
public class CrypterXOR implements Crypter {

	/**
	 * Integer Deque reserved for keys
	 */
	private Deque<Integer> keyDeque;
	/**
	 * Character ArrayList reserved for the alphabet
	 */
	private ArrayList<Character> alphabet;

	/**
	 * Encrypts given String according to XOR encryption.
	 * 
	 * @param s
	 *            String that should be encrypted
	 * @return encrypted String
	 */
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
				erg += alphabet.get((tmp ^ tmp2));

			} else {
				erg += x.charAt(i);
			}
		}
		return erg;
	};

	/**
	 * Fills the given List with the alphabet and the given additional
	 * characters
	 * 
	 * @return list with filled alphabet
	 */
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

	/**
	 * Creates an XOR encrypter Object using the keyset provided for the
	 * encryption.
	 * 
	 * @param key
	 *            Keyset as a String that is used for the encryption.
	 * 
	 */
	public CrypterXOR(String key) {

		this.keyDeque = new ArrayDeque<Integer>();
		this.addToDeque(key);
		this.alphabet = this.fillAlphabet();

	}

	/**
	 * Fills given Deque with given keys
	 * 
	 * @param key
	 *            wanted key as String
	 */
	private void addToDeque(String key) {
		keyDeque.clear();
		for (char intValue : key.toCharArray()) {
			keyDeque.add((int) intValue);
		}
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
		return this.cryp.apply(message);
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
			list.add(this.encrypt(msg));
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
		return this.cryp.apply(cypherText);
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

			list.add(this.decrypt(msg));
		}
		return list;
	}
}