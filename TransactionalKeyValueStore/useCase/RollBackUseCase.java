package TransactionalKeyValueStore.useCase;

import TransactionalKeyValueStore.Transaction;
import TransactionalKeyValueStore.storage.TransactionRepositoryImpl;

public class RollBackUseCase extends UseCase {
    TransactionRepositoryImpl repository;

    public RollBackUseCase(TransactionRepositoryImpl repository) {
        this.repository = repository;
    }
    @Override
    public void execute() throws Exception {
         Transaction current = repository.getCurrentTransaction();
         if(current != null) {
             repository.removeCurrentTransaction();
         }else{
             System.out.println("Current transaction is null , Nothing to rollback");
         }
    }
}
