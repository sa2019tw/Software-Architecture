package UseCase;

import Input.Input;

public interface UseCase {

    void execute(Input input, OutputBoundary output);
}
