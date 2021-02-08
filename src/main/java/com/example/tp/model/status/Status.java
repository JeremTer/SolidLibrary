package com.example.tp.model.status;

public interface Status {

    boolean isAbleToAddNewBook();

    boolean isAbleToBorrowBook();

    Integer borrowBookTimeLimitInWeek();

    Integer borrowBookNumberLimitAtTheSameTime();
}
