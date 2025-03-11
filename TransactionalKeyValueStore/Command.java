package TransactionalKeyValueStore;



public abstract class Command {

    public static class Input extends Command {
        private final String transaction;
        private final String key;
        private final String value;

        public Input(String transaction, String key, String value) {
            this.transaction = transaction;
            this.key = key;
            this.value = value;
        }

        public String getTransaction() {
            return transaction;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    public static class Success extends Command {
        private final String output;

        public Success(String output) {
            this.output = output;
        }

        public String getOutput() {
            return output;
        }
    }

    public static class Error extends Command {
        private final TransactionError error;

        public Error(TransactionError error) {
            this.error = error;
        }

        public TransactionError getError() {
            return error;
        }
    }

    public static class Complete extends Command {
        private final Object complete;

        public Complete() {
            this.complete = new Object();
        }

        public Complete(Object complete) {
            this.complete = complete;
        }

        public Object getComplete() {
            return complete;
        }
    }
}