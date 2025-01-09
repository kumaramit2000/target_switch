package com.db.RBA.models;

import com.db.RBA.models.CreditDecisionRequest;
import com.db.RBA.models.CreditDecisionResponse;
import com.db.RBA.models.RuleList;
import lombok.Data;

@Data
public class LimitSummary {
    private String limitId;
    private CreditDecisionRequest creditDecisionRequestForLimit;
    private RuleList rulesSummaryForLimit;
    private CreditDecisionResponse creditDecisionResponse;
}
