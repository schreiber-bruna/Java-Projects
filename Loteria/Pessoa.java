public class Pessoa {
	private int id;
	private int saldoPessoa;
	public Pessoa(int id, int dinheiro){
		this.id = id;
		this.saldoPessoa = dinheiro;
	}
	public int getId() {
		return id;
	 }
	public int getDinheiro() {
		return saldoPessoa;
	}
	public boolean debitar(double valorBilhete) {
		if (saldoPessoa>=valorBilhete) {
			saldoPessoa -= valorBilhete;
			return true;
		}
		else {
			return false;
		}
	}
	public void creditar(double valor) {
		saldoPessoa+=valor;
	}
	
	@Override
	public String toString() {
		return "Pessoa ID: " + id + " | Saldo: R$" + saldoPessoa;
	}
	
	

}
