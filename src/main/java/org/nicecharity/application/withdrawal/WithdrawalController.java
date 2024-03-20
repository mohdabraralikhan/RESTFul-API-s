package org.nicecharity.application.withdrawal;

import org.nicecharity.application.campaign.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/withdrawals")
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @PostMapping
    public ResponseEntity<Campaign> createWithdrawalRequest(@RequestBody Withdrawal request) {
        return ResponseEntity.ok(withdrawalService.createWithdrawalRequest(request));
    }

    // Add methods for retrieving withdrawal requests for users or campaigns
    // ...
}

