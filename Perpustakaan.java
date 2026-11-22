import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Perpustakaan{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Perpustakaan");

        JLabel judul = new JLabel("DATA PEMINJAMAN BUKU", JLabel.CENTER);
        JLabel labelBuku = new JLabel("Judul Buku:");
        JLabel labelPeminjam = new JLabel("Nama Peminjam:");

        JTextField fieldBuku = new JTextField();
        JTextField fieldPeminjam = new JTextField();

        JButton tombolSimpan = new JButton("Simpan");
        JButton tombolHapus = new JButton("Hapus");

        JTextArea areaHasil = new JTextArea();
        areaHasil.setEditable(false);

        JPanel panelInput = new JPanel(new GridLayout(2, 2, 10, 10));
        panelInput.add(labelBuku);
        panelInput.add(fieldBuku);
        panelInput.add(labelPeminjam);
        panelInput.add(fieldPeminjam);

        JPanel panelTombol = new JPanel(new FlowLayout());
        panelTombol.add(tombolSimpan);
        panelTombol.add(tombolHapus);

        JPanel panelAtas = new JPanel(new BorderLayout(10, 10));
        panelAtas.add(judul, BorderLayout.NORTH);
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(panelAtas, BorderLayout.NORTH);
        frame.add(new JScrollPane(areaHasil), BorderLayout.CENTER);

        tombolSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buku = fieldBuku.getText();
                String peminjam = fieldPeminjam.getText();

                areaHasil.append("Judul Buku: " + buku + "\nNama Peminjam: " + peminjam + "\n-------------------------\n");

                fieldBuku.setText("");
                fieldPeminjam.setText("");
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaHasil.setText("");
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}