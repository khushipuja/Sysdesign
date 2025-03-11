package TransactionalKeyValueStore.storage;

import TransactionalKeyValueStore.Transaction;
import TransactionalKeyValueStore.TransactionEntity;

import java.util.List;
import java.util.Map;

public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransientDataSourceImpl transientDataSource;
    private final LocalDataSourceImpl localDataSource;

    public TransactionRepositoryImpl(TransientDataSourceImpl transientDataSource, LocalDataSourceImpl localDataSource) {
        this.transientDataSource = transientDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public List<Transaction> getTransactionStack() {
        return transientDataSource.getTransactionStack();
    }

    @Override
    public void removeCurrentTransaction() {
        transientDataSource.removeCurrentTransaction();
    }

    @Override
    public Transaction getCurrentTransaction() {
        return transientDataSource.getCurrentTransaction();
    }

    @Override
    public void createTransaction(Map<String, String> map) {
        transientDataSource.createTransaction(map);
    }

    @Override
    public Transaction getTransactionAtIndex(int index) {
        return transientDataSource.getTransactionAtIndex(index);
    }

    @Override
    public void setValue(String key, String value) {
        transientDataSource.setValue(key, value);
    }

    @Override
    public String getValue(String key) {
        return transientDataSource.getValue(key);
    }

    @Override
    public void begin() {
        Map<String, String> currentStore = transientDataSource.getCurrentTransaction().getMap();
        createTransaction(currentStore);
    }

    @Override
    public void delete(String key) {
        transientDataSource.delete(key);
    }

    @Override
    public void clearLocalStore() {
        localDataSource.getTransactionMap();
    }

    @Override
    public Map<String, String> getLocalStoreTransactions() {
        return localDataSource.getTransactionMap();
    }

    @Override
    public void commitToLocalStore(Map<String, String> map) {
        localDataSource.put(map);
    }

    @Override
    public void insertTransactionToLocalStore(TransactionEntity transactionEntity) {
        localDataSource.put(transactionEntity);
    }

    @Override
    public void insertAllToLocalStore(Map<String, String> map) {
        localDataSource.put(map);
    }
}
