package com.example.tp.model.status;

public class StatusGuest implements Status {

    @Override
    public boolean isAbleToAddNewBook() {
        return false;
    }

    @Override
    public boolean isAbleToBorrowBook() {
        return false;
    }

    @Override
    public Integer borrowBookTimeLimitInWeek() {
        return 0;
    }

    @Override
    public Integer borrowBookNumberLimitAtTheSameTime() {
        return 0;
    }
}
