package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Main;

import de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Exceptions.IllegalKeyException;


public class CrypterFactory {
	public static Crypter createCrypter(String key, Crypters c)
		        throws IllegalKeyException {
			switch (c) {
			case CAESAR:
				return new CrypterCaesar(key);

			case SUBSTITUTION:
				return new CrypterSubstitution();

			case REVERSE:
				return new CrypterReverse();

			case XOR:
				return new CrypterXOR();

			case NULL:
				return new CrypterNull();
			default:
				return null;
			}
		}

	
		
		
	}


