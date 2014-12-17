package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

/**
 * 
 * @author Lukas
 *
 */
public enum CryptTypen {

	CAESAR("Caesar"), SUBSTITUTION("Substitution"), REVERSE("Revers"), XOR(
			"Xor"), NULL("Null");

	private final String name;

	/**
	 * lists the different encryption types by name
	 * 
	 * @param name
	 *            name of given type
	 */
	private CryptTypen(String name) {
		this.name = name;
	}

}
