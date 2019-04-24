package usecase.edit;

import usecase.UseCaseInterface;
import usecase.input.edit.EditInputInterface;
import usecase.output.EditOutputInterface;

public interface EditUseCaseInterface extends UseCaseInterface<EditInputInterface, EditOutputInterface> {
    void execute(EditInputInterface input, EditOutputInterface output);
}
