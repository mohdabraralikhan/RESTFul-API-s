package org.nicecharity.application.withdrawal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.nicecharity.application.campaign.Campaign;
import org.nicecharity.application.campaign.CampaignRepository;
import org.nicecharity.application.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {

    @Autowired
    private CampaignRepository campaignRepository;  // Assuming a CampaignRepository exists
    @Autowired
    private WithdrawalRepository withdrawalRepository;  // Assuming a WithdrawalRequestRepository exists

    public void submitWithdrawalRequest(Long campaignId, LocalDateTime requestDate, BigDecimal requestAmount, WithdrawalStatus status) {
        Campaign campaign = campaignRepository.findById(campaignId).orElse(null);
        if (campaign != null) {
            Withdrawal request = new Withdrawal(campaignId,requestDate,requestAmount, status);
            withdrawalRepository.save(request);
            // Additional logic for handling request submission (e.g., notifications)
        } else {
            // Handle invalid campaign scenario
        }
    }

    public Campaign createWithdrawalRequest(Withdrawal request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createWithdrawalRequest'");
    }

    // Additional methods for managing withdrawal requests (e.g., approving/rejecting requests)
}
