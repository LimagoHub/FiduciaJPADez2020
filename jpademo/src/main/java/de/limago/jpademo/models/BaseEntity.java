package de.limago.jpademo.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@MappedSuperclass
public class BaseEntity {
	@EqualsAndHashCode.Exclude
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Version
	private int version;
	
	@PrePersist
	public void prePersist() {
		id = UUID.randomUUID().toString();
	}
	@PreUpdate
	public void preUpdate() {
		System.out.println("PreUpdate");
	}
	@PostRemove
	public void postRemove() {
		System.out.println("PostRemove");
	}
}
