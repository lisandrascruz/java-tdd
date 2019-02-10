package leilao.exceptions;

public class ValorLanceInvalidoException extends  RuntimeException {

    public static final String MSG_PADRAO = "O valor do lance não pode ser menor ou igual ao valor ofertado pelo leiloeiro.";

    public ValorLanceInvalidoException() {
        super(MSG_PADRAO);
    }

    public ValorLanceInvalidoException(String s) {
        super(s);
    }
}
