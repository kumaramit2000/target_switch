package com.db.RBA;

import com.db.RBA.models.CreditDecisionRequest;
import com.db.RBA.models.CreditDecisionResponse;

public interface CreditDecisionProcessor {

    CreditDecisionResponse executeRules(CreditDecisionRequest creditDecisionRequest);
}
