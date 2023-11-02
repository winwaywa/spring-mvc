package com.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // jpa auditing
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "createdat")
	private Timestamp createdAt;

	@Column(name = "createdby")
	private String createdBy;

	@Column(name = "updatedat")
	private Timestamp updatedAt;

	@Column(name = "updatedby")
	private String updatedBy;

	@CreatedDate // jpa auditing
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	@CreatedBy // jpa auditing
	public String getCreatedBy() {
		return createdBy;
	}

	@LastModifiedDate // jpa auditing
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	@LastModifiedBy // jpa auditing
	public String getUpdatedBy() {
		return updatedBy;
	}

	public Long getId() {
		return id;
	}

}
