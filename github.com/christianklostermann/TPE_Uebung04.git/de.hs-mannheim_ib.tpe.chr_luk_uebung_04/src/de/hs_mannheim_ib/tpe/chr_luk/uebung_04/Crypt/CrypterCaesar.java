package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class CrypterCaesar implements Crypter {

	private final char key;
	private final int numShift;

	Function<String, String> encryp = (x) -> {
		String txt = "";

		for (char token : x.toCharArray()) {
			txt += (char) ((int) token + this.numShift);
		}
		return txt;
	};

	Function<String, String> decryp = (x) -> {
		String txt = "";

		for (char token : x.toCharArray()) {
			txt += (char) ((int) token - this.numShift);
		}

		return txt;
	};

	BiConsumer<String, String> biCon = (x, y) -> {

	};

	public CrypterCaesar(String key) {
		this.key = key.charAt(0);
		this.numShift = ((int) this.key) - 65; // start with char 'A'
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return this.encryp.apply(message);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> list = new ArrayList<>();
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
	        throws CrypterException {		List<String> list = new ArrayList<>();
			for (String msg : cypherTexte) {

				list.add(this.decryp.apply(msg));
			}

			return list;
	}

}
