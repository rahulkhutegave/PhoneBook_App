package com.user.main.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Contact_DTLS")
public class Contact {

	@Id
	@GeneratedValue
	@Column(name = "Contact_ID")
	private Integer contactId;

	@Column(name = "Contact_Name")
	private String contactName;

	@Column(name = "Contact_Number")
	private Long contactNumber;

	@Column(name = "Contact_Email")
	private String contactEmail;

	@CreationTimestamp
	@Column(name = "Creation_Date", updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name = "Updated_Date", insertable = false)
	private LocalDate updatedDate;

	@Column(name = "Active_SW")
	private String activesw;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getActivesw() {
		return activesw;
	}

	public void setActivesw(String activesw) {
		this.activesw = activesw;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber=" + contactNumber
				+ ", contactEmail=" + contactEmail + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", activesw=" + activesw + "]";
	}

}
