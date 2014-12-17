package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.List;

public class CrypterNull  implements Crypter{


	public CrypterNull(String key) {
	
    }

	@Override
    public String encrypt(String message) throws CrypterException {	   
	    return message;
    }

	@Override
    public List<String> encrypt(List<String> messages) throws CrypterException {	
	    return messages;
    }

	@Override
    public String decrypt(String cypherText) throws CrypterException {
	 
	    return cypherText;
    }

	@Override
    public List<String> decrypt(List<String> cypherTexte)
            throws CrypterException {
	
	    return cypherTexte;
    }

}
