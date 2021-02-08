package com.example.tp.domain.model.person.ability;

public class GuestAbilities implements PersonAbilities {

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
