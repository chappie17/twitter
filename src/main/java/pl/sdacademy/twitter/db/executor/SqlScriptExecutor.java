package pl.sdacademy.twitter.db.executor;

public interface SqlScriptExecutor {

    void execute(String classpath) throws SqlScriptExecutorException;
}
