package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	TwitterPoruka a;
	
	@Before
	public void setUp() throws Exception {
		a = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		a = null;
	}
	/*
	@Test
	public void testGetKorisnik() {
		a.setKorisnik("aleksa");
		if(!a.getKorisnik().equals("aleksa")){
			fail("greska!!!");
		}
	}*/

	@Test
	public void testSetKorisnik() {
	a.setKorisnik("aleksa");
	assertEquals("aleksa", a.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
	a.setKorisnik(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazno() {
	a.setKorisnik("");
	}
	/*@Test
	public void testGetPoruka() {
		a.setPoruka("poruka");
		if(!a.getPoruka().equals("poruka")){
			fail("greska!!!");
		}
	}*/
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		a.setPoruka(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazno() {
		a.setPoruka("");
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzina() {
		a.setPoruka("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	}
	@Test 
	public void testSetPoruka() {
		a.setPoruka("nesto");
		assertEquals("nesto", a.getPoruka());
	}

	@Test
	public void testToString() {
		a.setKorisnik("aleska");
		a.setPoruka("poruka");
		String tekst = a.toString();
		if(!tekst.equals("KORISNIK:"+a.getKorisnik()+" PORUKA:"+a.getPoruka())){
			fail("toString je nekako los, ubi me ako znam hahaha");
		}
	}

}
