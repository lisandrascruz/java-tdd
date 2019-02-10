package leilao.exceptions;

public class UsuarioInvalidoException extends RuntimeException {

    public static final String MSG_PADRAO = "O usuário não pode ser nulo ou inválido para esta operação.";

    public UsuarioInvalidoException() {
        super(MSG_PADRAO);
    }

    public UsuarioInvalidoException(String s) {
        super(s);
    }
}
