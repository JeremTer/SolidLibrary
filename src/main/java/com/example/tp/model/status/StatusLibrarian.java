package com.example.tp.model.status;

public class StatusLibrarian implements Status{

    @Override
    public boolean isAbleToAddNewBook() {
        return true;
    }

    @Override
    public boolean isAbleToBorrowBook() {
        return true;
    }

    @Override
    public Integer borrowBookTimeLimitInWeek() {
        return -1;
    }

    @Override
    public Integer borrowBookNumberLimitAtTheSameTime() {
        return -1;
    }
}
