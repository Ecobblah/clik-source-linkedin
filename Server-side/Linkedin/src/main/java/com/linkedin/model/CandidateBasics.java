package com.linkedin.model;

public class CandidateBasics {
	
	private String localizedLastName;
	LastName LastNameObject;
	FirstName FirstNameObject;
	ProfilePicture ProfilePictureObject;
	private String id;
	private String localizedFirstName;

	 // Getter Methods 

	  public String getLocalizedLastName() {
	    return localizedLastName;
	  }

	  public LastName getLastName() {
	    return LastNameObject;
	  }

	  public FirstName getFirstName() {
	    return FirstNameObject;
	  }

	  public ProfilePicture getProfilePicture() {
	    return ProfilePictureObject;
	  }

	  public String getId() {
	    return id;
	  }

	  public String getLocalizedFirstName() {
	    return localizedFirstName;
	  }

	 // Setter Methods 

	  public void setLocalizedLastName( String localizedLastName ) {
	    this.localizedLastName = localizedLastName;
	  }

	  public void setLastName( LastName lastNameObject ) {
	    this.LastNameObject = lastNameObject;
	  }

	  public void setFirstName( FirstName firstNameObject ) {
	    this.FirstNameObject = firstNameObject;
	  }

	  public void setProfilePicture( ProfilePicture profilePictureObject ) {
	    this.ProfilePictureObject = profilePictureObject;
	  }

	  public void setId( String id ) {
	    this.id = id;
	  }

	  public void setLocalizedFirstName( String localizedFirstName ) {
	    this.localizedFirstName = localizedFirstName;
	  }

	@Override
	public String toString() {
		return "CandidateBasics [localizedLastName=" + localizedLastName + ", LastNameObject=" + LastNameObject
				+ ", FirstNameObject=" + FirstNameObject + ", ProfilePictureObject=" + ProfilePictureObject + ", id="
				+ id + ", localizedFirstName=" + localizedFirstName + "]";
	}
	  
}
