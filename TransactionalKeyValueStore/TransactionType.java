package TransactionalKeyValueStore;

/*
SET <key1> <value1> <key2> <value2> // store the value for key
GET <key>         // return the current value for key
DELETE <key1> <key2>      // remove the entry for key
COUNT <value>     // return the number of keys that have the given value
BEGIN             // start a new transaction
COMMIT            // complete the current transaction
ROLLBACK          // revert to state prior to BEGIN call
 */
public enum  TransactionType{
    Set("SET"),
    Get("GET"),
    Delete("DELETE"),
    Count("COUNT"),
    Begin("BEGIN"),
    Commit("COMMIT"),
    Rollback("ROLLBACK");

    private String value;
    TransactionType(String value){
        this.value = value;
    }
}
