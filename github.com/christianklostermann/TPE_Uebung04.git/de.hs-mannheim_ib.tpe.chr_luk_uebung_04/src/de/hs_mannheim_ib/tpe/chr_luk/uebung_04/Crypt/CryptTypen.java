package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

public enum CryptTypen {
	
	CAESAR("Caesar"), SUBSTITUTION("Substitution"),REVERSE("Revers"),XOR("Xor"),NULL("Null");
	
	private final String name;
	
	private CryptTypen(String name){
		this.name = name;
	}

}
