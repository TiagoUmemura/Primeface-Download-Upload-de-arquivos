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
import br.com.webapplication.model.Contato;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "fileUploadView")
public class FileUploadView {

    //file recebe o arquivo da pagina
    
    private UploadedFile file;
    private static final List<String> dados = new ArrayList<>();

    public UploadedFile getFile() {
        return file;
    }

    public static List<String> getDados() {
        return dados;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() throws IOException {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            String nome = file.getFileName();

            InputStream inputStream = file.getInputstream();
            OutputStream outputStream = new FileOutputStream(new File("/home/tiago/PrimefacesBaseDados/" + nome));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            dados.add(nome);
            
//            Arquivo arq = new Arquivo();
//            arq.setNome("teste");
//            new DAO<Arquivo>(Arquivo.class).insert(arq);
        }
    }
}
