package com.capgemini.unilever.cec.sapientdcs;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

public class ContactUsRecordTest {

	final String ratherUnusualLargeString = "fkhgkjdfhgkshksdhkshkshdkfhksdhfksdhfksdhkfshks"
			+ "kkshsdkhdskhfksdhfkdshfkdskshajpjwe3alsdlflasflasflsflsdhkjsdhksdkhsdfl"
			+ "dsfdslhkdshfksdhkdshfkdshfkdshfkdshkfhdskhkshfksdhfkdshfkdshfksdskhfkdsh"
			+ "fkdshkfhdskhfkdshfkdshfkdshfkdshfkdshfkdshkfdshfkdshfkdshfkdshkdsf";
	
	@Test
	public void validateContactUsBrand() {
		// Good - value length within the limit 255
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setBrand("Magnum");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 255
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setBrand("Knorrrrrrrrrrrvkjdhdjkfhdjkafhdkashfkdshakdjhvkjdsahvkjdshkvjsdhkjdshkfjahkdjfhdaksjjadssdckjxbckjasdcbkjabckjadsbckdjabcvkjdasbvkdjsvbkdjsbvjkdsabvkdsdksjavdkjsvkdsbvjkdsbkjvbdsjkvbdkjsbvdjksbvjkdsbvjkdsbvkdjsbvdksbvdskvbkdsvbkdsvbsdkbvdskvbksdvbkdskdsbvkdsvbksdbvksdv");

		assertFalse(contactUsRecord.isValid());
	}

	@Test
	public void validateContactUsCampaign() {
		// Good - value length within the limit 255
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setCampaign("Marketing");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 255
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setCampaign(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}

	@Test
	public void validateContactUsMicroSiteId() {
		// Good - value length within the limit 255
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setMicroSiteId("MicroSiteId");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 255
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setMicroSiteId(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}

	@Test
	public void validateContactUsProductionCode() {
		// Good - value length within the limit 20
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setProdcutionCode("B72592520220");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 20
		contactUsRecord = new ContactUsRecord();
		String prodcutionCodeBeyondLimit = "B983475345034043094304048034";
		contactUsRecord.setProdcutionCode(prodcutionCodeBeyondLimit);

		assertFalse(contactUsRecord.isValid());
	}

	@Test
	public void validateContactUsCorporateValue() {
		// Good - value length within the limit 255
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setCorporate("B72592520220");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 255
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setCorporate(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}

	@Test
	public void validateContactUsExpiryDateValue() {
		// Good - value format dd/MM/yyyy
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactUsExpiryDate("20/05/2015");

		assertTrue(contactUsRecord.isValid());

		// Bad - value format not dd/MM/yyyy
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactUsExpiryDate("06/2016");

		assertFalse(contactUsRecord.isValid());
		
		// Bad - value format not dd/MM/yyyy
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactUsExpiryDate("16/05/16");

		assertFalse(contactUsRecord.isValid());
	}

	@Test
	public void validateContactUsPurchaseDateValue() {
		// Good - value format yyyy/MM/dd
		ContactUsRecord contactUsRecord1 = new ContactUsRecord();
		contactUsRecord1.setContactUsDatePurchased("2015/02/14");

		assertTrue(contactUsRecord1.isValid());

		// Bad - value format not yyyy/MM/dd
		contactUsRecord1 = new ContactUsRecord();
		contactUsRecord1.setContactUsDatePurchased("NA");

		assertFalse(contactUsRecord1.isValid());
		
		// Bad - value format not yyyy/MM/dd
		contactUsRecord1 = new ContactUsRecord();
		contactUsRecord1.setContactUsDatePurchased("15/05/16");

		assertFalse(contactUsRecord1.isValid());
	}

	// Contact mapped fields validation test
	
	@Test
	public void validateContactEmailValue() {
		// Good - value length within the limit 80
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactEmail("john.doe@gmail.com");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 80
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactEmail(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactHonorificPrefixValue() {
		// Good - value length within the limit 40
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactHonorificPrefix("Mr");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 40
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactHonorificPrefix(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactCountryValue() {
		// Good - value length within the limit 80
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactCountry("Zambia");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 80
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactCountry(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactGivenNameValue() {
		// Good - value length within the limit 40
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactGivenName("David");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 40
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactGivenName(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactFamilyNameValue() {
		// Good - value length within the limit 80
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactFamilyName("Bernanke");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 80
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactFamilyName(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactStreetAddressValue() {
		// Good - value length within the limit 255
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactStreetAddress1("Unilever House");
		contactUsRecord.setContactStreetAddress2("Springfield Drive");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 255
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactStreetAddress1("Unilever House");
		contactUsRecord.setContactStreetAddress2(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactLocalityValue() {
		// Good - value length within the limit 40
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactLocality("London");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 40
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactLocality(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactRegionValue() {
		// Good - value length within the limit 40
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactRegion("Surrey");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 40
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactRegion(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactPostalCodeValue() {
		// Good - value length within the limit 20
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactPostalCode("KT1 4ER");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 20
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactPostalCode(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactLanguagePrefValue() {
		// Good - value length within the limit 255
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactLanguagePref("English");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 255
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactLanguagePref(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void validateContactPrimaryPhoneNumberValue() {
		// Good - value length within the limit 40
		ContactUsRecord contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactPrimaryPhoneNumber("02085607676");

		assertTrue(contactUsRecord.isValid());

		// Bad - value length not within the limit 40
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactPrimaryPhoneNumber(ratherUnusualLargeString);

		assertFalse(contactUsRecord.isValid());
	}
	
	@Test
	public void uuidLengthTest(){
		System.out.println(UUID.randomUUID().toString().length());
		System.out.println("74d61a72-2577-4673-9d5b-9f75fbc724745".length());
	}
	
	@Test
	public void shouldSayContactDataInvalidWhenAnyErrorIdentifiedRelatedToAccountObject(){
		ContactUsRecord contactUsRecord = new ContactUsRecord();

		// Bad - value length not within the limit 80
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactPostalCode(ratherUnusualLargeString);

		contactUsRecord.isValid();
		assertFalse(contactUsRecord.isContactDataValid());
	}
	
	@Test
	public void shouldSayContactDataInvalidWhenLengthyEmailProvided(){
		ContactUsRecord contactUsRecord = new ContactUsRecord();

		// Bad - value length not within the limit 80
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactEmail(ratherUnusualLargeString);

		contactUsRecord.isValid();
		assertFalse(contactUsRecord.isContactDataValidForExistingAccount());
	}
	
	@Test
	public void shouldSayContactDataInvalidWhenLengthyLastNameProvided(){
		ContactUsRecord contactUsRecord = new ContactUsRecord();

		// Bad - value length not within the limit 80
		contactUsRecord = new ContactUsRecord();
		contactUsRecord.setContactFamilyName(ratherUnusualLargeString);

		contactUsRecord.isValid();
		assertFalse(contactUsRecord.isContactDataValidForExistingAccount());
	}
}
