package usecase.list;

import usecase.UseCaseInterface;
import usecase.input.list.ListInputInterface;
import usecase.output.ListOutputInterface;

public interface ListUseCaseInterface extends UseCaseInterface<ListInputInterface, ListOutputInterface> {
    void execute(ListInputInterface input, ListOutputInterface output);
}
