package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionRepositoryTest {

    @Test
    void should_add_one_instance_to_list_when_execute_addDeposit(){
        //given
        Clock mockClock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(mockClock);
        List<Transaction> mockTransactions = mock(ArrayList.class);
        transactionRepository.transactions = mockTransactions;
        when(mockClock.todayAsString()).thenReturn("any date str");
        //when
        transactionRepository.addDeposit(100);

        //then
        verify(mockClock, times(1)).todayAsString();
        verify(mockTransactions, times(1)).add(any(Transaction.class));
    }

    @Test
    void should_add_one_instance_to_list_when_execute_addWithdraw(){
        //given
        Clock mockClock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(mockClock);
        ArrayList<Transaction> mockTransactions = mock(ArrayList.class);
        transactionRepository.transactions = mockTransactions;
        when(mockClock.todayAsString()).thenReturn("any date str");
        //when
        transactionRepository.addWithdraw(100);

        //then
        verify(mockClock, times(1)).todayAsString();
        verify(mockTransactions, times(1)).add(any(Transaction.class));
    }

    @Test
    void should_return_all_transactions_when_execute_allTransactions(){
        //given
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        List<Transaction> testTransactions = new ArrayList<>();
        testTransactions.add(new Transaction("any date str", 100));
        testTransactions.add(new Transaction("any date str", -100));
        transactionRepository.transactions = testTransactions;
        //when
        List<Transaction> transactionsReturn = transactionRepository.allTransactions();

        //then
        assertEquals(testTransactions.size(), transactionsReturn.size());
    }




}