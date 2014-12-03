package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.Function;

public class CrypterXOR implements Crypter{
	
	private Deque<Integer> keyDeque;
	
	Function<String, String> encryp = (x) -> {
		
		  int pointer = 0;
		   for(int i = 0; i < x.length();i++ ){
			   keyDeque.iterator().next() 
			   System.out.println(this.keyDeque.iterator().next());
		   }
		
		
		String erg="";
	
		return erg;
	};
	Function<String, String> decryp = (x) -> {
		String erg="";
	
			return erg;
	};
	

	public CrypterXOR(String key) {	
		this.keyDeque = new ArrayDeque<Integer>();
	   this.addToDeque(key);

    }
	private void addToDeque(String key){
	   
	   for(char intValue:key.toCharArray()){
		   keyDeque.add((int) intValue +65);
		   
	   }
	
	}

	@Override
    public String encrypt(String message) throws CrypterException {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public List<String> encrypt(List<String> messages) throws CrypterException {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public String decrypt(String cypherText) throws CrypterException {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public List<String> decrypt(List<String> cypherTexte)
            throws CrypterException {
	    // TODO Auto-generated method stub
	    return null;
    }
}