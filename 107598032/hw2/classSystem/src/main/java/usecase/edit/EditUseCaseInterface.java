package usecase.edit;

import usecase.UseCaseInterface;
import usecase.input.edit.EditInputImplement;
import usecase.output.edit.EditOutputImplement;

public interface EditUseCaseInterface extends UseCaseInterface<EditInputImplement, EditOutputImplement> {
    void execute(EditInputImplement input, EditOutputImplement output);
}
