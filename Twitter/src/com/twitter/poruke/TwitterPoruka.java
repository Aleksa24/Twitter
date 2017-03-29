package com.twitter.poruke;
/**
 * 
 *  Klasa Twitter ima polje korisnik i poruka i oba su String. 
 *  Takodje ima i get i set metode, kao i toString metodu
 * 
 * @author Aleksa
 * @version 1.0
 */
public class TwitterPoruka {
	/**
	 * Ime korisnika kao String.
	 */
	private String korisnik;
	/**
	 * Sadrzaj poruke kao String. Mora imati do 140 karaktera.
	 */
	private String poruka;
	/**
	 * Vraca ime korisnika
	 * @return ime Korisnika kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Upisuje ime korisnika. Ime ne sme biti prazno ili null da se ne bi bacila RuntimeException
	 * @param korisnik novo ime korisnika
	 * throws link java.lang.RuntimeException ako je ime prazno ili null
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || !korisnik.isEmpty())
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca sta je zapisano u poruci
	 * @return vrednost poruke kao String
	 */
	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * Upisuje sadrzaj poruke preko parametra koji mora biti razlicit od null i postojan da se ne bi bacila RuntimeException
	 * @param poruka vrednost nove poruke
	 * @throws java.lang.RuntimeException ako je parametar null ili prazan
	 */
	public void setPoruka(String poruka) {
		if (this.poruka==null || this.poruka == new String("") ||
				this.poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Ispisuje ko je korisnik i kakva je poruka
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
