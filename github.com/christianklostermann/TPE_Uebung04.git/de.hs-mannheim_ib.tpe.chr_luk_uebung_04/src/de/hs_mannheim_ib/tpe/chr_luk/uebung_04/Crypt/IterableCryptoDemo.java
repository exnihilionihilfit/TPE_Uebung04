package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;

public class IterableCryptoDemo {
	public static void main(String[] args) throws IllegalKeyException {
		new IterableCryptoDemo();
	}

	public IterableCryptoDemo() {
		
		
		Crypter caesar = CrypterFactory.createCrypter(CryptTypen.CAESAR, "U");
		Crypter xor = CrypterFactory
		        .createCrypter(CryptTypen.XOR, "TPEISTCOOL");

		List<String> liste = Arrays.asList("ABCDEFG");

		IterableCrypter iterableCrypter = new IterableCrypter(liste, caesar);

		System.out.println(makeCollection(iterableCrypter).toString());

		for (String cypherText : iterableCrypter) {

			System.out.println(cypherText);
		}

		List<String> list = Arrays.asList("UVWXYZA");

		IterableDecrypter iterableDecrypter = new IterableDecrypter(list,
		        caesar);

		for (String Text : iterableDecrypter) {
			System.out.println(Text);
		}
	}

	public static <E> Collection<E> makeCollection(Iterable<E> iter) {
		Collection<E> list = new ArrayList<E>();
		for (E item : iter) {
			list.add(item);
		}
		return list;
	}
}