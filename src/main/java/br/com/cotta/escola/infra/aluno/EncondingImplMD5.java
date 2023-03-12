package br.com.cotta.escola.infra.aluno;

import br.com.cotta.escola.domain.aluno.Encoding;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncondingImplMD5 implements Encoding {
    @Override
    public String encondig(String password) {
       try{
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(password.getBytes());
           byte[] bytes = md.digest();
           StringBuilder sb = new StringBuilder();
           for(int i = 0; i < bytes.length; i++){
               sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
           }
           return sb.toString();
       }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("erro ao gerar hash da senha");
       }
    }

    @Override
    public boolean validEncondig(String passwordEncodig, String password) {
        return passwordEncodig.equals(encondig(password));
    }
}
