package com.capgemini.unilever.cec.sapientdcs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class ContactUsRecordUtilsTest {
	
	@Test
	public void shouldGetPhoneValueWhenPrimaryPhoneAvailable(){
		final String expectedPhone = "094583048502";
		final ImmutableList<ImmutableMap<String, String>> testList = ImmutableList.of(
				 ImmutableMap.of("type", "primary", "value", expectedPhone),
				ImmutableMap.of("type", "mobile", "value", "8457943879438"));
		String actualPhone = ContactUsRecordUtils.getPhoneValue(testList.toArray());
		assertNotNull(actualPhone);
		assertEquals(actualPhone, expectedPhone);
	}
	
	@Test
	public void shouldGetPhoneValueWhenPhoneAvailable(){
		final String expectedPhone = "094583048502";
		final ImmutableList<ImmutableMap<String, String>> testList = ImmutableList.of(
				ImmutableMap.of("type", "phone", "value", expectedPhone),
				ImmutableMap.of("type", "mobile", "value", "8457943879438"));
		String actualPhone = ContactUsRecordUtils.getPhoneValue(testList.toArray());
		assertNotNull(actualPhone);
		assertEquals(actualPhone, expectedPhone);
	}
	
	@Test
	public void shouldNotGetPhoneValueWhenNoPhoneOrPrimaryPhoneAvailable(){
		final ImmutableList<ImmutableMap<String, String>> testList = ImmutableList.of(
				ImmutableMap.of("type", "mobile", "value", "8457943879438"));
		String actualPhone = ContactUsRecordUtils.getPhoneValue(testList.toArray());
		assertNull(actualPhone);
	}
	
	@Test
	public void shouldNotGetMobileValueWhenMobilePhoneNotAvailable(){
		final ImmutableList<ImmutableMap<String, String>> testList = ImmutableList.of(
				ImmutableMap.of("type", "phone", "value", "094583048502"));
		String actualMobile = ContactUsRecordUtils.getMobileValue(testList.toArray());
		assertNull(actualMobile);
	}
	
	@Test
	public void shouldGetMobileValueWhenAvailable(){
		final String expectedMobile = "8457943879438";
		final ImmutableList<ImmutableMap<String, String>> testList = ImmutableList.of(
				ImmutableMap.of("type", "phone", "value", "094583048502"),
				ImmutableMap.of("type", "mobile", "value", expectedMobile));
		String actualMobile = ContactUsRecordUtils.getMobileValue(testList.toArray());
		assertNotNull(actualMobile);
		assertEquals(actualMobile, expectedMobile);
	}

}
