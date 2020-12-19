package com.elif.rest.xml;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@Entity
@NamedQueries({ @NamedQuery(name = "Countries.findAll", query = "select o from Countries o") })
@Table(name = "country")
@Setter
public class Countries implements Serializable {
    private static final long serialVersionUID = -347206161253066825L;
   
    @Id
    @Column(name = "COUNTRY_ID", nullable = false)
    private String countryId;
    
    
    @Column(name = "COUNTRY_NAME", length = 40)
    private String countryName;
    
    
    @Column(name = "REGION_ID")
    private BigDecimal regionId;

	
    @XmlElement
	public String getCountryId() {
		return countryId;
	}
    @XmlElement
	public String getCountryName() {
		return countryName;
	}
    @XmlElement
	public BigDecimal getRegionId() {
		return regionId;
	}

    
    
}
