/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ljubavnikalkulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Prozor extends javax.swing.JFrame {

    private static List<Integer> parna = new ArrayList<Integer>();
	private static List<Integer> neparna = new ArrayList<Integer>();
	private static List<Integer> zbrojenalista = new ArrayList<Integer>();
	private static List<Integer> zaspremanje = new ArrayList<Integer>();
	private static List<Integer> listIzlazna = new ArrayList<>();
	static final int MAX_CHAR = 256;
    /**
     * Creates new form Prozor
     */
    public Prozor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ispisRezultata = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        unosPrvi = new javax.swing.JTextField();
        unosDrugi = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Izračunaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(unosPrvi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(unosDrugi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ispisRezultata, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unosPrvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unosDrugi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addGap(56, 56, 56)
                .addComponent(ispisRezultata)
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String s1 = unosPrvi.getText();
       String s2 = unosDrugi.getText();
       String unos = s1 + s2;
       unos = unos.toLowerCase();
		char[] charOdUnosa = unos.toCharArray();
		Arrays.parallelSort(charOdUnosa);

		String str = new String(charOdUnosa);

		getOccuringChar(str);

		// code to convert int array to List of Integer

		List<Integer> listUlazna = new ArrayList<>(getOccuringChar(str).length);

		for (int i : getOccuringChar(str)) {
			listUlazna.add(Integer.valueOf(i));
		}

		for (int i = 0; i < listUlazna.size(); i++) {
			listUlazna.remove(new Integer(0));
			for (int j = 0; j < listUlazna.size(); j++) {
				listUlazna.remove(new Integer(0));
			}
		}

		Integer removaniElement;
		Integer prviElement, drugiElement;
		Integer zbrojPrvogDrugog;
		Integer ostatak = 0;
		String konacniRezultatSvega;

		if (!(listUlazna.size() % 2 == 0)) {

			// Uklanjanje ako je parna veca
			removaniElement = listUlazna.remove(listUlazna.size() - 1);

			smanjivanjeListe(listUlazna);
			listIzlazna = smanjivanjeListe(listUlazna);

			prviElement = listIzlazna.get(0);
			drugiElement = listIzlazna.get(1);
			zbrojPrvogDrugog = prviElement + drugiElement;

			if (!(zbrojPrvogDrugog % 10 == 0)) {
				ostatak = zbrojPrvogDrugog % 10;
			}

			konacniRezultatSvega = ostatak.toString() + removaniElement.toString();

                        ispisRezultata.setText(konacniRezultatSvega + "%");
                        
			
		} else {

			smanjivanjeListe(listUlazna);
			listIzlazna = smanjivanjeListe(listUlazna);

			prviElement = listIzlazna.get(0);
			drugiElement = listIzlazna.get(1);

			konacniRezultatSvega = prviElement.toString() + drugiElement.toString();

			ispisRezultata.setText(konacniRezultatSvega + "%");
		}
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prozor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prozor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prozor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prozor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prozor().setVisible(true);
            }
        });
    }

    public static List<Integer> smanjivanjeListe(List<Integer> list) {

		if (list.size() > 2) {

			for (int i = 0; i < list.size(); i += 2) {
				parna.add(list.get(i));
			}

			for (int i = 1; i < list.size(); i += 2) {
				neparna.add(list.get(i));
			}
			if (parna.size() > neparna.size()) {
				neparna.add(0);
			}

			for (int i = 0; i < parna.size(); i++) {
				zbrojenalista.add(parna.get(i) + neparna.get(i));
			}

			list.clear();

			for (int i = 0; i < zbrojenalista.size(); i++) {
				list.add(zbrojenalista.get(i));
			}

			parna.clear();
			neparna.clear();
			zbrojenalista.clear();

			smanjivanjeListe(list);

		}

		return list;

	}

	static int[] getOccuringChar(String str) {
		// Create an array of size 256 i.e. ASCII_SIZE
		int count[] = new int[MAX_CHAR];

		int len = str.length();

		// Initialize count array index
		for (int i = 0; i < len; i++)
			count[str.charAt(i)]++;

		// Create an array of given String size
		char ch[] = new char[str.length()];
		for (int i = 0; i < len; i++) {
			ch[i] = str.charAt(i);

			int find = 0;
			for (int j = 0; j <= i; j++) {

				// If any matches found
				if (str.charAt(i) == ch[j])
					find++;
			}
//
//		if (find == 1)
//
//			System.out.println("Number of Occurrence of " + str.charAt(i) + " is:" + count[str.charAt(i)]);
		}
		return count;

	}

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ispisRezultata;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField unosDrugi;
    private javax.swing.JTextField unosPrvi;
    // End of variables declaration//GEN-END:variables
}
