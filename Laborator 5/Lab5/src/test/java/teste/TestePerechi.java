package teste;

import ex2.PerecheNumere;
import exemplul2.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePerechi {
    @Test
    void test1_consFib() {
        PerecheNumere p=new PerecheNumere(2,3);
        assertTrue(p.consFib());
    }

    @Test
    void test2_consFib() {
        PerecheNumere p=new PerecheNumere(5,7);
        assertFalse(p.consFib());
    }

    @Test
    void test3_consFib() {
        PerecheNumere p=new PerecheNumere(5,8);
        assertTrue(p.consFib());
    }

    @Test
    void test1_cmmmc(){
        PerecheNumere p=new PerecheNumere(6,4);
        assertEquals(p.Cmmmc(),12);
    }

    @Test
    void test2_cmmmc(){
        PerecheNumere p=new PerecheNumere(2,3);
        assertEquals(p.Cmmmc(),6);
    }

    @Test
    void test3_cmmmc(){
        PerecheNumere p=new PerecheNumere(5,10);
        assertEquals(p.Cmmmc(),10);
    }

    @Test
    void test1_sumCif(){
        PerecheNumere p=new PerecheNumere(100,10);
        assertTrue(p.sumCifEgale());
    }

    @Test
    void test2_sumCif(){
        PerecheNumere p=new PerecheNumere(103,10);
        assertFalse(p.sumCifEgale());
    }

    @Test
    void test3_sumCif(){
        PerecheNumere p=new PerecheNumere(41,50);
        assertTrue(p.sumCifEgale());
    }

    @Test
    void test1_pareCif(){
        PerecheNumere p=new PerecheNumere(41,50);
        assertTrue(p.sumPareEgale());
    }

    @Test
    void test2_pareCif(){
        PerecheNumere p=new PerecheNumere(31,50);
        assertFalse(p.sumPareEgale());
    }

    @Test
    void test3_pareCif(){
        PerecheNumere p=new PerecheNumere(24,22);
        assertTrue(p.sumPareEgale());
    }












}
