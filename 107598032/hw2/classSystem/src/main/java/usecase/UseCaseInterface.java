package usecase;

import dao.CourseDaoInterface;
import usecase.input.InputInterface;
import usecase.output.OutputInterface;

public interface UseCaseInterface<INPUT extends InputInterface, OUTPUT extends OutputInterface> {
    void setRepository(CourseDaoInterface courseDao);
    void execute(INPUT input, OUTPUT output);
}
