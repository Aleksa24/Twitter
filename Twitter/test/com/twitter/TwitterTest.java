package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	Twitter a;

	@Before
	public void setUp() throws Exception {
		a = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		a = null;
	}
	
	@Test
	public void testVratiSvePoruke() {
		a.unesi("korisnik", "poruka");
		a.unesi("korisnik1", "poruka2");
		LinkedList<TwitterPoruka> pom = a.vratiSvePoruke();
		if(pom == null){fail("vraca praznu listu i ne radi sta treba!");}
		if( a.vratiSvePoruke().get(0).getKorisnik() != pom.get(0).getKorisnik() || 
			a.vratiSvePoruke().get(0).getPoruka() != pom.get(0).getPoruka() || 
			a.vratiSvePoruke().get(1).getKorisnik() != pom.get(1).getKorisnik() ||
			a.vratiSvePoruke().get(1).getPoruka() != pom.get(1).getPoruka() ){
			fail("ne radi sta treba da uradi");
		}
		
	}

	@Test
	public void testUnesiZadnjeMesto() {
		a.unesi("peraaa peric", "nekaaa porukica");
		a.unesi("peraa peric", "nekaa porukica");
		a.unesi("pera peric", "neka porukica");
		if( !a.vratiSvePoruke().get(a.vratiSvePoruke().size()-1).getKorisnik().equals("pera peric") ||
			!a.vratiSvePoruke().get(a.vratiSvePoruke().size()-1).getPoruka().equals("neka porukica")){
			fail("na zadjem mestu nisu jednaki");
		}
	}
	@Test
	public void testUnesi() {
		a.unesi("pera peric", "neka porukica");
		if( !a.vratiSvePoruke().get(0).getKorisnik().equals("pera peric") ||
			!a.vratiSvePoruke().get(0).getPoruka().equals("neka porukica")){
			fail("lose se dodeljuju korisnik i poruka, posto sam namerno stavio da su na prvom mestu i da bi trebalo da budu isti,tj. da unos na zadnjem mestu nema veze sa kreiranim objektom");
		}
		
	}

	@Test
	public void testVratiPorukeProveraNiza() {
		a.unesi("ime", "tag");
		a.unesi("ime2", "tdaagg");
		a.unesi("ime3", "taagg");
		a.unesi("ime4", "tagg");
		a.unesi("ime5", "sadasdasd  tag");
		a.unesi("ime6", "tagtg");
		a.unesi("ime7", "taagg");
		a.unesi("ime8", "ttagg");
		a.unesi("ime9", "tatgg");
		a.unesi("ime10", "tttagg");
		TwitterPoruka[] pom = a.vratiPoruke(10, "tag");
		for (int i = 0; i < pom.length && pom[i]!=null; i++) {
			if(!pom[i].getPoruka().contains("tag")){
				fail("lose radi sa tagom");
				}
		}
		
		
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		a.unesi("ime", "tag");
		a.vratiPoruke(1, null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan() {
		a.unesi("ime", "tag");
		a.vratiPoruke(1, "");
	}
	@Test 
	public void testVratiPorukeMaxBroj() {
		a.unesi("ime", "tag");
		if(a.vratiPoruke(-1, "tag").length != 100){
			fail("nece da vraca niz duzine 100 ako je unet negativan broj!");
		}
			
	}

}
