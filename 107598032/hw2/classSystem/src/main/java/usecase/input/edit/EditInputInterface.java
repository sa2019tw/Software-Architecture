package usecase.input.edit;

import usecase.input.InputInterface;

public interface EditInputInterface extends InputInterface {
    int getId();
    String getName();
    String getContent();
    String getMember();
    int getPrice();
    String getNotice();
    String getRemark();
}
