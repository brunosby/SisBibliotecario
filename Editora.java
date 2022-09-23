package bdbiblioteca;

public class Editora {
	private int idEditora;
	private String nomeEditora;
	private String telEditora;
	private String endEditora;
	
	public Editora() {
		
	}
	public Editora(int idEditora, String nomeEditora, String telEditora, String endEditora) {
		this.idEditora = idEditora;
		this.nomeEditora = nomeEditora;
		this.telEditora = telEditora;
		this.endEditora = endEditora;
	}
	
	// setters
	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}
	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	public void setTelEditora(String telEditora) {
		this.telEditora = telEditora;
	}
	public void setEndEditora(String endEditora) {
		this.endEditora = endEditora;
	}
	
	// getters
	public int getIdEditora() {
		return idEditora;
	}
	public String getNomeEditora() {
		return nomeEditora;
	}
	public String getTelEditora() {
		return telEditora;
	}
	public String getEndEditora() {
		return endEditora;
	}
	
	@Override
	public String toString() {
		return "id: " + idEditora +
				"\nNome: " + nomeEditora +
				"\nTelefone: " + telEditora +
				"\nEndereco: " + endEditora;
	}
}
