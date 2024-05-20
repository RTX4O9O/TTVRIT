import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {
    JPanel reportPage = new JPanel();
    JPanel profilePage = new JPanel();

    MainWindow() {
        this.setTitle("Taiwan Traffic Violation Reporting Integration Tool (TTVRIT) <alpha>");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);

        reportPage();
        profilePage();


        this.add(profilePage);










        this.pack();
        this.setVisible(true);
    }

    void reportPage() {
        reportPage.setLayout(new FlowLayout());




    }
    void profilePage() {
        profilePage.setLayout(new GridLayout(1, 2, 5, 5));


        //left part
        JPanel createProfiles = new JPanel();
        {
            createProfiles.setLayout(new GridLayout(3, 1));

            //upper part
            JPanel personalInfoInput = new JPanel();
            {

                personalInfoInput.setLayout(new GridLayout(5, 2, 0, 2));
                JLabel nameLabel = new JLabel("姓名");
                JLabel idLabel = new JLabel("身分證字號");
                JLabel emailLabel = new JLabel("電子郵件");
                JLabel phoneLabel = new JLabel("電話號碼");
                JLabel addressLabel = new JLabel("聯絡地址");
                JTextField nameField = new JTextField();
                JTextField idField = new JTextField();
                JTextField emailField = new JTextField();
                JTextField phoneField = new JTextField();
                JTextField addressField = new JTextField();
                personalInfoInput.add(nameLabel);
                personalInfoInput.add(nameField);
                personalInfoInput.add(idLabel);
                personalInfoInput.add(idField);
                personalInfoInput.add(emailLabel);
                personalInfoInput.add(emailField);
                personalInfoInput.add(phoneLabel);
                personalInfoInput.add(phoneField);
                personalInfoInput.add(addressLabel);
                personalInfoInput.add(addressField);

            }

            JLabel hintLabel = new JLabel();
            JButton createProfileButton = new JButton("新增");

            createProfiles.add(personalInfoInput);
            createProfiles.add(hintLabel);
            createProfiles.add(createProfileButton);
        }

        //right part
        JPanel existedProfiles = new JPanel();
        {

        }
    }
}
