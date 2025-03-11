package TransactionalKeyValueStore.storage;

import TransactionalKeyValueStore.TransactionEntity;

import javax.sql.DataSource;
import java.util.Map;

public class LocalDataSourceImpl implements LocalDataSource {

    Map<String, String> map;

    public LocalDataSourceImpl(Map<String, String> map) {
        this.map = map;
    }
    @Override
    public void clear() {
      map.clear();
    }

    @Override
    public void put(TransactionEntity transactionEntity) {
      try{
          map.put(transactionEntity.getKey(), transactionEntity.getValue());
      }catch (Exception e){
          e.printStackTrace();
      }
    }

    @Override
    public void put(Map<String, String> transactionMap) {


    }

    public Map<String, String> getTransactionMap() {
        return map;
    }
}
