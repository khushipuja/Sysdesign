package TransactionalKeyValueStore.storage;

import TransactionalKeyValueStore.Transaction;

import java.util.List;
import java.util.Map;

/**
 * Data source that creates, updates, deletes, or counts the number
 * of transactions or key-value pairs inside any transaction.
 *
 * This storage is transient, meaning every transaction is deleted when the session
 * is finished without committing to persistent storage.
 */
public interface TransientDataSource {

    Transaction getCurrentTransaction();
    int getTransactionSize();
    List<Transaction> getTransactionStack();
    Transaction getTransactionAtIndex(int index);
    void createTransaction(Map<String, String> map);
    String getValue(String key);
    void setValue(String key, String value);
    void removeCurrentTransaction();
    void delete(String key);
}



