package usecase.list;

import usecase.UseCaseInterface;
import usecase.input.list.ListInputImplement;
import usecase.output.list.ListOutputImplement;

public interface ListUseCaseInterface extends UseCaseInterface<ListInputImplement, ListOutputImplement> {
    void execute(ListInputImplement input, ListOutputImplement output);
}
