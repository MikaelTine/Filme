package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;
import br.com.fiap.dao.FilmeDao;
import br.com.fiap.model.Filme;
import br.com.fiap.service.UploadService;

@Named
@RequestScoped
public class FilmeBean {

	private Filme filme = new Filme();
	
	@Inject 
	private FilmeDao dao;
	
	private UploadedFile image;
	
	public String save() {
		System.out.println(this.filme);
		filme.setImagePath( UploadService.write(image, "filmes"));
		dao.create(filme);
		
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Filme cadastrado com sucesso"));
		
		return "filmes";
	}
	
	public List<Filme> getAll(){
		return dao.listAll();
	}
	
	public String remove(Filme filme) {
		dao.remove(filme);
		
		FacesContext
		.getCurrentInstance()
		.addMessage(null, new FacesMessage("Filme apagado com sucesso"));

		return "filmes?faces-redirect=true";
	}
	
	public void edit() {
		dao.update(filme);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage("Filme atualizado com sucesso"));
	}

	public Filme getFilme() {
		return filme;
	}

	public void setSetup(Filme filme) {
		this.filme = filme;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
