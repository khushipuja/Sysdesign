package TransactionalKeyValueStore;



public abstract class TransactionResult<R> {

    public static class Success<T> extends TransactionResult<T> {
        private final T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    public static class Error extends TransactionResult<Void> {
        private final TransactionError transactionError;

        public Error(TransactionError transactionError) {
            this.transactionError = transactionError;
        }

        public TransactionError getTransactionError() {
            return transactionError;
        }
    }
}

