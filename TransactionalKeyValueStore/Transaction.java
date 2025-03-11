package TransactionalKeyValueStore;

import java.util.HashMap;
import java.util.Map;

public class Transaction {

    Map<String,String> map;

    public Transaction(Map<String,String> map) {
        this.map = map;
    }

    public Map<String,String> getMap() {
        return map;
    }
}
