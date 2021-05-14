package pe.edu.ucont.proyectodemoef.view;

import javax.swing.JOptionPane;
import pe.edu.ucont.proyectodemoef.dto.EmpleadoDto;
import pe.edu.ucont.proyectodemoef.service.CuentaService;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class RetiroView extends javax.swing.JInternalFrame {

    /** Creates new form RetiroView */
    public RetiroView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      txtCuenta = new javax.swing.JTextField();
      txtImporte = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      txtClave = new javax.swing.JPasswordField();
      btnProcesar = new javax.swing.JButton();

      setClosable(true);
      setMaximizable(true);
      setResizable(true);
      setTitle("REGISTRAR RETIRO");

      jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
      jLabel1.setText("Cuenta");

      txtCuenta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

      txtImporte.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

      jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
      jLabel2.setText("Importe");

      jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
      jLabel3.setText("Clave");

      txtClave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

      btnProcesar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
      btnProcesar.setText("Procesar");
      btnProcesar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnProcesarActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(18, 18, 18)
                     .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(18, 18, 18)
                     .addComponent(txtClave))
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(18, 18, 18)
                     .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(249, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
               .addComponent(txtClave))
            .addGap(53, 53, 53)
            .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(180, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
      try {
			// Datos
			String cuenta = txtCuenta.getText();
			double importe = Double.parseDouble(txtImporte.getText());
			String clave = new String(txtClave.getPassword());
			// El Empleado
			EmpleadoDto empleado = (EmpleadoDto) Session.get("usuario");
			// Proceso
			CuentaService service = new CuentaService();
			double saldo = service.procesoRetiro(cuenta, importe, clave, empleado.getCodigo());
			if( service.getCode() == 1 ){
				Mensaje.info(this, "Nuevo saldo: " + saldo);
				//JOptionPane.showMessageDialog(this, "Nuevo saldo: " + saldo);
			} else {
				Mensaje.error(this, service.getMessage());
				//JOptionPane.showMessageDialog(this, service.getMessage());
			}
		} catch (Exception e) {
			Mensaje.error(this, e.getMessage());
			//JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
   }//GEN-LAST:event_btnProcesarActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnProcesar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPasswordField txtClave;
   private javax.swing.JTextField txtCuenta;
   private javax.swing.JTextField txtImporte;
   // End of variables declaration//GEN-END:variables

}
