package com.example.tp.model.status;

public class StatusMember implements Status{
    @Override
    public boolean isAbleToAddNewBook() {
        return false;
    }

    @Override
    public boolean isAbleToBorrowBook() {
        return true;
    }

    @Override
    public Integer borrowBookTimeLimitInWeek() {
        return 4;
    }

    @Override
    public Integer borrowBookNumberLimitAtTheSameTime() {
        return 3;
    }
}
