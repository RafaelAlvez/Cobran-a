package br.com.iss53.dto;

public interface InterfaceHandler {
	
	/** INTERFACE **/
	public static final String UI_CADASTRO_TITULO = "CadastroTitulo";
	public static final String UI_TITULOS = "PesquisaTitulos";
	
	/** HANDLER'S **/
	public static final String MSG_SUCCESS = "mensagemSuccess";
	public static final String MSG_DANGER = "mensagemDanger";
	public static final String MSG_WARNING = "mensagemWarning";
	
	/** OBJECT **/
	public static final String OBJECT_TITULOS = "titulos";
	public static final String OBJECT_TITULO = "titulo";
	
	/** REDIRECT **/
	public static final String REDIRECT_TO_TITULOS = "redirect:/titulos";
	public static final String REDIRECT_TO_CADASTRO_NOVO_TITULO = "redirect:/titulos/novo";
	
	/** MENSAGENS **/
	public static final String MSG_TITULO_NAO_ENCONTRADO = "Titulo não encontrado!";
	public static final String MSG_TITULO_SALVO = "Titulo salvo com sucesso!";
	public static final String MSG_TITULO_EXCLUIDO = "Titulo excluido com sucesso!";
	
}