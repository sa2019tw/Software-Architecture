package usecase.input.insert;

import usecase.input.InputInterface;

public interface InsertInputInterface extends InputInterface {
    int getId();
    String getName();
    String getContent();
    String getMember();
    int getPrice();
    String getNotice();
    String getRemark();
}
