package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * @author Aleksa
 * @version 1.0
 */
public class Twitter {
	
	/**
	 * LinkedList -a klase TwitterPoruka
	 */
	
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	
	/**
	 * 
	 * Vraca pokazivac na listu poruke
	 * 
	 * @return vraca listu TeitterPoruka -a
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Pravi se nova poruka, puni podacima i stavlja na kraj liste.
	 * @param korisnik ime korisnika kao String
	 * @param poruka vrednost poruke kao String
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * 
	 * Vraca niz TwitterPoruka duzine maxBroj 
	 *  ili 100 ako je maxBroj negativan,
	 *  koji u poruci sadrze String tag
	 * 
	 * @param maxBroj parametar koji govori kolika ce biti velicina izlaznog niza
	 * @param tag String koji se trazi u poruci
	 * @return TwiterPoruka[] ,duzine maxBroj
	 * @throws java.lang.RuntimeException ako je tag prazan ili null
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac+1]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
} 
