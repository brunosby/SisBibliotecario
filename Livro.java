package bdbiblioteca;

public class Livro{
	private int idLivro;
	private String nomeLivro;
	private boolean statusLivro;
	private Editora e;
	
	public Livro() {
		
	}
	public Livro(int idLivro, String nomeLivro, boolean statusLivro, Editora e) {
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.statusLivro = statusLivro;
		this.e = e;
	}
	
	// setters
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public void setNomelivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public void setStatusLivro(boolean statusLivro) {
		this.statusLivro = statusLivro;
	}
	public void setEditora(Editora e) {
		this.e = e;
	}
	
	// getters
	public int getIdLivro() {
		return idLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public boolean getStatusLivro() {
		return statusLivro;
	}
	public Editora getEditora() {
		return e;
	}
	
	@Override
	public String toString() {
		return "id: " + idLivro +
				"\nNome: " + nomeLivro +
				"\nstatusLivro: " + statusLivro +
				"\nEditora: " + e.getIdEditora();
	}
}
