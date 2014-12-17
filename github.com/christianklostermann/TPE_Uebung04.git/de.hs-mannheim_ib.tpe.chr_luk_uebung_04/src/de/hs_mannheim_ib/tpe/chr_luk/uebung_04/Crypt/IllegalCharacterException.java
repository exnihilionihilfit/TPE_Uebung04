package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

public class IllegalCharacterException extends Exception {

	public IllegalCharacterException(String string) {
	System.out.println("FEHLER UNZULAESSIGES ZEICHEN IN ZU DECODIERENDER NACHRICHT");
    }

}