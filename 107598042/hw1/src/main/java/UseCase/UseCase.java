package UseCase;

public interface UseCase<T, V> {
    void execute(T input, V output);
}
