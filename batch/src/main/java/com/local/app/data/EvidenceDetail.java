package com.local.app.data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "EVIDENCE_DETAIL")
public class EvidenceDetail{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long  OUTPUT_DETAIL_ID ;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "output_id", nullable = false)
private Evidence  evidence ;

private String KEY_X;
private String VALUE_X ;


protected EvidenceDetail() {}

public EvidenceDetail( Evidence  evidence, String KEY, String VALUE) {  
    this.evidence = evidence;
    this.KEY_X=KEY;
    this.VALUE_X =VALUE ;
}

public long getOUTPUT_DETAIL_ID() {
	return OUTPUT_DETAIL_ID;
}

public Evidence getEvidence() {
	return evidence;
}

public String getKEY() {
	return KEY_X;
}

public String getVALUE() {
	return VALUE_X;
}





}
