package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.List;

public class CrypterReverse implements Crypter {

	public CrypterReverse(String key) {
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return new StringBuilder(message).reverse().toString();
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		for (String msg : messages) {
			this.encrypt(msg);
		}
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		return this.encrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
	        throws CrypterException {
		return this.encrypt(cypherTexte);
	}

}
