package usecase.delete;

import usecase.UseCaseInterface;
import usecase.input.delete.DeleteInputInterface;
import usecase.output.delete.DeleteOutputInterface;

public interface DeleteUseCaseInterface extends UseCaseInterface<DeleteInputInterface, DeleteOutputInterface> {
    void execute(DeleteInputInterface input, DeleteOutputInterface output);
}
