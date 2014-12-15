package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Main;

import java.util.LinkedList;
import java.util.List;

public class CrypterCaesar implements Crypter {
	private int key;

	public CrypterCaesar(String key) {
		this.key = key.charAt(0);
		
	}

	@Override
	public String encrypt(String message) {
		message = message.toUpperCase();
		for (int i = 0; i < message.length(); i++) {
			char temp = message.charAt(i);
			if (temp >= 'A' && temp <= 'Z') {
				temp = (char) ((temp - 'A' + key) % 26 + 'A');
				return String.valueOf(temp);
			} else {
				return message;
			}

		}
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) {
		LinkedList<String> list=new LinkedList<>();
		for (String message:messages){
			list.add(encrypt(message));
		}
		
		return list;
	}

	@Override
	public String decrypt(String cypherText) {
		cypherText = cypherText.toUpperCase();
		for (int i = 0; i < cypherText.length(); i++) {
			char temp = cypherText.charAt(i);
			if (temp >= 'A' && temp <= 'Z') {
				temp = (char) ((temp - 'A' + (26-key)) % 26 + 'A');
				return String.valueOf(temp);
			} else {
				return cypherText;
			}

		}
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) {
		LinkedList<String> list=new LinkedList<>();
		for (String message:cypherTexte){
			list.add(encrypt(message));
		}
		return list;
	}

}
