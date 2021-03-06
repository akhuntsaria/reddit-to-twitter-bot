package com.github.akhuntsaria.reddittotwitterbot.service;

import com.github.akhuntsaria.reddittotwitterbot.domain.PostHistoryEntry;
import com.github.akhuntsaria.reddittotwitterbot.repository.PostHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PostHistoryService {

    private static final Logger log = LoggerFactory.getLogger(PostHistoryService.class);

    private final PostHistoryRepository postHistoryRepository;

    public PostHistoryService(PostHistoryRepository postHistoryRepository) {
        this.postHistoryRepository = postHistoryRepository;
    }

    public boolean postHistoryEntryExists(String postFullName) {
        return postHistoryRepository.countByRedditPostFullName(postFullName) > 0;
    }

    public PostHistoryEntry save(PostHistoryEntry postHistoryEntry) {
        postHistoryEntry = postHistoryRepository.save(postHistoryEntry);

        log.debug("Save new post history entry: {}", postHistoryEntry.toString());
        return postHistoryEntry;
    }
}
