package com.db.RBA;

import com.db.RBA.models.CreditDecisionRequest;
import com.db.RBA.models.CreditDecisionResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditDecisionController {
    Logger logger = LoggerFactory.getLogger(CreditDecisionController.class);
    private final CreditDecisionProcessor creditDecisionProcessor;

    // @RequiredArgsConstructor can also be used.
    public CreditDecisionController(CreditDecisionProcessor creditDecisionProcessor) {
        this.creditDecisionProcessor = creditDecisionProcessor;
    }

    @PostMapping(value="/request/execute")
    public ResponseEntity<CreditDecisionResponse> executeRules(@RequestBody CreditDecisionRequest creditDecisionRequest){
        CreditDecisionResponse creditDecisionResponse = new CreditDecisionResponse();
        logger.info("Starting RBA for request : {}", creditDecisionRequest.getRequestId());
        creditDecisionProcessor.executeRules(creditDecisionRequest);
        return ResponseEntity.ok().body(creditDecisionResponse);
    }
}
