package TransactionalKeyValueStore.useCase;

import TransactionalKeyValueStore.Transaction;
import TransactionalKeyValueStore.storage.TransactionRepositoryImpl;

public class SetUseCase extends UseCase {
    TransactionRepositoryImpl transactionRepository;
    public SetUseCase(TransactionRepositoryImpl transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void execute(String key, String value) throws Exception {
        Transaction transaction = transactionRepository.getCurrentTransaction();
        if (transaction == null) {
            transactionRepository.updateLocalTransaction(key,value);
        }else{
            transactionRepository.removeCurrentTransaction();
            transaction.getMap().put(key , value);
            transactionRepository.createTransaction(transaction.getMap());
        }

    }

    @Override
    public void execute() throws Exception {

    }
}
