import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dmitrii on 30.03.2017.
 */

public class Window {
    JTextArea textArea;
    JTextArea ta;
    JTextField key;

    public Window() {
        JFrame frame = new JFrame("YouXOR");

        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea("Введите текст", 4, 20);
        textArea.setBackground(Color.white);
        panel.add("West",textArea);

        ta = new JTextArea(4,20);
        ta.setBackground(Color.white);
        ta.setEditable(false);
        panel.add("East",ta);

        JButton button = new JButton("Шифровать");
        button.addActionListener(new Action());
        panel.add("Center", button);

        key = new JTextField("KEY", 4);
        panel.add("South", key);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setResizable(false);
    }
    class Action implements ActionHandler {
        @Override
        public void actionPerformed(ActionEvent e) throws UnsupportedEncodingException  {
            byte[] arr = toByte(textArea.getText());

        }
        public byte[] toByte(String s) throws UnsupportedEncodingException {
            byte[] arr = s.getBytes("UTF-8");
            return arr;
        }
        public String toStr(byte[] arr) throws UnsupportedEncodingException {
            String s = new String(arr, "UTF-8");
            return s;
        }
        public String byteToBin(byte b){
            return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        }
        /*
         *  Переводим массив byte в строку с двоичным видом
         */
        public String bytesToBin(byte[] bytes){
            StringBuilder stringBuilder = new StringBuilder();
            for(byte b:bytes){
                stringBuilder.append(byteToBin(b)).append(" ");
            }
            return stringBuilder.toString();
        }
    }
}
