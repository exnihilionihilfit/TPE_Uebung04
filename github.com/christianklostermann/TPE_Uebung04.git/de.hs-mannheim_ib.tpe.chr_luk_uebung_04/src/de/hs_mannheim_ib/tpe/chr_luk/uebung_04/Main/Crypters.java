package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Main;

public enum Crypters {
	CAESAR("Caesar"),SUBSTITUTION("Subs"),REVERSE("Rev"),XOR("XOR"),NULL("Null");
	private String name;
	
	private Crypters(String name){
		this.name=name;
	}
	}
