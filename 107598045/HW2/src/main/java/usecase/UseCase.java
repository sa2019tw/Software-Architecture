package usecase;

public interface UseCase<IN extends Input, OUT extends Output> {
    void execute(IN input, OUT output);
}
