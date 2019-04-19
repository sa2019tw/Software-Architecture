package usecase.delete;

import usecase.UseCaseInterface;
import usecase.input.delete.DeleteInputImplement;
import usecase.output.delete.DeleteOutputImplement;

public interface DeleteUseCaseInterface extends UseCaseInterface<DeleteInputImplement, DeleteOutputImplement> {
    void execute(DeleteInputImplement input, DeleteOutputImplement output);
}
