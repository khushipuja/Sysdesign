package TransactionalKeyValueStore;

public class TransactionEntity {

    private String transactionId;
    private String key;
    private String value;

    public TransactionEntity(String transactionId, String key, String value) {
        this.transactionId = transactionId;
        this.key = key;
        this.value = value;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
