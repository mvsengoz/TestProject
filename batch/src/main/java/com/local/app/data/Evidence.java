package com.local.app.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "EVIDENCE")
public class Evidence{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long  OUTPUT_ID ;


private String	CTRL;
private String SRC ;
private String APP_ID;
private String STATUS;

@OneToMany(mappedBy = "evidence", fetch = FetchType.LAZY,
cascade = CascadeType.ALL)
private List<EvidenceDetail> evidenceDetails = new ArrayList<EvidenceDetail>();


protected Evidence() {}

public Evidence(String CTRL, String SRC, String APP_ID, String STATUS) {
    
	
    this.CTRL = CTRL;
    this.SRC = SRC;
    this.APP_ID=APP_ID;
    this.STATUS =STATUS ;
   
}

public long getOUTPUT_ID() {
	return OUTPUT_ID;
}

public String getCTRL() {
	return CTRL;
}

public String getSRC() {
	return SRC;
}

public String getAPP_ID() {
	return APP_ID;
}

public String getSTATUS() {
	return STATUS;
}

public List<EvidenceDetail> getEvidenceDetails() {
	return evidenceDetails;
}

public void addEvidenceDetails(EvidenceDetail evidenceDetail) {
	 evidenceDetails.add(evidenceDetail);
}




}
