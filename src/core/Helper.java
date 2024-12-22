package core;

import javax.swing.*;

public class Helper
{
    public static void setTheme(){
        UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException expetion) {
                    expetion.printStackTrace();
                }
                break;
            }
        }
    }
    public static boolean isFieldEmpty(JTextField field){
        return field.getText().isEmpty();
    }
    public static boolean isFieldListEmpty(JTextField[] fields){
        for (JTextField field : fields) {
            if (isFieldEmpty(field)) return true;
        }
            return false;
        }
    public static void optionPaneDialogTR(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
    }
    //mail kontrolü
    // aise@gmail.com
    //@ olacak @.2ten önce bir değer @'tan sonra bir nokta ve bir değer olacak

    public static boolean isEmailValid(String mail){
        if (mail==null || mail.trim().isEmpty()) return false;
        if (!mail.contains("@")) return false;
        String[] parts= mail.split("@");
        if (parts.length!=2) return false;
        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;
        if (!parts[1].contains(".")) return false;
        return true;
        }

        public static void showMsg(String message){
        String msg;
        String title;

        optionPaneDialogTR();
        switch (message){
            case"fill":
                msg = "Lütfen tüm alanları doldurunuz.";
                title  ="HATA!!!";
                break;
            case "done":
                msg="İşlem Başarılı.";
                title="Sonuç";
                break;
            case "error":
                msg="Bir Hata Oluştu";
                title="HATA!!!";
                break;
            default:
                    msg=message;
                    title="Mesaj!";
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);

        }
    }

