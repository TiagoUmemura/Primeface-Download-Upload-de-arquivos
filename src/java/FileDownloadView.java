/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiago
 */

import br.com.webapplication.model.Arquivo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@ManagedBean(name = "fileDownloadView")
public class FileDownloadView {
     
    private StreamedContent file;// /home/tiago/PrimefacesBaseDados/teste.jpg
    
    public FileDownloadView() throws FileNotFoundException { //ideia: passar uma string com nome do arquivo para fazer download
        InputStream stream = new FileInputStream("/home/tiago/PrimefacesBaseDados/declaracao.pdf");
        file = new DefaultStreamedContent(stream, "application/pdf", "teste5.pdf");
//        Arquivo arq = new Arquivo();
//        arq.setNome("testeeeee");
//        System.out.println(arq.toString());
//        new DAO<Arquivo>(Arquivo.class).insert(arq);
    }
 
    public StreamedContent getFile(String arq) throws FileNotFoundException {
        InputStream stream = new FileInputStream("/home/tiago/PrimefacesBaseDados/" + arq);
        file = new DefaultStreamedContent(stream, "application/pdf", arq);
        return file;
    }
}

