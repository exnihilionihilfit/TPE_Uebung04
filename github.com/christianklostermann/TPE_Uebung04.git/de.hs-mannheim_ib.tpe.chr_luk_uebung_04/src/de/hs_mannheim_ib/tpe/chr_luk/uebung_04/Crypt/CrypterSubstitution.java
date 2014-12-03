package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CrypterSubstitution implements Crypter {

	private String key;

	Function<String, String> encryp = (x) -> {
		x = x.toUpperCase();
		String erg="";
		for (int i = 0; i < x.length(); i++) {
		 erg+=	key.charAt( x.charAt(i) -65 );	
		}	
		return erg;
	};
	Function<String, String> decryp = (x) -> {
		String erg="";
		for (int i = 0; i < x.length(); i++) {
			 erg+= (char) (key.indexOf(x.charAt(i))+65);		
			}		
			return erg;
	};
	public CrypterSubstitution(String key) {
		this.key = key;

	}

	@Override
	public String encrypt(String message) throws CrypterException {

		return this.encryp.apply(message);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> list = new ArrayList<>();
		for(String msg:messages){
			list.add(this.encrypt(msg));
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
		// TODO Auto-generated method stub
		return null;
	}

}
