package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

public class CrypterFactory {

	public Crypter createCrypter(CryptTypen type, String key) {

		if (key != null) {

			// FEHLT IllegalKeyException !!!
			switch (type) {
			case CAESAR:
				// key nur 1 Zeichen
				try {
					if (key.length() > 1 && key.length() != 0) {
						throw new IllegalKeyException("Key für Caesar > 1");
						
					}

				} catch (IllegalKeyException e) {
					System.out.println("Key für Caesar > 1");
					key = "A";
				}
				return new CrypterCaesar(key);
			case NULL:
				return new CrypterNull(key);
			case REVERSE:
				return new CrypterReverse(key);
			case SUBSTITUTION:
				// key nur 26 Zeichen
				try {
				
					if (key.length() != 26 && key.length() != 0) {
						throw new IllegalKeyException("Key für Substitution ungleich 26");
					}

				} catch (IllegalKeyException e) {
					System.out.println("Key für Substitution ungleich 26");
					key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				}
				return new CrypterSubstitution(key);
			case XOR:
				// key nur 32 Zeichen
				try {
				
					if (key.length() != 32 && key.length() != 0) {
						throw new IllegalKeyException("Key für XOR ungleich 26");
					}

				} catch (IllegalKeyException e) {
					System.out.println("Key für XOR ungleich 32");
					key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@[\\]^_";
				}
				return new CrypterXOR(key);
			default:
				break;
			}
		}
		return null;
	}

}
