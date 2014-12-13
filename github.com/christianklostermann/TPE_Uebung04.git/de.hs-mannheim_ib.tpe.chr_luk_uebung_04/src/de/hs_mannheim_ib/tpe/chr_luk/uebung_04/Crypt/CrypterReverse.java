package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class CrypterReverse  implements Crypter{
	
	Function<String, String> reverse = (x)->{
		return new StringBuilder(x).reverse().toString();
	};

	public CrypterReverse(String key) {
	    
    }

	@Override
    public String encrypt(String message) throws CrypterException {
		
	    return this.reverse.apply(message);
    }

	@Override
    public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> list = new LinkedList<>();
		for (String msg : messages) {
			list.add(this.reverse.apply(msg));
		}

	    return list;
    }

	@Override
    public String decrypt(String cypherText) throws CrypterException {	
		   return this.reverse.apply(cypherText);
    }

	@Override
    public List<String> decrypt(List<String> cypherTexte)
            throws CrypterException {
		List<String> list = new LinkedList<>();
		for (String msg :cypherTexte) {
			list.add(this.reverse.apply(msg));
		}

	    return list;
    }

}
