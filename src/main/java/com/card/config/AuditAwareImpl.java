package com.card.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Here we can use Spring Security to get the logged-in user
        // For now, return a default string "ACCOUNTS_MS"
        return Optional.of("ACCOUNTS_MS");
    }
}
