package leilao.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeilaoTest {

    @Test
    public void naoDeveAceitarLancesSubsequentes() {
        Leilao leilao = new Leilao("Dell Inspiron", 100);
        Usuario ana = new Usuario(1, "Lis");

        Lance lance1 = new Lance(ana, 30);
        Lance lance2 = new Lance(ana, 800);

        leilao.propoe(lance1);
        leilao.propoe(lance2);

        assertEquals(1, leilao.getLances().size());
        assertEquals(200, leilao.getLances().get(0).getValor());  //pra assegurar q o objeto inserido foi o correto

    }
}
