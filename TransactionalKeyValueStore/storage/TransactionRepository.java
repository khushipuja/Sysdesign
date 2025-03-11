package TransactionalKeyValueStore.storage;

import TransactionalKeyValueStore.Transaction;
import TransactionalKeyValueStore.TransactionEntity;

import java.util.List;
import java.util.Map;

public interface TransactionRepository {

    List<Transaction> getTransactionStack();
    void removeCurrentTransaction();
    Transaction getCurrentTransaction();
    void createTransaction(Map<String, String> map);
    Transaction getTransactionAtIndex(int index);

    void setValue(String key, String value);
    String getValue(String key);
    void begin();
    void delete(String key);

    // Persistent Storage Functions
    void clearLocalStore();
    Map<String, String> getLocalStoreTransactions();
    void commitToLocalStore(Map<String, String> map);
    void insertTransactionToLocalStore(TransactionEntity transactionEntity);
    void insertAllToLocalStore(Map<String, String> map);
}
