package TransactionalKeyValueStore;

public enum TransactionError {
        EmptyCommandError,
        NoKeyCommandError,
        NoValueCommandError,
        NoTransactionError,
        KeyNotSetError,
        InvalidCommandError,
        UnknownError;
}
