package utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptEncrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("cjj666");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("这里是用户名");
        String password = textEncryptor.encrypt("这里是密码");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
    }
}
