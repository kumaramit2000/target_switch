package com.db.RBA.services;

import com.db.RBA.models.CreditDecisionRequest;
import org.springframework.stereotype.Service;

@Service
public class PartyDataPopulationService {

    public void populate(CreditDecisionRequest creditDecisionRequest){
        //Business Logic Comes Here...
        /*
        private final PartyDataServiceClient partyDataServiceClient;
        Set<Integer> parties = partyDataServiceClient.getPartyRatings(ratingType,email,creditDecisionRequest);
         */
        creditDecisionRequest.setGroupCPTYDetails(null);
    }
}
