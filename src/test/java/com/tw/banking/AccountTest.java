package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class AccountTest {

    @Test
    void should_call_repository_to_add_one_transaction_when_execute_deposit(){
        //given
        TransactionRepository mockTransactionRepository = mock(TransactionRepository.class);
        Printer mockPrinter = mock(Printer.class);
        doNothing().when(mockTransactionRepository).addDeposit(anyInt());
        Account account = new Account(mockTransactionRepository, mockPrinter);

        //when
        account.deposit(100);

        //then
        verify(mockTransactionRepository, times(1)).addDeposit(100);
    }

    @Test
    void should_call_repository_to_add_one_transaction_when_execute_withdraw(){
        //given
        TransactionRepository mockTransactionRepository = mock(TransactionRepository.class);
        Printer mockPrinter = mock(Printer.class);
        doNothing().when(mockTransactionRepository).addWithdraw(anyInt());
        Account account = new Account(mockTransactionRepository, mockPrinter);

        //when
        account.withdraw(100);

        //then
        verify(mockTransactionRepository, times(1)).addWithdraw(100);
    }

    @Test
    void should_call_print_and_allTransactions_when_execute_printStatement(){
        //given
        TransactionRepository mockTransactionRepository = mock(TransactionRepository.class);
        Printer mockPrinter = mock(Printer.class);
        when(mockTransactionRepository.allTransactions()).thenReturn(new ArrayList<>());
        doNothing().when(mockPrinter).print(anyList());
        Account account = new Account(mockTransactionRepository, mockPrinter);

        //when
        account.printStatement();

        //then
        verify(mockTransactionRepository, times(1)).allTransactions();
        verify(mockPrinter, times(1)).print(anyList());
    }

}