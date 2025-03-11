package TransactionalKeyValueStore.useCase;

import TransactionalKeyValueStore.Transaction;
import TransactionalKeyValueStore.storage.TransactionRepositoryImpl;

public class GetUseCase extends UseCase{
    TransactionRepositoryImpl repository;
    public GetUseCase(TransactionRepositoryImpl repository) {
        this.repository = repository;
    }

    public void execute(String key) throws Exception {
        Transaction current = repository.getCurrentTransaction();
        if(current != null) {
            System.out.println("Reading from current transaction");
            if (current.getMap().containsKey(key)) {
                System.out.println("Reading from current transaction");
                System.out.print("Value is " + current.getMap().get(key));
                return;
            }
            System.out.println("Reading from local database");
            repository.getLocalStoreTransactions().getOrDefault(key, null);
        }
    }

    @Override
    public void execute() throws Exception {

    }
}
