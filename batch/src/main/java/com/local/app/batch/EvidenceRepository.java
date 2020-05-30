package com.local.app.batch;

import org.springframework.data.repository.CrudRepository;

import com.local.app.data.Evidence;
import com.local.app.data.EvidenceDetail;

public interface EvidenceRepository extends CrudRepository<Evidence, Long> {


}
