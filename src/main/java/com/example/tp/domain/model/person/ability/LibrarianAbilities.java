package com.example.tp.domain.model.person.ability;

public class LibrarianAbilities implements PersonAbilities {

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
