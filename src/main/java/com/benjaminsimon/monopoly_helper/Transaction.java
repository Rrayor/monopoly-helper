package main.java.com.benjaminsimon.monopoly_helper;

import java.time.Instant;
import java.util.UUID;

public final class Transaction {

    private final UUID id = UUID.randomUUID();
    private final Instant createdAt = Instant.now();

    private final IMonetaryEntity sender;
    private final IMonetaryEntity recipient;
    private final String description;
    private final double amount;

    private TransactionStatus status = TransactionStatus.PENDING;

    public Transaction(IMonetaryEntity senderIn, IMonetaryEntity recipientIn, String descriptionIn, double amountIn) {
        this.sender = senderIn;
        this.recipient = recipientIn;
        this.description = descriptionIn;
        this.amount = amountIn;
    }

    public void run() {
        final boolean senderPayed = this.sender.pay(this.amount);

        if(!senderPayed) {
            this.status = TransactionStatus.FAIL;
            return;
        }

        final boolean received = this.recipient.receive(this.amount);

        if(!received) {
            this.status = TransactionStatus.FAIL;
            this.sender.receive(this.amount);
            return;
        }

        this.status = TransactionStatus.SUCCESS;
    }

    public void undo() {
        final boolean recipientPayed = this.recipient.pay(this.amount);

        if(!recipientPayed) {
            return;
        }

        final boolean received = this.sender.receive(this.amount);

        if(!received) {
            this.recipient.receive(this.amount);
            return;
        }

        this.status = TransactionStatus.CANCELLED;
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

    public double getAmount() { return amount; }

    @Override
    public int hashCode() {
        return this.id.hashCode() + 22;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Transaction))
            return false;

        return this.id == ((Transaction) obj).getId();
    }

    private enum TransactionStatus {
        SUCCESS, FAIL, PENDING, CANCELLED
    }
}
