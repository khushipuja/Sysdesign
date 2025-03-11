package TransactionalKeyValueStore;

import TransactionalKeyValueStore.storage.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Demo {

    public static void main(String[] args) throws Exception {
        LinkedList<Transaction> transactions = new LinkedList<>();
        Map<String,String> map = new HashMap<>();
        TransientDataSourceImpl transientDataSource = new TransientDataSourceImpl(transactions);
        LocalDataSourceImpl localDataSource = new LocalDataSourceImpl(map);
        TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl(transientDataSource,localDataSource);

        TransactionManager transactionManager = new TransactionManager(transactionRepository);

        transactionManager.doTransaction(TransactionType.Set,"key1","5");
        transactionManager.doTransaction(TransactionType.Begin,"","");
        transactionManager.doTransaction(TransactionType.Set,"key1","1");
        transactionManager.doTransaction(TransactionType.Set,"key2","2");
        transactionManager.doTransaction(TransactionType.Rollback,"","");

        transactionManager.print();

    }
}
