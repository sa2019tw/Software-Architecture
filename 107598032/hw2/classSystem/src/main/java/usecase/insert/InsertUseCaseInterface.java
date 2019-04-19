package usecase.insert;

import usecase.UseCaseInterface;
import usecase.input.insert.InsertInputImplement;
import usecase.output.insert.InsertOutputImplement;

public interface InsertUseCaseInterface extends UseCaseInterface<InsertInputImplement, InsertOutputImplement> {
    void execute(InsertInputImplement input, InsertOutputImplement output);
}
