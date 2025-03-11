package TransactionalKeyValueStore.useCase;

import TransactionalKeyValueStore.storage.TransactionRepositoryImpl;

public class CommitUseCase extends UseCase {
    TransactionRepositoryImpl transactionRepository;

    public CommitUseCase(TransactionRepositoryImpl transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void execute() throws Exception {
        transactionRepository.commitToLocalStore(transactionRepository.getCurrentTransaction().getMap());
    }
}
