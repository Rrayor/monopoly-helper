package com.benjaminsimon.monopoly_helper;

import java.time.Instant;
import java.util.UUID;

public final class Transaction {

    private final UUID id = UUID.randomUUID();
    private final Instant createdAt = Instant.now();

    private final IMonetaryEntity sender;
    private final IMonetaryEntity recipient;
    private final String description;

    public Transaction(IMonetaryEntity senderIn, IMonetaryEntity recipientIn, String descriptionIn) {
        this.sender = senderIn;
        this.recipient = recipientIn;
        this.description = descriptionIn;
    }

    public UUID getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public IMonetaryEntity getSender() {
        return sender;
    }

    public IMonetaryEntity getRecipient() {
        return recipient;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() + 22;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || !(obj instanceof Transaction))
            return false;

        return this.id == ((Transaction) obj).getId();
    }
}
