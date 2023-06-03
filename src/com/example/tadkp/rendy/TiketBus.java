package com.example.tadkp.rendy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// Implementasi modul 5 (OOP)
public class TiketBus {
    // Implementasi modul 1 (Variabel)
    private JPanel panel;
    // Implementasi  (GUI)
    private JTextField textNama_bus;
    private JTextField harga_tiket;
    private JTextField jumlah_tiket;
    private JTextField uang_bayar;
    private JTextField uang_kembali;
    private JTextField textNama_Pemesan;
    private JTextField textTotalBayar;
    private JComboBox kode_bus;
    private JComboBox kelas_bus;
    private JButton hapus;
    private JButton pesan;
    private JButton hitung;
    private JLabel labelKode;
    private JLabel labelRp4;
    private JLabel labelRp2;
    private JLabel labelRp1;
    private JLabel labelRp;
    private JLabel labelNama;
    private JLabel labelTotalbayar;
    private JLabel labelKembalian;
    private JLabel labelJudul;
    private JLabel NamaPemesan;
    private JLabel labelKelas;
    private JLabel labelHarga;
    private JLabel labelJumlahtiket;
    private JLabel labelUangbayar;
    private JTextArea DataPenumpang;
    private JButton keluar;

    public static void main(String[] args) {
        TiketBus tiketBus = new TiketBus();
        tiketBus.run();
    }


    public void run() {
        createUI();
        addActionListeners();
    }

    private void createUI() {
        JFrame frame = new JFrame("Pembelian Tiket Bus RJ TRANS");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void addActionListeners() {
        kode_bus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // implementasi modul 4 (pemanggilan fungsi)
                updateNamaBus();
            }
        });

        kelas_bus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHargaTiket();
            }
        });

        hitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalBayar();
            }
        });

        pesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPesan();
            }
        });

        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitProgram();
            }
        });
    }

    // implementasi modul 4 (pendefinisi fungsi)
    private void updateNamaBus() {
        // Implementasi modul 2 (If-else if)
        if (kode_bus.getSelectedItem().equals("SMG-BDL")) {
            textNama_bus.setText("Semarang - Bandar Lampung");
        } else if (kode_bus.getSelectedItem().equals("SMG-JKT")) {
            textNama_bus.setText("Semarang - Jakarta");
        } else if (kode_bus.getSelectedItem().equals("SMG-PLM")) {
            textNama_bus.setText("Semarang - Palembang");
        }
    }

    private void updateHargaTiket() {
        if (kode_bus.getSelectedItem().equals("SMG-BDL")) {
            if (kelas_bus.getSelectedItem().equals("Eksekutif")) {
                harga_tiket.setText("450000");
            } else if (kelas_bus.getSelectedItem().equals("Bisnis")) {
                harga_tiket.setText("400000");
            } else if (kelas_bus.getSelectedItem().equals("Ekonomi")) {
                harga_tiket.setText("200000");
            }
        } else if (kode_bus.getSelectedItem().equals("SMG-JKT")) {
            if (kelas_bus.getSelectedItem().equals("Eksekutif")) {
                harga_tiket.setText("350000");
            } else if (kelas_bus.getSelectedItem().equals("Bisnis")) {
                harga_tiket.setText("250000");
            } else if (kelas_bus.getSelectedItem().equals("Ekonomi")) {
                harga_tiket.setText("180000");
            }
        } else if (kode_bus.getSelectedItem().equals("SMG-PLM")) {
            if (kelas_bus.getSelectedItem().equals("Eksekutif")) {
                harga_tiket.setText("700000");
            } else if (kelas_bus.getSelectedItem().equals("Bisnis")) {
                harga_tiket.setText("600000");
            } else if (kelas_bus.getSelectedItem().equals("Ekonomi")) {
                harga_tiket.setText("500000");
            }
        }
    }

    private void calculateTotalBayar() {
        int harga = Integer.parseInt(harga_tiket.getText());
        int jumlah = Integer.parseInt(jumlah_tiket.getText());
        int hasil = harga * jumlah;
        textTotalBayar.setText(Integer.toString(hasil));
        int total = Integer.parseInt(textTotalBayar.getText());
        int uang = Integer.parseInt(uang_bayar.getText());
        int kembalian = uang - total;
        uang_kembali.setText(Integer.toString(kembalian));
    }

    private void processPesan() {
        int total = Integer.parseInt(textTotalBayar.getText());
        int uang = Integer.parseInt(uang_bayar.getText());
        int kembalian = uang - total;
        if (kembalian <= -1) {
            JOptionPane.showMessageDialog(kode_bus, "Proses gagal! Uang Anda kurang.", "Transaksi gagal", JOptionPane.WARNING_MESSAGE);
        } else if (kembalian >= 0) {
            showTiketMessage();
            showCountdown();
            showDataPenumpang();
        }
    }

    private void showTiketMessage() {
        JOptionPane.showMessageDialog(kode_bus, "Tiket Anda akan dicetak dalam ");
    }

    private void showCountdown() {
        // Implementasi modul 3 (for looping)
        for (int i = 3; i >= 1; i--) {
            JOptionPane.showMessageDialog(kode_bus, +i);
        }
    }

    private void showDataPenumpang() {
        DataPenumpang.setText("Detail Tiket RJ TRANS" + "\n\nNama Bus : RJ TRANS" + "\nNama Pemesan : " + textNama_Pemesan.getText() +
                "\nKode Jurusan : " + kode_bus.getSelectedItem() + "\nKelas Bus : " + kelas_bus.getSelectedItem() +
                "\nJurusan : " + textNama_bus.getText() + "\nHarga Tiket : Rp." + harga_tiket.getText() +
                "\nJumlah Tiket : " + jumlah_tiket.getText() + "\nHarga Total : Rp." + textTotalBayar.getText() +
                "\nUang Kembalian : Rp." + uang_kembali.getText() + "\n\nSilahkan ambil tiket pesanan Anda");
    }

    private void resetForm() {
        textNama_Pemesan.setText("");
        textNama_bus.setText("");
        harga_tiket.setText("");
        jumlah_tiket.setText("");
        textTotalBayar.setText("");
        uang_bayar.setText("");
        uang_kembali.setText("");
        kelas_bus.setSelectedIndex(0);
        kode_bus.setSelectedIndex(0);
        DataPenumpang.setText("");
    }

    private void exitProgram() {
        JOptionPane.showMessageDialog(kode_bus, "Teman Setia Perjalanan Anda");
        System.exit(0);
    }
}
