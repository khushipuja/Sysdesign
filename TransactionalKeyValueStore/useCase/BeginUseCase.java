package TransactionalKeyValueStore.useCase;

import TransactionalKeyValueStore.storage.TransactionRepositoryImpl;

public class BeginUseCase extends UseCase {

    TransactionRepositoryImpl transactionRepository;

    public BeginUseCase(TransactionRepositoryImpl transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void execute() throws Exception {
        transactionRepository.begin();
    }
}
