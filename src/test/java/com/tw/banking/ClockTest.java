package com.tw.banking;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClockTest {

    @Test
    void should_return_correct_format_when_execute_todayAsString(){
        //given
        Clock spyClock = Mockito.spy(new Clock());
        when(spyClock.today()).thenReturn(LocalDate.parse("2021-06-28"));
        //when
        String s = spyClock.todayAsString();
        //then
        assertEquals("28/06/2021", s);
    }

}