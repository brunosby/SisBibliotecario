package bdbiblioteca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BDbiblioteca {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/biblioteca?useTimezone=true&serverTimezone=UTC&useSSL=false";		                 //jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
	

		String usuario = "root";
		String senha = "root";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
		}catch (Exception e) {
		    System.out.println("Erro" + e.getMessage());
		}		
	}
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public void cadastrarLivro(Livro l) {
		try {
			String query = "insert into livros (nomeLivro, idEditora) values ('" + l.getNomeLivro() + "', '" + l.getEditora().getIdEditora() + "');";				         
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void cadastrarEditora(Editora ed) {
		try {
			String query = "insert into editora (nomeEditora, endEditora, telEditora) values ('" + ed.getNomeEditora() + "', '" + ed.getEndEditora() + "', '" + ed.getTelEditora() + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void listarLivros() {
		 try {
			String query = "select * from livros order by nomeLivro";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
			   System.out.println("\nid do Livro: "+this.resultset.getString("idLivro")+ "\nNome: "+this.resultset.getString("nomeLivro") + "\nEstado: "+this.resultset.getString("statusLivro") + "\nid Editora: " + this.resultset.getString("idEditora") + "\n");	
			}
		 }
		 catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());		
		 }
	}
	public void listarEditora() {
		 try {
			String query = "select * from editora order by idEditora";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
			   System.out.println("\nid da Editora: "+this.resultset.getString("idEditora") + "\nNome Editora: " + this.resultset.getString("idEditora") + "\nTelefone: " + this.resultset.getString("telEditora") + "\nEndereco: " + this.resultset.getString("endEditora") + "\n");
			}
		 }
		 catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());		
		 }
	}
	public void editarLivro(Livro l) {
		try {
			String query = "update livros set nomeLivro = '" + l.getNomeLivro() + "' where idLivro = "+ l.getIdLivro() +";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void editarEditora(Editora ed) {
		try {
			String query = "update editora set nomeEditora = '" + ed.getNomeEditora() + "', telEditora = '" + ed.getTelEditora() + "', endEditora = '" + ed.getEndEditora() + "' where idEditora = "+ ed.getIdEditora() +";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void alugarLivro(Livro l) {
		try {
			String query = "update livros set statusLivro = " + false + " where idLivro = "+ l.getIdLivro() + ";";
			this.statement.executeUpdate(query);
		}	catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void devolverLivro(Livro l) {
		try {
			String query = "update livros set statusLivro = " + true + " where idLivro = "+ l.getIdLivro() + ";";
			this.statement.executeUpdate(query);
		}	catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void apagarLivro(Livro l) {
		try {
			String query = "delete from livros where idLivro = " + l.getIdLivro() + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void apagarEditora(Editora ed) {
		try {
			String query = "delete from editora where idEditora = " + ed.getIdEditora() + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void desconectar() {
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}