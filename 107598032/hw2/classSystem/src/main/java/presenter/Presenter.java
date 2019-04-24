package presenter;

import usecase.output.OutputInterface;
import view.ViewModel;

public interface Presenter<V extends ViewModel> extends OutputInterface {
    V buildViewModel();
}
