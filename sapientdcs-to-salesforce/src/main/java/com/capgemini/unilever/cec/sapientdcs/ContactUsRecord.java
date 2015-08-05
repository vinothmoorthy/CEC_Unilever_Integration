package com.capgemini.unilever.cec.sapientdcs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * This class is represents a Contact Us record retrieved from the Sapient DCS
 * service.
 * 
 * The Json data obtained from the service is mapped to this object using the
 * Mule Datamapper in order for this class to provide convenient validation
 * routines.
 * 
 * The member variables are all related and named after a property from the
 * 'Contact Us entity schema'. Whilst the class provides a variable for most
 * properties, not all properties are validated, only those mapped to
 * Salesforce.
 * 
 * Member variable naming convention is the Json schema path to to the property
 * and the property name in camelcase.
 * 
 * @author Ben Sales - Capgemini UK plc
 */
public class ContactUsRecord implements Serializable {

	private static final long serialVersionUID = -6571894194130828582L;

	/** Brand the contact us form is for */
	String brand;

	/** Sapient contactus campaign */
	String campaign;

	/** Sapient contactus micro site id */
	String microSiteId;

	/** Sapient contactus production code */
	String prodcutionCode;

	/** Sapient contactus corporate */
	String corporate;

	/** Category may be 'beauty' or 'food'. Not required, so may be empty. */
	String category;

	/** Contact's age. Not required, so may be empty. */
	String contactAge;

	/**
	 * Contact's birthday. Not required, so may be null. Json schema should
	 * format this as a date, but not to be relied upon.
	 */
	String contactBirthday;

	/** Contact's postal country. Not required, so may be empty */
	String contactCountry;

	/**
	 * Contact's email. Required, so should be present, but not be be relied on.
	 * Schema enforces email format validation, but not to be relied on.
	 */
	String contactEmail;

	/**
	 * Contact's family name. Required, so should not be null. Schema enforces a
	 * length of between 2 and 50 characters, but not to be relied upon.
	 */
	String contactFamilyName;

	/**
	 * Contact's gender. May be 'M', 'F', or null. Not required, so may be
	 * empty.
	 */
	String contactGender;

	/**
	 * Contact's given name. Required, so should not be null. Schema enforces a
	 * length of between 2 and 50 characters, but not to be relied upon.
	 */
	String contactGivenName;

	/**
	 * Contact's honourific (title... Mr, Mrs, etc). Not required, so may be
	 * empty
	 */
	String contactHonorificPrefix;

	/** Contact's language. Not required, so may be empty */
	String contactLanguagePref;

	/**
	 * Contact's confirmation of being of legal age. Not required, so may be
	 * empty. Should be a boolean value if provided, but cannot be relied on.
	 */
	String contactLegalAgeConfirmation;

	/**
	 * Contact's postal locality. Not required, so may be empty. Schema enforces
	 * a length of no more than 50 characters, but not to be relied upon.
	 */
	String contactLocality;

	/** Contact's marital status. Not required, so may be empty */
	String contactMaritalStatus;

	/** Contact's postal code. Not required, so may be empty. */
	String contactPostalCode;

	/**
	 * Contact's primary telephone number. Not required, so may be null.
	 * Obtained from the 'value' property of the 'phoneNumber' property.
	 * Determined by the 'type' property of 'primary'
	 */
	String contactPrimaryPhoneNumber;

	/**
	 * Contact's primary telephone number extension. Not required, so may be
	 * null. Determined by the 'ext' property of 'primary'
	 */
	String contactPrimaryPhoneNumberExt;

	/**
	 * Contact's region. Not required, so may be empty. Schema enforces a length
	 * of exactly 2 characters, but not to be relied upon.
	 */
	String contactRegion;

	/**
	 * Contact's secondary telephone number. Not required, so may be null.
	 * Obtained from the 'value' property of the 'phoneNumber' property.
	 * Determined by the 'type' property of 'secondary'
	 */
	String contactSecondaryPhoneNumber;

	/**
	 * Contact's secondary telephone number extension. Not required, so may be
	 * null. Determined by the 'ext' property of 'primary'
	 */
	String contactSecondaryPhoneNumberExt;

	/**
	 * Contact's postal address line 1. Not required, so may be empty. Schema
	 * enforces a length of between 2 and 50 characters, but not to be relied
	 * upon.
	 */
	String contactStreetAddress1;

	/**
	 * Contact's postal address line 2. Not required, so may be empty. Schema
	 * enforces a length of between 2 and 50 characters, but not to be relied
	 * upon.
	 */
	String contactStreetAddress2;

	/**
	 * Contact's postal address line 3. Not required, so may be empty. Schema
	 * enforces a length of between 2 and 50 characters, but not to be relied
	 * upon.
	 */
	String contactStreetAddress3;

	/**
	 * Contact's type. May be either 'individual' or 'household'. Not required,
	 * so may be null.
	 */
	String contactType;

	/**
	 * Contact Us brand. Required, so should not be empty, but not be be relied
	 * on.
	 */
	String contactUsBrand;

	/** Contact Us comments. Required, but not be relied on. */
	String contactUsComments;

	/**
	 * Contact Us type. Will be either '1', '2', '3', '4', or null. Not
	 * required, so may be null
	 */
	String contactUsContactType;

	/**
	 * Contact us product date purchased. Not required, so may be empty. Schema
	 * type is date, but no formatting enforced so not to be relied on.
	 */
	String contactUsDatePurchased;

	/** Contact's username. Not required, so may be null */
	String contactUsername;

	/**
	 * Contact us product expiry date. Not required, so may be empty. Schema
	 * type is date, but no formatting enforced so not to be relied on. Schema
	 * defines a limit of 50 characters, but not to be relied on.
	 */
	String contactUsExpiryDate;

	/**
	 * Contact us form date time. Not required, so may be empty. Schema type is
	 * date, but no formatting enforced so not to be relied on.
	 */
	Boolean contactUsFormDateTime;

	/**
	 * Contact Us enquiry type. May be 'Product Question', 'Product Concern'.
	 * Not required, so may be null.
	 */
	String contactUsInquiryType;

	/** Contact Us manufacturing code. Not required, so may be empty. */
	String contactUsManufacturingCode;

	/**
	 * Contact Us manufacturing code detail. May be 'Full', 'Partial', 'Not
	 * Legible', 'Not Available', or null. Not required, so may be empty.
	 */
	String contactUsManufacturingCodeDetail;

	/**
	 * Contact us privacy. Not required, so will default to false as schema
	 * defines a boolean value.
	 */
	Boolean contactUsPrivacy = Boolean.FALSE;

	/** Contact Us product. Not required, so may be empty. */
	String contactUsProduct;

	/** Contact us product size. Not required, so may be empty */
	String contactUsSize;

	/**
	 * Contact Us store name product purchased from. Not required, so may be
	 * empty.
	 */
	String contactUsStoreNamePurchasedFrom;

	/** Contact Us subject. Not required, so may be null. */
	String contactUsSubject;

	/**
	 * Contact Us town name product purchased in. Not required, so may be empty.
	 */
	String contactUsTownPurchasedFrom;

	/**
	 * Contact Us UPC Code. Not required, so may be null. Schema limits to 50
	 * characters, but not to be relied on.
	 */
	String contactUsUpcCode;

	/**
	 * Contact Us UPC Code Detail. May be 'Full', 'Not Available', or null. Not
	 * required, so may be empty.
	 */
	String contactUsUpcCodeDetail;

	/** Entity which will default to 'contactus_eu' */
	String entity;

	/** Locale the contact us form has come from */
	String locale;

	/**
	 * OptIn to brand. Not required, so maybe null and therefore defaults to
	 * false
	 */
	Boolean optInBrand = Boolean.FALSE;

	/**
	 * OptIn to corporate. Not required, so maybe null and therefore defaults to
	 * false
	 */
	Boolean optInCorporate = Boolean.FALSE;

	/**
	 * OptIn to all mail. Not required, so maybe null and therefore defaults to
	 * false
	 */
	Boolean optInMailAll = Boolean.FALSE;

	/**
	 * OptIn to mail brand. Not required, so maybe null and therefore defaults
	 * to false
	 */
	Boolean optInMailBrand = Boolean.FALSE;

	/**
	 * OptIn to brand. Not required, so maybe null and therefore defaults to
	 * false
	 */
	Boolean optInMailHelp = Boolean.FALSE;

	/**
	 * OptIn to all online. Not required, so maybe null and therefore defaults
	 * to false
	 */
	Boolean optInOnlineAll = Boolean.FALSE;

	/**
	 * OptIn to onine brand. Not required, so maybe null and therefore defaults
	 * to false
	 */
	Boolean optInOnlineBrand = Boolean.FALSE;

	/**
	 * OptIn to SMS help. Not required, so maybe null and therefore defaults to
	 * false
	 */
	Boolean optInS = Boolean.FALSE;

	/**
	 * OptIn to all SMS. Not required, so maybe null and therefore defaults to
	 * false
	 */
	Boolean optInSmsAll = Boolean.FALSE;

	/**
	 * OptIn to SMS brand. Not required, so maybe null and therefore defaults to
	 * false
	 */
	Boolean optInSmsBrand = Boolean.FALSE;
	
	/**
	 * NOT USED yet for validation
	 */
	Boolean optInConsentComplain = Boolean.FALSE;
	
	/**
	 * NOT USED yet for validation
	 */
	Boolean optInConsentMarketing = Boolean.FALSE;

	/** List of messages provided by the isValid method */
	List<String> validationMessages = new ArrayList<String>();

	/**
	 * This method implements validation upon the data received from the Sapient
	 * DCS record and used to populate the global variables. The data is
	 * validated against the requirements of the Salesforce system to ensure
	 * that it can be mapped into the Salesforce system. If any field cannot be
	 * mapped, then a message is added to the 'validationMessages' List, and the
	 * method will return 'false'.
	 * 
	 * If all the data can be mapped into Salesforce, then the method will
	 * return 'true'.
	 * 
	 * Examples of validation are: - Ensure that fields required by Salesforce
	 * are not null in the source data. - Ensure that source data field lengths
	 * do not exceed Salesforce data field lengths - Ensure that dates provided
	 * in the source data can be parsed into required Salesforce date formats.
	 * 
	 * @return boolean true if the source data can be mapped directly to
	 *         Salesforce, false otherwise.
	 */
	public boolean isValid() {
		/**
		 * CASE mapping Mapped fields except description and
		 * IDs(country,owner,contact, sapient_dcs_id and account) Brand__c <=
		 * 255 campaign <= 255 micro-site <= 255 expiry_date = format dd/MM/yyyy
		 * production_code__c <= 20 purchase_date = format yyyy/MM/dd
		 * corporate__c <= 255
		 */
		if (getBrand() != null && getBrand().length() > 255)
			validationMessages
					.add("Contactus Brand length is beyond the limit of Brand__c field of Salesforce Case Object\n");
		if (getCampaign() != null && getCampaign().length() > 255)
			validationMessages
					.add("Contactus campaign length is beyond the limit of Sapient_campaign__c field of Salesforce Case Object\n");
		if (getMicroSiteId() != null && getMicroSiteId().length() > 255)
			validationMessages
					.add("Contactus MicroSiteId length is beyond the limit of Sapient_Micro_site_id__c field of Salesforce Case Object\n");
		if (getProdcutionCode() != null && getProdcutionCode().length() > 20)
			validationMessages
					.add("Contactus ProdctionCode length is beyond the limit of Production_Code__c field of Salesforce Case Object\n");
		if (getCorporate() != null && getCorporate().length() > 255)
			validationMessages
					.add("Contactus Corporate length is beyond the limit of Sapient_Corporate__c field of Salesforce Case Object\n");

		try {
			if (getContactUsExpiryDate() != null 
					&& ! getContactUsExpiryDate().isEmpty()
					) {
				if(getContactUsExpiryDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
					DateTimeFormatter formatter = DateTimeFormat
						.forPattern("dd/MM/yyyy");
					formatter.parseDateTime(getContactUsExpiryDate());
					// all good
				} else {
					validationMessages
					.add("Contactus expiry date is not of dd/MM/yyyy to be converted to a date object for field Expiry_date__c of Salesforce Case Object\n");
				}
			}
		} catch (Exception e) {
			// date format wrong, this will create unpareable date exception
			validationMessages
					.add("Contactus expiry date is not of dd/MM/yyyy to be converted to a date object for field Expiry_date__c of Salesforce Case Object\n");
		}

		try {
			if (getContactUsDatePurchased() != null 
					&& ! getContactUsDatePurchased().isEmpty()
					) {
				if( getContactUsDatePurchased().matches("([0-9]{4})/([0-9]{2})/([0-9]{2})")){
					DateTimeFormatter formatter = DateTimeFormat
							.forPattern("yyyy/MM/dd");
					formatter.parseDateTime(getContactUsDatePurchased());
					// all good
				} else {
					// date format wrong, this will create unpareable date exception
					validationMessages
							.add("Contactus purchased date is not of yyyy/MM/dd to be converted to a date object for field Purchase_date__c of Salesforce Case Object\n");
				}
		}
		} catch (Exception e) {
			// date format wrong, this will create unpareable date exception
			validationMessages
					.add("Contactus purchased date is not of yyyy/MM/dd to be converted to a date object for field Purchase_date__c of Salesforce Case Object\n");
		}

		/**
		 * Account Mapping Mapped fields except ownerId, email <= 80, salutation
		 * <= 40, country <= 80, Givenname - firstname <= 40, familyname - lastname
		 * <= 80, streetAddress1 & streeAddress2 <= 255, locality <= 40, region <=
		 * 40, postalcode <= 20, languagePref <= 255, phone <= 40
		 */
		if (getContactEmail() != null && getContactEmail().length() > 80)
			validationMessages
					.add("Contact email length is beyond the limit of PersonEmail field of Salesforce Account Object\n");
		if (getContactHonorificPrefix() != null
				&& getContactHonorificPrefix().length() > 40)
			validationMessages
					.add("Contact HonorificPrefix length is beyond the limit of Salutation field of Salesforce Account Object\n");
		if (getContactCountry() != null && getContactCountry().length() > 80)
			validationMessages
					.add("Contact Country length is beyond the limit of PersonMailingCountry field of Salesforce Account Object\n");
		if (getContactGivenName() != null
				&& getContactGivenName().length() > 40)
			validationMessages
					.add("Contact GivenName length is beyond the limit of FirstName field of Salesforce Account Object\n");
		if (getContactFamilyName() != null
				&& getContactFamilyName().length() > 80)
			validationMessages
					.add("Contact familyName length is beyond the limit of LastName field of Salesforce Account Object\n");
		if (getContactStreetAddress1() != null
				&& getContactStreetAddress2() != null
				&& (getContactStreetAddress1().concat(",")
						.concat(getContactStreetAddress2())).length() > 255)
			validationMessages
					.add("Contact StreetAddress1 and StreetAddress2 combined length is beyond the limit of PersonMailingStreet field of Salesforce Account Object\n");
		if (getContactLocality() != null && getContactLocality().length() > 40)
			validationMessages
					.add("Contact locality length is beyond the limit of PersonMailingCity field of Salesforce Account Object\n");
		if (getContactRegion() != null && getContactRegion().length() > 40)
			validationMessages
					.add("Contact Region length is beyond the limit of PersonMailingState field of Salesforce Account Object\n");
		if (getContactPostalCode() != null
				&& getContactPostalCode().length() > 20)
			validationMessages
					.add("Contact postalcode length is beyond the limit of PersonMailingPostcode field of Salesforce Account Object\n");
		if (getContactLanguagePref() != null
				&& getContactLanguagePref().length() > 255)
			validationMessages
					.add("Contact LanguagePref length is beyond the limit of Sapient_Language_preference__pc field of Salesforce Account Object\n");
		if (getContactPrimaryPhoneNumber() != null
				&& getContactPrimaryPhoneNumber().length() > 40)
			validationMessages
					.add("Contact phone length is beyond the limit of phone field of Salesforce Account Object\n");

		// valiate any errors found
		if (validationMessages.size() == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * validation logic to decide whether to attempt find existing account 
	 * when validation errors occured during initial validation
	 * 
	 * @return
	 */
	public boolean isContactDataValid(){
		try {
			if(getValidationMessages().size() > 0 &&  Iterables.find(getValidationMessages(), new Predicate<String>() {
				public boolean apply(String msg) { return msg.contains("Account Object");}
			}) != null)
				return false;
		} catch (NoSuchElementException e) {
			return true;
		}
		return true;
	}
	
	/**
	 * validation logic to decide whether to attempt find existing account 
	 * when validation errors occured during initial validation
	 * 
	 * @return
	 */
	public boolean isContactDataValidForExistingAccount(){
		try {
			if(getValidationMessages().size() > 0 &&  Iterables.find(getValidationMessages(), new Predicate<String>() {
				public boolean apply(String msg) { return msg.contains("PersonEmail") || msg.contains("LastName");}
			}) != null)
				return false;
		} catch (NoSuchElementException e) {
			return true;
		}
		return true;
	}

	public String getBrand() {
		return brand;
	}

	public String getCategory() {
		return category;
	}

	public String getContactAge() {
		return contactAge;
	}

	public String getContactBirthday() {
		return contactBirthday;
	}

	public String getContactCountry() {
		return contactCountry;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getContactGender() {
		return contactGender;
	}

	public String getContactGivenName() {
		return contactGivenName;
	}

	public String getContactHonorificPrefix() {
		return contactHonorificPrefix;
	}

	public String getContactLanguagePref() {
		return contactLanguagePref;
	}

	public String getContactLegalAgeConfirmation() {
		return contactLegalAgeConfirmation;
	}

	public String getContactLocality() {
		return contactLocality;
	}

	public String getContactMaritalStatus() {
		return contactMaritalStatus;
	}

	public String getContactPostalCode() {
		return contactPostalCode;
	}

	public String getContactPrimaryPhoneNumber() {
		return contactPrimaryPhoneNumber;
	}

	public String getContactPrimaryPhoneNumberExt() {
		return contactPrimaryPhoneNumberExt;
	}

	public String getContactRegion() {
		return contactRegion;
	}

	public String getContactSecondaryPhoneNumber() {
		return contactSecondaryPhoneNumber;
	}

	public String getContactSecondaryPhoneNumberExt() {
		return contactSecondaryPhoneNumberExt;
	}

	public String getContactStreetAddress1() {
		return contactStreetAddress1;
	}

	public String getContactStreetAddress2() {
		return contactStreetAddress2;
	}

	public String getContactStreetAddress3() {
		return contactStreetAddress3;
	}

	public String getContactType() {
		return contactType;
	}

	public String getContactUsBrand() {
		return contactUsBrand;
	}

	public String getContactUsComments() {
		return contactUsComments;
	}

	public String getContactUsContactType() {
		return contactUsContactType;
	}

	public String getContactUsDatePurchased() {
		return contactUsDatePurchased;
	}

	public String getContactUsername() {
		return contactUsername;
	}

	public String getContactUsExpiryDate() {
		return contactUsExpiryDate;
	}

	public Boolean getContactUsFormDateTime() {
		return contactUsFormDateTime;
	}

	public String getContactUsInquiryType() {
		return contactUsInquiryType;
	}

	public String getContactUsManufacturingCode() {
		return contactUsManufacturingCode;
	}

	public String getContactUsManufacturingCodeDetail() {
		return contactUsManufacturingCodeDetail;
	}

	public Boolean getContactUsPrivacy() {
		return contactUsPrivacy;
	}

	public String getContactUsProduct() {
		return contactUsProduct;
	}

	public String getContactUsSize() {
		return contactUsSize;
	}

	public String getContactUsStoreNamePurchasedFrom() {
		return contactUsStoreNamePurchasedFrom;
	}

	public String getContactUsSubject() {
		return contactUsSubject;
	}

	public String getContactUsTownPurchasedFrom() {
		return contactUsTownPurchasedFrom;
	}

	public String getContactUsUpcCode() {
		return contactUsUpcCode;
	}

	public String getContactUsUpcCodeDetail() {
		return contactUsUpcCodeDetail;
	}

	public String getEntity() {
		return entity;
	}

	public String getLocale() {
		return locale;
	}

	public Boolean getOptInBrand() {
		return optInBrand;
	}

	public Boolean getOptInCorporate() {
		return optInCorporate;
	}

	public Boolean getOptInMailAll() {
		return optInMailAll;
	}

	public Boolean getOptInMailBrand() {
		return optInMailBrand;
	}

	public Boolean getOptInMailHelp() {
		return optInMailHelp;
	}

	public Boolean getOptInOnlineAll() {
		return optInOnlineAll;
	}

	public Boolean getOptInOnlineBrand() {
		return optInOnlineBrand;
	}

	public Boolean getOptInS() {
		return optInS;
	}

	public Boolean getOptInSmsAll() {
		return optInSmsAll;
	}

	public Boolean getOptInSmsBrand() {
		return optInSmsBrand;
	}

	public List<String> getValidationMessages() {
		return validationMessages;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setContactAge(String contactAge) {
		this.contactAge = contactAge;
	}

	public void setContactBirthday(String contactBirthday) {
		this.contactBirthday = contactBirthday;
	}

	public void setContactCountry(String contactCountry) {
		this.contactCountry = contactCountry;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public void setContactGender(String contactGender) {
		this.contactGender = contactGender;
	}

	public void setContactGivenName(String contactGivenName) {
		this.contactGivenName = contactGivenName;
	}

	public void setContactHonorificPrefix(String contactHonorificPrefix) {
		this.contactHonorificPrefix = contactHonorificPrefix;
	}

	public void setContactLanguagePref(String contactLanguagePref) {
		this.contactLanguagePref = contactLanguagePref;
	}

	public void setContactLegalAgeConfirmation(
			String contactLegalAgeConfirmation) {
		this.contactLegalAgeConfirmation = contactLegalAgeConfirmation;
	}

	public void setContactLocality(String contactLocality) {
		this.contactLocality = contactLocality;
	}

	public void setContactMaritalStatus(String contactMaritalStatus) {
		this.contactMaritalStatus = contactMaritalStatus;
	}

	public void setContactPostalCode(String contactPostalCode) {
		this.contactPostalCode = contactPostalCode;
	}

	public void setContactPrimaryPhoneNumber(String contactPrimaryPhoneNumber) {
		this.contactPrimaryPhoneNumber = contactPrimaryPhoneNumber;
	}

	public void setContactPrimaryPhoneNumberExt(
			String contactPrimaryPhoneNumberExt) {
		this.contactPrimaryPhoneNumberExt = contactPrimaryPhoneNumberExt;
	}

	public void setContactRegion(String contactRegion) {
		this.contactRegion = contactRegion;
	}

	public void setContactSecondaryPhoneNumber(
			String contactSecondaryPhoneNumber) {
		this.contactSecondaryPhoneNumber = contactSecondaryPhoneNumber;
	}

	public void setContactSecondaryPhoneNumberExt(
			String contactSecondaryPhoneNumberExt) {
		this.contactSecondaryPhoneNumberExt = contactSecondaryPhoneNumberExt;
	}

	public void setContactStreetAddress1(String contactStreetAddress1) {
		this.contactStreetAddress1 = contactStreetAddress1;
	}

	public void setContactStreetAddress2(String contactStreetAddress2) {
		this.contactStreetAddress2 = contactStreetAddress2;
	}

	public void setContactStreetAddress3(String contactStreetAddress3) {
		this.contactStreetAddress3 = contactStreetAddress3;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public void setContactUsBrand(String contactUsBrand) {
		this.contactUsBrand = contactUsBrand;
	}

	public void setContactUsComments(String contactUsComments) {
		this.contactUsComments = contactUsComments;
	}

	public void setContactUsContactType(String contactUsContactType) {
		this.contactUsContactType = contactUsContactType;
	}

	public void setContactUsDatePurchased(String contactUsDatePurchased) {
		this.contactUsDatePurchased = contactUsDatePurchased;
	}

	public void setContactUsername(String contactUsername) {
		this.contactUsername = contactUsername;
	}

	public void setContactUsExpiryDate(String contactUsExpiryDate) {
		this.contactUsExpiryDate = contactUsExpiryDate;
	}

	public void setContactUsFormDateTime(Boolean contactUsFormDateTime) {
		this.contactUsFormDateTime = contactUsFormDateTime;
	}

	public void setContactUsInquiryType(String contactUsInquiryType) {
		this.contactUsInquiryType = contactUsInquiryType;
	}

	public void setContactUsManufacturingCode(String contactUsManufacturingCode) {
		this.contactUsManufacturingCode = contactUsManufacturingCode;
	}

	public void setContactUsManufacturingCodeDetail(
			String contactUsManufacturingCodeDetail) {
		this.contactUsManufacturingCodeDetail = contactUsManufacturingCodeDetail;
	}

	public void setContactUsPrivacy(Boolean contactUsPrivacy) {
		this.contactUsPrivacy = contactUsPrivacy;
	}

	public void setContactUsProduct(String contactUsProduct) {
		this.contactUsProduct = contactUsProduct;
	}

	public void setContactUsSize(String contactUsSize) {
		this.contactUsSize = contactUsSize;
	}

	public void setContactUsStoreNamePurchasedFrom(
			String contactUsStoreNamePurchasedFrom) {
		this.contactUsStoreNamePurchasedFrom = contactUsStoreNamePurchasedFrom;
	}

	public void setContactUsSubject(String contactUsSubject) {
		this.contactUsSubject = contactUsSubject;
	}

	public void setContactUsTownPurchasedFrom(String contactUsTownPurchasedFrom) {
		this.contactUsTownPurchasedFrom = contactUsTownPurchasedFrom;
	}

	public void setContactUsUpcCode(String contactUsUpcCode) {
		this.contactUsUpcCode = contactUsUpcCode;
	}

	public void setContactUsUpcCodeDetail(String contactUsUpcCodeDetail) {
		this.contactUsUpcCodeDetail = contactUsUpcCodeDetail;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setOptInBrand(Boolean optInBrand) {
		this.optInBrand = optInBrand;
	}

	public void setOptInCorporate(Boolean optInCorporate) {
		this.optInCorporate = optInCorporate;
	}

	public void setOptInMailAll(Boolean optInMailAll) {
		this.optInMailAll = optInMailAll;
	}

	public void setOptInMailBrand(Boolean optInMailBrand) {
		this.optInMailBrand = optInMailBrand;
	}

	public void setOptInMailHelp(Boolean optInMailHelp) {
		this.optInMailHelp = optInMailHelp;
	}

	public void setOptInOnlineAll(Boolean optInOnlineAll) {
		this.optInOnlineAll = optInOnlineAll;
	}

	public void setOptInOnlineBrand(Boolean optInOnlineBrand) {
		this.optInOnlineBrand = optInOnlineBrand;
	}

	public void setOptInS(Boolean optInS) {
		this.optInS = optInS;
	}

	public void setOptInSmsAll(Boolean optInSmsAll) {
		this.optInSmsAll = optInSmsAll;
	}

	public void setOptInSmsBrand(Boolean optInSmsBrand) {
		this.optInSmsBrand = optInSmsBrand;
	}

	public void setValidationMessages(List<String> validationMessages) {
		this.validationMessages = validationMessages;
	}

	public String getCampaign() {
		return campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public String getMicroSiteId() {
		return microSiteId;
	}

	public void setMicroSiteId(String microSiteId) {
		this.microSiteId = microSiteId;
	}

	public String getProdcutionCode() {
		return prodcutionCode;
	}

	public void setProdcutionCode(String prodcutionCode) {
		this.prodcutionCode = prodcutionCode;
	}

	public String getCorporate() {
		return corporate;
	}

	public void setCorporate(String corporate) {
		this.corporate = corporate;
	}

	public String getContactFamilyName() {
		return contactFamilyName;
	}

	public void setContactFamilyName(String contactFamilyName) {
		this.contactFamilyName = contactFamilyName;
	}

	public Boolean getOptInConsentComplain() {
		return optInConsentComplain;
	}

	public void setOptInConsentComplain(Boolean optInConsentComplain) {
		this.optInConsentComplain = optInConsentComplain;
	}

	public Boolean getOptInConsentMarketing() {
		return optInConsentMarketing;
	}

	public void setOptInConsentMarketing(Boolean optInConsentMarketing) {
		this.optInConsentMarketing = optInConsentMarketing;
	}
}
