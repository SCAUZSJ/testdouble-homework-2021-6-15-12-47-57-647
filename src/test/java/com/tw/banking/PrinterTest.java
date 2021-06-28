package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.tw.banking.Printer.STATEMENT_HEADER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PrinterTest {

    @Test
    void should_return_correct_format_str_when_execute_statementLine(){
        //given
        Printer printer = new Printer(new Console());
        Transaction transaction = new Transaction("28/06/2021", 100);

        //when
        String formatStr = printer.statementLine(transaction, 1000);

        //then
        assertEquals("28/06/2021 | 100 | 1000", formatStr);
    }

    @Test
    void should_return_correct_format_str_when_execute_statementLine2(){
        //given
        Console mockConsole = mock(Console.class);
        Printer printer = spy(new Printer(mockConsole));
        Transaction transaction1 = new Transaction("28/06/2021", 100);
        Transaction transaction2 = new Transaction("29/06/2021", 200);
        doNothing().when(mockConsole).printLine(anyString());
        //when

        printer.print(Arrays.asList(transaction1, transaction2));

        //then
        verify(mockConsole, times(1)).printLine(STATEMENT_HEADER);
        verify(mockConsole).printLine("29/06/2021 | 200 | 300");
        verify(mockConsole).printLine("28/06/2021 | 100 | 100");
    }

    // mock private methods

}