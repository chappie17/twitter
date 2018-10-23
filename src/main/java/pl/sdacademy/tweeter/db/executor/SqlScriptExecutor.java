package pl.sdacademy.tweeter.db.executor;

public interface SqlScriptExecutor {

    void execute(String classpath) throws SqlScriptExecutorException;
}
