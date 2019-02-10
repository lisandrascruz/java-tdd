package leilao.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private double valorInicial;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public Leilao(String descricao, double valorInicial) {
		this.descricao = descricao;
		this.valorInicial = valorInicial;
		this.lances = new ArrayList<Lance>();
	}

	// fazer ==> o mesmo user nao pode ter mais do que 5 lances no leilao

	public void propoe(Lance lance) {
		//verificar como melhorar esse codigo
		if (lances.isEmpty()) lances.add(lance);
		else {
			Lance lastLance = lances.get(lances.size() - 1);
			if (lastLance.getUsuario().getId() != lance.getUsuario().getId()) lances.add(lance);
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}
}
