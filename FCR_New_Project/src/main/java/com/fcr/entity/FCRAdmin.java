package com.fcr.entity;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "fcr_admin_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FCRAdmin {
	@Id
	@Column(name = "SL_NO")
	private Long id;
	@Column(name = "DIVISION")
	private String division;
	@Column(name = "GROUPNAME")
	private String groupname;

}
