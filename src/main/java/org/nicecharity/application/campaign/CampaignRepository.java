package org.nicecharity.application.campaign;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findAllByStatus(CampaignStatus status);
    Optional<Campaign> findAllById(Long campaignId);
}
