package swing_calismalari;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class vucut_kutle {

	private JFrame frmVcutKtleIndeksi;
	private JTextField txt_kilo;
	private JTextField txt_boy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vucut_kutle window = new vucut_kutle();
					window.frmVcutKtleIndeksi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vucut_kutle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcutKtleIndeksi = new JFrame();
		frmVcutKtleIndeksi.getContentPane().setBackground(new Color(230, 230, 250));
		frmVcutKtleIndeksi.setTitle("Vucut Kitle Indeksi Hesaplama");
		frmVcutKtleIndeksi.setBounds(100, 100, 1059, 661);
		frmVcutKtleIndeksi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVcutKtleIndeksi.getContentPane().setLayout(null);
		
		JCheckBox chc_k = new JCheckBox("Kadin");
		chc_k.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		chc_k.setBackground(new Color(230, 230, 250));
		chc_k.setBounds(175, 273, 137, 41);
		frmVcutKtleIndeksi.getContentPane().add(chc_k);
		
		JCheckBox chc_e = new JCheckBox("Erkek");
		chc_e.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		chc_e.setBackground(new Color(230, 230, 250));
		chc_e.setBounds(36, 273, 137, 41);
		frmVcutKtleIndeksi.getContentPane().add(chc_e);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(chc_k);
		bg.add(chc_e);
		
		
		txt_kilo = new JTextField();
		txt_kilo.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		txt_kilo.setBounds(364, 170, 124, 47);
		frmVcutKtleIndeksi.getContentPane().add(txt_kilo);
		txt_kilo.setColumns(10);
		
		txt_boy = new JTextField();
		txt_boy.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		txt_boy.setColumns(10);
		txt_boy.setBounds(514, 170, 124, 47);
		frmVcutKtleIndeksi.getContentPane().add(txt_boy);
		
		JLabel lbl = new JLabel("");
		lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lbl.setBounds(26, 329, 952, 47);
		frmVcutKtleIndeksi.getContentPane().add(lbl);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lbl2.setBounds(36, 389, 391, 39);
		frmVcutKtleIndeksi.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lbl3.setBounds(36, 442, 391, 41);
		frmVcutKtleIndeksi.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lbl4.setBounds(36, 486, 391, 47);
		frmVcutKtleIndeksi.getContentPane().add(lbl4);
		
		JButton btn = new JButton("Hesapla");
		btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 27));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double kilo =Integer.parseInt(txt_kilo.getText());
				double boy = Integer.parseInt(txt_boy.getText());
				
				double boy_m = (boy/100);
				double boy_inc = (boy/2.54);
				float v_kutle;
				float vy_alani;
				float yv_kadin;
				float yv_erkek;
				float iv_kadin;
				float iv_erkek;
				
				v_kutle=(float)(kilo/(Math.pow(boy_m, 2)));
				vy_alani = (float)Math.sqrt((boy*kilo)/3600);
				yv_kadin= (float)((1.07*kilo)-(148*(Math.pow(kilo, 2)/(Math.pow(100*boy_m, 2)))));
				yv_erkek=(float)((1.10*kilo)-(128*(Math.pow(kilo, 2)/(Math.pow(100*boy_m, 2)))));
				iv_kadin = (float)(45.5 + 2.3*(boy_inc - 60));
				iv_erkek = (float)(50 + 2.3*(boy_inc - 60));
				
				String sonuc = null , sonuc2 = null, sonuc3 = null ,sonuc4 = null;
				
				if(chc_k.isSelected()==true){
					sonuc3=" Yagsiz Vucut Orani :  " +yv_kadin  +" kg";
					lbl3.setText(sonuc3);
					sonuc4=" Ideal Vucut Agirliginiz :  " +iv_kadin +" kg";
					lbl4.setText(sonuc4);
					
				}
				else if(chc_e.isSelected()==true){
					sonuc3=" Yagsiz Vucut Orani :  " +yv_erkek +" kg";
					lbl3.setText(sonuc3);
					sonuc4=" Ideal Vucut Agirliginiz :  " +iv_erkek +" kg";
					lbl4.setText(sonuc4);
				}
				else if(chc_e.isSelected()==false && chc_k.isSelected()==false){
					JOptionPane.showMessageDialog(frmVcutKtleIndeksi, "    Cinsiyet secmediniz !!!   ","  UYARI  ",JOptionPane.WARNING_MESSAGE);
				}
								
				
				if (v_kutle < 18.5){
					sonuc = "  Vucut Kitle Indeksiniz :  "+ v_kutle +"  (Zayif)  "  +"   Vucut kitle indeksiniz olmasi gerekenin altinda. ";
					lbl.setText(sonuc);
					JOptionPane.showMessageDialog(frmVcutKtleIndeksi, "    ZAYIF    ","  SONUC  ",JOptionPane.WARNING_MESSAGE);
				}
				else if( 18.5<= v_kutle && v_kutle<24.9){
					sonuc = "  Vucut Kitle Indeksiniz :  "+ v_kutle +"  (Normal)  "  +"   Vucut kitle indeksiniz olmasi gereken degerde. ";
					lbl.setText(sonuc);
					JOptionPane.showMessageDialog(frmVcutKtleIndeksi, "    NORMAL     ","  SONUC  ",JOptionPane.WARNING_MESSAGE);
				}
				else if( 25.0 <= v_kutle && v_kutle<29.9){
					sonuc = "  Vucut Kitle Indeksiniz :  "+ v_kutle +"  (Fazla Kilolu)  "  +"   Vucut kitle indeksiniz olmasi gerekenden biraz fazla. ";	
					lbl.setText(sonuc);
					JOptionPane.showMessageDialog(frmVcutKtleIndeksi, "    FAZLA KILOLU    ","  SONUC  ",JOptionPane.WARNING_MESSAGE);
				}
				else if(30 <= v_kutle && v_kutle <39.9){
					sonuc="  Vucut Kitle Indeksiniz : "+ v_kutle+ "  (Obez)  "+ "   Vucut kitle indeksiniz olmasi gerekenin cok ustunde. ";
					lbl.setText(sonuc);
					JOptionPane.showMessageDialog(frmVcutKtleIndeksi, "    OBEZ    ","  SONUC  ",JOptionPane.WARNING_MESSAGE);
				}
				else{
					sonuc=" Vucut Kitle Indeksiniz : "+v_kutle+"   (Asiri Obez)  "+"  Vucut kitle indeksiniz cok yuksek en kisa surede destek almalisiniz.  ";
					lbl.setText(sonuc);
					JOptionPane.showMessageDialog(frmVcutKtleIndeksi, "    ASIRI OBEZ    ","  SONUC  ",JOptionPane.WARNING_MESSAGE);
				} 
				sonuc2=" Vucut Yuzey Alaniniz :  "+vy_alani +" m2";
				lbl2.setText(sonuc2);				 
				
				
			}
		});
		btn.setBounds(405, 245, 171, 41);
		frmVcutKtleIndeksi.getContentPane().add(btn);
		
		
		
		JLabel lbl_kilo = new JLabel("Kilo(kg)");
		lbl_kilo.setFont(new Font("Comic Sans MS", Font.PLAIN, 27));
		lbl_kilo.setBounds(364, 109, 115, 33);
		frmVcutKtleIndeksi.getContentPane().add(lbl_kilo);
		
		JLabel lbl_boy = new JLabel("Boy(cm)");
		lbl_boy.setFont(new Font("Comic Sans MS", Font.PLAIN, 27));
		lbl_boy.setBounds(514, 109, 115, 33);
		frmVcutKtleIndeksi.getContentPane().add(lbl_boy);
		
		JLabel lbl_ikon_e = new JLabel(new ImageIcon("src/erkek.png"));
		lbl_ikon_e.setBounds(22, 122, 115, 145);
		frmVcutKtleIndeksi.getContentPane().add(lbl_ikon_e);
	    
		
		JLabel lbl_ikon_k = new JLabel(new ImageIcon("src/kadin.png"));
		lbl_ikon_k.setBounds(163, 122, 115, 145);
		frmVcutKtleIndeksi.getContentPane().add(lbl_ikon_k);
		
		JLabel lbl_baslik = new JLabel("VUCUT KUTLE INDEKSI HESAPLAMA ");
		lbl_baslik.setFont(new Font("Comic Sans MS", Font.BOLD, 27));
		lbl_baslik.setBounds(177, 28, 532, 53);
		frmVcutKtleIndeksi.getContentPane().add(lbl_baslik);
		
		JLabel lbl_tablo = new JLabel(new ImageIcon("src/tablo3.png"));
		lbl_tablo.setBounds(689, 137, 299, 187);
		frmVcutKtleIndeksi.getContentPane().add(lbl_tablo);
		
		JLabel lbl_tablobaslik = new JLabel("Boy-Kilo Endeks Tablosu");
		lbl_tablobaslik.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		lbl_tablobaslik.setBounds(722, 91, 256, 33);
		frmVcutKtleIndeksi.getContentPane().add(lbl_tablobaslik);
		
		
		
		
		
		
	}
}
