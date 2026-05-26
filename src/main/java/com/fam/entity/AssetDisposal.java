package com.fam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Component
@Table(name = "saleorretirement", schema = "public")
public class AssetDisposal implements java.io.Serializable {

	@Id
	@SequenceGenerator(name = "saleorretirement_sequence_generator", sequenceName = "saleorretirement_recordid_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saleorretirement_sequence_generator")
	private Long recordid;

}
