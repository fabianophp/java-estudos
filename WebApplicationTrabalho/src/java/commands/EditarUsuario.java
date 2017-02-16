/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.UsuarioDAO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author fabia
 */
public class EditarUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
      
            // pegando os parâmetros do request
            Integer id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            
            String dataEmTexto = request.getParameter("dataNascimento");
            Calendar dataNascimento = null;

            // fazendo a conversão da data 
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
            Date now = new Date();
           

            // monta um objeto contato
            Usuario Usuario = new Usuario();
            
            Usuario.setId(id); 
            Usuario.setNome(nome);
            Usuario.setLogin(login);
            Usuario.setEmail(email);
            Usuario.setSenha(convertStringToMd5(senha));
            
            Usuario.setDataCadastro(now);
            Usuario.setDataNascimento(dataNascimento.getTime());

            

      try {
           UsuarioDAO dao = new UsuarioDAO();
            dao.editar(Usuario);

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");
            d.forward(request, response);
            
        } catch (Exception ex) {
            Logger.getLogger(EditarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            //Instanciamos o nosso HASH MD5, poderíamos usar outro como
            //SHA, por exemplo, mas optamos por MD5.
            mDigest = MessageDigest.getInstance("MD5");

            //Convert a String valor para um array de bytes em MD5
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

            //Convertemos os bytes para hexadecimal, assim podemos salvar
            //no banco para posterior comparação se senhas
            StringBuilder sb = new StringBuilder();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            return null;
        }
        // TODO Auto-generated catch block

    }

}