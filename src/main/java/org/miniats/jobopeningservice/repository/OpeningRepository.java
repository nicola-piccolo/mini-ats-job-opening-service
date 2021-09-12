package org.miniats.jobopeningservice.repository;

import java.sql.SQLException;
import java.util.Optional;

import org.miniats.jobopeningservice.model.Opening;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;

public interface OpeningRepository extends PagingAndSortingRepository<Opening, Long> {
	@Retryable(value = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 200))
	Optional<Opening> findByUid(String uid);
	
	@Retryable(value = SQLException.class, maxAttempts = 2, backoff = @Backoff(delay = 200))
	Iterable<Opening> findAll();
}
