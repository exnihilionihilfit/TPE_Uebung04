package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Lukas
 *
 */

public class CrypterReverse implements Crypter {

	/**
	 * Function that reverses the given String
	 * 
	 * @return reversed term as String
	 */
	Function<String, String> reverse = (x) -> {
		return new StringBuilder(x).reverse().toString();
	};

	/**
	 * Creates a Reverse encrypter Object using the keyset provided for the
	 * encryption.
	 * 
	 * @param key
	 *            Keyset as a String that is used for the encryption.
	 */
	public CrypterReverse(String key) {

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

		return this.reverse.apply(message);
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
			list.add(this.reverse.apply(msg));
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
		return this.reverse.apply(cypherText);
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
		List<String> list = new LinkedList<>();
		for (String msg : cypherTexte) {
			list.add(this.reverse.apply(msg));
		}

		return list;
	}

}
