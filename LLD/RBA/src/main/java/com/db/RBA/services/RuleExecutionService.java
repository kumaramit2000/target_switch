package com.db.RBA.services;

import com.db.RBA.models.ExecutionSummary;
import com.db.RBA.models.Rule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleExecutionService {

    public List<ExecutionSummary> executeAllRules(List<Rule> rules, Object context){
        // Execute Engine Call
        // Business Logic Comes Here...
        List<ExecutionSummary> res = new ArrayList<>();
        return res;
    }
}
