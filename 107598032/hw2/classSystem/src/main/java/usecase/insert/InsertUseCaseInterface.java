package usecase.insert;

import usecase.UseCaseInterface;
import usecase.input.insert.InsertInputInterface;
import usecase.output.insert.InsertOutputInterface;

public interface InsertUseCaseInterface extends UseCaseInterface<InsertInputInterface, InsertOutputInterface> {
    void execute(InsertInputInterface input, InsertOutputInterface output);
}
