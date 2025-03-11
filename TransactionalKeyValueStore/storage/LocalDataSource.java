package TransactionalKeyValueStore.storage;

import TransactionalKeyValueStore.TransactionEntity;

import java.util.Map;

/**
 * DataSource that commits the current transaction into the database or
 * fetches transactions from a previous session.
 */
public interface LocalDataSource {
    void clear();
    void put(TransactionEntity transactionEntity);
    void put(Map<String, String> transactionMap);
}

