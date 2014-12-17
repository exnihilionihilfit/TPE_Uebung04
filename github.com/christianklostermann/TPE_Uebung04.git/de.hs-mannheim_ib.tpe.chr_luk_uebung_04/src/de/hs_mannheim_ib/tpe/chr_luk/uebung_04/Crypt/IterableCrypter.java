package de.hs_mannheim_ib.tpe.chr_luk.uebung_04.Crypt;

import java.util.Iterator;

/**
 * @author Lukas
 *
 */
public class IterableCrypter implements Iterable<String> {

	private Iterator<String> iterator;

	private Crypter crypter;

	/**
	 * Creates an Iterable Crypter Object
	 * 
	 * @param list
	 *            list that should be used as iterator
	 * @param crypter
	 *            type of crypter that should be used
	 */
	public IterableCrypter(Iterable<String> list, Crypter crypter) {
		this.crypter = crypter;
		this.iterator = list.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<String> iterator() {

		return new Iterator<String>() {

			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public String next() {
				String erg = "";

				try {
					erg = crypter.encrypt(iterator.next());
				} catch (CrypterException e) {
					e.printStackTrace();
				}

				return erg;
			}
		};
	}
}