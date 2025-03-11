package TransactionalKeyValueStore;

import TransactionalKeyValueStore.storage.TransactionRepository;
import TransactionalKeyValueStore.storage.TransactionRepositoryImpl;
import TransactionalKeyValueStore.useCase.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TransactionManager {

    private BeginUseCase beginUseCase;
    private CommitUseCase commitUseCase;
    private RollBackUseCase rollbackUseCase;
    private GetUseCase getUseCase;
    private SetUseCase setUseCase;
    private TransactionRepositoryImpl repository;

    public TransactionManager(TransactionRepositoryImpl repository) {
        this.repository = repository;
        beginUseCase = new BeginUseCase(repository);
        commitUseCase = new CommitUseCase(repository);
        rollbackUseCase  = new RollBackUseCase(repository);
        getUseCase = new GetUseCase(repository);
        setUseCase = new SetUseCase(repository);
    }

    public void print(){
        System.out.println("Printing transactions");
        Map<String,String> map = repository.getLocalStoreTransactions();
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }



    public void doTransaction(TransactionType transactionType , String key, String value) throws Exception {
        switch (transactionType.toString()) {
            case "BEGIN":
                beginUseCase.execute();
                return;
            case "GET":
                getUseCase.execute(key);
                return;
            case "SET":
                setUseCase.execute(key, value);
                return;
//            case "DELETE":
//                return deleteFlow(input);
//            case "COUNT":
//                return countFlow(input);
            case "COMMIT":
                commitUseCase.execute();
                return;
            case "ROLLBACK":
                rollbackUseCase.execute();
        }
    }



}
