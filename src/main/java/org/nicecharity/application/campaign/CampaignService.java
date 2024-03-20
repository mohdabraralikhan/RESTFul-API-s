package org.nicecharity.application.campaign;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public List<Campaign> getAllActiveCampaigns() {
        return campaignRepository.findAllByStatus(CampaignStatus.ACTIVE);
    }

    public Campaign createCampaign(Campaign campaign) {
        // Business logic for campaign creation (e.g., validation)
        return campaignRepository.save(campaign);
    }

    public Optional<Campaign> findById(Long campaignId) {
        return campaignRepository.findById(campaignId);
    }

    public List<Campaign> findAll() {
       return campaignRepository.findAll();
    }

    // Additional methods for managing campaigns (e.g., viewing details, updating status)
}

