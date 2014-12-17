package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.List;

/**
 * @author Lukas
 *
 */
public class CrypterNull  implements Crypter{


	/**
	 * @param key as String which should be used for encryption
	 */
	public CrypterNull(String key) {
	
    }

	/* (non-Javadoc)
	 * @see de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#encrypt(java.lang.String)
	 */
	@Override
    public String encrypt(String message) throws CrypterException {	   
	    return message;
    }

	/* (non-Javadoc)
	 * @see de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#encrypt(java.util.List)
	 */
	@Override
    public List<String> encrypt(List<String> messages) throws CrypterException {	
	    return messages;
    }

	/* (non-Javadoc)
	 * @see de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#decrypt(java.lang.String)
	 */
	@Override
    public String decrypt(String cypherText) throws CrypterException {
	 
	    return cypherText;
    }

	/* (non-Javadoc)
	 * @see de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt.Crypter#decrypt(java.util.List)
	 */
	@Override
    public List<String> decrypt(List<String> cypherTexte)
            throws CrypterException {
	
	    return cypherTexte;
    }

}
