package TransactionalKeyValueStore.storage;

import TransactionalKeyValueStore.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TransientDataSourceImpl implements TransientDataSource {

    private final LinkedList<Transaction> transactionStack;

    public TransientDataSourceImpl(LinkedList<Transaction> transactionStack) {
        this.transactionStack = transactionStack;
    }

    @Override
    public Transaction getCurrentTransaction() {
        return transactionStack.getLast();
    }

    @Override
    public int getTransactionSize() {
        return transactionStack.size();
    }

    @Override
    public List<Transaction> getTransactionStack() {
        return transactionStack;
    }

    @Override
    public Transaction getTransactionAtIndex(int index) {
        try {
            return transactionStack.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public void createTransaction(Map<String, String> map) {
        transactionStack.add(new Transaction(map));
    }

    @Override
    public String getValue(String key) {
        return getCurrentTransaction().getMap().get(key);
    }

    @Override
    public void setValue(String key, String value) {
        getCurrentTransaction().getMap().put(key, value);
    }

    @Override
    public void removeCurrentTransaction() {
        transactionStack.removeLast();
    }

    @Override
    public void delete(String key) {
        getCurrentTransaction().getMap().remove(key);
    }
}
