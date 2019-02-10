package leilao.servico;

import leilao.exceptions.UsuarioInvalidoException;
import leilao.exceptions.ValorLanceInvalidoException;
import leilao.models.Lance;
import leilao.models.Leilao;
import leilao.models.Usuario;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AvaliadorTeste {

  private Avaliador cenarioLances() {

    Leilao leilao = new Leilao("Dell Inspiron", 100);
    Avaliador avaliador = new Avaliador();

    Lance lance1  = new Lance(new Usuario("Lis"), 300);
    Lance lance2  = new Lance(new Usuario("Lala"), 800);
    Lance lance3  = new Lance(new Usuario("Olly"), 260);
    Lance lance4  = new Lance(new Usuario("Ana"), 280);
    Lance lance5  = new Lance(new Usuario("Ronny"), 500);

    leilao.setLances(Arrays.asList(lance1, lance2, lance3, lance4, lance5));

    avaliador.avalia(leilao);

    return avaliador;
  }

  private Avaliador cenarioLancesCrescente() {

    Leilao leilao = new Leilao("Dell Inspiron", 100);
    Avaliador avaliador = new Avaliador();

    Lance lance1  = new Lance(new Usuario("Lis"), 300);
    Lance lance2  = new Lance(new Usuario("Lala"), 400);
    Lance lance3  = new Lance(new Usuario("Olly"), 500);

    leilao.setLances(Arrays.asList(lance1, lance2, lance3));
    avaliador.avalia(leilao);

    return avaliador;
  }

  private Avaliador cenarioLancesDecrescentes() {

    Leilao leilao = new Leilao("Dell Inspiron", 100);
    Avaliador avaliador = new Avaliador();

    Lance lance1  = new Lance(new Usuario("Lis"), 500);
    Lance lance2  = new Lance(new Usuario("Lala"), 400);
    Lance lance3  = new Lance(new Usuario("Olly"), 300);

    leilao.setLances(Arrays.asList(lance1, lance2, lance3));
    avaliador.avalia(leilao);

    return avaliador;
  }


  @Test
  public void deveAvaliarMaiorLanceEmOrdemCrescente() {
    assertEquals(500, cenarioLancesCrescente().getMaiorLance());
  }

  @Test
  public void deveAvaliarMaiorLanceEmOrdemDecrescente() {
    assertEquals(500, cenarioLancesDecrescentes().getMaiorLance());
  }

  @Test
  public void deveAvaliarMaiorLanceEmOrdemAleatoria() {
    assertEquals(800, cenarioLances().getMaiorLance());
  }

  @Test
  public void deveAvaliarMenorLanceEmOrdemCrescente() {
    assertEquals(300, cenarioLancesCrescente().getMenorLance());
  }

  @Test
  public void deveAvaliarMenorLanceEmOrdemDecrescente() {
    assertEquals(300, cenarioLancesDecrescentes().getMenorLance());
  }

  @Test
  public void deveAvaliarMenorLanceEmOrdemAleatoria() {
    assertEquals(260, cenarioLances().getMenorLance());
  }

  @Test
  public void deveAvaliarMediaLanceEmOrdemCrescente() {
    assertEquals(400, cenarioLancesCrescente().getMedia());
  }

  @Test
  public void deveAvaliarMediaLanceEmOrdemDecrescente() {
    assertEquals(400, cenarioLancesDecrescentes().getMedia());
  }

  @Test
  public void deveAvaliarMediaLanceEmOrdemAleatoria() {
    assertEquals(428, cenarioLances().getMedia());
  }

  @Test
  public void deveLancarExcecaoSeLanceMenorQueValorInicial() {
    Leilao leilao = new Leilao("Dell Inspiron", 100);
    Avaliador avaliador = new Avaliador();

    Lance lance1  = new Lance(new Usuario("Lis"), 30);
    Lance lance2  = new Lance(new Usuario("Lala"), 800);
    Lance lance3  = new Lance(new Usuario("Olly"), 260);
    Lance lance4  = new Lance(new Usuario("Ana"), 280);
    Lance lance5  = new Lance(new Usuario("Ronny"), 500);

    leilao.setLances(Arrays.asList(lance1, lance2, lance3, lance4, lance5));

    try {
      avaliador.avalia(leilao);
      fail();
    } catch (ValorLanceInvalidoException e) {
      assertEquals(ValorLanceInvalidoException.MSG_PADRAO, e.getMessage());
    }
  }

  @Test
  public void deveLancarExcecaoSeUsuarioNulo() {
    Leilao leilao = new Leilao("Dell Inspiron", 100);
    Avaliador avaliador = new Avaliador();

//    Lance lance1  = new Lance(new Usuario("Lis"), 300);
    Lance lance1  = new Lance(null, 300);

    leilao.setLances(Arrays.asList(lance1));

    UsuarioInvalidoException e =

    assertThrows(UsuarioInvalidoException.class,
            () -> avaliador.avalia(leilao));

    assertEquals(UsuarioInvalidoException.MSG_PADRAO, e.getMessage());
  }
}
